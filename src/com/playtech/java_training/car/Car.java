package com.playtech.java_training.car;

import java.util.Map;

import com.playtech.java_training.car.systems.AbstractSystem;
import com.playtech.java_training.car.systems.ComplexSystem;
import com.playtech.java_training.car.systems.enums.Status;

public class Car extends ComplexSystem {

	public Car(Map<AbstractSystem, Boolean> systems) {
		super(0, systems);
	}
}
