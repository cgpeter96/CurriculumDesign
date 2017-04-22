package cn.lut.server.day3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class HttpResponse {
	private static final char CR=13;
	private static final char LF=10;
	
	private static final int OK=200;
	private static final String OK_PHRASE="OK";
	private static final int NOT_FOUND=404;
	private static final int SERVER_ERROR=500;
	
	private boolean statusOut = false;
	private OutputStream out;	
	private static HashMap<Integer,String>phrase;
	static{
		phrase = new HashMap<Integer,String>();
		phrase.put(200, "OK");
		phrase.put(403, "Forbidden");
		phrase.put(404, "Not Found");
	}
	private int status=OK;
	private String contentType;
	private int contentLength;
	
	public HttpResponse(OutputStream out) {
		this.out=out;
	}
	/*设置响应状态码*/
	public void setStatus(int status){
		this.status=status;
	}
	
	/*设置媒体长度*/
	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}

	public void flush() throws IOException {
		if(writer!=null){
			writer.flush();
			byte[]body = buf .toByteArray();
			println("HTTP/1.1 "+status+" "+phrase.get(status));
			println("Content-Type:"+contentType);
			println("Content-Length:"+body.length);
			println("Connection: close");
			println("");
			out.write(body);
			statusOut=true;
		}
		if(!statusOut){
			println("HTTP/1.1 "+status+" "+phrase.get(NOT_FOUND));
			println("");
			statusOut=true;
		}
		out.flush();
		
	}
	/**
	 * getOut用于发送body数
	 * @return
	 * @throws IOException 
	 */
	public OutputStream getOut() throws IOException{
		if(contentType==null){
			throw new IOException("必须设置contentType!");
		}
		if(!statusOut){
			println("HTTP/1.1 "+status+" "+phrase.get(status));
			println("Content-Type:"+contentType);
			println("Content-Length:"+contentLength);
			println("");
			statusOut=true;
		}
		return out;
	}
	public void println(String str) throws UnsupportedEncodingException, IOException{
		out.write(str.getBytes("ISO8859-1"));
		out.write(CR);
		out.write(LF);
	}
	private String encoding = "utf-8";
	public void setEncoding(String encoding){
		this.encoding=encoding;
	}
	/*设置媒体类型**/
	public void setContentType(String contentType) {
		if(contentType.contains("charset")){
			String enc =  contentType.substring(contentType.lastIndexOf("=")+1);
			this.encoding=enc;
		}
		this.contentType = contentType;
	}
	
	private ByteArrayOutputStream buf;
	private PrintWriter writer;
	
	public PrintWriter getWriter() throws IOException {
		if(writer==null){
			buf =new ByteArrayOutputStream();
			writer = new PrintWriter(
					new OutputStreamWriter(buf, encoding), true);
		}
		return writer;
	}
}
