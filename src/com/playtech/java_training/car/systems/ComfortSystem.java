package com.playtech.java_training.car.systems;

import java.util.Collection;

public class ComfortSystem extends ComplexSystem {

	public ComfortSystem(Collection<AbstractSystem> subSystems) {
		super(4000, subSystems);
	}

	@Override
	public void initialize() {
		super.initialize();
	}

}
