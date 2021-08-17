package com.nicolis.services.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nicolis.models.Employees;
import com.nicolis.repositories.EmployeesRepo;
import com.nicolis.services.EmployeesService;
import com.nicolis.util.HibernateUtil;

public class EmployeesServiceImpl implements EmployeesService {

	public EmployeesRepo er;

	public EmployeesServiceImpl(EmployeesRepo er) {
		super();
		this.er = er;
	}

	@Override
	public Employees getEmployees(int EId) {
		return er.getEmployees(EId);
	}

	@Override
	public List<Employees> getAllEmployees() {
		return er.getAllEmployees();
	}

	@Override
	public Employees addEmployees(Employees e) {
		return er.addEmployees(e);
	}

	@Override
	public Employees updateEmployees(Employees change) {
		return er.updateEmployees(change);
	}

	@Override
	public Employees deleteEmployees(int EId) {
		return er.deleteEmployees(EId);
	}

	@Override
	public Employees getEmployees(String username, String password) {
		Session sess = HibernateUtil.getSession();
		Employees e = null;

		try {
			Criteria crit = sess.createCriteria(Employees.class);
			crit.add(Restrictions.eq("username", username));
			crit.add(Restrictions.eq("password", password));
			if (crit.list().size() > 0)
				e = (Employees) crit.list().get(0);
		} catch (HibernateException e1) {
			e1.printStackTrace();
		} finally {
			sess.close();
		}

		return e;

	}
}
