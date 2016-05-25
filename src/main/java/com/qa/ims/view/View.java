package com.qa.ims.view;

import com.alee.laf.panel.WebPanel;

public abstract class View extends WebPanel {

	private static final long serialVersionUID = 8841264299735754478L;

	private final String identifier;

	private boolean initialized = false;

	public View(String identifier) {
		this.identifier = identifier;
	}

	public void initialize() {
		initialized = true;
	}

	public void preSwitch() {

	}

	public void postSwitch() {

	}

	public String getIdentifier() {
		return identifier;
	}

	public boolean hasInitialized() {
		return initialized;
	}

}
