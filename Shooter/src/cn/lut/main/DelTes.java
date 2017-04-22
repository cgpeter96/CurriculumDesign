package cn.lut.main;

import java.util.Arrays;

public class DelTes {
	public static void main(String[] args) {
		int arr[]={0,0,1,1,1,1,1,1,1,1,1,1,0,0,2,0,0,0,2,0,0,0,0,0,0};
		long t1=System.nanoTime();
		int rm=0;
		for (int j = 0; j <arr.length-rm;j++ ){
			if (arr[j]==1) {
				rm++;
				for (int i = j; i <arr.length; i++) {
					if (i < arr.length-1) {
						int temp = arr[i];
						arr[i] = arr[i + 1];//类似冒泡算法,也可以通过覆盖不进行交换
						arr[i + 1] = temp;
					}
				}
				j-=1;
			}
			
		}
		arr=Arrays.copyOf(arr, arr.length-rm);
		System.out.println(Arrays.toString(arr));
		System.out.println(System.nanoTime()-t1);
	}
	
}
