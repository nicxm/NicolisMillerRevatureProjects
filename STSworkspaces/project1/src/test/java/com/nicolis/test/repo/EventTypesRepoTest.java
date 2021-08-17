package com.nicolis.test.repo;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nicolis.models.EventTypes;
import com.nicolis.repositories.impl.EventTypesRepoImpl;

class EventTypesRepoTest {
	EventTypesRepoImpl test = new EventTypesRepoImpl();
	byte percent = 5;
	EventTypes eventType = new EventTypes("Class", percent);
	EventTypes updEventType = new EventTypes(3, "Class", percent);

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddEventTypes() {
		assertNotNull("", test.addEventTypes(eventType));
	}

	@Test
	void testGetAllEventTypes() {
		assertNotNull("", test.getAllEventTypes());
	}

	@Test
	void testGetEventTypes() {
		assertNotNull("", test.getEventTypes(1));
	}

//	@Test
//	void testUpdateEventTypes() {
//		assertNotNull("", test.updateEventTypes(updEventType));
//	}
//
//	@Test
//	void testDeleteEventTypes() {
//		assertNotNull("", test.deleteEventTypes(6));
//	}

}
