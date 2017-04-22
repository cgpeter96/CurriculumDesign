package cn.lut.server.day3;

import java.io.IOException;

public interface Servlet {
	void service(HttpRequest request,HttpResponse response)
		throws IOException;
}
