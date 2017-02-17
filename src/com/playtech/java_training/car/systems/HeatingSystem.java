package com.playtech.java_training.car.systems;

import com.playtech.java_training.car.systems.enums.Status;

public class HeatingSystem extends AbstractSystem {
	public HeatingSystem() {
		super(3000);
	}
	
	@Override
	protected Status decideStatus() {
		return Status.WARNING;
	}
}
