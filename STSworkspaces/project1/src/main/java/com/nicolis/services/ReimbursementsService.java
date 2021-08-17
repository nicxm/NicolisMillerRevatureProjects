package com.nicolis.services;

import java.util.List;

import com.nicolis.models.Reimbursements;

public interface ReimbursementsService {
	public Reimbursements getReimbursements(int RId);

	public List<Reimbursements> getAllReimbursements();

	public Reimbursements addReimbursements(Reimbursements r);

	public Reimbursements updateReimbursements(Reimbursements change);

	public Reimbursements deleteReimbursements(int RId);

}
