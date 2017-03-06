package com.playtech.java_training.car.systems;

import java.util.Collection;

import com.playtech.java_training.car.systems.enums.Status;

public abstract class ComplexSystem extends AbstractSystem {
	protected Collection<AbstractSystem> systems;
	
	public Collection<AbstractSystem> getSystems() {
		return systems;
	}

	public ComplexSystem(Collection<AbstractSystem> systems) {
		this(DEFAULT_INIT_TIME, systems);
	}

	public ComplexSystem(int initializationTime, Collection<AbstractSystem> systems) {
		super(initializationTime);
		setSystems(systems);
	}

	public ComplexSystem(int initializationTime, Collection<AbstractSystem> systems, Status forcedStatus) {
		super(initializationTime, forcedStatus);
		setSystems(systems);
	}

	private void setSystems(Collection<AbstractSystem> systems) {
		if (systems == null || systems.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.systems = systems;
	}

	@Override
	public void initialize() {
		for (AbstractSystem system : systems) {
			system.initialize();
		}

		Thread init = checkSubsystemsThread();
		init.setDaemon(false);
		init.start();
	}

	private Thread checkSubsystemsThread() {
		return new Thread() {
			@Override
			public void run() {
				check: while (true) {
					for (AbstractSystem system : systems) {
						if (!system.isInitialized()) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								onInitializeCompleted(Status.ERROR);
							}
							continue check;
						}
					}
					break;
				}
				onSubSystemsInitialized();
			}
		};
	}

	protected void onSubSystemsInitialized() {
		if (checkSubSystemsForStatus(Status.ERROR)) {
			onInitializeCompleted(Status.ERROR);
		} else {
			super.initialize();
		}
	}

	@Override
	protected Status decideStatus() {
		Status st = super.decideStatus();

		if (st.equals(Status.HEALTHY) && checkSubSystemsForStatus(Status.WARNING)) {
			st = Status.WARNING;
		}
		return st;
	}

	protected boolean checkSubSystemsForStatus(Status status) {
		for (AbstractSystem sys : systems) {
			if (sys.status.equals(status)) {
				return true;
			}
		}
		return false;
	}
}
