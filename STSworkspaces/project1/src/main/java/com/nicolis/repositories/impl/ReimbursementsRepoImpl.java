package com.nicolis.repositories.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nicolis.models.Reimbursements;
import com.nicolis.repositories.ReimbursementsRepo;
import com.nicolis.util.HibernateUtil;

public class ReimbursementsRepoImpl implements ReimbursementsRepo {

	@Override
	public Reimbursements addReimbursements(Reimbursements r) {

		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			r.setRId((int) sess.save(r));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			r = null;
		} finally {
			sess.close();
		}

		return r;
	}

	@Override
	public List<Reimbursements> getAllReimbursements() {

		Session sess = HibernateUtil.getSession();
		List<Reimbursements> Reimbursements = null;
		try {
			// SELECT * FROM Reimbursements
			// HQL - wants you to be able to just use your Java Classes.
			Reimbursements = sess.createQuery("FROM Reimbursements").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return Reimbursements;
	}

	@Override
	public Reimbursements getReimbursements(int RId) {

		Session sess = HibernateUtil.getSession();
		Reimbursements r = null;

		try {
			r = sess.get(Reimbursements.class, RId);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return r;
	}

	@Override
	public Reimbursements updateReimbursements(Reimbursements change) {

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
	public Reimbursements deleteReimbursements(int RId) {

		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Reimbursements r = sess.get(Reimbursements.class, RId);

		try {
			tx = sess.beginTransaction();
			sess.delete(r);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}

		return r;
	}

}
