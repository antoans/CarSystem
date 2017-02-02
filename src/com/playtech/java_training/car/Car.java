package com.playtech.java_training.car;

import java.util.Collection;

import com.playtech.java_training.car.systems.AbstractSystem;

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

		boolean areSystemsInit = false;
		while (!areSystemsInit) {
			areSystemsInit = true;
			for (AbstractSystem system : systems) {
				if (!system.isInitialized()) {
					areSystemsInit = false;
					break;
				}
			}
		}
		System.out.println("DONE");
	}
}
