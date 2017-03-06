package com.playtech.java_training.car;

import java.util.Arrays;

import com.playtech.java_training.car.systems.AbstractSystem;
import com.playtech.java_training.car.systems.AudioSystem;
import com.playtech.java_training.car.systems.BreakSystem;
import com.playtech.java_training.car.systems.ComfortSystem;
import com.playtech.java_training.car.systems.CoolingSystem;
import com.playtech.java_training.car.systems.HeatingSystem;
import com.playtech.java_training.car.systems.TractionControlSystem;

public class CarFactory {
	public static Car make(String make) {
		Car c;
		switch (make) {
		case "BMW":
			c = new Car(make, Arrays.asList(new AbstractSystem[] {
					new BreakSystem(3000),
					new TractionControlSystem(2000),
					new ComfortSystem(Arrays.asList(new AbstractSystem[] {
							new HeatingSystem(1000),
							new CoolingSystem(5000),
							new AudioSystem(4000)
					}))
			}));
			break;
		case "Audi":
			c = new Car(make, Arrays.asList(new AbstractSystem[] {
					new BreakSystem(),
					new TractionControlSystem(),
					new ComfortSystem(Arrays.asList(new AbstractSystem[] {
							new HeatingSystem(),
							new CoolingSystem(),
							new AudioSystem()
					}))
			}));
			break;

		default:
			throw new IllegalArgumentException("We can make only Audi and BMW");
		}
		return c;
	}
	
	public static Car makeWithForcedStatus(String make) {
		Car c;
		switch (make) {
		case "BMW":
			c = new Car(make, Arrays.asList(new AbstractSystem[] {
					new BreakSystem(3000),
					new TractionControlSystem(2000),
					new ComfortSystem(Arrays.asList(new AbstractSystem[] {
							new HeatingSystem(1000),
							new CoolingSystem(5000),
							new AudioSystem(4000)
					}))
			}));
			break;
		case "Audi":
			c = new Car(make, Arrays.asList(new AbstractSystem[] {
					new BreakSystem(),
					new TractionControlSystem(),
					new ComfortSystem(Arrays.asList(new AbstractSystem[] {
							new HeatingSystem(),
							new CoolingSystem(),
							new AudioSystem()
					}))
			}));
			break;

		default:
			throw new IllegalArgumentException("We can make only Audi and BMW");
		}
		return c;
	}
}
