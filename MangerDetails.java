import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import algoritm.Driver;
import algoritm.Manager;
import algoritm.Singletone;
import algoritm.Trip;
import algoritm.managerActions;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class MangerDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	Singletone all;
	Manager manager;

	/**
	 * Create the frame.
	 */
	public MangerDetails() {
		
		this.all =Singletone.getInstance();
		this.manager=Manager.getInstance();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manager Account");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Tillana ExtraBold", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(42, 29, 331, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Miriam Fixed", Font.ITALIC, 20));
		lblNewLabel_1.setBounds(55, 96, 124, 34);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(174, 103, 145, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Miriam Fixed", Font.ITALIC, 20));
		lblPassword.setBounds(55, 131, 107, 32);
		contentPane.add(lblPassword);
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(174, 137, 145, 23);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(UIManager.getColor("info"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean valdresult =AuthenticationManger(textField.getText(),passwordField.getText());
				System.out.println(valdresult);
				if(valdresult)
				{ManagerView ManagerView = new ManagerView();	
				setVisible(false);
				ManagerView.setVisible(true);
				}
				else if(!valdresult)
					JOptionPane.showMessageDialog(contentPane, " Wrong Username Or Password !! ");
				
			}
		});
		btnLogin.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnLogin.setBounds(152, 184, 124, 32);
		contentPane.add(btnLogin);
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBackground(UIManager.getColor("info"));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entry Entry =new Entry() ;
				setVisible(false);
				Entry.setVisible(true);
			}
		});
		btnPrevious.setBounds(171, 227, 89, 23);
		contentPane.add(btnPrevious);
	}
	static Boolean AuthenticationManger(String username,String password) {
		Manager manager=Manager.getInstance();

		/* This is how to declare HashMap */
	    HashMap<String, String> hmap = new HashMap<String, String>();
	    /*Adding elements to HashMap*/
	    hmap.put(manager.getUserName(), manager.getPassword());  
	    String fetchedpass =hmap.get(username);
	    if (fetchedpass!=null) 
	    	return fetchedpass.equals(password) ;
	    else  return false ;
	}
}
