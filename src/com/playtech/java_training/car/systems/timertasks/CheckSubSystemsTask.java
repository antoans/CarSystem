package com.playtech.java_training.car.systems.timertasks;

import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

import com.playtech.java_training.car.systems.AbstractSystem;
import com.playtech.java_training.interfaces.SystemDependable;

public class CheckSubSystemsTask extends TimerTask {
	private Timer timer;
	private Collection<AbstractSystem> systems;
	private SystemDependable parentSystem;

	public CheckSubSystemsTask(Timer timer, Collection<AbstractSystem> systems, SystemDependable parentSystem) {
		this.timer = timer;
		this.systems = systems;
		this.parentSystem = parentSystem;
	}

	@Override
	public void run() {
		if (checkSystems()) {
			cancel();
			timer.cancel();
		}
	}

	private boolean checkSystems() {
		for (AbstractSystem system : systems) {
			if (!system.isInitialized()) {
				return false;
			}
		}
		parentSystem.onSubSystemsInitialized();
		return true;
	}
}