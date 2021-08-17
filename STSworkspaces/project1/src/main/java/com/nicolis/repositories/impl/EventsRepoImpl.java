package com.nicolis.repositories.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nicolis.models.Events;
import com.nicolis.repositories.EventsRepo;
import com.nicolis.util.HibernateUtil;

public class EventsRepoImpl implements EventsRepo {

	@Override
	public Events addEvents(Events ev) {

		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			ev.setEvId((int) sess.save(ev));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			ev = null;
		} finally {
			sess.close();
		}

		return ev;
	}

	@Override
	public List<Events> getAllEvents() {

		Session sess = HibernateUtil.getSession();
		List<Events> Events = null;
		try {
			// SELECT * FROM Events
			// HQL - wants you to be able to just use your Java Classes.
			Events = sess.createQuery("FROM Events").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return Events;
	}

	@Override
	public Events getEvents(int EvId) {

		Session sess = HibernateUtil.getSession();
		Events ev = null;

		try {
			ev = sess.get(Events.class, EvId);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return ev;
	}

	@Override
	public Events updateEvents(Events change) {

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
	public Events deleteEvents(int EvId) {

		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Events ev = sess.get(Events.class, EvId);

		try {
			tx = sess.beginTransaction();
			sess.delete(ev);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}

		return ev;
	}

}
