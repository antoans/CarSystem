package com.playtech.java_training.car;

import java.util.Collection;

import com.playtech.java_training.car.systems.AbstractSystem;
import com.playtech.java_training.car.systems.ComplexSystem;
import com.playtech.java_training.car.systems.enums.Status;

public class Car extends ComplexSystem {

//	public Car(String name, Map<AbstractSystem, Boolean> systems) {
//		super(0, systems);
//		this.name = name;
//	}
	
	public Car(String name, Collection<AbstractSystem> systems) {
		super(0, systems);
		this.name = name;
	}
	
	@Override
	protected void onSubSystemsInitialized() {
		if (checkSubSystemsForStatus(Status.ERROR)) {
			onInitializeCompleted(Status.ERROR);
		} else if (checkSubSystemsForStatus(Status.WARNING)) {
			onInitializeCompleted(Status.WARNING);
		} else {
			onInitializeCompleted(Status.HEALTHY);
		}
	}
}
