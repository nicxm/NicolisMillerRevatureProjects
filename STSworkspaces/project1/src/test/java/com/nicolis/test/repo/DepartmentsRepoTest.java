package com.nicolis.test.repo;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nicolis.models.Departments;
import com.nicolis.repositories.impl.DepartmentsRepoImpl;

class DepartmentsRepoTest {
	DepartmentsRepoImpl test = new DepartmentsRepoImpl();
	Departments newDept = new Departments("JunitTestDept", "JunitTestDHead");
	Departments updDept = test.getDepartments(2);

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddDepartments() {
		assertNotNull("", test.addDepartments(newDept));
	}

	@Test
	void testGetAllDepartments() {
		assertNotNull("", test.getAllDepartments());
	}

	@Test
	void testGetDepartments() {
		assertNotNull("", test.getDepartments(1));
	}

//	@Test
//	void testUpdateDepartments() {
//		assertNotNull("", test.updateDepartments(updDept));
//	}
//
//	@Test
//	void testDeleteDepartments() {
//		assertNotNull("", test.deleteDepartments(3));
//	}

}
