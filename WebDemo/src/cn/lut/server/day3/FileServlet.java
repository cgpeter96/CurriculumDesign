package cn.lut.server.day3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class FileServlet implements Servlet {

	@Override
	public void service(HttpRequest request, HttpResponse response) throws IOException {
		//找到文件,将文件发送到客户端
		//获取文件系统的目录
		String root=Config.getWebRoot();
		//获取请求的文件名
		String uri = request.getUri();
		String fileName = root+uri;
		File file = new File(fileName);
		if(!file.exists()){
			response.setStatus(404);
			return ;
		}
		int length = (int)file.length();
		//发送content-Type
		String name =file.getName();
		String ext = name.substring(name.lastIndexOf(".")+1);
		String contentType=Config.get(ext);
		response.setContentType(contentType);
		response.setContentLength(length);
		//发送body
		OutputStream out = response.getOut();
		InputStream in =new BufferedInputStream(new FileInputStream(file));
//		ByteBuffer buffer=ByteBuffer.all
		int b;
		byte[]buf=new byte[1024];
		while((b=in.read(buf))!=-1){
			out.write(buf);
		}
	}

}
