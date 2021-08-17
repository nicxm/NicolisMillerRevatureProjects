package com.nicolis.repositories.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nicolis.models.EventTypes;
import com.nicolis.repositories.EventTypesRepo;
import com.nicolis.util.HibernateUtil;

public class EventTypesRepoImpl implements EventTypesRepo {

	@Override
	public EventTypes addEventTypes(EventTypes evt) {

		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			evt.setEtId((int) sess.save(evt));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			evt = null;
		} finally {
			sess.close();
		}

		return evt;
	}

	@Override
	public List<EventTypes> getAllEventTypes() {

		Session sess = HibernateUtil.getSession();
		List<EventTypes> EventTypes = null;
		try {
			// SELECT * FROM EventTypes
			// HQL - wants you to be able to just use your Java Classes.
			EventTypes = sess.createQuery("FROM EventTypes").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return EventTypes;
	}

	@Override
	public EventTypes getEventTypes(int EtId) {

		Session sess = HibernateUtil.getSession();
		EventTypes evt = null;

		try {
			evt = sess.get(EventTypes.class, EtId);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return evt;
	}

	@Override
	public EventTypes updateEventTypes(EventTypes change) {

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
	public EventTypes deleteEventTypes(int EtId) {

		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		EventTypes evt = sess.get(EventTypes.class, EtId);

		try {
			tx = sess.beginTransaction();
			sess.delete(evt);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}

		return evt;
	}

}
