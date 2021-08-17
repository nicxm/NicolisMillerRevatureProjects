package com.nicolis.app;

import com.nicolis.controllers.AttachmentsController;
import com.nicolis.controllers.DepartmentsController;
import com.nicolis.controllers.EmployeesController;
import com.nicolis.controllers.EventTypesController;
import com.nicolis.controllers.EventsController;
import com.nicolis.controllers.GradingFormatsController;
import com.nicolis.controllers.PresentationsController;
import com.nicolis.controllers.ReimbursementsController;
import com.nicolis.controllers.RequestsController;
import com.nicolis.repositories.AttachmentsRepo;
import com.nicolis.repositories.DepartmentsRepo;
import com.nicolis.repositories.EmployeesRepo;
import com.nicolis.repositories.EventTypesRepo;
import com.nicolis.repositories.EventsRepo;
import com.nicolis.repositories.GradingFormatsRepo;
import com.nicolis.repositories.PresentationsRepo;
import com.nicolis.repositories.ReimbursementsRepo;
import com.nicolis.repositories.RequestsRepo;
import com.nicolis.repositories.impl.AttachmentsRepoImpl;
import com.nicolis.repositories.impl.DepartmentsRepoImpl;
import com.nicolis.repositories.impl.EmployeesRepoImpl;
import com.nicolis.repositories.impl.EventTypesRepoImpl;
import com.nicolis.repositories.impl.EventsRepoImpl;
import com.nicolis.repositories.impl.GradingFormatsRepoImpl;
import com.nicolis.repositories.impl.PresentationsRepoImpl;
import com.nicolis.repositories.impl.ReimbursementsRepoImpl;
import com.nicolis.repositories.impl.RequestsRepoImpl;
import com.nicolis.services.AttachmentsService;
import com.nicolis.services.DepartmentsService;
import com.nicolis.services.EmployeesService;
import com.nicolis.services.EventTypesService;
import com.nicolis.services.EventsService;
import com.nicolis.services.GradingFormatsService;
import com.nicolis.services.PresentationsService;
import com.nicolis.services.ReimbursementsService;
import com.nicolis.services.RequestsService;
import com.nicolis.services.impl.AttachmentsServiceImpl;
import com.nicolis.services.impl.DepartmentsServiceImpl;
import com.nicolis.services.impl.EmployeesServiceImpl;
import com.nicolis.services.impl.EventTypesServiceImpl;
import com.nicolis.services.impl.EventsServiceImpl;
import com.nicolis.services.impl.GradingFormatsServiceImpl;
import com.nicolis.services.impl.PresentationsServiceImpl;
import com.nicolis.services.impl.ReimbursementsServiceImpl;
import com.nicolis.services.impl.RequestsServiceImpl;

import io.javalin.Javalin;

public class App {

	public static void main(String[] args) {
		Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());
		establishRoutes(app);
		app.start(7000);
	}

	private static void establishRoutes(Javalin app) {

		AttachmentsRepo ar = new AttachmentsRepoImpl();
		AttachmentsService as = new AttachmentsServiceImpl(ar);
		AttachmentsController ac = new AttachmentsController(as);

		DepartmentsRepo dr = new DepartmentsRepoImpl();
		DepartmentsService ds = new DepartmentsServiceImpl(dr);
		DepartmentsController dc = new DepartmentsController(ds);

		EmployeesRepo er = new EmployeesRepoImpl();
		EmployeesService es = new EmployeesServiceImpl(er);
		EmployeesController ec = new EmployeesController(es);

		EventsRepo evr = new EventsRepoImpl();
		EventsService evs = new EventsServiceImpl(evr);
		EventsController evc = new EventsController(evs);

		EventTypesRepo evtr = new EventTypesRepoImpl();
		EventTypesService evts = new EventTypesServiceImpl(evtr);
		EventTypesController evtc = new EventTypesController(evts);

		GradingFormatsRepo gfr = new GradingFormatsRepoImpl();
		GradingFormatsService gfs = new GradingFormatsServiceImpl(gfr);
		GradingFormatsController gfc = new GradingFormatsController(gfs);

		PresentationsRepo pr = new PresentationsRepoImpl();
		PresentationsService ps = new PresentationsServiceImpl(pr);
		PresentationsController pc = new PresentationsController(ps);

		ReimbursementsRepo rr = new ReimbursementsRepoImpl();
		ReimbursementsService rs = new ReimbursementsServiceImpl(rr);
		ReimbursementsController rc = new ReimbursementsController(rs);

		RequestsRepo rqr = new RequestsRepoImpl();
		RequestsService rqs = new RequestsServiceImpl(rqr);
		RequestsController rqc = new RequestsController(rqs);

		app.get("/employees", ec.getAllEmployees);
		app.get("/employees/:id", ec.getEmployeesById);
		app.post("/employees", ec.addEmployees);
		app.put("/employees/:id", ec.updateEmployees);
		app.delete("/employees/:id", ec.deleteEmployees);

		app.get("/reimbursements", rc.getAllReimbursements);
		app.get("/reimbursements/:id", rc.getReimbursementsById);
		app.post("/reimbursements", rc.addReimbursements);
		app.put("/reimbursements/:id", rc.updateReimbursements);
		app.delete("/reimbursements/:id", rc.deleteReimbursements);

		app.get("/attachments", ac.getAllAttachments);
		app.get("/attachments/:id", ac.getAttachmentsById);
		app.post("/attachments", ac.addAttachments);
		app.put("/attachments/:id", ac.updateAttachments);
		app.delete("/attachments/:id", ac.deleteAttachments);

		app.get("/departments", dc.getAllDepartments);
		app.get("/departments/:id", dc.getDepartmentsById);
		app.post("/departments", dc.addDepartments);
		app.put("/departments/:id", dc.updateDepartments);
		app.delete("/departments/:id", dc.deleteDepartments);

		app.get("/events", evc.getAllEvents);
		app.get("/events/:id", evc.getEventsById);
		app.post("/events", evc.addEvents);
		app.put("/events/:id", evc.updateEvents);
		app.delete("/events/:id", evc.deleteEvents);

		app.get("/eventtypes", evtc.getAllEventTypes);
		app.get("/eventtypes/:id", evtc.getEventTypesById);
		app.post("/eventtypes", evtc.addEventTypes);
		app.put("/eventtypes/:id", evtc.updateEventTypes);
		app.delete("/eventtypes/:id", evtc.deleteEventTypes);

		app.get("/gradingformats", gfc.getAllGradingFormats);
		app.get("/gradingformats/:id", gfc.getGradingFormatsById);
		app.post("/gradingformats", gfc.addGradingFormats);
		app.put("/gradingformats/:id", gfc.updateGradingFormats);
		app.delete("/gradingformats/:id", gfc.deleteGradingFormats);

		app.get("/presentations", pc.getAllPresentations);
		app.get("/presentations/:id", pc.getPresentationsById);
		app.post("/presentations", pc.addPresentations);
		app.put("/presentations/:id", pc.updatePresentations);
		app.delete("/presentations/:id", pc.deletePresentations);

		app.get("/requests", rqc.getAllRequests);
		app.get("/requests/:id", rqc.getRequestsById);
		app.post("/requests", rqc.addRequests);
		app.put("/requests/:id", rqc.updateRequests);
		app.delete("/requests/:id", rqc.deleteRequests);

	}
}