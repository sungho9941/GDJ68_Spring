package com.iu.main.di;

public class Main {

	public static void main(String[] args) {
		Robot robot = new Robot();
		Arm arm = new Arm();
		robot.setArm(arm);
		System.out.println(robot.getArm());
		
		robot = null;
		
		
	}

}
