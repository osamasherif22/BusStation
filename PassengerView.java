import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import algoritm.Customer;
import algoritm.Driver;
import algoritm.Singletone;
import algoritm.Trip;
import files.CreatFile;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Formatter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PassengerView extends JFrame {
	Customer customer=Customer.getInstance();

	private JPanel contentPane;
	Singletone all ;

	/**
	 * Create the frame.
	 * @param customer 
	 */
	public PassengerView(Customer customer ) {
		this.customer=customer;
		//System.out.println(customer.getCustomerTickets().get(0).getNumberOfTicket());
		setTitle("My Profile  [Passenger]");
		System.out.println("3"+customer.getUserName());
		System.out.println(customer.getPassword());
		this.all =Singletone.getInstance();
		System.out.println("3"+customer.getUserName());
		System.out.println(customer.getPassword());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSelectTrip = new JButton("Select Trip");
		btnSelectTrip.setBackground(UIManager.getColor("info"));
		btnSelectTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectTrip SelectTrip = new SelectTrip(customer);	
				setVisible(false);
				SelectTrip.setVisible(true);
			}
		});
		btnSelectTrip.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnSelectTrip.setBounds(126, 99, 169, 33);
		contentPane.add(btnSelectTrip);
		
		JButton btnReviewTrips = new JButton("Review Trips");
		btnReviewTrips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(customer.getCustomerTickets().get(0).getNumberOfTicket());

				if(customer.getCustomerTickets()==null)
		     	JOptionPane.showMessageDialog(contentPane, " There isn't Booked Ticket Yet ! ");
				else {PassengerReviewTrips passengerReviewTrips = new PassengerReviewTrips(customer);
				setVisible(false);
				passengerReviewTrips.setVisible(true);
				}
			}
		});
		btnReviewTrips.setBackground(UIManager.getColor("info"));
		btnReviewTrips.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnReviewTrips.setBounds(126, 152, 169, 33);
		contentPane.add(btnReviewTrips);
		
		JButton btnExit = new JButton("Logout");
		btnExit.setBackground(UIManager.getColor("info"));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(customer.getUserName());
				System.out.println(customer.getPassword());

				        all.getCustomerList().add(customer);
				        System.out.println(all.getCustomerList().get(all.getCustomerList().size()-1).getUserName());
				        System.out.println(all.getCustomerList().get(all.getCustomerList().size()-1).getPassword());

				Entry Entry =new Entry();
				setVisible(false);
				Entry.setVisible(true);
					
			}
		});
		btnExit.setFont(new Font("Consolas", Font.PLAIN, 17));
		btnExit.setBounds(170, 217, 89, 22);
		contentPane.add(btnExit);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Courier New", Font.BOLD, 21));
		lblUsername.setBounds(57, 44, 117, 25);
		contentPane.add(lblUsername);
		
		JLabel label = new JLabel();
		label.setFont(new Font("Tillana ExtraBold", Font.BOLD, 21));
		label.setText(customer.getUserName());
		label.setBounds(184, 37, 117, 36);
		contentPane.add(label);
	}

}




