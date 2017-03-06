package com.playtech.java_training.car.systems;

import com.playtech.java_training.car.systems.enums.Status;

public class TractionControlSystem extends AbstractSystem {

	public TractionControlSystem(int initializationTime, Status forcedStatus) {
		super(initializationTime, forcedStatus);
		// TODO Auto-generated constructor stub
	}

	public TractionControlSystem() {
		this(DEFAULT_INIT_TIME);
	}

	public TractionControlSystem(int initializationTime) {
		super(initializationTime);
		name = "tractioncontrol";
	}

}
