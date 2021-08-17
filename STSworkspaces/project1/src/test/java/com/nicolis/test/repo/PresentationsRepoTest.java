package com.nicolis.test.repo;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nicolis.models.Presentations;
import com.nicolis.models.Reimbursements;
import com.nicolis.repositories.impl.PresentationsRepoImpl;
import com.nicolis.repositories.impl.ReimbursementsRepoImpl;

class PresentationsRepoTest {

	ReimbursementsRepoImpl testr = new ReimbursementsRepoImpl();
	Reimbursements reimbursement = testr.getReimbursements(1);
	PresentationsRepoImpl test = new PresentationsRepoImpl();
	Presentations presentation = new Presentations(reimbursement, "this is my presentation");
	Presentations updPresentation = new Presentations(2, reimbursement, "this is my presentation");

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddPresentations() {
		assertNotNull("", test.addPresentations(presentation));
	}

	@Test
	void testGetAllPresentations() {
		assertNotNull("", test.getAllPresentations());
	}

	@Test
	void testGetPresentations() {
		assertNotNull("", test.getPresentations(1));
	}

//	@Test
//	void testUpdatePresentations() {
//		assertNotNull("", test.updatePresentations(updPresentation));
//	}
//
//	@Test
//	void testDeletePresentations() {
//		assertNotNull("", test.deletePresentations(5));
//	}

}
