package cn.lut.day4;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;

public class DecodeDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String s="%E4%B8%8A%E6%B5%B7 ";
		String str = URLDecoder.decode(s,"utf-8");
		System.out.println(str);
		
		str="name=TOme&pwd=123";
		System.out.println(Arrays.toString(str.split("[&=]")));
	}

}
