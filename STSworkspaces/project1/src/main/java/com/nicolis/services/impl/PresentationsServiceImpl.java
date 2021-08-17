package com.nicolis.services.impl;

import java.util.List;

import com.nicolis.models.Presentations;
import com.nicolis.repositories.PresentationsRepo;
import com.nicolis.services.PresentationsService;

public class PresentationsServiceImpl implements PresentationsService {
	public PresentationsRepo pr;

	public PresentationsServiceImpl(PresentationsRepo pr) {
		super();
		this.pr = pr;
	}

	@Override
	public Presentations getPresentations(int presId) {
		return pr.getPresentations(presId);
	}

	@Override
	public List<Presentations> getAllPresentations() {
		return pr.getAllPresentations();
	}

	@Override
	public Presentations addPresentations(Presentations p) {
		return pr.addPresentations(p);
	}

	@Override
	public Presentations updatePresentations(Presentations change) {
		return pr.updatePresentations(change);
	}

	@Override
	public Presentations deletePresentations(int presId) {
		return pr.deletePresentations(presId);
	}

}
