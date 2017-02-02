package com.playtech.java_training.car.systems;

import java.util.Timer;
import java.util.TimerTask;

public abstract class AbstractSystem {
	private boolean isInitialized;
	protected int delay;
	protected Timer initializationTimer;

	public boolean isInitialized() {
		return isInitialized;
	}

	public AbstractSystem(int delay) {
		isInitialized = false;
		this.delay = delay;
	}

	public void initialize() {
		initializationTimer = new Timer(true);
		initializationTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				isInitialized = true;
			}
		}, delay);
	};

}
