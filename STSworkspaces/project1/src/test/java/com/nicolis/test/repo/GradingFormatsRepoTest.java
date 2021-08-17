package com.nicolis.test.repo;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nicolis.models.GradingFormats;
import com.nicolis.repositories.impl.GradingFormatsRepoImpl;

class GradingFormatsRepoTest {

	GradingFormatsRepoImpl test = new GradingFormatsRepoImpl();
	GradingFormats gFormat = new GradingFormats("test", "test");
	GradingFormats updGFormat = new GradingFormats(3, "test", "test");

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddGradingFormats() {
		assertNotNull("", test.addGradingFormats(gFormat));
	}

	@Test
	void testGetAllGradingFormats() {
		assertNotNull("", test.getAllGradingFormats());
	}

	@Test
	void testGetGradingFormats() {
		assertNotNull("", test.getGradingFormats(1));
	}

//	@Test
//	void testUpdateGradingFormats() {
//		assertNotNull("", test.updateGradingFormats(updGFormat));
//	}
//
//	@Test
//	void testDeleteGradingFormats() {
//		assertNotNull("", test.deleteGradingFormats(5));
//	}

}
