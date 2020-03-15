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
import algoritm.Manager;
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
 
public class ReviewTrip extends JFrame {

	private JPanel contentPane;
	
     Trip currenTrip ;
	Customer customer ;
	boolean falgView ;
	Manager manager ;
	private JButton btnBook;
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
	private JButton btnRemove;
	private JLabel lblVehicleType;
    private JComboBox comboBox ;
	Singletone all;

	/**
	 * Launch the application.
	

	/**
	 * Create the frame.
	 */
	public ReviewTrip( ) {
		
	    this.manager=Manager.getInstance();
		this.all =Singletone.getInstance();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		
		all.getTripList().forEach(Trip ->        // populate produce combo box with one to length of produce names array
	        {
			 comboBox.addItem(Trip.getDate());
	        });
		comboBox.setBounds(55, 36, 321, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Destination ");
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblNewLabel.setBounds(59, 101, 96, 16);
		contentPane.add(lblNewLabel);
		
		btnBook = new JButton("Add A Trip");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTrip addTrip = new AddTrip();
				setVisible(false);
				addTrip.setVisible(true);
			}
		});
		btnBook.setBounds(313, 227, 96, 23);
		contentPane.add(btnBook);
		
		lblSource = new JLabel("Source");
		lblSource.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblSource.setBounds(79, 126, 48, 16);
		contentPane.add(lblSource);
		
		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblDate.setBounds(85, 151, 32, 16);
		contentPane.add(lblDate);
		
		lblTime = new JLabel("Time");
		lblTime.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblTime.setBounds(85, 178, 32, 16);
		contentPane.add(lblTime);
		
		lblAvailableTrips = new JLabel("All Trips");
		lblAvailableTrips.setFont(new Font("Tillana ExtraBold", Font.PLAIN, 18));
		lblAvailableTrips.setBackground(new Color(240, 240, 240));
		lblAvailableTrips.setBounds(156, 1, 90, 30);
		contentPane.add(lblAvailableTrips);
		
		
		btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				falgView=true;
				all.getTripList().forEach(Trip ->        // populate produce combo box with one to length of produce names array
		        {
		        	if (Trip.getDate().equalsIgnoreCase((String)comboBox.getSelectedItem()))
		        	{

    textArea.setText(Trip.getDestination());
    textArea_1.setText(Trip.getSource());
    textArea_2.setText(Trip.getDate());
    textArea_3.setText(Trip.getTime());
    textArea_4.setText(Trip.getVehicleType().getVehicleType());
    currenTrip=Trip;
    //idOfTrip=Integer.parseInt(Trip.getId());	 
    }	
		         });
				
			}
		});
		btnView.setBounds(156, 67, 82, 23);
		contentPane.add(btnView);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagerView managerView =new ManagerView();
				setVisible(false);
				managerView.setVisible(true);
			}
		});
		btnPrevious.setBounds(26, 227, 89, 23);
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
		textArea_3.setBounds(193, 179, 124, 15);
		contentPane.add(textArea_3);
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(falgView==true)
				{
					Ticket ticket=new Ticket();
				ticket.removeTicketByTripId(currenTrip.getId());
				all.getTripList().remove(currenTrip);
				JOptionPane.showMessageDialog(contentPane,"Done Removing !! ");			
          ReviewTrip reviewTrip =new ReviewTrip();
          setVisible(false);
          reviewTrip.setVisible(true);
			   }
				else  JOptionPane.showMessageDialog(contentPane,"Please ,Press View Button First To Remove This Trip  !! ");			

			}
		});
		btnRemove.setBounds(168, 227, 89, 23);
		contentPane.add(btnRemove);
		
		lblVehicleType = new JLabel("vehicle Type");
		lblVehicleType.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblVehicleType.setBounds(59, 200, 96, 16);
		contentPane.add(lblVehicleType);
		
	    textArea_4 = new JTextArea();
	    textArea_4.setEditable(false);
		textArea_4.setBounds(193, 205, 124, 15);
		contentPane.add(textArea_4);
		
	    
	}
}
