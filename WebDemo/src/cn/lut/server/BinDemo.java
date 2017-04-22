package cn.lut.server;

public class BinDemo {
	public static void main(String[] args) throws Exception{
		int length = 0x27652641;
		System.out.println(Integer.toBinaryString(length));
		int b1 = length & 0xff;//低8位
		int b2 = (length >>> 8) & 0xff;
		int b3 = (length >>> 16) & 0xff;
		int b4 = (length >>> 24) & 0xff;
		/**
		 * >>>全部补0
		 * >>看高位情况补1或补0
		 */
		System.out.println(Integer.toBinaryString(b1));
		System.out.println(Integer.toBinaryString(b2));
		System.out.println(Integer.toBinaryString(b3));
		System.out.println(Integer.toBinaryString(b4));
		int l=b1|(b2<<8)|(b3<<16)|(b4<<24);
		System.out.println(Integer.toBinaryString(l));
		
		System.out.println("-----------------------");
		
		int n = '您';//24744   2^16=65535
		System.out.println(Integer.toBinaryString(n));
		byte[]bytes="您".getBytes("UTF-16BE");//B是高位在前 字符串的编码
		b1=bytes[0];
		b2=bytes[1];
		System.out.println(Integer.toBinaryString(b1));
		System.out.println(Integer.toBinaryString(b2&0xff));
		//字符串数据的解码
		String str = new String(bytes,"utf-16be");
		System.out.println(str);
		/**
		 * UTF-8 1字节 0XXXXXXX
		 *       2字节 110XXXXX 10XXXXXX
		 *       3字节 1110XXXX 10XXXXXX 10XXXXXX
		 *       4字节 11110XXX 10XXXXXX 10XXXXXX 10XXXXXX
		 *       
		 *         您  01100000 10101000
		 * utf8--3字节 1110XXXX 10XXXXXX 10XXXXXX
		 * utf8            您 11100110 10000010 10101000
		 */
		System.out.println("------------------------");
		byte []utf8="你好".getBytes("utf-8");
		System.out.println(Integer.toBinaryString(utf8[0]&0xff));
		System.out.println(Integer.toBinaryString(utf8[1]&0xff));
		System.out.println(Integer.toBinaryString(utf8[2]&0xff));
		String s1="A".toLowerCase();
		String s =new String(utf8,"Utf-8");
		System.out.println(s);
	}

}
