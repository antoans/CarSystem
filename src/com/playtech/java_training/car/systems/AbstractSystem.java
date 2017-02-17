package com.playtech.java_training.car.systems;

import java.util.Timer;
import java.util.TimerTask;

import com.playtech.java_training.car.systems.enums.Status;

public abstract class AbstractSystem {
	protected boolean isInitializing;

	protected int initializationTime;
	protected Timer initializationTimer;

	protected Status status;

	private void setInitializationTime(int initializationTime) {
		if (initializationTime < 0)
			throw new IllegalArgumentException();
		this.initializationTime = initializationTime;
	}

	public boolean isInitialized() {
		return status != Status.NOT_INIT;
	}

	public AbstractSystem(int initializationTime) {
		status = Status.NOT_INIT;
		isInitializing = false;
		setInitializationTime(initializationTime);
		initializationTimer = null;
	}

	public void initialize() {
		if (isInitializing || status != Status.NOT_INIT)
			return; // system has started to initialize/ has been initialized

		isInitializing = true;
		start();
	};

	protected void start() {
		initializationTimer = new Timer(true);
		initializationTimer.schedule(new InitializeTask(), initializationTime);
	}

	protected void onInitializeCompleted(Status status) {
		isInitializing = false;
		this.status = status;
		System.out.println(this);
	}

	private class InitializeTask extends TimerTask {
		@Override
		public void run() {
			Status st = decideStatus();
			onInitializeCompleted(st);
			initializationTimer.cancel();
		}
	}

	protected Status decideStatus() {
		return Status.getRandom();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName() + " : [status] = " + status.toString();
	}
}
