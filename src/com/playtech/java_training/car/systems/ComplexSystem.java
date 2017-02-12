package com.playtech.java_training.car.systems;

import java.util.Collection;

import com.playtech.java_training.car.SystemInitializer;
import com.playtech.java_training.interfaces.SystemDependable;

public abstract class ComplexSystem extends AbstractSystem implements SystemDependable {

	protected Collection<AbstractSystem> systems;

	public ComplexSystem(int initializationTime, Collection<AbstractSystem> systems) {
		super(initializationTime);
		this.systems = systems;
	}

	@Override
	public void initialize() {
		SystemInitializer.start(systems, this);
	}

	@Override
	public void onSubSystemsInitialized() {
		// TODO : check all subsystems' status
		System.out.println(this.getClass().getSimpleName() + " - Done.");
		isInitialized = true;
	}
}
