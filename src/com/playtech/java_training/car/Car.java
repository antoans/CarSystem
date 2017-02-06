package com.playtech.java_training.car;

import java.util.Collection;
import java.util.Timer;

import com.playtech.java_training.car.systems.AbstractSystem;
import com.playtech.java_training.car.systems.timertasks.CheckSystemsTask;

public class Car {
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
		for (AbstractSystem system : systems) {
			system.initialize();
		}
		
		Timer checkTimer = new Timer();
		checkTimer.schedule(new CheckSystemsTask(checkTimer, systems), 1000, 1000);
	}
}
