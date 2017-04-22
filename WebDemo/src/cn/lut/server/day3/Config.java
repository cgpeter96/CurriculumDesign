package cn.lut.server.day3;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {
	private static Properties cfg;
	static{
		cfg = new Properties();
		try {
			FileInputStream in = new FileInputStream(
					"conf/http.properties");
			cfg.load(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static int getInt(String key){
		return Integer.parseInt(cfg.getProperty(key));
	}
	public static String get(String key){
		return cfg.getProperty(key);
	}
	public static int getHttpPort(){
		return getInt("http.port");
	}
	public static int getThreads(){
		return getInt("threads");
	}
	public static String getWebRoot(){
		return cfg.getProperty("webroot");
	}
	public static void main(String[] args) {
		System.out.println(cfg);
		int port = Config.getInt("http.port");
		System.out.println(port);
		int num = Config.getInt("threads");
		System.out.println(num);
	}
	public static String grtAppsRoot() {
		// TODO Auto-generated method stub
		return cfg.getProperty("appsroot");
	}
	
}
