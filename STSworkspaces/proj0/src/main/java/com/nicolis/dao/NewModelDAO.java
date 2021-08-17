package com.nicolis.dao;

import java.util.List;

import com.nicolis.proj0.NewModel;

public interface NewModelDAO {

	public NewModel addNewModel(NewModel n);

	public List<NewModel> getAllNewModels();

	public NewModel getNewModel(int id);

	public NewModel getNewModel(String name);

	public NewModel updateNewModel(NewModel change);

	public NewModel deleteNewModel(int id);
}
