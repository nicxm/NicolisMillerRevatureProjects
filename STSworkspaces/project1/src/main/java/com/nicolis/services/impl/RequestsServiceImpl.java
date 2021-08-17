package com.nicolis.services.impl;

import java.util.List;

import com.nicolis.models.Requests;
import com.nicolis.repositories.RequestsRepo;
import com.nicolis.services.RequestsService;

public class RequestsServiceImpl implements RequestsService {
	public RequestsRepo reqr;

	public RequestsServiceImpl(RequestsRepo reqr) {
		super();
		this.reqr = reqr;
	}

	@Override
	public Requests getRequests(int reqId) {
		return reqr.getRequests(reqId);
	}

	@Override
	public List<Requests> getAllRequests() {
		return reqr.getAllRequests();
	}

	@Override
	public Requests addRequests(Requests req) {
		return reqr.addRequests(req);
	}

	@Override
	public Requests updateRequests(Requests change) {
		return reqr.updateRequests(change);
	}

	@Override
	public Requests deleteRequests(int reqId) {
		return reqr.deleteRequests(reqId);
	}

}
