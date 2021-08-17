package com.nicolis.services.impl;

import java.util.List;

import com.nicolis.models.GradingFormats;
import com.nicolis.repositories.GradingFormatsRepo;
import com.nicolis.services.GradingFormatsService;

public class GradingFormatsServiceImpl implements GradingFormatsService {

	public GradingFormatsRepo gfr;

	public GradingFormatsServiceImpl(GradingFormatsRepo gfr) {
		super();
		this.gfr = gfr;
	}

	@Override
	public GradingFormats getGradingFormats(int gfId) {
		return gfr.getGradingFormats(gfId);
	}

	@Override
	public List<GradingFormats> getAllGradingFormats() {
		return gfr.getAllGradingFormats();
	}

	@Override
	public GradingFormats addGradingFormats(GradingFormats gf) {
		return gfr.addGradingFormats(gf);
	}

	@Override
	public GradingFormats updateGradingFormats(GradingFormats change) {
		return gfr.updateGradingFormats(change);
	}

	@Override
	public GradingFormats deleteGradingFormats(int gfId) {
		return gfr.deleteGradingFormats(gfId);
	}

}
