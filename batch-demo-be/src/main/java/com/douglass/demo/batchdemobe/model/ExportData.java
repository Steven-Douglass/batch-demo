package com.douglass.demo.batchdemobe.model;

import java.util.Date;

public class ExportData {

	private char color;
	private int number;
	private Date date;

	public ExportData() {

	}

	public ExportData(char color, int number, Date date) {
		super();
		this.color = color;
		this.number = number;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
