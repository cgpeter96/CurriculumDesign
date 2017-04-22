package cn.lut.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
	
	
	public static void main(String[] args) {
		Socket socket =new Socket();
		try {
			socket.connect(new InetSocketAddress("127.0.0.1",8888));
			
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			int type=in.read();
			int b1=in.read();
			int b2=in.read();
			int b3=in.read();
			int b4=in.read();
			int length=b1|(b2<<8)|(b3<<16)|(b4<<24);
			
			byte[]bt=new byte[length];
			int i=in.read(bt);
			
			int STR=0;
			int INT=1;
			int LONG=2;
			int DOUBLE=3;
			
			if(type==STR){
				String str=new String(bt);
				System.out.println(str);
			}else if(type==INT){
				String str=new String(bt);
				
			}else if(type==LONG){
				
			}else if(type==DOUBLE){
				
			}
			
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Á¬½ÓÊ§°Ü");
			throw new RuntimeException(e);
		}
	}
}
