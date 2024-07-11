package task1task1gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Starting {
	ATMMenu menu;
	ATMMain main;
	JFrame frame;
	JTextField textField;
	JPanel panel;
	JLabel label1,label2,label3;
	JButton nextButton;

	public void startingFrame() {
		
		menu = new ATMMenu();
		main = new ATMMain();
		
		
		 // Create a new JFrame instance
        frame = new JFrame("ATM Machine Simulation");

        // Set the default close operation to exit the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame
        frame.setSize(500, 300);
        
    

        // Create a JPanel to hold the components
        panel = new JPanel();
        panel.setLayout(null);

      
        Font font=new Font("Times New Roman",Font.BOLD,26);
        // Create labels
        label1 = new JLabel("Welcome to ATM Machine Simulation");
        label1.setFont(font);
        
        label2 = new JLabel("Enter Your PIN : ");
        
        textField = new JTextField();
        
        nextButton = new JButton("Continue");
        
        label1.setBounds(20, 10, 1000, 30);
        label2.setBounds(50,100,150,30);
        textField.setBounds(150,105,60,25);
        nextButton.setBounds(180, 180, 100, 30);
   
        label3=new JLabel("Wrong PIN... TRY AGAIN");
        label3.setBounds(200, 105, 100, 30);
        

       
        
        nextButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int tempPin=Integer.parseInt(textField.getText());
				if(tempPin==ATMMain.fetchPin()) {
					menu.showMenu();
					frame.setVisible(false);
					 
				}
				else {
					panel.add(label3);
				}
			}
		});
        
        // Add labels to their respective sub-panels
        panel.add(label1);
        panel.add(label2);
        panel.add(textField);
        panel.add(nextButton);
       

        // Add the main panel to the frame
        frame.add(panel);

        // Set the frame's location to the center of the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
        

	}

}
