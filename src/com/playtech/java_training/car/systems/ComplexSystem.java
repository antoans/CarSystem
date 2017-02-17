package com.playtech.java_training.car.systems;

import java.util.Map;

import com.playtech.java_training.car.systems.enums.Status;

public abstract class ComplexSystem extends AbstractSystem {
	/**
	 * The boolean value defines if the sub-system is considered a key system
	 * (the car cannot start without it).
	 */
	protected Map<AbstractSystem, Boolean> systems;

	public ComplexSystem(int initializationTime, Map<AbstractSystem, Boolean> systems) {
		super(initializationTime);
		setSystems(systems);
	}

	private void setSystems(Map<AbstractSystem, Boolean> systems) {
		if (systems == null || systems.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.systems = systems;
	}

	@Override
	public void start() {
		for (AbstractSystem system : systems.keySet()) {
			system.initialize();
		}

		try {
			checkSubSystems();
		} catch (InterruptedException e) {
			status = Status.ERROR;
		}

	}

	private void checkSubSystems() throws InterruptedException {
		check: while (true) {
			for (AbstractSystem system : systems.keySet()) {
				if (!system.isInitialized()) {
					Thread.sleep(200);
					continue check;
				}
			}
			break;
		}
		onSubSystemsInitialized();
		// TODO : onInitializeCompleted(decideStatus()); ???
	}

	private void onSubSystemsInitialized() {
		if (checkSubSystemsForStatus(Status.ERROR)) {
			onInitializeCompleted(Status.ERROR);
		} else {
			super.start();
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
		for (AbstractSystem sys : systems.keySet()) {
			if (systems.get(sys) && sys.status.equals(status)) {
				return true;
			}
		}
		return false;
	}
}
