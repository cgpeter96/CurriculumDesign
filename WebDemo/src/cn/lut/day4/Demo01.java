package cn.lut.day4;

import java.util.Scanner;

public class Demo01 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Scanner in = new Scanner(System.in);
		System.out.println("¿‡√˚");
		
		String name = in .nextLine();
		Class cls = Class.forName(name);
		
		Object obj = cls.newInstance();
		System.out.println(obj);
	}

}
