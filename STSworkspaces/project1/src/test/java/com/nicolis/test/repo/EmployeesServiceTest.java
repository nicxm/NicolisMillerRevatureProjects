package com.nicolis.test.repo;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nicolis.repositories.impl.DepartmentsRepoImpl;
import com.nicolis.repositories.impl.EmployeesRepoImpl;
import com.nicolis.services.impl.DepartmentsServiceImpl;
import com.nicolis.services.impl.EmployeesServiceImpl;

class EmployeesServiceTest {
	EmployeesRepoImpl er = new EmployeesRepoImpl();
	DepartmentsRepoImpl dr = new DepartmentsRepoImpl();

	EmployeesServiceImpl test = new EmployeesServiceImpl(er);
	DepartmentsServiceImpl testd = new DepartmentsServiceImpl(dr);

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetEmployeesStringString() {
		assertNotNull("", test.getEmployees("username1", "password1"));
	}

}
