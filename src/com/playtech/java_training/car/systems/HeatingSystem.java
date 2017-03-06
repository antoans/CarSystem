package com.playtech.java_training.car.systems;

import com.playtech.java_training.car.systems.enums.Status;

public class HeatingSystem extends AbstractSystem {
	public HeatingSystem(int initializationTime, Status forcedStatus) {
		super(initializationTime, forcedStatus);
		// TODO Auto-generated constructor stub
	}

	public HeatingSystem() {
		this(DEFAULT_INIT_TIME);
	}

	public HeatingSystem(int initializationTime) {
		super(initializationTime);
		name = "heating";
	}
}
