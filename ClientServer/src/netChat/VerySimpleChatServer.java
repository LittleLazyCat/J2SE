package netChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class VerySimpleChatServer {

	ArrayList<PrintWriter> clientOutputStream;

	public class ClientHandler implements Runnable {
		BufferedReader reader;
		Socket socket;

		public ClientHandler(Socket clientSocket) {
			try {
				socket = clientSocket;
				InputStreamReader is = new InputStreamReader(socket.getInputStream());
				reader = new BufferedReader(is);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			String message;
			try {
				while ((message = reader.readLine()) != null) {
					System.out.println("read " + message);
					 tellEveryOne(message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void go() {
		clientOutputStream = new ArrayList<PrintWriter>();
		try {
			ServerSocket serverScoket = new ServerSocket(5000);
			while (true) {
				Socket clientSocket = serverScoket.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientOutputStream.add(writer);
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();
				System.out.println("got a connection");
				 
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	public void tellEveryOne(String message) {
		Iterator<PrintWriter> it = clientOutputStream.iterator();
		while (it.hasNext()) {
			try {
				PrintWriter pw = it.next();
				pw.println(message);
				pw.flush();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		new VerySimpleChatServer().go();
	}

}
