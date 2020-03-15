import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import algoritm.Customer;
import algoritm.Driver;
import algoritm.Manager;
import algoritm.Singletone;
import algoritm.Ticket;
import algoritm.Trip;
import files.CreatFile;
import files.ReadFile;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Entry extends JFrame {

	private JPanel contentPane;
	private JLabel lblBusStaion;
	Singletone all ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ReadFile file =new ReadFile();
		      //Define Manager 
		Manager manager=Manager.getInstance();
		   manager.setUserName("Youssef");
		   manager.setPassword("6012");
		   //Define Lists
		   Singletone  all =Singletone.getInstance();

		 //Load Trip
		   		Scanner input = file.openFile("inputFile.txt");
		   		all.setTripList(file.readTrips(input));
		   		file.closeFile(input);
		   		
		   //**load 		Driver**/
		   		Scanner driverin = file.openFile("driverFile.txt");
		   		all.setListofDriver(file.readDriver(driverin,all.getTripList()));
		   		file.closeFile(driverin);
		   /**load ticket*/
		   Scanner ticketin = file.openFile("ticketFile.txt");
		   		all.setListofTickets(file.readTicket(ticketin,all.getTripList()));
		   		file.closeFile(ticketin);
		   /**load Customer**/
		   Scanner customerinput = file.openFile("customerFile.txt");
		   		all.setCustomerList(file.readCustomer(customerinput,all.getListofTickets()));
		   		file.closeFile(customerinput);


        
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entry frame = new Entry();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 * 
	 */
	public Entry() {
	    setTitle(" Bus Station Programme ");
	    all =Singletone.getInstance();
		System.out.println(all.getCustomerList().size());
		System.out.println(all.getListofDriver().size());
		System.out.println(all.getTripList().size());
		System.out.println(all.getListofTickets().size());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 460, 321);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBusStaion = new JLabel("Bus Station");
		lblBusStaion.setBackground(UIManager.getColor("text"));
		lblBusStaion.setForeground(SystemColor.text);
		lblBusStaion.setFont(new Font("Tillana ExtraBold", Font.BOLD | Font.ITALIC, 46));
		lblBusStaion.setBounds(54, 11, 333, 77);
		contentPane.add(lblBusStaion);
		
		JLabel lblPoweredBy = new JLabel("Powered By : Osama Sherif [6012] || Mohammed Aiman [6017] ");
		lblPoweredBy.setForeground(Color.BLACK);
		lblPoweredBy.setFont(new Font("Yu Mincho", Font.ITALIC, 12));
		lblPoweredBy.setBounds(49, 257, 389, 14);
		contentPane.add(lblPoweredBy);
		
		JRadioButton rdbtnEmpl = new JRadioButton("Manager");
		rdbtnEmpl.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		rdbtnEmpl.setBackground(SystemColor.activeCaption);
		rdbtnEmpl.setVerticalAlignment(SwingConstants.TOP);
		rdbtnEmpl.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnEmpl.setForeground(SystemColor.desktop);
		rdbtnEmpl.setBounds(159, 158, 85, 31);
		contentPane.add(rdbtnEmpl);
		
		JRadioButton rdbtnPassenger = new JRadioButton("Passenger");
		rdbtnPassenger.setForeground(SystemColor.desktop);
		rdbtnPassenger.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		rdbtnPassenger.setBackground(SystemColor.activeCaption);
		rdbtnPassenger.setBounds(162, 124, 95, 31);
		contentPane.add(rdbtnPassenger);

		JRadioButton rdbtnDriver = new JRadioButton("Driver");
		rdbtnDriver.setVerticalAlignment(SwingConstants.TOP);
		rdbtnDriver.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnDriver.setForeground(Color.BLACK);
		rdbtnDriver.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		rdbtnDriver.setBackground(SystemColor.activeCaption);
		rdbtnDriver.setBounds(288, 158, 69, 31);
		contentPane.add(rdbtnDriver);
		
		rdbtnEmpl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnEmpl.isSelected())
					rdbtnPassenger.setSelected(false);
				    rdbtnDriver.setSelected(false);

			}
		});
		rdbtnPassenger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnPassenger.isSelected())
					rdbtnEmpl.setSelected(false);
			        rdbtnDriver.setSelected(false);
			}
		});
		
		rdbtnDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnDriver.isSelected())
					rdbtnEmpl.setSelected(false);
				rdbtnPassenger.setSelected(false);
			}
		});
		
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 17));
		btnNewButton.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean flagBoolean =false ;
				  if(rdbtnPassenger.isSelected()){
					    flagBoolean=true;
				        Details Details = new Details() ;
						setVisible(false);
						Details.setVisible(true);
				    }
				    if(rdbtnEmpl.isSelected()){
					    flagBoolean=true;
				    	MangerDetails mangerDetails = new MangerDetails();
						setVisible(false);
						mangerDetails.setVisible(true);
				    }
				    if(rdbtnDriver.isSelected()){
					    flagBoolean=true;
				    	DriverDetails driverDetails = new DriverDetails();
						setVisible(false);
						driverDetails.setVisible(true);
				    }
				    else if (flagBoolean ==false){	
					JOptionPane.showMessageDialog(contentPane, " Please, Choose Your account type ! ");
					}    
				
			}
		});
		btnNewButton.setBounds(251, 209, 151, 23);
		contentPane.add(btnNewButton);
		
		
		JLabel lblEmployee = new JLabel("Employee:");
		lblEmployee.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblEmployee.setBounds(49, 165, 81, 16);
		contentPane.add(lblEmployee);
		
		JLabel lblLoginAs = new JLabel("Login As");
		lblLoginAs.setForeground(new Color(0, 0, 0));
		lblLoginAs.setFont(new Font("Calibri Light", Font.BOLD | Font.ITALIC, 27));
		lblLoginAs.setBounds(159, 83, 98, 34);
		contentPane.add(lblLoginAs);
		
		JButton btnSafeExit = new JButton("Safe Exit ");
		btnSafeExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("when Save button");
				System.out.println(all.getCustomerList().size());
				System.out.println(all.getListofDriver().size());
				System.out.println(all.getTripList().size());
				System.out.println(all.getListofTickets().size());

				/**save**/
				CreatFile savefile =new CreatFile();
				//trip
				Formatter trip=null;
				trip=savefile.openFile("tripfile.txt");
						savefile.saveTrips(all.getTripList(),trip);
						savefile.closeFile(trip);
						
				 
				//driver	
				Formatter driverOut = savefile.openFile("driverFile.txt");
				savefile.saveDrivers(all.getListofDriver(),driverOut );
						savefile.closeFile(driverOut );
                 
				//ticket
				Formatter ticketout;
				ticketout =savefile.openFile("ticketFile.txt");
						savefile.saveTickets(all.getListofTickets(), ticketout);
						savefile.closeFile(ticketout);
					

				//customer	
                   try {
				
				Formatter customerout;
				customerout =savefile.openFile("customerFile.txt");
						savefile.saveCustomer(all.getCustomerList(), customerout);
						savefile.closeFile(customerout);
						
   				} catch (Exception e) {
   					// TODO: handle exception
   				}
                   System.exit(0);
			}
		});
		btnSafeExit.setFont(new Font("Consolas", Font.PLAIN, 17));
		btnSafeExit.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnSafeExit.setBounds(49, 209, 151, 23);
		contentPane.add(btnSafeExit);
	}
}

