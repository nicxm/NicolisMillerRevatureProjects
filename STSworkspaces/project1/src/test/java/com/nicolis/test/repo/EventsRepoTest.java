package com.nicolis.test.repo;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nicolis.models.EventTypes;
import com.nicolis.models.Events;
import com.nicolis.models.GradingFormats;
import com.nicolis.repositories.impl.EventTypesRepoImpl;
import com.nicolis.repositories.impl.EventsRepoImpl;
import com.nicolis.repositories.impl.GradingFormatsRepoImpl;

class EventsRepoTest {
	GradingFormatsRepoImpl testgf = new GradingFormatsRepoImpl();
	EventTypesRepoImpl testet = new EventTypesRepoImpl();
	EventTypes newet = testet.getEventTypes(1);
	GradingFormats newgf = testgf.getGradingFormats(1);
	EventsRepoImpl test = new EventsRepoImpl();
	BigDecimal cost = new BigDecimal(0);
	Events event = new Events(newet, newgf, 121212, 000000, cost, "test", "test");
	Events updEvent = new Events(3, newet, newgf, 121212, 000000, cost, "test", "test");

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddEvents() {
		assertNotNull("", test.addEvents(event));
	}

	@Test
	void testGetAllEvents() {
		assertNotNull("", test.getAllEvents());
	}

	@Test
	void testGetEvents() {
		assertNotNull("", test.getEvents(1));
	}

//	@Test
//	void testUpdateEvents() {
//		assertNotNull("", test.updateEvents(updEvent));
//	}
//
//	@After
//	@Test
//	void testDeleteEvents() {
//		assertNotNull("", test.deleteEvents(5));
//	}

}
