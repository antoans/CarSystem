package com.playtech.java_training;

import java.util.Arrays;

import com.playtech.java_training.car.Car;
import com.playtech.java_training.car.systems.AbstractSystem;
import com.playtech.java_training.car.systems.BreakingSystem;
import com.playtech.java_training.car.systems.HeatingSystem;

public class Main {

	public static void main(String[] args) {
		Car c = new Car(Arrays.asList(new AbstractSystem [] {new BreakingSystem(), new HeatingSystem()}));
		c.startIgnition();

	}

}
