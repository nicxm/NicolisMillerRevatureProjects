package com.nicolis.repositories;

import java.util.List;

import com.nicolis.models.Reimbursements;

public interface ReimbursementsRepo {
	public Reimbursements getReimbursements(int RId);

	public List<Reimbursements> getAllReimbursements();

	public Reimbursements addReimbursements(Reimbursements r);

	public Reimbursements updateReimbursements(Reimbursements change);

	public Reimbursements deleteReimbursements(int RId);

}
