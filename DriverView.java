import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import algoritm.Customer;
import algoritm.Driver;
import algoritm.Singletone;
import algoritm.Trip;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextArea;

public class DriverView extends JFrame {

	private JPanel contentPane;
	Singletone all ;
    Customer customer ;
    Driver driver;
	/**
	 * Create the frame.
	 * @param driver 
	 */
	public DriverView(Driver driver ) {
		setTitle("My Profile  [Driver]");
		
		this.all =Singletone.getInstance();
		this.driver =driver;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAssignedTrips = new JButton("Assigned Trips");
		btnAssignedTrips.setBackground(SystemColor.info);
		btnAssignedTrips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AssignedTrips assignedTrips = new AssignedTrips(driver);
				setVisible(false);
				assignedTrips.setVisible(true);
						
			}
		});
		btnAssignedTrips.setFont(new Font("Consolas", Font.PLAIN, 19));
		btnAssignedTrips.setBounds(116, 147, 187, 44);
		contentPane.add(btnAssignedTrips);
		
		JButton btnPrevious = new JButton("Logout");
		btnPrevious.setBackground(SystemColor.info);
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				all.getListofDriver().add(driver);
				Entry Entry =new Entry() ;
				setVisible(false);
				Entry.setVisible(true);
			}
		});
		btnPrevious.setBounds(158, 227, 89, 23);
		contentPane.add(btnPrevious);
		
		JLabel label = new JLabel("Username:");
		label.setFont(new Font("Courier New", Font.BOLD, 21));
		label.setBounds(50, 89, 117, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Courier New", Font.BOLD, 21));
		label_1.setBounds(212, 89, 117, 25);
		label_1.setText(driver.getUserName());
		contentPane.add(label_1);
	}
}
