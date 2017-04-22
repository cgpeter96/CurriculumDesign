package com.lut.student;

public class Card {
	private String Cnumber;
	private String Cpassword;
	private int isLost;
	private float Cmoney;
	public String getCnumber() {
		return Cnumber;
	}
	public void setCnumber(String cnumber) {
		Cnumber = cnumber;
	}
	public String getCpassword() {
		return Cpassword;
	}
	public void setCpassword(String cpassword) {
		Cpassword = cpassword;
	}
	public int isLost() {
		return isLost;
	}
	public void setLost (int isLost) {
		this.isLost = isLost;
	}
	public float getCmoney() {
		return Cmoney;
	}
	public void setCmoney(float cmoney) {
		Cmoney = cmoney;
	}

}
