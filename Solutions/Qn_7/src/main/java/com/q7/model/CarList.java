package com.q7.model;

import java.util.List;

public class CarList {
	
	private List<Car> previousFileData;
	private List<Car> currentFileData;
	
	public List<Car> getPreviousFileData() {
		return previousFileData;
	}
	public void setPreviousFileData(List<Car> previousFileData) {
		this.previousFileData = previousFileData;
	}
	public List<Car> getCurrentFileData() {
		return currentFileData;
	}
	public void setCurrentFileData(List<Car> currentFileData) {
		this.currentFileData = currentFileData;
	}
}
