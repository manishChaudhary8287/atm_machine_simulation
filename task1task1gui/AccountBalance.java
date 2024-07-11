package task1task1gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountBalance {
	
	JFrame frame;
	Font font,font1;
	
	public void checkAccountBalance() {
		
		frame = new JFrame("Checking Account Balance");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// creating the panel
		JPanel panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		
		frame.setSize(500, 200);
		
		font = new Font("Times New Roman",Font.BOLD,25);
		
		
		// creating the sub-panel to hold the components.
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		JLabel label1 = new JLabel("ACCOUNT BALANCE INQUIRY");
		label1.setFont(font);
		
		JLabel label2 = new JLabel("Current Balance : ");
		font1 = new Font("Serif",Font.BOLD,20);
		label2.setFont(font1);
		
		ATMMain atmMain = new ATMMain();
		String temp = String.valueOf(ATMMain.fetchAccountBalance());
		
		JLabel label3 = new JLabel(temp);
		label3.setFont(font1);
		
		JButton menuButton = new JButton("Back to Menu");
		
		menuButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ATMMenu atmMenu = new ATMMenu();
				atmMenu.showMenu();
				frame.setVisible(false);
				
			}
		});
		
		
		panel1.add(label1);
		panel2.add(label2);
		panel2.add(label3);
		panel3.add(menuButton);
		
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		
		frame.add(panel);
		
	
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
