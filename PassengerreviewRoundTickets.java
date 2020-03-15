import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import algoritm.Customer;
import algoritm.Driver;
import algoritm.Singletone;
import algoritm.Ticket;
import algoritm.Trip;
import javafx.scene.control.TextField;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
 
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Color;
 
public class PassengerreviewRoundTickets extends JFrame {

	private JPanel contentPane;
	Customer customer ;
	private JLabel lblSource;
	private JLabel lblDate;
	private JLabel lblTime;
	private JLabel lblAvailableTrips;
	private JButton btnView;
	private JButton btnPrevious;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JTextArea textArea_3;
	private JTextArea textArea_4;
	private JTextArea textArea_5;
	private JLabel lblViehcleType;
	private JLabel lblNumberOfSeats;
	Singletone all;

	/**
	 * Launch the application.
	

	/**
	 * Create the frame.
	 * @param customer 
	 */
	public PassengerreviewRoundTickets(Customer customer) {
		setTitle("Back Trip");
		
		this.all =Singletone.getInstance();
		this.customer =customer;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.info);
		
		customer.getCustomerTickets().forEach(Ticket ->        // populate produce combo box with one to length of produce names array
	        {
			 comboBox.addItem(Ticket.getNumberOfTicket());
	        });
		comboBox.setBounds(67, 36, 280, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Destination ");
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblNewLabel.setBounds(77, 101, 96, 16);
		contentPane.add(lblNewLabel);
		
		lblSource = new JLabel("Source");
		lblSource.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblSource.setBounds(87, 126, 48, 16);
		contentPane.add(lblSource);
		
		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblDate.setBounds(88, 151, 32, 16);
		contentPane.add(lblDate);
		
		lblTime = new JLabel("Time");
		lblTime.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblTime.setBounds(42, 178, 32, 16);
		contentPane.add(lblTime);
		
		lblAvailableTrips = new JLabel("MyTrips");
		lblAvailableTrips.setFont(new Font("Tillana ExtraBold", Font.PLAIN, 14));
		lblAvailableTrips.setBackground(new Color(240, 240, 240));
		lblAvailableTrips.setBounds(154, 1, 124, 24);
		contentPane.add(lblAvailableTrips);
		
		btnView = new JButton("View");
		btnView.setFont(new Font("Consolas", Font.PLAIN, 15));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customer.getCustomerTickets().forEach(Ticket ->        // populate produce combo box with one to length of produce names array
		        {
		        	if (Ticket.getNumberOfTicket()==(int)comboBox.getSelectedItem())
		        	{

textArea.setText(Ticket.getTrip2().getDestination());
textArea_1.setText(Ticket.getTrip2().getSource());
textArea_2.setText(Ticket.getTrip2().getDate());
textArea_3.setText(Ticket.getTrip2().getTime());
textArea_4.setText(Ticket.getTrip2().getVehicleType().getVehicleType());
textArea_5.setText(String.valueOf(Ticket.getbookedSeats()));

		        	}	
		         });
				
			}
		});
		btnView.setBounds(154, 70, 89, 20);
		contentPane.add(btnView);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.setFont(new Font("Consolas", Font.PLAIN, 15));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PassengerReviewTrips passengerView =new PassengerReviewTrips(customer);
				setVisible(false);
				passengerView.setVisible(true);
			}
		});
		btnPrevious.setBounds(154, 236, 105, 20);
		contentPane.add(btnPrevious);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(193, 102, 124, 15);
		contentPane.add(textArea);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(193, 127, 124, 15);
		contentPane.add(textArea_1);
		
		textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setBounds(193, 152, 124, 15);
		contentPane.add(textArea_2);
		
		textArea_3 = new JTextArea();
		textArea_3.setEditable(false);
		textArea_3.setBounds(98, 181, 124, 15);
		contentPane.add(textArea_3);
		
		lblViehcleType = new JLabel("Viehcle Type");
		lblViehcleType.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblViehcleType.setBounds(67, 200, 96, 16);
		contentPane.add(lblViehcleType);
		
		textArea_4 = new JTextArea();
		textArea_4.setEditable(false);
		textArea_4.setBounds(193, 205, 124, 15);
		contentPane.add(textArea_4);
		
		lblNumberOfSeats = new JLabel("Number Of Seats");
		lblNumberOfSeats.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblNumberOfSeats.setBounds(244, 178, 120, 16);
		contentPane.add(lblNumberOfSeats);
		
	   textArea_5 = new JTextArea();
		textArea_5.setEditable(false);
		textArea_5.setBounds(374, 181, 21, 15);
		contentPane.add(textArea_5);
		
	    
	}
}
