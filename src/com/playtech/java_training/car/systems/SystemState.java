package com.playtech.java_training.car.systems;

public class SystemState {
	private boolean initialized;

	public SystemState() {
		initialized = false;
	}

	public boolean isInitialized() {
		return initialized;
	}

	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}

}
