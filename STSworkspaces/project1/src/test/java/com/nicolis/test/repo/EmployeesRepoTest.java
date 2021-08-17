package com.nicolis.test.repo;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nicolis.models.Departments;
import com.nicolis.models.Employees;
import com.nicolis.repositories.impl.DepartmentsRepoImpl;
import com.nicolis.repositories.impl.EmployeesRepoImpl;

class EmployeesRepoTest {

	EmployeesRepoImpl test = new EmployeesRepoImpl();
	DepartmentsRepoImpl testd = new DepartmentsRepoImpl();
	Departments dept = testd.getDepartments(1);
	Employees supEmp = test.getEmployees(1);
	Employees benEmp = test.getEmployees(1);
	BigDecimal awardedR = new BigDecimal(0);
	Employees newEmp = new Employees(dept, supEmp, benEmp, "testu", "testpw", "testn", "dob", "email", awardedR);
	Employees updatedEmp = test.getEmployees(2);

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddEmployees() {
		assertNotNull("", test.addEmployees(newEmp));
	}

	@Test
	void testGetAllEmployees() {
		assertNotNull("", test.getAllEmployees());
	}

	@Test
	void testGetEmployees() {
		assertNotNull("", test.getEmployees(1));
	}

//	@Test
//	void testUpdateEmployees() {
//		assertNotNull("", test.updateEmployees(updatedEmp));
//	}
//
//	@Test
//	void testDeleteEmployees() {
//		assertNotNull("", test.deleteEmployees(5));
//	}

}
