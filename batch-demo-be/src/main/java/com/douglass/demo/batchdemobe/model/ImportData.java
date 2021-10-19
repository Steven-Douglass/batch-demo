package com.douglass.demo.batchdemobe.model;

public class ImportData {

	private char color;
	private int number;

	public ImportData() {

	}

	public ImportData(char color, int number) {
		super();
		this.color = color;
		this.number = number;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}