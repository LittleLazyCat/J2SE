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
import javax.swing.JTextField;

public class SimpleChatClientA {
	JTextField outgoing;
	PrintWriter writer;
	static Socket socket;
	//建立GUI
	public void go() {
		JFrame frame = new JFrame("Simple Chat Client");
		JPanel panel = new JPanel();
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		panel.add(outgoing);
		panel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		setUpNetworking();
		frame.setSize(400, 500);
		frame.setVisible(true);
	}
//	建立Socket和PrintWriter
	public void setUpNetworking() {
		try {
			socket = new Socket("127.0.0.1", 5000);//IP地址与端口号
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
		new SimpleChatClientA().go();
		InputStreamReader inreader;
		BufferedReader br;
		while (true) {
			try {
				inreader = new InputStreamReader(socket.getInputStream());
				br = new BufferedReader(inreader);
				String s = br.readLine();
				System.out.println(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
