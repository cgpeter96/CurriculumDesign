package cn.lut.main;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []names={"a","b"};
		System.out.println(Arrays.toString(names));
		//Êý×éÀ©ÈÝ
		names=Arrays.copyOf(names, names.length+1);
		names[names.length-1]="c";
		System.out.println(Arrays.toString(names));
	}

}
