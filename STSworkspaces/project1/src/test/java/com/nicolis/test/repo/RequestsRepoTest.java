package com.nicolis.test.repo;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nicolis.models.Employees;
import com.nicolis.models.Reimbursements;
import com.nicolis.models.Requests;
import com.nicolis.repositories.impl.EmployeesRepoImpl;
import com.nicolis.repositories.impl.ReimbursementsRepoImpl;
import com.nicolis.repositories.impl.RequestsRepoImpl;

class RequestsRepoTest {
	EmployeesRepoImpl teste = new EmployeesRepoImpl();
	Employees employee = teste.getEmployees(2);
	ReimbursementsRepoImpl testr = new ReimbursementsRepoImpl();
	Reimbursements reimbursement = testr.getReimbursements(1);
	RequestsRepoImpl test = new RequestsRepoImpl();
	Requests request = new Requests(employee, reimbursement, "message", true);
	Requests updRequest = new Requests(3, employee, reimbursement, "message", true);

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddRequests() {
		assertNotNull("", test.addRequests(request));
	}

	@Test
	void testGetAllRequests() {
		assertNotNull("", test.getAllRequests());
	}

	@Test
	void testGetRequests() {
		assertNotNull("", test.getRequests(1));
	}

//	@Test
//	void testUpdateRequests() {
//		assertNotNull("", test.updateRequests(updRequest));
//	}
//
//	@Test
//	void testDeleteRequests() {
//		assertNotNull("", test.deleteRequests(4));
//	}

}
