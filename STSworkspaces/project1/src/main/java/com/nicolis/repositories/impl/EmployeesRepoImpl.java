package com.nicolis.repositories.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nicolis.models.Employees;
import com.nicolis.repositories.EmployeesRepo;
import com.nicolis.util.HibernateUtil;

public class EmployeesRepoImpl implements EmployeesRepo {

	@Override
	public Employees addEmployees(Employees e) {

		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			e.setEId((int) sess.save(e));
			sess.getTransaction().commit();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			sess.getTransaction().rollback();
			e1 = null;
		} finally {
			sess.close();
		}

		return e;
	}

	@Override
	public List<Employees> getAllEmployees() {

		Session sess = HibernateUtil.getSession();
		List<Employees> Employees = null;
		try {
			Employees = sess.createQuery("FROM Employees").list();
		} catch (HibernateException e1) {
			e1.printStackTrace();
		} finally {
			sess.close();
		}

		return Employees;
	}

	@Override
	public Employees getEmployees(int EId) {

		Session sess = HibernateUtil.getSession();
		Employees e = null;

		try {
			e = sess.get(Employees.class, EId);
		} catch (HibernateException e1) {
			e1.printStackTrace();
		} finally {
			sess.close();
		}

		return e;
	}

	@Override
	public Employees updateEmployees(Employees change) {

		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			sess.update(change);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}

		return change;
	}

	@Override
	public Employees deleteEmployees(int EId) {

		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Employees e = sess.get(Employees.class, EId);

		try {
			tx = sess.beginTransaction();
			sess.delete(e);
			tx.commit();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}

		return e;

	}
}
