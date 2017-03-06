package com.playtech.java_training.car.systems;

import com.playtech.java_training.car.systems.enums.Status;

public class BreakSystem extends AbstractSystem {

	public BreakSystem() {
		this(DEFAULT_INIT_TIME);
	}

	public BreakSystem(int initializationTime) {
		super(initializationTime);
		name = "break";
	}

	public BreakSystem(int initializationTime, Status forcedStatus) {
		super(initializationTime, forcedStatus);
	}
}
