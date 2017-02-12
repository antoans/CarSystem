package com.playtech.java_training.car;

import java.util.Collection;

import com.playtech.java_training.car.systems.AbstractSystem;
import com.playtech.java_training.interfaces.SystemDependable;

public class Car implements SystemDependable {
	private Collection<AbstractSystem> systems;

	public Car(Collection<AbstractSystem> systems) {
		setSystems(systems);
	}

	public Collection<AbstractSystem> getSystems() {
		return systems;
	}

	private void setSystems(Collection<AbstractSystem> systems) {
		if (systems == null || systems.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.systems = systems;
	}

	public void startIgnition() {
		SystemInitializer.start(systems, this);
	}
	
	@Override
	public void onSubSystemsInitialized() {
		//TODO : check all subsystems' status
		System.out.println(this.getClass().getSimpleName() + " - Done.");
	}
}
