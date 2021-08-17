package com.nicolis.repositories.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nicolis.models.Presentations;
import com.nicolis.repositories.PresentationsRepo;
import com.nicolis.util.HibernateUtil;

public class PresentationsRepoImpl implements PresentationsRepo {

	@Override
	public Presentations addPresentations(Presentations p) {

		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			p.setPresId((int) sess.save(p));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			p = null;
		} finally {
			sess.close();
		}

		return p;
	}

	@Override
	public List<Presentations> getAllPresentations() {

		Session sess = HibernateUtil.getSession();
		List<Presentations> Presentations = null;
		try {
			// SELECT * FROM Presentations
			// HQL - wants you to be able to just use your Java Classes.
			Presentations = sess.createQuery("FROM Presentations").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return Presentations;
	}

	@Override
	public Presentations getPresentations(int PresId) {

		Session sess = HibernateUtil.getSession();
		Presentations p = null;

		try {
			p = sess.get(Presentations.class, PresId);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return p;
	}

	@Override
	public Presentations updatePresentations(Presentations change) {

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
	public Presentations deletePresentations(int PresId) {

		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Presentations p = sess.get(Presentations.class, PresId);

		try {
			tx = sess.beginTransaction();
			sess.delete(p);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}

		return p;
	}

}
