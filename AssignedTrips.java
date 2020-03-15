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
 
public class AssignedTrips extends JFrame {

	private JPanel contentPane;
	
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
	private JLabel lblViehcleType;
	private JTextArea textArea_4;
	Singletone all ;
  Driver driver ;
	/**
	 * Launch the application.
	

	/**
	 * Create the frame.
	 * @param driver 
	 */
	public AssignedTrips(Driver driver ) {
		
		this.all =Singletone.getInstance();
       this.driver =driver;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		
		driver.getDriverTrips().forEach(Trip ->        // populate produce combo box with one to length of produce names array
	        {
			 comboBox.addItem(Trip.getDate());
	        });
		comboBox.setBounds(77, 36, 280, 20);
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
		lblTime.setBounds(88, 178, 32, 16);
		contentPane.add(lblTime);
		
		lblAvailableTrips = new JLabel("Assigned Trips");
		lblAvailableTrips.setFont(new Font("Tillana ExtraBold", Font.PLAIN, 14));
		lblAvailableTrips.setBackground(new Color(240, 240, 240));
		lblAvailableTrips.setBounds(134, 8, 124, 24);
		contentPane.add(lblAvailableTrips);
		
		btnView = new JButton("View");
		btnView.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnView.setFont(new Font("Consolas", Font.PLAIN, 15));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		   driver.getDriverTrips().forEach(Trip ->        // populate produce combo box with one to length of produce names array
		        {
		        	if (Trip.getDate().equalsIgnoreCase((String)comboBox.getSelectedItem()))
		        	{

textArea.setText(Trip.getDestination());
textArea_1.setText(Trip.getSource());
textArea_2.setText(Trip.getDate());
textArea_3.setText(Trip.getTime());
textArea_4.setText(Trip.getVehicleType().getVehicleType());

		        	}	
		         });
				
			}
		});
		btnView.setBounds(154, 67, 89, 23);
		contentPane.add(btnView);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnPrevious.setFont(new Font("Consolas", Font.PLAIN, 15));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DriverView driverView =new DriverView(driver);
				setVisible(false);
				driverView.setVisible(true);
			}
		});
		btnPrevious.setBounds(154, 227, 104, 27);
		contentPane.add(btnPrevious);
		
		textArea = new JTextArea();
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
		
		lblViehcleType = new JLabel("Viehcle Type");
		lblViehcleType.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblViehcleType.setBounds(60, 204, 96, 16);
		contentPane.add(lblViehcleType);
		
		textArea_4 = new JTextArea();
		textArea_4.setEditable(false);
		textArea_4.setBounds(193, 205, 124, 15);
		contentPane.add(textArea_4);
		
	    
	}
}
