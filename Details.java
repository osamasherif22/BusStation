import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import algoritm.Authentication;
import algoritm.Customer;
import algoritm.Driver;
import algoritm.Singletone;
import algoritm.Trip;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Details extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	Singletone all ;
	Customer customer ;

	/**
	
	/**
	 * Create the frame.
	 * @param entry 
	 */
	public Details( ) {
		
		this.all =Singletone.getInstance();
		this.customer =Customer.getInstance();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Passenger Account");
		lblNewLabel.setForeground(UIManager.getColor("text"));
		lblNewLabel.setBackground(UIManager.getColor("text"));
		lblNewLabel.setFont(new Font("Tillana ExtraBold", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(42, 24, 350, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Miriam Fixed", Font.ITALIC, 20));
		lblNewLabel_1.setBounds(64, 93, 96, 21);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(174, 94, 145, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Miriam Fixed", Font.ITALIC, 20));
		lblPassword.setBounds(64, 130, 107, 32);
		contentPane.add(lblPassword);
		

		passwordField = new JPasswordField();
		passwordField.setBounds(174, 137, 145, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				int index =Authentication.getCustomerIndex(textField.getText(), passwordField.getText(),all.getCustomerList());
				if(index!=-1)
				{				
				customer = all.getCustomerList().get(index);
				all.getCustomerList().remove(index);
		        PassengerView PassengerView= new PassengerView(customer);
				setVisible(false);
				PassengerView.setVisible(true);
				}
				else if(index==-1)
					JOptionPane.showMessageDialog(contentPane, " Wrong Username Or Password !! ");
				
			
			}
		});
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(UIManager.getColor("info"));
		btnLogin.setFont(new Font("Consolas", Font.PLAIN, 17));
		btnLogin.setBounds(137, 194, 158, 22);
		contentPane.add(btnLogin);
		
		
		JButton btnNewButton = new JButton("Previous");
		btnNewButton.setBackground(UIManager.getColor("info"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entry Entry =new Entry() ;
				setVisible(false);
				Entry.setVisible(true);
			
			}
		});
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 17));
		btnNewButton.setBounds(157, 227, 120, 23);
		contentPane.add(btnNewButton);
	}
	
}
