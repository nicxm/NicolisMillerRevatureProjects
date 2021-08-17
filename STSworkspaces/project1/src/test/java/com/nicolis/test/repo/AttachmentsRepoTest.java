package com.nicolis.test.repo;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nicolis.models.Attachments;
import com.nicolis.models.Reimbursements;
import com.nicolis.repositories.impl.AttachmentsRepoImpl;
import com.nicolis.repositories.impl.ReimbursementsRepoImpl;

class AttachmentsRepoTest {
	ReimbursementsRepoImpl testr = new ReimbursementsRepoImpl();
	Reimbursements reimbursement = testr.getReimbursements(1);
	AttachmentsRepoImpl test = new AttachmentsRepoImpl();
	Attachments attachment = new Attachments(reimbursement, "www.test.net");
	Attachments updAttachment = test.getAttachments(2);

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddAttachments() {
		assertNotNull("", test.addAttachments(attachment));
	}

	@Test
	void testGetAllAttachments() {
		assertNotNull("", test.getAllAttachments());
	}

	@Test
	void testGetAttachments() {
		assertNotNull("", test.getAttachments(1));
	}

//	@Test
//	void testUpdateAttachments() {
//		assertNotNull("", test.updateAttachments(updAttachment));
//	}
//
//	@Test
//	void testDeleteAttachments() {
//		assertNotNull("", test.deleteAttachments(4));
//	}

}
