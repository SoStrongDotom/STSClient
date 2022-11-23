import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ChatClient extends JFrame{
	private JTextField serverAddr;
	private JTextField portNo;
	private JTextField talkName;
	private JTextField sendMessageBox;
	
	private JTextArea showMessageBox;
	private JButton sendButton;
	private JButton disconnectButton;
	private JTextArea showConnectorBox;
	private JButton connectButton;
	
	
	JPanel panel;
	JPanel panel_1;
	
	private Socket echoSocket;
	private PrintStream socketOut;
	private BufferedReader socketIn;
	private sendMessageHandler3 sendMsgHandler;
	private SjChatReceiveThread rec;
	
	
	public ChatClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		getContentPane().setLayout(null);
		setSize(1700, 950);
		panel = new JPanel();
		panel.setBounds(0, 0, 1700, 950);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		showMessageBox = new JTextArea();
		showMessageBox.setBounds(143, 69, 387, 254);
		panel.add(showMessageBox);
		
		sendMessageBox = new JTextField();
		sendMessageBox.setBounds(143, 346, 387, 21);
		panel.add(sendMessageBox);
		sendMessageBox.setColumns(10);
		
		sendButton = new JButton("SEND");
		sendButton.setBounds(542, 345, 97, 23);
		panel.add(sendButton);
		
		disconnectButton = new JButton("EXIT");
		disconnectButton.setBounds(12, 310, 97, 23);
		panel.add(disconnectButton);
		
		showConnectorBox = new JTextArea();
		showConnectorBox.setBounds(551, 94, 138, 229);
		panel.add(showConnectorBox);
		
		
		//panel_1 = new JPanel();
		ImagePanel panel_1 = new ImagePanel(new ImageIcon("./image/bg4.png").getImage());
		panel_1.setBounds(0, 0, 1700, 950);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		serverAddr = new JTextField();
		serverAddr.setBounds(153, 76, 116, 21);
		panel_1.add(serverAddr);
		serverAddr.setColumns(10);
		
		portNo = new JTextField();
		portNo.setBounds(153, 120, 116, 21);
		panel_1.add(portNo);
		portNo.setColumns(10);
		
		talkName = new JTextField();
		talkName.setBounds(153, 167, 116, 21);
		panel_1.add(talkName);
		talkName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Server IP");
		lblNewLabel.setBounds(58, 79, 57, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Port Num");
		lblNewLabel_1.setBounds(58, 123, 57, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(58, 170, 57, 15);
		panel_1.add(lblNewLabel_2);
		
		connectButton = new JButton("Go");
		connectButton.setBounds(58, 206, 266, 58);
		panel_1.add(connectButton);
		panel_1.setVisible(true);
		panel.setVisible(false);
		
		connectButton.addActionListener(new ActionListener() {
	         public void actionPerformed(java.awt.event.ActionEvent evt) {
	            connectButtonActionPerformed(evt);
	         }
	      });
	      disconnectButton.addActionListener(new disConnectHandler());
	      sendMsgHandler = new sendMessageHandler3();
	      sendButton.addActionListener(sendMsgHandler);
	      sendMessageBox.addActionListener(sendMsgHandler);
	      talkName.requestFocus();
	}
	class ImagePanel extends JPanel {
		  private Image img;
		  
		  public ImagePanel(Image img) {
		      this.img = img;
		      setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		      setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		      setLayout(null);
		  }
		  
		  public void paintComponent(Graphics g) {
		      g.drawImage(img, 3, 0, null);
		  }
	}
		 
	private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {
	      String strMsg;
	      try {
	         echoSocket = new Socket(serverAddr.getText(), Integer.parseInt(portNo.getText()));
	         
	         socketOut = new PrintStream(echoSocket.getOutputStream(), true);
	         socketIn = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
	         
	         strMsg = socketIn.readLine();
	         if(strMsg.equals("SjChatServer")) {
	            socketOut.println("SjChatClient");
	            socketOut.println(talkName.getText());
	            
	            rec = new SjChatReceiveThread(socketIn, showMessageBox);
	            rec.start();
	            
	            sendMessageBox.requestFocus();
	            connectButton.setEnabled(false);
	            disconnectButton.setEnabled(true);;
	            sendButton.setEnabled(true);;
	            panel.setVisible(true);
	            panel_1.setVisible(false);
	         }
	         else {
	            showMessageBox.append("not equals message\n");
	         }
	      }
	      catch(UnknownHostException e) {
	         showMessageBox.append("Serverexception e.\n");
	      }
	      catch(IOException e) {
	         showMessageBox.append("IOexception e.\n");
	      }
	      catch(Exception e) {
	         showMessageBox.append("exception e. \n");
	      }
	   }
	   class disConnectHandler implements ActionListener {
	      public void actionPerformed(ActionEvent evt) {
	         showMessageBox.append("disconnect ");
	         try {
	            socketOut.close();
	            socketIn.close();
	            echoSocket.close();
	            connectButton.setEnabled(true);
	            disconnectButton.setEnabled(false);
	            sendButton.setEnabled(false);
	         }
	         catch(IOException e) {
	            showMessageBox.append("Error.\n");
	         }
	      }
	   }
	   class sendMessageHandler3 implements ActionListener {
	      public void actionPerformed(ActionEvent evt) {
	         String strMsg;
	         try {
	            strMsg = sendMessageBox.getText();
	            if(!strMsg.isEmpty()) {
	               socketOut.println(strMsg);
	               sendMessageBox.setText("");
	               sendMessageBox.requestFocus();
	            }
	         }
	         catch(Exception e) {
	            showMessageBox.append("         \n");
	         }
	      }
	   }
	   class SjChatReceiveThread extends Thread {
	      BufferedReader socketIn = null;
	      JTextArea showMessageBox;
	      String strSocket;
	      
	      SjChatReceiveThread() {}
	      SjChatReceiveThread(BufferedReader socketIn, JTextArea showMessageBox) {
	         this.socketIn = socketIn;
	         this.showMessageBox = showMessageBox;
	      }
	      public void run() {
	         try {
	            while ((strSocket = socketIn.readLine()) != null) {
	               showMessageBox.append(strSocket + "\n");
	               showMessageBox.setCaretPosition(showMessageBox.getDocument().getLength());
	            }
	         }
	         catch(Exception e) {
	            showMessageBox.append("erorr.\n");
	         }
	      }
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatClient().setVisible(true);
	}
}
