package task1task1gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TransactionHistory {
	
	JFrame frame;
	JLabel label1;
	JTextArea textArea;
	JButton backToMenu;
	
	public void transactionHist() {
		
		frame = new JFrame("TRANSACTION HISTORY");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		Font font  = new Font("Times New Roman",Font.BOLD,26);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		label1 = new JLabel();
		textArea = new JTextArea(15,30);
		
		label1 = new JLabel("TRANSACTION HISTORY");
		label1.setFont(font);
		
//		label2.setText("This is the demo.");
		String tempStr=ATMMain.fetchTransaction();
		textArea.setText(tempStr);
		textArea.setEditable(false);
		JScrollPane scrollPane  =new JScrollPane(textArea);
	
		
		
		backToMenu= new JButton("Back To Menu");
		
		backToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATMMenu menuPage = new ATMMenu();
				menuPage.showMenu();
				frame.setVisible(false);	
			}
		});
		
		panel1.add(label1);
		panel2.add(textArea);
		panel2.add(scrollPane);
		panel3.add(backToMenu);
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		frame.add(panel);
		frame.setSize(500, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
