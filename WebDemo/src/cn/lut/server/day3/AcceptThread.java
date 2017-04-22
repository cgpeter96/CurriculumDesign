package cn.lut.server.day3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AcceptThread implements Runnable {
	ExecutorService pool=Executors.newFixedThreadPool(Config.getThreads());
	private ServerSocket ss;
	
	public AcceptThread(ServerSocket ss){
		this.ss = ss;
	}
	
	@Override
	public void run() {
		
				while(true){
			try {
				
				System.out.println("µÈ´ýÁ¬½Ó...");
				Socket socket=ss.accept();
				System.out.println(socket);
//				Thread t = new Thread(new ClientService(socket));
//				t.start();
				pool.submit(new ClientService(socket));
			} catch (IOException e) {
				e.printStackTrace();
//				throw new RuntimeException(e);
				break;
			}
		}
	}

}
