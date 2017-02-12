package com.playtech.java_training.car.systems;

import java.util.Timer;
import java.util.TimerTask;

public abstract class AbstractSystem {
	protected boolean isInitialized;
	protected int initializationTime;
	protected Timer initializationTimer;
	protected Status status;

	public boolean isInitialized() {
		return isInitialized;
	}

	public AbstractSystem(int initializationTime) {
		isInitialized = false;
		this.initializationTime = initializationTime;
	}

	public void initialize() {
		initializationTimer = new Timer(true);
		initializationTimer.schedule(new InitializeTask(), initializationTime);
	};

	protected void onInitializeCompleted() {
		isInitialized = true;
		initializationTimer.cancel();
		System.out.println(this.getClass().getSimpleName()
				+ " has initialized successfully.");
	}

	private class InitializeTask extends TimerTask {

		@Override
		public void run() {
			onInitializeCompleted();
		}

	}
}
