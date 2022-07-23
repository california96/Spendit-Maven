package com.spendit.model;

public class Module {
	private int moduleID;
	private String name;
	
	public Module() {
		
	}

	public Module(int moduleID, String name) {
		this.moduleID = moduleID;
		this.name = name;
	}

	public int getModuleID() {
		return moduleID;
	}

	public void setModuleID(int name) {
		this.moduleID = moduleID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
