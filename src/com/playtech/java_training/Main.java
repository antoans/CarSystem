package com.playtech.java_training;

import java.util.HashMap;

import com.playtech.java_training.car.Car;
import com.playtech.java_training.car.systems.AbstractSystem;
import com.playtech.java_training.car.systems.AudioSystem;
import com.playtech.java_training.car.systems.BreakingSystem;
import com.playtech.java_training.car.systems.ComfortSystem;
import com.playtech.java_training.car.systems.HeatingSystem;

public class Main {

	public static void main(String[] args) {
		HashMap<AbstractSystem, Boolean> carSystems = new HashMap<>();
		HashMap<AbstractSystem, Boolean> comfortSystems = new HashMap<>();

		AbstractSystem b = new BreakingSystem();
		AbstractSystem a = new AudioSystem();
		AbstractSystem h = new HeatingSystem();

		comfortSystems.put(a, true);
		comfortSystems.put(h, true);
		AbstractSystem c = new ComfortSystem(comfortSystems);

		carSystems.put(b, true);
		carSystems.put(c, true);

		Car car = new Car(carSystems);
		car.initialize();
	}

}
