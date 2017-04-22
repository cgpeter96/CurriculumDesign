package cn.lut.server2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

		//发生请求
		//获取响应
		//建立连接
		//断开连接
public class WebServer {
	private ServerSocket ss;
	private final static char CR=13;
	private final static char LF=10;
	public WebServer(){
		try {
			ss = new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public void start()throws Exception{
		Socket socket = ss.accept();
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		String requestLine = readLine(in);
		System.out.println(requestLine);
		while(true){
			String head = readLine(in);
			if(head.equals("")){
				break;
			}
			System.out.println(head);
		}
//		String html="<html><body>Hello World!你好</body></html>";
//		byte[]body=html.getBytes("utf-8");
		
//		out.write("HTTP/1.1 200 OK".getBytes("ISO8859-1"));
//		out.write(CR);
//		out.write(LF);
		
//		out.write("Contenn-Type:text/html charset=utf-8"
//				.getBytes("ISO8859-1"));
//		out.write(CR);
//		out.write(LF);
		//		out.write(("Contenn-Length:"+body.length)
//				.getBytes("ISO8859-1"));
//		out.write(CR);
//		out.write(LF);
		
//		out.write(CR);
//		out.write(LF);
		
		
//		println(out,"HTTP/1.1 200 OK");
//		println(out,"Contenn-Type:text/html charset=utf-8");
//		println(out,"Contenn-Length:"+body.length);
//		println(out,"");
//		out.write(body);
		
		//向浏览器发生照片
//		BufferedImage img = createImg();
//		byte[] body =toPng(img);
		
		BufferedImage img =demoImg();
		byte[]body=toPng(img);
		
		println(out,"HTTP/1.1 200 OK");
		println(out,"Content-Type: image/png");
		println(out,"Content-Length:"+body.length);
		println(out,"");
		out.write(body);
		out.flush();
		
		socket.close();
	}
	//在内存中动态创建一个照片
	public BufferedImage createImg(){
		BufferedImage img = new BufferedImage(80, 50, BufferedImage.TYPE_3BYTE_BGR);
		img.setRGB(0, 0, 0x00ff00);
		img.setRGB(79, 49, 0xff0000);
		Graphics2D g=img.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setColor(Color.white);
		g.drawString("ABC", 10, 30);
		g.drawLine(0, 0, 35, 48);
		return img;
	}
	//读取照片,在照片上绘制需要的文字
	public BufferedImage demoImg() throws IOException{
		BufferedImage img=ImageIO.read(WebServer.class.getClassLoader().
				getResourceAsStream("cn/lut/server2/02-1.jpg"));
		
		Graphics2D g=img.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		//开启抗锯齿
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		//高质量绘制
		Font font =new Font(Font.SANS_SERIF,Font.PLAIN,30);
		g.setFont(font);
		g.setColor(new Color(255,0,0));
		g.drawString("表走", 170, 150);
		
		return img;
	}
	public byte[] toPng(BufferedImage img) throws IOException{
		ByteArrayOutputStream buf =new ByteArrayOutputStream();
		ImageIO.write(img, "png", buf);
		byte[]png =buf.toByteArray();
		return png;
	}
	public byte[] toJpg(BufferedImage img) throws IOException{
		ByteArrayOutputStream buf =new ByteArrayOutputStream();
		ImageIO.write(img, "jpg", buf);
		byte[]jpg =buf.toByteArray();
		return jpg;
	}
	/**
	 * 向流中写入一行文本数据,采用ISO8859-1编码,以CRLF结尾
	 * @param out
	 * @param str
	 * @throws Exception
	 */
	public void println(OutputStream out,String str)
		throws Exception{
		out.write(str.getBytes("ISO8859-1"));
		out.write(CR);
		out.write(LF);
	}
	
	public  String readLine(InputStream in) throws Exception {
		int c1=-1,c2=-1;
		StringBuffer buffer = new StringBuffer();
		while(true){
			c2=in.read();
			if(c2==-1){
				break;
			}
			if(c1==CR&&c2==LF){
				break;
			}
			buffer.append((char)c2);
			c1=c2;
		}
		return buffer.toString().trim();
	}
	public static void main(String[] args) throws Exception {
		WebServer server =new WebServer();
		server.start();
	}
}	
