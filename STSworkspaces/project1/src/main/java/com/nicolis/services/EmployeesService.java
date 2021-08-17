package com.nicolis.services;

import java.util.List;

import com.nicolis.models.Employees;

public interface EmployeesService {
	public Employees getEmployees(int EId);

	public List<Employees> getAllEmployees();

	public Employees addEmployees(Employees e);

	public Employees updateEmployees(Employees change);

	public Employees deleteEmployees(int EId);

	public Employees getEmployees(String username, String password);
}
