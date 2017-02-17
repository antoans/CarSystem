package com.playtech.java_training.car.systems;

import java.util.Map;

public class ComfortSystem extends ComplexSystem {

	public ComfortSystem(Map<AbstractSystem, Boolean> subSystems) {
		super(4000, subSystems);
	}

	@Override
	public void initialize() {
		super.initialize();
	}

}
