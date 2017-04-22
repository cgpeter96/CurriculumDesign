package cn.lut.server.day3;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ServletContext {
	private Map<String,Map<String,String>>map;
	private static ServletContext context;
	
	public Map<String, String> getUrlMap(String path) {
		return map.get(path);
	}


	public static ServletContext getContext() {
		return context;
	}


	private ServletContext(String appsRoot) throws IOException, DocumentException{
		//扫描每个web.xml
		map =new HashMap<String, Map<String,String>>();
		//扫描每个web.xml //想web.xml 存储到map中
		//假设appsRoot 的值webapps 文件夹
		File dir = new File(appsRoot);
//		System.out.println(dir.getCanonicalPath());
		File[]subs = dir.listFiles();
		for(File sub:subs){
			if(sub.isDirectory()){
				String key = "/"+sub.getName();
//				System.out.println(key);
				File xml = new File(sub,"WEB-INF/web.xml");
				if(xml.exists()){
//					System.out.println(xml);
					Map<String, String>mapping=read(xml);
					map.put(key, mapping);
				}
			}
		}
//		System.out.println(this.map);
	}
	

	private Map<String, String> read(File xml) {
		try{
		Map<String, String>map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		Document doc =reader.read(xml);
		Element root  = doc.getRootElement();
		List<Element> list = root.elements("servlet");
		List<Element> mappingList=root.elements("servlet-mapping");
		for(Element mapping:mappingList){
			String url = mapping.elementTextTrim("url-pattern");
			String name = mapping.elementTextTrim("servlet-name");
//			System.out.println(name+":"+url);
			String className = null;
			for(Element e:list){
				String servletName=e.elementTextTrim("servlet-name");
				String cls=e.elementTextTrim("servlet-class");
				if(servletName.equals(name)){
					className=cls;
					break;
				}
			}
//			System.out.println(url+":"+className);
			if(className!=null){
				map.put(url, className);
			}
		}
	
			return map;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static  void init(String appsRoot) throws IOException, DocumentException{
		if(context==null){
			context = new ServletContext(appsRoot);
		}
	}
}
