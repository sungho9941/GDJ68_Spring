package com.iu.main.di;

public class Robot {
	private String name;
	
	private Arm arm;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Arm getArm() {
		return arm;
	}

	public void setArm(Arm arm) {
		this.arm = arm;
	}
	
	public Robot() {
//		this.arm = new Arm();
//		결합도높음
	}

	public Robot(Arm arm) {
		this.arm = arm;		
//		결합도낮음
	}
}
