package cn.lut.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

import cn.lut.server.day3.HttpRequest;
import cn.lut.server.day3.HttpResponse;
import cn.lut.server.day3.Servlet;

public class ParamServlet implements Servlet {

	@Override
	public void service(HttpRequest request, HttpResponse response) throws IOException {
		String []names=request.getParameters("name");
		String age = request.getParameter("age");
		
		System.out.println(age);
		System.out.println(Arrays.toString(names));
		String html="<html><body><h1>"+age+"</h1></body></html>";
		byte[]body=html.getBytes("utf-8");
		
//		response.setContentType("text/html;charset=utf-8");
//		response.setContentLength(body.length);
//		
//		OutputStream out =response.getOut();
//		out.write(body);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<html>");
		out.write("<body>");
		out.write(age);
		out.write("</body>");
		out.write("</html>");
//		response.flush();
	}

}
