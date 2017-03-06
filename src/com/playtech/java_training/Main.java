package com.playtech.java_training;

import com.playtech.java_training.car.Car;
import com.playtech.java_training.car.CarFactory;

public class Main {

	public static void main(String[] args) {
		Car c = CarFactory.make("BMW");
		c.initialize();
	}

}
