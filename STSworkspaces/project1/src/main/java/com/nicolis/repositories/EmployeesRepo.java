package com.nicolis.repositories;

import java.util.List;

import com.nicolis.models.Employees;

public interface EmployeesRepo {
	public Employees getEmployees(int EId);

	public List<Employees> getAllEmployees();

	public Employees addEmployees(Employees e);

	public Employees updateEmployees(Employees change);

	public Employees deleteEmployees(int EId);

}
