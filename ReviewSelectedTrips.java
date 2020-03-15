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
import javax.swing.UIManager;
 
public class ReviewSelectedTrips extends JFrame {

	private JPanel contentPane;
	ArrayList<Trip> flist1,flist2 ;
	Customer customer;

	private JButton btnBook;
	private JLabel lblSource;
	private JLabel lblDate;
	private JLabel lblTime;
	private JLabel lblAvailableTrips;
	private JLabel lblBack ;
	private JButton button ;
	private JButton btnView;
	private JButton btnPrevious;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JTextArea textArea_3;
	private JTextArea textArea_4;
	private JTextArea textArea_5;
	private JTextArea textArea_6;
	private JTextArea textArea_7;
	private JTextArea textArea_8;
	private JTextArea textArea_9;
	Singletone all ;

	int idOfTrip1 ;
	int idOfTrip2 ;

	 boolean flagvIEW=false ;
	 boolean flagRound=false ;

	 private JLabel label_1;
	 private JLabel label_2;
	 private JLabel label_3;
	 private JLabel label_4;
	 private JComboBox comboBox_1;
	/**
	 * Launch the application.
	

	/**
	 * Create the frame.
	 * @param customer 
	 * @param flist1 
	 * @param flist2 
	 
	
	 */
	 
	public ReviewSelectedTrips(Customer customer, ArrayList<Trip> flist1, ArrayList<Trip> flist2 ) {
		setTitle("Booking Trip");
		this.flist1=flist1;
		this.flist2=flist2;
		this.all =Singletone.getInstance();
		this.customer=customer;
		System.out.println("5"+customer.getUserName());
		System.out.println(customer.getPassword());
		if(flist2==null) {flagRound =false;}
		else {flagRound =true; }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 305);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		
		flist1.forEach(Trip ->        // populate produce combo box with one to length of produce names array
	        {
			 comboBox.addItem(Trip.getDate());
	        });
		
		comboBox.setBounds(116, 25, 131, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Destination ");
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 87, 96, 16);
		contentPane.add(lblNewLabel);
		
		
		btnView = new JButton("View");
		btnView.setFont(new Font("Corbel", Font.PLAIN, 13));
		btnView.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flagvIEW=true;
				flist1.forEach(Trip ->        // populate produce combo box with one to length of produce names array
		        {
		        	if (Trip.getDate().equalsIgnoreCase((String)comboBox.getSelectedItem()))
		        	{

    textArea.setText(Trip.getDestination());
    textArea_1.setText(Trip.getSource());
    textArea_2.setText(Trip.getDate());
    textArea_3.setText(Trip.getTime());
    textArea_4.setText(Trip.getVehicleType().getVehicleType());
    idOfTrip1=Integer.parseInt(Trip.getId());	       
    }	
		         });
				
			}
		});
		btnView.setBounds(70, 56, 89, 24);
		contentPane.add(btnView);
		
		btnBook = new JButton("Book");
		btnBook.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flagvIEW)
				{
				Book book =new Book(customer,idOfTrip1,idOfTrip2);
					book.setVisible(true);
				}
				else JOptionPane.showMessageDialog(contentPane," Press View Button To Book This Trip !");			

			}
		});
		btnBook.setBounds(282, 227, 89, 23);
		contentPane.add(btnBook);
		
		lblSource = new JLabel("Source");
		lblSource.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblSource.setBounds(20, 114, 48, 16);
		contentPane.add(lblSource);
		
		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblDate.setBounds(33, 137, 32, 16);
		contentPane.add(lblDate);
		
		lblTime = new JLabel("Time");
		lblTime.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblTime.setBounds(33, 165, 32, 16);
		contentPane.add(lblTime);
		
		lblAvailableTrips = new JLabel("Available Trips");
		lblAvailableTrips.setFont(new Font("Tillana ExtraBold", Font.PLAIN, 10));
		lblAvailableTrips.setBackground(new Color(240, 240, 240));
		lblAvailableTrips.setBounds(10, 23, 124, 24);
		contentPane.add(lblAvailableTrips);
	
		
		btnPrevious = new JButton("Previous");
		btnPrevious.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SelectTrip selectTrip =new SelectTrip(customer);
				setVisible(false);
				selectTrip.setVisible(true);
			}
		});
		btnPrevious.setBounds(70, 227, 89, 23);
		contentPane.add(btnPrevious);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(116, 90, 101, 15);
		contentPane.add(textArea);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(116, 114, 101, 16);
		contentPane.add(textArea_1);
		
		textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setBounds(116, 140, 101, 15);
		contentPane.add(textArea_2);
		
		textArea_3 = new JTextArea();
		textArea_3.setEditable(false);
		textArea_3.setBounds(116, 168, 101, 15);
		contentPane.add(textArea_3);
		
		textArea_4 = new JTextArea();
		textArea_4.setEditable(false);
		textArea_4.setBounds(116, 194, 101, 15);
		contentPane.add(textArea_4);
		
		JLabel lblViehcleType = new JLabel("Viehcle Type");
		lblViehcleType.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblViehcleType.setBounds(10, 191, 96, 16);
		contentPane.add(lblViehcleType);
		
		JLabel label = new JLabel("Viehcle Type");
		label.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		label.setVisible(false);
		label.setBounds(227, 191, 96, 16);
		contentPane.add(label);
		
		label_1 = new JLabel("Time");
		label_1.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		label_1.setVisible(false);
		label_1.setBounds(258, 165, 32, 16);
		contentPane.add(label_1);
		
		label_2 = new JLabel("Date");
		label_2.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		label_2.setVisible(false);
		label_2.setBounds(258, 138, 32, 14);
		contentPane.add(label_2);
		
		label_3 = new JLabel("Source");
		label_3.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		label_3.setVisible(false);
		label_3.setBounds(248, 114, 48, 16);
		contentPane.add(label_3);
		
		label_4 = new JLabel("Destination ");
		label_4.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		label_4.setVisible(false);
		label_4.setBounds(227, 90, 96, 16);
		contentPane.add(label_4);
		
		textArea_5 = new JTextArea();
		textArea_5.setEditable(false);
		textArea_5.setVisible(false);
		textArea_5.setBounds(333, 194, 101, 15);
		contentPane.add(textArea_5);
		
		 textArea_6 = new JTextArea();
		textArea_6.setEditable(false);
		textArea_6.setVisible(false);
		textArea_6.setBounds(333, 168, 101, 15);
		contentPane.add(textArea_6);
		
	   textArea_7 = new JTextArea();
		textArea_7.setEditable(false);
		textArea_7.setBounds(333, 140, 101, 15);
		textArea_7.setVisible(false);
		contentPane.add(textArea_7);
		
		 textArea_8 = new JTextArea();
		textArea_8.setEditable(false);
		textArea_8.setBounds(333, 115, 101, 15);
		textArea_8.setVisible(false);
		contentPane.add(textArea_8);
		
		 textArea_9 = new JTextArea();
		textArea_9.setEditable(false);
		textArea_9.setBounds(333, 90, 101, 15);
		textArea_9.setVisible(false);
		contentPane.add(textArea_9);
		
	     comboBox_1 = new JComboBox();
		comboBox_1.setBounds(270, 25, 149, 20);
		if(flist2!=null)
		{
		flist2.forEach(Trip ->        // populate produce combo box with one to length of produce names array
        {
		 comboBox_1.addItem(Trip.getDate());
        });
		}
		comboBox_1.setVisible(false);
		contentPane.add(comboBox_1);
		
		JLabel lblGoing = new JLabel("Going");
		lblGoing.setFont(new Font("Tillana ExtraBold", Font.PLAIN, 11));
		lblGoing.setBounds(155, 11, 46, 14);
		contentPane.add(lblGoing);
		
		lblBack = new JLabel("Back");
		lblBack.setFont(new Font("Tillana ExtraBold", Font.PLAIN, 11));
		lblBack.setVisible(false);
		lblBack.setBounds(325, 11, 46, 14);
		contentPane.add(lblBack);
		
		 button = new JButton("View");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flagvIEW=true;
				flist2.forEach(Trip ->        // populate produce combo box with one to length of produce names array
		        {
		        	if (Trip.getDate().equalsIgnoreCase((String)comboBox.getSelectedItem()))
		        	{

    textArea_9.setText(Trip.getDestination());
    textArea_8.setText(Trip.getSource());
    textArea_7.setText(Trip.getDate());
    textArea_6.setText(Trip.getTime());
    textArea_5.setText(Trip.getVehicleType().getVehicleType());
    idOfTrip2=Integer.parseInt(Trip.getId());	       
    }	
		         });
				
			}
		});
		button.setFont(new Font("Corbel", Font.PLAIN, 13));
		button.setBackground(SystemColor.inactiveCaptionBorder);
		button.setVisible(false);
		button.setBounds(296, 56, 89, 24);
		contentPane.add(button);
		

		if(flagRound==true)
		{
			button.setVisible(true);
			comboBox_1.setVisible(true);
			label_1.setVisible(true);
			label_2.setVisible(true);
			label_3.setVisible(true);
			label_4.setVisible(true);
			textArea_9.setVisible(true);
			textArea_8.setVisible(true);
			textArea_7.setVisible(true);
			textArea_6.setVisible(true);
			textArea_5.setVisible(true);
			textArea_4.setVisible(true);


			
		}
	}
}
