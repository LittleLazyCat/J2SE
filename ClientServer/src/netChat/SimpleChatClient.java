package netChat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class SimpleChatClient {

	JTextField outgoing;
	JTextArea incoming;
	PrintWriter writer;
	Socket socket;
	BufferedReader br;
	//建立GUI
	public void go() {
		JFrame frame = new JFrame("Simple Chat Client");
		JPanel panel = new JPanel();
		incoming = new JTextArea(20,30);
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEditable(false);
		JScrollPane qScroller = new JScrollPane(incoming);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		panel.add(qScroller);
		panel.add(outgoing);
		panel.add(sendButton);
		setUpNetworking();
		
		Thread t = new Thread(new IncomingReader());
		t.start();
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(400, 500);
		frame.setVisible(true);
	}
//	建立Socket和PrintWriter
	public void setUpNetworking() {
		try {
			socket = new Socket("127.0.0.1", 5000);//IP地址与端口号
			InputStreamReader inreader = new InputStreamReader(socket.getInputStream());
			br = new BufferedReader(inreader);
			writer = new PrintWriter(socket.getOutputStream());
			System.out.println("networking established");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	单击按钮，监听事件
	public class SendButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
//				获得文字字段内容
//				传送到服务器
				writer.println(outgoing.getText());
				writer.flush();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}

	}

	public static void main(String[] args) {
		new SimpleChatClient().go();


	}
	
	public class IncomingReader implements Runnable{

		@Override
		public void run() {
			String s;
			while (true) {
				try {
					while((s = br.readLine())!= null)
					{
							System.out.println("read "+s);
							incoming.append(s+"\n");
					}
				
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
