package com.playtech.java_training.car.systems;

import com.playtech.java_training.car.systems.enums.Status;

public class CoolingSystem extends AbstractSystem {

	public CoolingSystem() {
		this(DEFAULT_INIT_TIME);
	}

	public CoolingSystem(int initializationTime) {
		super(initializationTime);
		name = "cooling";
	}

	public CoolingSystem(int initializationTime, Status forcedStatus) {
		super(initializationTime, forcedStatus);
		// TODO Auto-generated constructor stub
	}

}
