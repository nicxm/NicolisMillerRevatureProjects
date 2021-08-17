package com.nicolis.repositories;

import java.util.List;

import com.nicolis.models.Presentations;

public interface PresentationsRepo {
	public Presentations getPresentations(int presId);

	public List<Presentations> getAllPresentations();

	public Presentations addPresentations(Presentations p);

	public Presentations updatePresentations(Presentations change);

	public Presentations deletePresentations(int presId);

}
