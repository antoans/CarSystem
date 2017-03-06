package com.playtech.java_training.tests;

import java.util.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.playtech.java_training.car.Car;
import com.playtech.java_training.car.CarFactory;
import com.playtech.java_training.car.systems.AbstractSystem;

public class TestCarSystems {

	@Test
	public void testHasMandatorySystems() {
		String[] mandatorySystems = { "break", "tractioncontrol", "comfort" };
		Car vozilo = CarFactory.make("BMW");
		Collection<AbstractSystem> s = vozilo.getSystems();
		for (String system : mandatorySystems) {
//			Assert.assertTrue(s.contains(system));
			// TODO : check...
		}
	}
}
