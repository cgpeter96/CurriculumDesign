package cn.lut.web;

import java.io.IOException;
import java.io.OutputStream;

import cn.lut.server.day3.HttpRequest;
import cn.lut.server.day3.HttpResponse;
import cn.lut.server.day3.Servlet;

public class DemoServlet implements Servlet {

	@Override
	public void service(HttpRequest request, HttpResponse response) throws IOException {
		String html = "<html><body>Hello World</body></html>";
		byte[]body = html.getBytes();
		response.setContentType("text/html;charset=utf-8");
		response.setContentLength(body.length);
		OutputStream out = response.getOut();
		out.write(body);
//		response.flush();
	}

}
