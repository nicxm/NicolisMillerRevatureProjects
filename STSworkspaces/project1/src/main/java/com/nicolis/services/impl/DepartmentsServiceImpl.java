package com.nicolis.services.impl;

import java.util.List;

import com.nicolis.models.Departments;
import com.nicolis.repositories.DepartmentsRepo;
import com.nicolis.services.DepartmentsService;

public class DepartmentsServiceImpl implements DepartmentsService {

	public DepartmentsRepo dr;

	public DepartmentsServiceImpl(DepartmentsRepo dr) {
		super();
		this.dr = dr;
	}

	@Override
	public Departments getDepartments(int deptId) {
		return dr.getDepartments(deptId);
	}

	@Override
	public List<Departments> getAllDepartments() {
		return dr.getAllDepartments();
	}

	@Override
	public Departments addDepartments(Departments d) {
		return dr.addDepartments(d);
	}

	@Override
	public Departments updateDepartments(Departments change) {
		return dr.updateDepartments(change);
	}

	@Override
	public Departments deleteDepartments(int deptId) {
		return dr.deleteDepartments(deptId);
	}

}
