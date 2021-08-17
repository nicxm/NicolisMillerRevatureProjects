package com.nicolis.repositories;

import java.util.List;

import com.nicolis.models.GradingFormats;

public interface GradingFormatsRepo {
	public GradingFormats getGradingFormats(int gfId);

	public List<GradingFormats> getAllGradingFormats();

	public GradingFormats addGradingFormats(GradingFormats gf);

	public GradingFormats updateGradingFormats(GradingFormats change);

	public GradingFormats deleteGradingFormats(int gfId);

}
