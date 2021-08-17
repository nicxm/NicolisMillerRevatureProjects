package com.nicolis.repositories.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nicolis.models.Attachments;
import com.nicolis.repositories.AttachmentsRepo;
import com.nicolis.util.HibernateUtil;

public class AttachmentsRepoImpl implements AttachmentsRepo {

	@Override
	public Attachments addAttachments(Attachments a) {

		Session sess = HibernateUtil.getSession();

		try {
			sess.beginTransaction();
			a.setAttachId((int) sess.save(a));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			a = null;
		} finally {
			sess.close();
		}

		return a;
	}

	@Override
	public List<Attachments> getAllAttachments() {

		Session sess = HibernateUtil.getSession();
		List<Attachments> Attachments = null;
		try {
			// SELECT * FROM Attachments
			// HQL - wants you to be able to just use your Java Classes.
			Attachments = sess.createQuery("FROM Attachments").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return Attachments;
	}

	@Override
	public Attachments getAttachments(int AttachId) {

		Session sess = HibernateUtil.getSession();
		Attachments a = null;

		try {
			a = sess.get(Attachments.class, AttachId);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return a;
	}

	@Override
	public Attachments updateAttachments(Attachments change) {

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
	public Attachments deleteAttachments(int AttachId) {

		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Attachments a = sess.get(Attachments.class, AttachId);

		try {
			tx = sess.beginTransaction();
			sess.delete(a);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}

		return a;
	}

}
