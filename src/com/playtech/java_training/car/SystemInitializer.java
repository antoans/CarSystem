package com.playtech.java_training.car;

import java.util.Collection;
import java.util.Timer;

import com.playtech.java_training.car.systems.AbstractSystem;
import com.playtech.java_training.car.systems.timertasks.CheckSubSystemsTask;
import com.playtech.java_training.interfaces.SystemDependable;

public class SystemInitializer {

	public static void start(Collection<AbstractSystem> systems, SystemDependable parentSystem) {
		initSystems(systems);

		Timer checkTimer = new Timer();
		checkTimer.schedule(new CheckSubSystemsTask(checkTimer, systems, parentSystem), 1000, 1000);
	}

	private static void initSystems(Collection<AbstractSystem> systems) {
		for (AbstractSystem system : systems) {
			system.initialize();
		}
	}

}
