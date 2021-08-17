package com.nicolis.repositories;

import java.util.List;

import com.nicolis.models.Requests;

public interface RequestsRepo {
	public Requests getRequests(int reqId);

	public List<Requests> getAllRequests();

	public Requests addRequests(Requests req);

	public Requests updateRequests(Requests change);

	public Requests deleteRequests(int reqId);

}
