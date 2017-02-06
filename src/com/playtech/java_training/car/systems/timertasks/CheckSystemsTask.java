package com.playtech.java_training.car.systems.timertasks;

import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

import com.playtech.java_training.car.systems.AbstractSystem;

	public class CheckSystemsTask extends TimerTask {
		private Timer timer;
		private Collection<AbstractSystem> systems;
		public CheckSystemsTask(Timer timer, Collection<AbstractSystem> systems) {
			this.timer = timer;
			this.systems = systems;
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
			System.out.println("Done.");
			return true;
		}
	}