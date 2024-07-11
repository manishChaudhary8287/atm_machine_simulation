package task1task1gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CashWithdrawal {
	
	JFrame frame;
	JLabel label1,label2,label3,label4;
	JTextField textField;
	JButton done,backToMenu;
	Font font1;
	ATMMain atmMain; 
	
	public void cashWithdrawal() {
		
		atmMain= new ATMMain();
		
		frame = new JFrame("CASH WITHDRAWAL");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		font1 = new Font("Times New Roman",Font.BOLD,26);
		
		label1 = new JLabel("Cash Withdrawal");
		label1.setFont(font1);
		label2 = new JLabel("Current Account Balance : ");
		String temp=String.valueOf(ATMMain.fetchAccountBalance());
		label3 = new JLabel(temp);
		
		label4 = new JLabel("Withdrawal Amount : ");
		textField = new JTextField();
		done =new JButton("DONE");
		backToMenu = new JButton("Back To Menu");
		
		label1.setBounds(60, 20, 300, 60);
		label2.setBounds(80, 100, 200, 50);
		label3.setBounds(250, 100, 50, 50);
		label4.setBounds(80, 150, 200, 50);
		textField.setBounds(200, 165, 60, 25);
		done.setBounds(150, 200, 100, 30);
		backToMenu.setBounds(120, 250, 150, 30);
		
		done.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int tempVar=Integer.parseInt(textField.getText());
				int tempCurr=(int) ATMMain.fetchAccountBalance();
				tempCurr=tempCurr-tempVar;

				String strTemp="Amount Withdraw : "+tempVar+"  Current Balance : "+tempCurr+"\n";
				
				ATMMain.insertCurrentBalance(tempCurr, strTemp);
				ATMMain.insertTransaction(strTemp);

				
				textField.setText("");
				label3.setText(String.valueOf(tempCurr));
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
		panel.add(label4);
		panel.add(textField);
		panel.add(done);
		panel.add(backToMenu);
		
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setSize(400, 350);
		frame.setVisible(true);
		
	}

}