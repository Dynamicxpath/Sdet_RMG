package com.CrudOperationWithoutBDD.RestAssuredApiTesting;

public class ProjectLibrary {
	// create global variables
	String creadtedBy;
	String projectName;
	String status;
	int size;
	// intialize the constructor
	public ProjectLibrary(String creadtedBy, String projectName, String status, int size) {
		this.creadtedBy = creadtedBy;
		this.projectName = projectName;
		this.status = status;
		this.size = size;
	}
	public String getCreadtedBy() {
		return creadtedBy;
	}
	public void setCreadtedBy(String creadtedBy) {
		this.creadtedBy = creadtedBy;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}

