import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import algoritm.Customer;
import algoritm.Driver;
import algoritm.Manager;
import algoritm.Singletone;
import algoritm.Trip;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Color;

public class ManagerView extends JFrame {

	private JPanel contentPane;
    Manager manager;
	Singletone all ;

	/**
	 * Create the frame.
	 */
	public ManagerView( ) {
		setTitle("My Profile  [Manager]");
		this.all =Singletone.getInstance();
	    this.manager=Manager.getInstance();


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAssignedTrips = new JButton("Assign Driver");
		btnAssignedTrips.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnAssignedTrips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 AssigneDriver assigneDriver = new AssigneDriver();
				 setVisible(false);
				 assigneDriver.setVisible(true);
				 
			}
		});
		btnAssignedTrips.setFont(new Font("Consolas", Font.BOLD, 18));
		btnAssignedTrips.setBounds(118, 144, 177, 44);
		contentPane.add(btnAssignedTrips);
		
		JButton btnReviewAllTrips = new JButton("Review All Trips");
		btnReviewAllTrips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReviewTrip reviewTrip = new ReviewTrip();
				setVisible(false);
				reviewTrip.setVisible(true);
			}
		});
		btnReviewAllTrips.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnReviewAllTrips.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
		btnReviewAllTrips.setBounds(101, 74, 214, 44);
		contentPane.add(btnReviewAllTrips);
		
		JButton btnPrevious = new JButton("Logout");
		btnPrevious.setForeground(new Color(255, 255, 255));
		btnPrevious.setBackground(new Color(0, 0, 0));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Entry Entry =new Entry() ;
				setVisible(false);
				Entry.setVisible(true);
			}
		});
		btnPrevious.setFont(new Font("Consolas", Font.PLAIN, 17));
		btnPrevious.setBounds(158, 227, 105, 23);
		contentPane.add(btnPrevious);
		
		JLabel label = new JLabel("Username:");
		label.setFont(new Font("Courier New", Font.BOLD, 21));
		label.setBounds(62, 38, 117, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel();
		label_1.setFont(new Font("Courier New", Font.BOLD, 21));
		label_1.setBounds(227, 38, 117, 25);
		label_1.setText(manager.getUserName());
		contentPane.add(label_1);
	}
}
