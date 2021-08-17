package com.nicolis.repositories.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nicolis.models.GradingFormats;
import com.nicolis.repositories.GradingFormatsRepo;
import com.nicolis.util.HibernateUtil;

public class GradingFormatsRepoImpl implements GradingFormatsRepo {

	@Override
	public GradingFormats addGradingFormats(GradingFormats gf) {

		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			gf.setGfId((int) sess.save(gf));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			gf = null;
		} finally {
			sess.close();
		}

		return gf;
	}

	@Override
	public List<GradingFormats> getAllGradingFormats() {

		Session sess = HibernateUtil.getSession();
		List<GradingFormats> GradingFormats = null;
		try {
			// SELECT * FROM GradingFormats
			// HQL - wants you to be able to just use your Java Classes.
			GradingFormats = sess.createQuery("FROM GradingFormats").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return GradingFormats;
	}

	@Override
	public GradingFormats getGradingFormats(int GfId) {

		Session sess = HibernateUtil.getSession();
		GradingFormats gf = null;

		try {
			gf = sess.get(GradingFormats.class, GfId);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return gf;
	}

	@Override
	public GradingFormats updateGradingFormats(GradingFormats change) {

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
	public GradingFormats deleteGradingFormats(int GfId) {

		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		GradingFormats gf = sess.get(GradingFormats.class, GfId);

		try {
			tx = sess.beginTransaction();
			sess.delete(gf);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}

		return gf;
	}

}
