package chapter5;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/**
 * BAO DOAN
 * Program: DavidApplet.java
 * Purpose: An Applet allows customers to reserve a camping sites on the Web.
 * Date: 11/18/2013
 * 
 */
public class DavidApplet extends Applet implements ActionListener {
	
	Panel Information = new Panel();
	Panel Button = new Panel();
	TextField FirstNameText;
	TextField LastNameText;
	TextField AddressText;
	TextField ArrDateText;
	TextField CityText;
	TextField NumNightsText;
	TextField StateText;
	TextField ZipText;
	JComboBox<String> CampVehicle; 
	JComboBox<String> Hookups;
	Button SubButton;
	Button ClearButton;
	
	public void init(){
	this.setBackground(Color.GREEN);
	this.setLayout(new BorderLayout());
	add(Information, BorderLayout.NORTH);
	add(Button, BorderLayout.SOUTH);
	
	Information.setLayout(new GridLayout(6,4,20,20));
	Button.setLayout(new FlowLayout(FlowLayout.CENTER));
	
	Information.add(new Label("First Name"));
	FirstNameText = new TextField(5);
	Information.add(FirstNameText);
	FirstNameText.requestFocus();
	
	Information.add(new Label("Select Vehicle Type"));
	String[] vehicle = {"Camping Vehicle", "tent", "pop-up", "travel trailer", "fifth-wheel","moto home" };
	CampVehicle = new JComboBox<String>(vehicle);
	CampVehicle.setSelectedIndex(0);
	Information.add(CampVehicle);
	
	Information.add(new Label("Last Name"));
	LastNameText = new TextField(5);
	Information.add(LastNameText);
	
	Information.add(new Label("Select Hookups"));
	String[] hook = {"Hookups", "water only", "water and electricity", "full hookups", "no hookups" };
	Hookups = new JComboBox<String>(hook);
	Hookups.setSelectedIndex(0);
	Information.add(Hookups);
	
	Information.add(new Label("Address"));
	AddressText = new TextField(5);
	Information.add(AddressText);
	
	Information.add(new Label("Arrival Date"));
	ArrDateText = new TextField(5);
	Information.add(ArrDateText);
	
	Information.add(new Label("City"));
	CityText = new TextField(5);
	Information.add(CityText);
	
	Information.add(new Label("Number of Nights"));
	NumNightsText = new TextField(5);
	Information.add(NumNightsText);
	
	Information.add(new Label("State"));
	StateText = new TextField(5);
	Information.add(StateText);
	
	Information.add(new Label("Zip"));
	ZipText = new TextField(5);
	Information.add(ZipText);
	
	SubButton = new Button("Submit");
	Button.add(SubButton);
	SubButton.addActionListener(this);
	
	
	ClearButton = new Button("Clear");
	Button.add(ClearButton);
	ClearButton.addActionListener(this);
	
	
	this.setSize(600, 300);
}
	
	public void actionPerformed(ActionEvent e)
	 {
	 String arg = e.getActionCommand();
	 	if (arg == "Submit")
	 {
	 	JOptionPane.showMessageDialog(null, "Your Reservation has been booked!! Thank You for Choosing Our Service");
	 	System.exit(0);
	 }
	 	if (arg == "Clear")
	 {
	 		FirstNameText.setText("");
	 		LastNameText.setText("");
	 		AddressText.setText("");
	 		ArrDateText.setText("");
	 		CityText.setText("");
	 		NumNightsText.setText("");
	 		StateText.setText("");
	 		ZipText.setText("");
	 		
	 		CampVehicle.setSelectedIndex(0);
	 		Hookups.setSelectedIndex(0);
	 		
	 		FirstNameText.requestFocus();
	 }
	}
}
