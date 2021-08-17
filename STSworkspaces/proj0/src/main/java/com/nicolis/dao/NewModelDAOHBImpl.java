package com.nicolis.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nicolis.proj0.NewModel;
import com.nicolis.util.HibernateUtil;

public class NewModelDAOHBImpl implements NewModelDAO {

	@Override
	public NewModel addNewModel(NewModel n) {

		return null;
	}

	@Override
	public List<NewModel> getAllNewModels() {

		return null;
	}

	@Override
	public NewModel getNewModel(int id) {

		Session sess = HibernateUtil.getSession();
		NewModel n = null;

		try {
			sess.get(NewModel.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return n;
	}

	@Override
	public NewModel getNewModel(String name) {

		return null;
	}

	@Override
	public NewModel updateNewModel(NewModel change) {

		return null;
	}

	@Override
	public NewModel deleteNewModel(int id) {

		return null;
	}

}
