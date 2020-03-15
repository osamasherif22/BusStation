import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import algoritm.Customer;
import algoritm.Driver;
import algoritm.Singletone;
import algoritm.Ticket;
import algoritm.Trip;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Book extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private  JLabel label ;
	Customer customer ;
	Trip currenTrip1;
	Trip currenTrip2;

	 boolean flag=false ;
	
	int idOfTrip1 ;
	int idOfTrip2 ;
    Singletone all;
	int index;
    Ticket currenTicket;

	/**
	 * Create the frame.
	 * @param customer 
	 * @param idOfTrip2 
	 */
	public Book(Customer customer, int idOfTrip1, int idOfTrip2  ) {
        this.all =Singletone.getInstance();
		this.customer =customer;
		this.idOfTrip1 = idOfTrip1 ;
		this.idOfTrip2 = idOfTrip2 ;
	    this.flag=false ;
	    this.index=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 226);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookATrip = new JLabel("Book A Trip");
		lblBookATrip.setForeground(SystemColor.text);
		lblBookATrip.setFont(new Font("Tillana ExtraBold", Font.PLAIN, 27));
		lblBookATrip.setBounds(44, 11, 188, 46);
		contentPane.add(lblBookATrip);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (flag==true)
			{
					System.out.println(Integer.parseInt(textField.getText()));
			currenTicket=customer.reserve(currenTrip1,currenTrip2, customer,Integer.parseInt(textField.getText()));
			currenTrip1=currenTicket.getTrip1();
			all.getTripList().set(index, currenTrip1);
			JOptionPane.showMessageDialog(contentPane,"Done Booking !! ");			
				setVisible(false);
				customer.setCustomerTickets(currenTicket);
				System.out.println(customer.getCustomerTickets().get(0).getNumberOfTicket());
			}
			else JOptionPane.showMessageDialog(contentPane,"Choose Number Of Seats First ! ");			
			}
		});
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnNewButton.setBounds(159, 161, 97, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.info);
		textField.setBounds(143, 76, 71, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNumberOfSeats = new JLabel(" Number Of Seats");
		lblNumberOfSeats.setFont(new Font("Corbel", Font.PLAIN, 15));
		lblNumberOfSeats.setBounds(25, 80, 108, 19);
		contentPane.add(lblNumberOfSeats);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.info);
		textArea.setEditable(false);
		textArea.setBounds(114, 121, 62, 15);
		contentPane.add(textArea);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Corbel", Font.PLAIN, 15));
		lblPrice.setBounds(44, 120, 46, 14);
		contentPane.add(lblPrice);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(SystemColor.info);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnCancel.setBounds(25, 161, 108, 23);
		contentPane.add(btnCancel);
		
		JButton btnGet = new JButton("Get");
		btnGet.setBackground(SystemColor.info);
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int numOfSeats = Integer.parseInt(textField.getText()) ;  int price =0;
					all.getTripList().forEach(Trip ->        // populate produce combo box with one to length of produce names array
			        {
			        	if(Integer.parseInt(Trip.getId())==idOfTrip1)
			        	{ currenTrip1=Trip ;
			        	index=all.getTripList().indexOf(Trip);
			        	}
			        	if(Integer.parseInt(Trip.getId())==idOfTrip2)
			        	{
			        		currenTrip2=Trip ;
			        	}
                    });
					
					if(	customer.available(currenTrip1,currenTrip2,numOfSeats)&&numOfSeats>0)
					{  price= customer.calculatePrice(currenTrip1.getDestance(),numOfSeats) ;
					    textArea.setText(Integer.toString(price));
						label.setVisible(true);
					    flag =true ;
						}
			   else  JOptionPane.showMessageDialog(contentPane," There isn't enough seats Try another number Of seats ! ");

				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane," Enter Number Of Seats You Want !! ");			
					}
			}
		});
		btnGet.setBounds(224, 76, 54, 23);
		contentPane.add(btnGet);
		
		 label = new JLabel("LE");
		 label.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
		label.setBounds(192, 104, 40, 46);
		label.setVisible(false);
		contentPane.add(label);
	}
}
