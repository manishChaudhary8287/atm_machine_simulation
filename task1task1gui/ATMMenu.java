package task1task1gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ATMMenu {
	JFrame jFrame;
	JButton accountBalance,cashWithdrawal,cashDeposit,changePin,transactionHistory,back;
	JLabel heading;

	public void showMenu() {
		
		jFrame = new JFrame(" ATM Menu ");
		
		 // Set the default close operation to exit the application
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a JPanel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(null);
       
        Font font = new Font("Times New Roman",Font.BOLD,26);
        heading = new JLabel("ATM MENU");
        heading.setFont(font);
        heading.setBounds(150, 2, 200, 50);

//      setting the button
        accountBalance =new JButton("Account Balance");
        accountBalance.setBounds(150, 50, 150, 30);
        cashWithdrawal =new JButton("Cash Withdrawal");
        cashWithdrawal.setBounds(150, 100, 150, 30);
        cashDeposit =new JButton("Cash Deposit");
        cashDeposit.setBounds(150, 150, 150, 30);
        changePin =new JButton("Change PIN");
        changePin.setBounds(150, 200, 150, 30);
        transactionHistory =new JButton("Transaction History");
        transactionHistory.setBounds(150, 250, 150, 30);
        back = new JButton("Back");
        back.setBounds(150, 300, 150, 30);
        
        // setting the click listener to the button to perform the action
        accountBalance.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AccountBalance accBalance = new AccountBalance();
				accBalance.checkAccountBalance();
				jFrame.setVisible(false);
			}
		});
        
        cashWithdrawal.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CashWithdrawal withdraw = new CashWithdrawal();
				withdraw.cashWithdrawal();
				jFrame.setVisible(false);
				
			}
		});
        
        cashDeposit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CashDeposit deposit = new CashDeposit();
				deposit.cashDeposit();
				jFrame.setVisible(false);
				
			}
		});
        
        changePin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ChangePIN changepin = new ChangePIN();
				changepin.changePin();
				jFrame.setVisible(false);
				
			}
		});
        
        transactionHistory.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				TransactionHistory tranHist = new TransactionHistory();
				tranHist.transactionHist();
				jFrame.setVisible(false);
			}
		});
        
        back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Starting startPage = new Starting();
				startPage.startingFrame();
				jFrame.setVisible(false);
				
			}
		});
        
        
        panel.add(heading);
        panel.add(accountBalance);
        panel.add(cashWithdrawal);
        panel.add(cashDeposit);
        panel.add(changePin);
        panel.add(transactionHistory);
        panel.add(back);
      
      
        
        jFrame.add(panel);
 
        // Set the frame's location to the center of the screen
        jFrame.setLocationRelativeTo(null);
        
     // Set the size of the frame
        jFrame.setSize(500, 400);
        
        jFrame.setVisible(true);
	}
}
