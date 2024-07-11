package task1task1gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChangePIN {
	
	JFrame frame;
	JLabel label1,label2,label3;
	JTextField textField1,textField2;
	JButton done,backToMenu;
	Font font1;
	ATMMain atmMain; 
	
	public void changePin() {
		
		atmMain= new ATMMain();
		
		frame = new JFrame("change PIN Number");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		font1 = new Font("Times New Roman",Font.BOLD,26);
		
		label1 = new JLabel("CHANGE PIN ");
		label1.setFont(font1);
		
		label2 = new JLabel("Old PIN ");
		
		label3 = new JLabel("New PIN ");
		
		textField1 = new JTextField();
		textField2 = new JTextField();
		done =new JButton("DONE");
		backToMenu = new JButton("Back To Menu");
		
		label1.setBounds(100, 20, 300, 60);
		label2.setBounds(80, 100, 100, 50);
		label3.setBounds(80, 150, 100, 50);
		textField1.setBounds(150, 110, 60, 25);
		textField2.setBounds(150, 165, 60, 25);
		done.setBounds(150, 210, 100, 30);
		backToMenu.setBounds(120, 260, 150, 30);
		
		done.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int temp=Integer.parseInt(textField1.getText());
				if(temp==ATMMain.fetchPin()) {
					int newPin = Integer.parseInt(textField2.getText());
					ATMMain.changePin(newPin);
					textField2.setText("");
					textField1.setText("");
					
					Starting start = new Starting();
					start.startingFrame();
					frame.setVisible(false);
				}
			}
		});
		
		
		backToMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ATMMenu menuPage = new ATMMenu();
				menuPage.showMenu();
				frame.setVisible(false);
				
			}
		});
		
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(textField1);
		panel.add(textField2);
		panel.add(done);
		panel.add(backToMenu);
		
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setSize(400, 350);
		frame.setVisible(true);
		
	}

}
