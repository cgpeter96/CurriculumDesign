package cn.lut.server.day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteDemo {
	ExecutorService pool =Executors.newFixedThreadPool(2);
	class Task implements Runnable {
		@Override
		public void run() {
			Thread t = Thread.currentThread();
			System.out.println(t+"do Task!");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	public static void main(String[] args) {
		ExecuteDemo demo =new ExecuteDemo();
		demo.test();
	}
	public void test(){
		for(int i=0;i<10;i++){
			pool.submit(new Task());
		}
		System.out.println("DONE!");
	}
}
