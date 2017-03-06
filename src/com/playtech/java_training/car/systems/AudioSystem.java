package com.playtech.java_training.car.systems;

import com.playtech.java_training.car.systems.enums.Status;

public class AudioSystem extends AbstractSystem {

	public AudioSystem(int initializationTime, Status forcedStatus) {
		super(initializationTime, forcedStatus);
		// TODO Auto-generated constructor stub
	}

	public AudioSystem() {
		this(DEFAULT_INIT_TIME);
	}

	public AudioSystem(int initializationTime) {
		super(initializationTime);
		name = "audio";
	}

}
