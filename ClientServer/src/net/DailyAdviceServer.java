package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {

	String[] adviceList = {"qqqq","wwww","eeee","rrrr"};
	public void go(){
		try {
//			ServerSocket会监听客户端对这台电脑在4242端口上的要求
			ServerSocket ss = new ServerSocket(4242);
			while(true)
			{
				Socket s = ss.accept();//accept()方法会停下来等待要求达到之后才会继续
//				使用Socket连接来送出消息
				PrintWriter pw = new PrintWriter(s.getOutputStream());
				String advice = getAdvice();
				pw.println(advice);
				pw.close();
				System.out.println(advice);
				if("1".equals(advice))
				{
					break;
				}
			}
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getAdvice(){
		int random = (int)Math.random()*adviceList.length;
		return adviceList[random];
		
	}
	public static void main(String[] args) {
		DailyAdviceServer das = new DailyAdviceServer();
		das.go();
	}

}
