package cn.lut.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	
	private ServerSocket ss;
	
	public WebServer(){
		try {
			ss = new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("该端口被占用");
			throw new RuntimeException(e);
		}
	}
	public void start(){
		try {
			//0000 1000 0000  0000  
			//1111 1111 1111  1111
			System.out.println("等待连接");
			Socket socket = ss.accept();
			//成功链接到客户端
			System.out.println("连接成功:"+socket);
			InputStream in =socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			int STR=0;
			int INT=1;
			int LONG=2;
			int DOUBLE=3;
			
			//向客户端发送数据
			byte[]value="Hello World!,你好".getBytes();
			int length=value.length;
			
			int b1=length & 0xff;
			int b2=length>>8&0xff;
			int b3=length >>16 &0xff;
			int b4=length >>24 &0xff;
			
			out.write(STR);//1byte
			out.write(b1);
			out.write(b2);
			out.write(b3);
			out.write(b4);
			
			out.write(value);
			out.flush();//刷出缓存
			
			//网络使用结合苏必须关闭socket
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("网络故障!!");
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.start();
	}

}
