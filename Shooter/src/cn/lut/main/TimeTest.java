package cn.lut.main;

public class TimeTest {
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		System.out.println((long)(now/1000/3600/24/365+1970));
	}
}
