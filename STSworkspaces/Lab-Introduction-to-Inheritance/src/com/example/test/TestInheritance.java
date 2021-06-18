package com.example.test;

import com.example.model.ActionFigure;

public class TestInheritance {
	public static void main(String[] args) {
		ActionFigure ironMan = new ActionFigure();
		ironMan.setName("Tony Stark");
		System.out.println(ironMan.getName());
	}
}