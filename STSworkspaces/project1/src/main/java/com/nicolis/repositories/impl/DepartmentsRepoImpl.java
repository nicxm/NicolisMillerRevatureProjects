package com.nicolis.repositories.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nicolis.models.Departments;
import com.nicolis.repositories.DepartmentsRepo;
import com.nicolis.util.HibernateUtil;

public class DepartmentsRepoImpl implements DepartmentsRepo {

	@Override
	public Departments addDepartments(Departments d) {

		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			d.setDeptId((int) sess.save(d));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			d = null;
		} finally {
			sess.close();
		}

		return d;
	}

	@Override
	public List<Departments> getAllDepartments() {

		Session sess = HibernateUtil.getSession();
		List<Departments> Departments = null;
		try {
			// SELECT * FROM Departments
			// HQL - wants you to be able to just use your Java Classes.
			Departments = sess.createQuery("FROM Departments").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return Departments;
	}

	@Override
	public Departments getDepartments(int id) {

		Session sess = HibernateUtil.getSession();
		Departments d = null;

		try {
			d = sess.get(Departments.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return d;
	}

	@Override
	public Departments updateDepartments(Departments change) {

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
	public Departments deleteDepartments(int id) {

		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Departments d = sess.get(Departments.class, id);

		try {
			tx = sess.beginTransaction();
			sess.delete(d);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}

		return d;
	}

}
