package cn.lut.server.day3;

import java.io.IOException;
import java.net.ServerSocket;

import org.dom4j.DocumentException;

public class WebServer {
	
	
	private ServerSocket ss;
	private Thread thread;
	public WebServer() throws IOException, DocumentException{
		//初始化web容器  上下文环境
		initServletContext(Config.grtAppsRoot());

		ss = new ServerSocket(Config.getHttpPort());
		thread = new Thread(new AcceptThread(ss));
	}
	private void initServletContext(String appsRoot)throws IOException, DocumentException{
		ServletContext.init(appsRoot);
	}
	public void start(){
		thread.start();
	}
	public static void main(String[] args) throws IOException, DocumentException {
		WebServer server =new WebServer();
		server.start();
		
	}
}
