import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import algoritm.Driver;
import algoritm.Manager;
import algoritm.Singletone;
import algoritm.Trip;
import algoritm.managerActions;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class AddTrip extends JFrame {

	private JPanel contentPane;
	private JTextField sourceField;
	private JTextField destField;
	private JTextField dateField;
	private JTextField timeField;
	private JTextField distencField;
	
     String veString ;
     int id ;
    Manager manager;
	Singletone all ;


     
     
     
     
	public AddTrip() {
		setTitle("Add Trip");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    this.manager=Manager.getInstance();
		this.all =Singletone.getInstance();

		JLabel lblAddTrip = new JLabel("Add Trip ");
		lblAddTrip.setForeground(Color.WHITE);
		lblAddTrip.setFont(new Font("Tillana ExtraBold", Font.PLAIN, 27));
		lblAddTrip.setBounds(141, 11, 153, 46);
		contentPane.add(lblAddTrip);
		this.id=all.getTripList().size();
		JLabel lblSource = new JLabel("Source");
		lblSource.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblSource.setBounds(55, 71, 48, 16);
		contentPane.add(lblSource);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblDestination.setBounds(39, 103, 88, 16);
		contentPane.add(lblDestination);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblDate.setBounds(55, 130, 48, 16);
		contentPane.add(lblDate);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblTime.setBounds(55, 158, 48, 16);
		contentPane.add(lblTime);
		
		JLabel lblVechil = new JLabel("Vehicle Type");
		lblVechil.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblVechil.setBounds(39, 185, 96, 16);
		contentPane.add(lblVechil);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id++;
Trip trip =new Trip(String.valueOf(id), sourceField.getText(), destField.getText(),dateField.getText(), timeField.getText(), veString,distencField.getText());
			all.getTripList().add(trip);
			JOptionPane.showMessageDialog(contentPane,"Done Adding !! ");			
			ManagerView ManagerView = new ManagerView();	
			setVisible(false);
			ManagerView.setVisible(true);
			}
		});
		btnAdd.setBounds(301, 227, 89, 23);
		contentPane.add(btnAdd);
		
		sourceField = new JTextField();
		sourceField.setBounds(141, 70, 116, 20);
		contentPane.add(sourceField);
		sourceField.setColumns(10);
		
		destField = new JTextField();
		destField.setBounds(141, 99, 116, 20);
		contentPane.add(destField);
		destField.setColumns(10);
		
		JRadioButton rdbtnBus = new JRadioButton("Bus");
		rdbtnBus.setBackground(SystemColor.activeCaption);
		rdbtnBus.setBounds(156, 183, 59, 23);
		contentPane.add(rdbtnBus);
		
		JRadioButton rdbtnMinibus = new JRadioButton("Mini-Bus");
		rdbtnMinibus.setBackground(SystemColor.activeCaption);
		rdbtnMinibus.setBounds(217, 183, 85, 23);
		contentPane.add(rdbtnMinibus);
		
		JRadioButton rdbtnL = new JRadioButton("Limousine");
		rdbtnL.setBackground(SystemColor.activeCaption);
		rdbtnL.setBounds(304, 183, 124, 23);
		contentPane.add(rdbtnL);
		
		dateField = new JTextField();
		dateField.setColumns(10);
		dateField.setBounds(141, 130, 116, 20);
		contentPane.add(dateField);
		
		timeField = new JTextField();
		timeField.setColumns(10);
		timeField.setBounds(141, 157, 116, 20);
		contentPane.add(timeField);
		
		JLabel lblDistence = new JLabel("Distence");
		lblDistence.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		lblDistence.setBounds(301, 130, 64, 16);
		contentPane.add(lblDistence);
		
		distencField = new JTextField();
		distencField.setColumns(10);
		distencField.setBounds(304, 157, 53, 20);
		contentPane.add(distencField);
		
		JButton btnPrevious = new JButton("Previous ");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReviewTrip reviewTrip = new ReviewTrip();
				setVisible(false);
				reviewTrip.setVisible(true);
			}
		});
		btnPrevious.setBackground(UIManager.getColor("inactiveCaptionBorder"));
		btnPrevious.setBounds(55, 227, 89, 23);
		contentPane.add(btnPrevious);
		
		rdbtnMinibus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMinibus.isSelected())
					{veString="mini-bus";
					rdbtnL.setSelected(false);
				    rdbtnBus.setSelected(false);
					}
			}
		});
		rdbtnBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnBus.isSelected())
					{veString="bus";
					rdbtnL.setSelected(false);
				rdbtnMinibus.setSelected(false);
					}
			}
		});
		rdbtnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnL.isSelected())
					{veString="Limousine";
					rdbtnBus.setSelected(false);
				rdbtnMinibus.setSelected(false);
					}
			}
		});
	}
}
