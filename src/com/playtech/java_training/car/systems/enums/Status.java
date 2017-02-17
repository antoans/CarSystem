package com.playtech.java_training.car.systems.enums;

public enum Status {
	NOT_INIT, HEALTHY, WARNING, ERROR;

	public static Status getRandom() {
		double rand = Math.random();
		if (rand < 0.1) {
			System.out.println("ERROR");
			return ERROR;
		} else if (rand < 0.3) {
			System.out.println("WARNING");
			return WARNING;
		}
		System.out.println("HEALTHY");
		return HEALTHY;
	}
}
