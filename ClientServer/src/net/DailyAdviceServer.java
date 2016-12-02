package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {

	String[] adviceList = {"qqqq","wwww","eeee","rrrr"};
	public void go(){
		try {
//			ServerSocket������ͻ��˶���̨������4242�˿��ϵ�Ҫ��
			ServerSocket ss = new ServerSocket(4242);
			while(true)
			{
				Socket s = ss.accept();//accept()������ͣ�����ȴ�Ҫ��ﵽ֮��Ż����
//				ʹ��Socket�������ͳ���Ϣ
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
