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

	public void setUpNetworking() {
		try {
			socket = new Socket("127.0.0.1", 5000);
			writer = new PrintWriter(socket.getOutputStream());
			System.out.println("networking established");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public class SendButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
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
