package com.nicolis.services;

import java.util.List;

import com.nicolis.models.GradingFormats;

public interface GradingFormatsService {
	public GradingFormats getGradingFormats(int gfId);

	public List<GradingFormats> getAllGradingFormats();

	public GradingFormats addGradingFormats(GradingFormats gf);

	public GradingFormats updateGradingFormats(GradingFormats change);

	public GradingFormats deleteGradingFormats(int gfId);

}
