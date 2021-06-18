package com.example.model;

public class Whale extends Mammal implements Swimmer{

	@Override
	public void swim() {
		System.out.println("Swim swim swim");
		
	}

}