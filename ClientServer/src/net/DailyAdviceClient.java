package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {
	public void go() {
		try{
//			�Զ˿�4242����
			Socket s= new Socket("127.0.0.1",4242);
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
//			�������ݴ���
			BufferedReader br = new BufferedReader(isr);
			String advice = br.readLine();
			System.out.println(advice);
//			�ر����еĴ���
			br.close();
			s.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DailyAdviceClient da = new DailyAdviceClient();
		da.go();
	}

}
