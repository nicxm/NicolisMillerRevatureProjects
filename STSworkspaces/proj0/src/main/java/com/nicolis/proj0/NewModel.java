package com.nicolis.proj0;

public class NewModel {

	private int id;
	private String name;
	private int age;

	public NewModel() {
		super();
	}

	public NewModel(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public NewModel(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "NewModel [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
