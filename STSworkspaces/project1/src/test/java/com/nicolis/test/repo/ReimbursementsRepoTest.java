package com.nicolis.test.repo;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nicolis.models.Employees;
import com.nicolis.models.Events;
import com.nicolis.models.Reimbursements;
import com.nicolis.repositories.impl.EmployeesRepoImpl;
import com.nicolis.repositories.impl.EventsRepoImpl;
import com.nicolis.repositories.impl.ReimbursementsRepoImpl;

class ReimbursementsRepoTest {
	EmployeesRepoImpl teste = new EmployeesRepoImpl();
	Employees employee = teste.getEmployees(2);
	EventsRepoImpl testev = new EventsRepoImpl();
	Events event = testev.getEvents(1);
	ReimbursementsRepoImpl test = new ReimbursementsRepoImpl();
	BigDecimal claim = new BigDecimal(150);
	Reimbursements reimbursement = new Reimbursements(employee, event, claim, "JunitTestDept", "JunitTestDHead", true,
			true, false);
	Reimbursements updReimbursement = new Reimbursements(106, employee, event, claim, "JunitTestDept", "JunitTestDHead",
			true, true, false);

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddReimbursements() {
		assertNotNull("", test.addReimbursements(reimbursement));
	}

	@Test
	void testGetAllReimbursements() {
		assertNotNull("", test.getAllReimbursements());
	}

	@Test
	void testGetReimbursements() {
		assertNotNull("", test.getReimbursements(1));
	}

//	@Test
//	void testUpdateReimbursements() {
//		assertNotNull("", test.updateReimbursements(updReimbursement));
//	}
//
//	@Test
//	void testDeleteReimbursements() {
//		assertNotNull("", test.deleteReimbursements(108));
//	}

}
