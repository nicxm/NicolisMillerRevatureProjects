package com.nicolis.repositories.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nicolis.models.Requests;
import com.nicolis.repositories.RequestsRepo;
import com.nicolis.util.HibernateUtil;

public class RequestsRepoImpl implements RequestsRepo {

	@Override
	public Requests addRequests(Requests req) {

		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			req.setReqId((int) sess.save(req));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			req = null;
		} finally {
			sess.close();
		}

		return req;
	}

	@Override
	public List<Requests> getAllRequests() {

		Session sess = HibernateUtil.getSession();
		List<Requests> Requests = null;
		try {
			// SELECT * FROM Requests
			// HQL - wants you to be able to just use your Java Classes.
			Requests = sess.createQuery("FROM Requests").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return Requests;
	}

	@Override
	public Requests getRequests(int ReqId) {

		Session sess = HibernateUtil.getSession();
		Requests req = null;

		try {
			req = sess.get(Requests.class, ReqId);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return req;
	}

	@Override
	public Requests updateRequests(Requests change) {

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
	public Requests deleteRequests(int ReqId) {

		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Requests req = sess.get(Requests.class, ReqId);

		try {
			tx = sess.beginTransaction();
			sess.delete(req);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}

		return req;
	}

}
