package cn.lut.main;

public class MemDemo {
	public static void main(String[] args) {
		Airplane a;
		Airplane[] ary = new Airplane[100000000];
		String s="hello";
		String s2=new String("hello");
//		for(int i=0;i<100000000;i++){
//			a=new Airplane();
//			ary[i]=a;
//			System.out.println(i);
//		}
		if(s.equals(s2))
			System.out.println("OK");
	}
}
