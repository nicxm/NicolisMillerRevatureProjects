package com.nicolis.services.impl;

import java.util.List;

import com.nicolis.models.Reimbursements;
import com.nicolis.repositories.ReimbursementsRepo;
import com.nicolis.services.ReimbursementsService;

public class ReimbursementsServiceImpl implements ReimbursementsService {
	public ReimbursementsRepo rr;

	public ReimbursementsServiceImpl(ReimbursementsRepo rr) {
		super();
		this.rr = rr;
	}

	@Override
	public Reimbursements getReimbursements(int RId) {
		return rr.getReimbursements(RId);
	}

	@Override
	public List<Reimbursements> getAllReimbursements() {
		return rr.getAllReimbursements();
	}

	@Override
	public Reimbursements addReimbursements(Reimbursements r) {
		return rr.addReimbursements(r);
	}

	@Override
	public Reimbursements updateReimbursements(Reimbursements change) {
		return rr.updateReimbursements(change);
	}

	@Override
	public Reimbursements deleteReimbursements(int RId) {
		return rr.deleteReimbursements(RId);
	}

}
