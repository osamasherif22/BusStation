
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.transform.Source;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import algoritm.Customer;
import algoritm.Driver;
import algoritm.Singletone;
import algoritm.Trip;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;

public class SelectTrip extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	Customer customer ;
	
	String vehicleType;
	boolean flagRound ;
	Singletone all ;

	/**
	 * Create the frame.
	 * @param customer2 
	 */
	public SelectTrip(Customer customer ) {
		setTitle("Select Trip");
       
        this.all =Singletone.getInstance();
		this.customer =customer;
		System.out.println("4"+customer.getUserName());
		System.out.println(customer.getPassword());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 359);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Source:");
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.PLAIN, 20));
		lblNewLabel.setBounds(35, 77, 118, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setFont(new Font("SimSun-ExtB", Font.PLAIN, 20));
		lblDestination.setBounds(10, 105, 143, 34);
		contentPane.add(lblDestination);
		
		JLabel lblTicketType = new JLabel("Ticket Type");
		lblTicketType.setFont(new Font("SimSun-ExtB", Font.PLAIN, 20));
		lblTicketType.setBounds(10, 140, 155, 43);
		contentPane.add(lblTicketType);
		
		JRadioButton rdbtnOneWay = new JRadioButton("One-Way");
		rdbtnOneWay.setSelected(true);
		rdbtnOneWay.setBackground(SystemColor.activeCaption);
		rdbtnOneWay.setFont(new Font("Corbel", Font.PLAIN, 16));
		rdbtnOneWay.setBounds(10, 190, 100, 23);
		contentPane.add(rdbtnOneWay);
		
		JRadioButton rdbtnRound = new JRadioButton("Round-Trip");
		rdbtnRound.setBackground(SystemColor.activeCaption);
		rdbtnRound.setFont(new Font("Corbel", Font.PLAIN, 16));
		rdbtnRound.setBounds(10, 217, 109, 23);
		contentPane.add(rdbtnRound);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.window);
		textField.setBounds(147, 85, 210, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		 textField.setText(null);
		 
		textField_1 = new JTextField();
		textField_1.setBounds(147, 116, 210, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		 textField_1.setText(null);
		 
		JLabel lblTicketFlavo = new JLabel("Ticket Flavor");
		lblTicketFlavo.setFont(new Font("SimSun-ExtB", Font.PLAIN, 20));
		lblTicketFlavo.setBounds(279, 140, 155, 34);
		contentPane.add(lblTicketFlavo);
		
		JRadioButton rdbtnNonStop = new JRadioButton("Non Stop");
		rdbtnNonStop.setBackground(SystemColor.activeCaption);
		rdbtnNonStop.setFont(new Font("Corbel", Font.PLAIN, 15));
		rdbtnNonStop.setBounds(289, 180, 83, 23);
		contentPane.add(rdbtnNonStop);
		
		JRadioButton rdbtnOneStop = new JRadioButton("One Stop");
		rdbtnOneStop.setBackground(SystemColor.activeCaption);
		rdbtnOneStop.setFont(new Font("Corbel", Font.PLAIN, 15));
		rdbtnOneStop.setBounds(289, 206, 83, 23);
		contentPane.add(rdbtnOneStop);
		
		JRadioButton rdbtnManyStops = new JRadioButton("Many Stops");
		rdbtnManyStops.setBackground(SystemColor.activeCaption);
		rdbtnManyStops.setFont(new Font("Corbel", Font.PLAIN, 15));
		rdbtnManyStops.setBounds(289, 232, 100, 23);
		contentPane.add(rdbtnManyStops);
		
		JButton btnNewButton = new JButton("Search for a trip");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
				 String source = textField.getText();
				String destination = textField_1.getText(); 
			
			ArrayList<Trip> foundList1=customer.listTrips(source,destination,vehicleType,all.getTripList());
			System.out.println(foundList1.size());
			ArrayList<Trip> foundList2= null;
			try {
			if (flagRound)
			{foundList2=customer.listTrips(destination,source,vehicleType,all.getTripList());}
	        ReviewSelectedTrips ReviewSelectedTrips=  new ReviewSelectedTrips(customer,foundList1,foundList2);
			setVisible(false);
			ReviewSelectedTrips.setVisible(true);
				} catch (Exception e2) {
				JOptionPane.showMessageDialog(contentPane, " There isn't Trip with matching informations !! ");
				}
			}
		});
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 17));
		btnNewButton.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnNewButton.setBounds(111, 262, 198, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblTripSelection = new JLabel("Trip Selection ");
		lblTripSelection.setBackground(UIManager.getColor("text"));
		lblTripSelection.setForeground(UIManager.getColor("text"));
		lblTripSelection.setFont(new Font("Tillana ExtraBold", Font.BOLD | Font.ITALIC, 32));
		lblTripSelection.setBounds(74, 20, 280, 54);
		contentPane.add(lblTripSelection);
		
		JLabel lblVehicle = new JLabel("Vehicle Type");
		lblVehicle.setFont(new Font("SimSun-ExtB", Font.PLAIN, 20));
		lblVehicle.setBounds(136, 150, 148, 23);
		contentPane.add(lblVehicle);
		
		JRadioButton rdbtnMinibus = new JRadioButton("Mini-Bus");
		rdbtnMinibus.setFont(new Font("Corbel", Font.PLAIN, 16));
		rdbtnMinibus.setBackground(SystemColor.activeCaption);
		rdbtnMinibus.setBounds(147, 180, 83, 29);
		contentPane.add(rdbtnMinibus);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Limousine");
		rdbtnNewRadioButton.setFont(new Font("Corbel", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton.setBounds(147, 206, 93, 29);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnBus = new JRadioButton("Bus");
		rdbtnBus.setFont(new Font("Corbel", Font.PLAIN, 16));
		rdbtnBus.setBackground(SystemColor.activeCaption);
		rdbtnBus.setBounds(147, 229, 49, 29);
		contentPane.add(rdbtnBus);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassengerView passengerView= new PassengerView(customer) ;
				setVisible(false);
				passengerView.setVisible(true);
			}
		});
		btnPrevious.setFont(new Font("Consolas", Font.PLAIN, 17));
		btnPrevious.setBounds(147, 296, 118, 23);
		contentPane.add(btnPrevious);
		
		
		
		
		rdbtnMinibus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMinibus.isSelected())
					{
					vehicleType="mini-bus";
					rdbtnNewRadioButton.setSelected(false);
				    rdbtnBus.setSelected(false);
					}
			}
		});
		rdbtnBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnBus.isSelected())
				{vehicleType="bus";
				rdbtnNewRadioButton.setSelected(false);
				rdbtnMinibus.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected())
				{vehicleType="Limousine";
				rdbtnBus.setSelected(false);
				rdbtnMinibus.setSelected(false);
				}
			}
		});
		rdbtnOneWay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnOneWay.isSelected())
					{rdbtnRound.setSelected(false);
				    flagRound =false;
					}
			}
		});
		rdbtnRound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnRound.isSelected())
				{	rdbtnOneWay.setSelected(false);
				 flagRound =true;
				}

			}
		});
		rdbtnNonStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNonStop.isSelected())
					rdbtnOneStop.setSelected(false);
				rdbtnManyStops.setSelected(false);
			}
		});
		rdbtnOneStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnOneStop.isSelected())
					rdbtnNonStop.setSelected(false);
				rdbtnManyStops.setSelected(false);
			}
		});
		rdbtnManyStops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnManyStops.isSelected())
					rdbtnOneStop.setSelected(false);
				rdbtnNonStop.setSelected(false);
			}
		});
		
		
		
		
		
	}
}
