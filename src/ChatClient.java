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
<<<<<<< HEAD
	//private JButton sendButton;
	//private JButton disconnectButton;
=======
	private JScrollPane scrollPane;
	private JButton sendButton;
	private JButton disconnectButton;
>>>>>>> f466cf52fc2336658c0ce8456d34d7cd045d351c
	private JTextArea showConnectorBox;
	//private JButton connectButton;
	ImageButton sendButton;
	ImageButton connectButton;
	ImageButton disconnectButton;
	//JPanel panel;
	//JPanel panel_1;
	ImagePanel panel;
	ImagePanel panel_1;
	
	Font font;
	
	private Socket echoSocket;
	private PrintStream socketOut;
	private BufferedReader socketIn;
	private sendMessageHandler3 sendMsgHandler;
	private SjChatReceiveThread rec;
	
	
	public ChatClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		font = new Font("맑은 고딕", font.BOLD, 50);
		
		getContentPane().setLayout(null);
		setSize(1700, 950);
<<<<<<< HEAD
=======
		panel = new JPanel();
		panel.setBounds(0, 0, 1700, 950);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		showMessageBox = new JTextArea();
		showMessageBox.setBounds(143, 69, 387, 254);
		panel.add(showMessageBox);
		
		scrollPane = new JScrollPane(showMessageBox, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollPane.setBounds(143, 69, 387, 254);
	    panel.add(scrollPane);
		
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
>>>>>>> f466cf52fc2336658c0ce8456d34d7cd045d351c
		
		
		//panel_1 = new JPanel();
		panel_1 = new ImagePanel(new ImageIcon("./image/bg4.png").getImage());
		panel_1.setBounds(0, 0, 1700, 950);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		serverAddr = new JTextField();
		serverAddr.setBounds(840, 540, 300, 100);
		panel_1.add(serverAddr);
		serverAddr.setColumns(10);
		serverAddr.setFont(font);
		
		portNo = new JTextField();
		portNo.setBounds(840, 640, 300, 100);
		panel_1.add(portNo);
		portNo.setColumns(10);
		portNo.setFont(font);
		
		talkName = new JTextField();
		talkName.setBounds(840, 740, 300, 100);
		panel_1.add(talkName);
		talkName.setFont(font);
		talkName.setColumns(10);
		
		//JLabel lblNewLabel = new JLabel("Server IP");
		ImageLabel lblNewLabel = new ImageLabel(new ImageIcon("./image/serverip.png").getImage());
		lblNewLabel.setBounds(520, 540, 300, 100);
		panel_1.add(lblNewLabel);
		
		//JLabel lblNewLabel_1 = new JLabel("Port Num");
		ImageLabel lblNewLabel_1 = new ImageLabel(new ImageIcon("./image/portnum.png").getImage());
		lblNewLabel_1.setBounds(520, 640, 300, 100);
		panel_1.add(lblNewLabel_1);
		
		//JLabel lblNewLabel_2 = new JLabel("Name");
		ImageLabel lblNewLabel_2 = new ImageLabel(new ImageIcon("./image/name.png").getImage());
		lblNewLabel_2.setBounds(520, 740, 300, 100);
		panel_1.add(lblNewLabel_2);
		
		//connectButton = new JButton("Go");
		connectButton = new ImageButton(new ImageIcon("./image/start.png").getImage());
		connectButton.setBounds(1200, 740, 300, 100);
		panel_1.add(connectButton);
		
		//panel = new JPanel();
		panel = new ImagePanel(new ImageIcon("./image/bg4.png").getImage());
		panel.setBounds(0, 0, 1700, 950);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		showMessageBox = new JTextArea();
		showMessageBox.setBounds(300, 80, 1000, 700);
		panel.add(showMessageBox);
		
		sendMessageBox = new JTextField();
		sendMessageBox.setBounds(300, 800, 1000, 80);
		panel.add(sendMessageBox);
		sendMessageBox.setColumns(10);
		
		//sendButton = new JButton("SEND");
		sendButton = new ImageButton(new ImageIcon("./image/send.png").getImage());
		sendButton.setBounds(1350, 800, 100, 80);
		panel.add(sendButton);
		
		//disconnectButton = new JButton("EXIT");
		disconnectButton = new ImageButton(new ImageIcon("./image/exit.png").getImage());
		disconnectButton.setBounds(1500, 0, 200, 80);
		panel.add(disconnectButton);
		
		showConnectorBox = new JTextArea();
		showConnectorBox.setBounds(551, 94, 138, 229);
		panel.add(showConnectorBox);
		
		
		
		panel_1.setVisible(true);
		panel.setVisible(false);
		
		
		
		connectButton.addActionListener(new ActionListener() {
	         public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	lblNewLabel.setVisible(false);
	     		lblNewLabel_1.setVisible(false);
	     		lblNewLabel_2.setVisible(false);
	     		
	            connectButtonActionPerformed(evt);
	         }
	      });
	      disconnectButton.addActionListener(new disConnectHandler());
	      sendMsgHandler = new sendMessageHandler3();
	      sendButton.addActionListener(sendMsgHandler);
	      sendMessageBox.addActionListener(sendMsgHandler);
	      talkName.requestFocus();
	}
	class ImageButton extends JButton {
		  private Image img;
		  
		  public ImageButton(Image img) {
		      this.img = img;
		      setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		      setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		      setLayout(null);
		  }
		  
		  public void paintComponent(Graphics g) {
		      g.drawImage(img, 3, 0, null);
		  }
	}
	class ImageLabel extends JLabel {
		  private Image img;
		  
		  public ImageLabel(Image img) {
		      this.img = img;
		      setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		      setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		      setLayout(null);
		  }
		  
		  public void paintComponent(Graphics g) {
		      g.drawImage(img, 3, 0, null);
		  }
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
	            connectButton.setVisible(false);
	            
	            serverAddr.setVisible(false);
	     		portNo.setVisible(false);
	     		talkName.setVisible(false);
	     		
	            
	            disconnectButton.setEnabled(true);;
	            sendButton.setEnabled(true);;
	            panel.setVisible(true);
	            sendButton.setVisible(true);
	            disconnectButton.setVisible(true);
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
	            showMessageBox.append("erorr\n");
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
