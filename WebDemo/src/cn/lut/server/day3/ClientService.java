package cn.lut.server.day3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Map;

public class ClientService implements Runnable {
	private static final char CR=13;
	private static final char LF=10;
	
	private Socket socket;
	public ClientService(Socket socket){
		this.socket=socket;
	}
	@Override
	public void run() {
		
		//接受请求
		//发送响应
		//关闭连接
		try{
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			//读取请求
			HttpRequest request =new HttpRequest(in);
			HttpResponse response = new HttpResponse(out);
			//假设用户请求了 /DemoWeb/demo
			//  ContextPath=/DemoWeb
			// path = /demo
			String ctxPath = request.getContextPath();
			ServletContext context = ServletContext.getContext();
			Map<String,String> map =context.getUrlMap(ctxPath);
			if(map!=null){
				//执行用户的Servlet
				String path = request.getPath();
				String clsName=map.get(path);
				if(clsName==null){
					response.setStatus(404);
				}
//				System.out.println(clsName);
				Class cls = Class.forName(clsName);
				Servlet servlet=(Servlet) cls.newInstance();
				servlet.service(request, response);
			}else{
				Servlet servlet = new FileServlet();
				servlet.service(request, response);
			}
			
			response.flush();
			
//			String requestLine = readLine(in);
//			System.out.println(requestLine);
//			String header ;
//			while(!(header=readLine(in)).equals("")){
//				System.out.println(header);
//			}
			//发送响应
//			String html = "<html><body>Hello</body></html>";
//			byte[]body=html.getBytes();
//			println(out,"HTTP/1.1 200 OK");
//			println(out,"Content-Type:text/html;charset=utf-8");
//			println(out,"Content-Length:"+body.length);
//			println(out,"");
//			out.write(body);
			
		}catch(IOException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	private void println(OutputStream out,String str) throws UnsupportedEncodingException, IOException{
		out.write(str.getBytes("ISO8859-1"));
		out.write(CR);
		out.write(LF);
	}
	private String readLine(InputStream in) throws IOException {
		int c1=-1,c2=-1;
//		StringBuffer buf = new StringBuffer();
		StringBuilder bul =new StringBuilder();
		while((c2=in.read())!=-1){//读到流末尾就返回-1
			if(c1==CR&&c2==LF){
				break;
			}
			bul.append((char)c2);
			c1=c2;
		}
		return bul.toString().trim();
	}

}
