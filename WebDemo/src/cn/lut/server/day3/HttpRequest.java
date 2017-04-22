package cn.lut.server.day3;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * 封装HTTP请求
 */
public class HttpRequest {
	private static final char CR=13;
	private static final char LF=10;
	
	private InputStream in;
	private String requestLine;
	private Map<String,String>headers;
	private byte[]body;
	
	private String method;
	private String uri;
	private String version;
	private String contextPath;
	private String path;
	private String queryString;
	
	private Map<String,Object> parametersMap=
			new HashMap<String,Object>();
	
	//http://主机名:端口号/contextPath/path/demo.html?queryString
	//uri :/contextPath/path/demo.html?queryString
	
	public HttpRequest(InputStream in) throws IOException {
		headers=new HashMap<String,String>();
		this.in=in;
		//解析请求行
		do{
			requestLine = readLine();
		}while("".equals(requestLine));
		String []line= requestLine.split("\\s");
		method = line[0];
		uri = line[1];
		String[] data;
		if(uri.length()>1){
//		System.out.println(uri);
		data=uri.split("\\?");
		System.out.println(Arrays.toString(data));
		uri = data[0];
		queryString = data.length>1?data[1]:"";
		int index=uri.indexOf("/",1);
		contextPath=index>0?uri.substring(0,index):"";
		path = index>0?uri.substring(index):"";
//		System.out.println("uri:"+uri);
//		System.out.println("queryString:"+queryString);
//		System.out.println("contextPath:"+contextPath);
//		System.out.println("path:"+path);
		}
		version = line[2];
		//解析请求头
		String header;
		while(!(header=readLine()).equals("")){
			data=header.split(":\\s");
			String name=data[0].trim();
			String value=data[1].trim();
			headers.put(name,value );
		}
		body=new byte[0];
		
		parseParameters();
	}
	private void parseParameters() throws UnsupportedEncodingException {
		if("".equals(queryString)){
			return ;
		}
		String []data = queryString.split("[&=]");
		for(int i=0;i<data.length;i+=2){
			String name=data[i];
			String value=data[i+1];
			value=URLDecoder.decode(value,"utf-8");
			
			if(parametersMap.containsKey(name)){
				Object param =parametersMap.get(name);
				if(param instanceof String){
					String ary[]={param.toString(),value};
					parametersMap.put(name, ary);
				}else{
					String[] ary=(String[])param;
					ary = Arrays.copyOf(ary, ary.length+1);
					ary[ary.length-1]=value;
					parametersMap.put(name, ary);
				}
			}else{
				parametersMap.put(name, value);
				
			}
		}
	}
	public String readLine() throws IOException{
		int c1=-1,c2=-1;
		StringBuilder bul=new StringBuilder();
		while((c2=in.read())!=-1){
			if(c1==CR&&c2==LF){
				break;
			}
			c1=c2;
			bul.append((char)c2);
		}
		return bul.toString().trim();
	}
	public String getRequestLine() {
		return requestLine;
	}
	public Map<String, String> getHeaders() {
		return headers;
	}
	public byte[] getBody() {
		return body;
	}
	public String getMethod() {
		return method;
	}
	public String getUri() {
		return uri;
	}
	public String getVersion() {
		return version;
	}
	public String getContextPath() {
		return contextPath;
	}
	public String getPath() {
		return path;
	}
	public String[] getParameters(String name){
		Object obj =parametersMap.get(name);
		if(obj ==null){
			return null;
		}
		if(obj instanceof String){
			return new String[]{obj.toString()};
		}
		String []ary=(String[])obj;
		return ary;
	}
	public String getParameter(String name){
		Object obj =parametersMap.get(name);
		if(obj ==null){
			return null;
		}
		if(obj instanceof String){
			return (String)obj;
		}
		String []ary=(String[])obj;
		return Arrays.toString(ary);
	}
}
