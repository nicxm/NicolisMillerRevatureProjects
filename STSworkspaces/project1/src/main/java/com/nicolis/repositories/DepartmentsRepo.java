package com.nicolis.repositories;

import java.util.List;

import com.nicolis.models.Departments;

public interface DepartmentsRepo {

	public Departments getDepartments(int deptId);

	public List<Departments> getAllDepartments();

	public Departments addDepartments(Departments d);

	public Departments updateDepartments(Departments change);

	public Departments deleteDepartments(int deptId);

}
