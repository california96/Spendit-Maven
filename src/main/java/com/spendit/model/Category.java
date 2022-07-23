package com.spendit.model;

public class Category {
	private int id;//for retrieval
	private String name;
	private int moduleID;
	private String module;//for retrieval
	private String description;
	private String image;
	/*For creation and writing to DB*/
	public Category(String name, int moduleID, String description, String image) {
		this.name = name;
		this.moduleID = moduleID;
		this.description = description;
		this.image = image;
	}
	/*For retrieval operations like editing or options for other modules*/
	public Category(int id, String name, int moduleID, String module, String description, String image) {
		this.id = id;
		this.name = name;
		this.moduleID = moduleID;
		this.module = module;
		this.description = description;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getModuleID() {
		return moduleID;
	}
	public void setModuleID(int moduleID) {
		this.moduleID = moduleID;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
