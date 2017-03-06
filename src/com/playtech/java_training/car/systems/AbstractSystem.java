package com.playtech.java_training.car.systems;

import com.playtech.java_training.car.systems.enums.Status;

public abstract class AbstractSystem {
	protected static final int DEFAULT_INIT_TIME = 3000;

	protected boolean isInitializing;
	protected String name;
	private Status forcedStatus;

	protected int initializationTime;

	protected Status status;

	private void setInitializationTime(int initializationTime) {
		if (initializationTime < 0)
			throw new IllegalArgumentException();
		this.initializationTime = initializationTime;
	}

	public boolean isInitialized() {
		return status != Status.NOT_INIT;
	}

	public String getName() {
		return name;
	}

	public AbstractSystem() {
		this(DEFAULT_INIT_TIME);
		this.forcedStatus = null;
	}

	public AbstractSystem(int initializationTime) {
		status = Status.NOT_INIT;
		isInitializing = false;
		name = "abstract";
		setInitializationTime(initializationTime);
	}
	
	public AbstractSystem(int initializationTime, Status forcedStatus) {
		this(initializationTime);
		this.forcedStatus = forcedStatus;
	}

	public void initialize() {
		if (isInitializing || status != Status.NOT_INIT)
			return; // system has started to initialize/ has been initialized

		isInitializing = true;
		Thread init = waitThread();
		init.setDaemon(false);
		init.start();
	}

	protected void onInitializeCompleted(Status status) {
		isInitializing = false;
		this.status = status;
		System.out.println(this);
	}

	protected Status decideStatus() {
		if (forcedStatus == null) {
			return Status.getRandom();
		} else {
			return forcedStatus;
		}
		
	}

	private Thread waitThread() {
		return new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(initializationTime);
				} catch (InterruptedException e) {
					onInitializeCompleted(Status.ERROR);
				}
				onInitializeCompleted(decideStatus());
			}
		};
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractSystem other = (AbstractSystem) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName() + " : [status] = "
				+ status.toString();
	}
}
