package com.playtech.java_training.car.systems.enums;

public enum Status {
	NOT_INIT, HEALTHY, WARNING, ERROR;

	public static Status getRandom() {
		double rand = Math.random();
		if (rand < 0.1) {
			return ERROR;
		} else if (rand < 0.3) {
			return WARNING;
		}
		return HEALTHY;
	}
}
