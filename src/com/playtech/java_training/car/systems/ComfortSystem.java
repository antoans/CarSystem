package com.playtech.java_training.car.systems;

import java.util.Collection;

import com.playtech.java_training.car.systems.enums.Status;

public class ComfortSystem extends ComplexSystem {

	public ComfortSystem(Collection<AbstractSystem> subSystems) {
		this(DEFAULT_INIT_TIME, subSystems);
	}

	public ComfortSystem(int initializationTime, Collection<AbstractSystem> systems) {
		super(initializationTime, systems);
		name = "comfort";
	}

	public ComfortSystem(int initializationTime,
			Collection<AbstractSystem> systems, Status forcedStatus) {
		super(initializationTime, systems, forcedStatus);
		// TODO Auto-generated constructor stub
	}

}
