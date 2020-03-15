import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.xml.transform.Source;

import javafx.scene.control.TextField;
import javafx.scene.paint.Stop;

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
import java.text.BreakIterator;
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
import algoritm.*;
import javax.swing.UIManager;
public class AssigneDriver extends JFrame {

	private JPanel contentPane;
	
	ArrayList<Trip> nonAssigneTriplist;
    int index,counter ;  
    boolean falgview;
	Customer customer ;
	Trip currentTrip ;
	Manager manager ;
	private JButton btnBook;
	private JLabel lblSource;
	private JLabel lblDate;
	private JLabel lblTime;
	private JLabel lblAvailableTrips;
	private JButton btnView;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JTextArea textArea_3;
	private JTextArea textArea_4;
	private JButton btnRemove;
	private JLabel lblVehicleType;
	private JComboBox comboBox_1;
	private JLabel lblAllDrivers;
	private JLabel lblName;
	private JTextArea textArea_6;
	Singletone all =Singletone.getInstance();

	/**
	 * Launch the application.
	

	/**
	 * Create the frame.
	 */
	public AssigneDriver( ) {
		
		this.index=-1;
		this.all =Singletone.getInstance();

		setTitle("Assign Trip To Driver");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    this.manager=Manager.getInstance();
		this.nonAssigneTriplist =manager.hasDriver(all.getTripList(), all.getListofDriver());

	    
	    /*************** First Combo Box *******************/
	    
		JComboBox comboBox = new JComboBox(); //Trips Combo Box !!
		
		nonAssigneTriplist.forEach(Trip ->        
	        {
			 comboBox.addItem(Trip.getDate());
	        });
		comboBox.setBounds(122, 21, 280, 16);
		contentPane.add(comboBox);
		

		btnView = new JButton("View Trip");
		btnView.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				falgview=true;
				nonAssigneTriplist.forEach(Trip ->      
		        {
		        	if (Trip.getDate().equalsIgnoreCase((String)comboBox.getSelectedItem()))
		        	{
    textArea.setText(Trip.getDestination());
    textArea_1.setText(Trip.getSource());
    textArea_2.setText(Trip.getDate());
    textArea_3.setText(Trip.getTime());
    textArea_4.setText( Trip.getVehicleType().getVehicleType());
    currentTrip=Trip;
		        	}	
		         });
			}
		});
		btnView.setBounds(83, 79, 96, 23);
		contentPane.add(btnView);
		
		/***************** END *****************/
		
		
	    /*************** Second Combo Box *******************/

		comboBox_1 = new JComboBox(); //Combo Box Of Drivers 
		all.getListofDriver().forEach(Driver ->       
        {
        	comboBox_1.addItem(Driver.getUserName());
        });
		comboBox_1.setBounds(122, 48, 280, 16);
		contentPane.add(comboBox_1);
		
		JButton btnViewDriver = new JButton("View Driver");
		btnViewDriver.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnViewDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				index=0;
				all.getListofDriver().forEach(Driver ->      
		        {
		        	if (Driver.getUserName().equalsIgnoreCase((String)comboBox_1.getSelectedItem()))
		        	{
		       
		      textArea_6.setText(Driver.getUserName());
                      counter=index;                 
		        	}	
	        		index++;

		         });
			}
	
		});
		btnViewDriver.setBounds(283, 79, 106, 23);
		contentPane.add(btnViewDriver);
		/***************** END *****************/
		
		JLabel lblNewLabel = new JLabel("Destination ");
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblNewLabel.setBounds(26, 113, 96, 16);
		contentPane.add(lblNewLabel);
		
		btnBook = new JButton("Assign");
		btnBook.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(falgview==true)
				{
					all.getListofDriver().forEach(Driver ->       
		        {
		        	if (Driver.getUserName().equalsIgnoreCase((String)comboBox_1.getSelectedItem()))
		        	{
		        		all.getListofDriver().set(counter, manager.assignDriverToTrip(Driver,currentTrip));
		        		nonAssigneTriplist.remove(currentTrip);
					}
		        
		        });
    			JOptionPane.showMessageDialog(contentPane," Done Assigning !! ");			
			   AssigneDriver assigneDriver=new AssigneDriver();
			   setVisible(false);
			   assigneDriver.setVisible(true);
    			
		}
				else   	JOptionPane.showMessageDialog(contentPane,"Press View Trip Button First To Treat With This Trip ! ");			

			}
		});
		btnBook.setBounds(313, 227, 99, 23);
		contentPane.add(btnBook);
		
		lblSource = new JLabel("Source");
		lblSource.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblSource.setBounds(47, 128, 48, 16);
		contentPane.add(lblSource);
		
		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblDate.setBounds(52, 149, 32, 16);
		contentPane.add(lblDate);
		
		lblTime = new JLabel("Time");
		lblTime.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblTime.setBounds(52, 176, 32, 16);
		contentPane.add(lblTime);
		
		lblAvailableTrips = new JLabel("All Trips");
		lblAvailableTrips.setFont(new Font("Tillana ExtraBold", Font.PLAIN, 14));
		lblAvailableTrips.setBackground(new Color(240, 240, 240));
		lblAvailableTrips.setBounds(26, 16, 69, 24);
		contentPane.add(lblAvailableTrips);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(132, 113, 124, 15);
		contentPane.add(textArea);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(132, 131, 124, 15);
		contentPane.add(textArea_1);
		
		textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setBounds(132, 153, 124, 15);
		contentPane.add(textArea_2);
		
		textArea_3 = new JTextArea();
		textArea_3.setEditable(false);
		textArea_3.setBounds(132, 179, 124, 15);
		contentPane.add(textArea_3);
		
		btnRemove = new JButton("Previous");
		btnRemove.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerView managerView =new ManagerView();
				setVisible(false);
				managerView.setVisible(true);
			}
		});
		btnRemove.setBounds(57, 227, 89, 23);
		contentPane.add(btnRemove);
		
		lblVehicleType = new JLabel("vehicle Type");
		lblVehicleType.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblVehicleType.setBounds(26, 203, 96, 16);
		contentPane.add(lblVehicleType);
		
	    textArea_4 = new JTextArea();
	    textArea_4.setEditable(false);
		textArea_4.setBounds(132, 201, 124, 15);
		contentPane.add(textArea_4);
		
		
		
		lblAllDrivers = new JLabel("All Drivers");
		lblAllDrivers.setFont(new Font("Tillana ExtraBold", Font.PLAIN, 14));
		lblAllDrivers.setBackground(SystemColor.menu);
		lblAllDrivers.setBounds(26, 44, 87, 24);
		contentPane.add(lblAllDrivers);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblName.setBounds(283, 128, 48, 16);
		contentPane.add(lblName);
		
		textArea_6 = new JTextArea();
		textArea_6.setEditable(false);
		textArea_6.setBounds(324, 131, 96, 15);
		contentPane.add(textArea_6);
		
	    
	}
}
