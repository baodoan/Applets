package chapter5;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

/**
 * BAO DOAN
 * Program: CheckBoard.java
 * Purpose: A program allows the user to enter the
start, stop, and step fields, then clicks the Go button and the results display.
 * Date: 11/18/2013
 * 
 */
public class CheckBoard extends Frame implements ActionListener{
	private int numRooms = 16;
	
	TextArea rooms[] = new TextArea [numRooms];
	Panel roomPanel = new Panel();
	
	TextField StartText = new TextField(10);
	TextField StopText = new TextField(10);
	TextField StepText = new TextField(10);
	
	int intStart, intStop, intStep;
	
	Label StartLabel = new Label("Start");
	Label StopLabel = new Label("Stop");
	Label StepLabel = new Label("Step");
	
	Button button = new Button("Go");
	Button clearButton = new Button("Clear");
	
	Panel fieldLabelPanel = new Panel();
	Panel buttonPanel = new Panel();
	
	public CheckBoard(){
		intStart = intStop= intStep = 0;
		this.setLayout(new BorderLayout());
		
		for(int i =0; i<numRooms; i++){
			rooms[i] = new TextArea(null,3,5,3);
			rooms[i].setText(i + "");
			rooms[i].setEditable(false);
			rooms[i].setBackground(Color.WHITE);
			roomPanel.add(rooms[i]);	
		}
		
		roomPanel.setLayout(new GridLayout(4,4));
		fieldLabelPanel.setLayout(new GridLayout(2,3));
		
		fieldLabelPanel.add(StartLabel);
		fieldLabelPanel.add(StopLabel);
		fieldLabelPanel.add(StepLabel);
		
		fieldLabelPanel.add(StartText);
		fieldLabelPanel.add(StopText);
		fieldLabelPanel.add(StepText);
		
		buttonPanel.add(button);
		buttonPanel.add(clearButton);
		
		// places the panels in the Frame using the appropriate border area
		add(roomPanel, BorderLayout.NORTH);
		add(fieldLabelPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		button.addActionListener(this);
		clearButton.addActionListener(this);
		//button.addActionListener(this);
		
		addWindowListener(
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						if(JOptionPane.YES_OPTION== JOptionPane.showConfirmDialog(null,"Do you really want to quit", "Confirm", JOptionPane.YES_OPTION))
							System.exit(0);
					}
				}
			);
	}// end of constructor
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckBoard frame = new CheckBoard();
		frame.setBounds(50,100,300,400);
		frame.setTitle("CheckerBoard Array");
		frame.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		// if the Go Button is pressed
		if(e.getSource() == button){
			try{
			intStart= Integer.parseInt(StartText.getText()); 
			intStop= Integer.parseInt(StopText.getText()); 
			intStep= Integer.parseInt(StepText.getText()); 
			
		if(intStart > 15 || intStop >15 || intStep >15)
			throw new NumberFormatException();
		
		else{
			// Set all rooms to BLUE and clear numbers
			for (int i =0; i<numRooms; i++)
			{	rooms[i].setText("");
				rooms[i].setBackground(Color.BLUE);
			}
			
			// Set selected rooms to YELLOW and fill in numbers
			for(int j = intStart; j<intStop; j=j+intStep){
				rooms[j].setText(j+"");
				rooms[j].setBackground(Color.YELLOW);
			}
		}
	}
			
			catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Invalid Input"); 
		 }
		}
		
		// If the Clear Button is pressed
		if (e.getSource()==clearButton){
			for(int i =0; i<numRooms; i++)
		{		rooms[i].setBackground(Color.WHITE);
				rooms[i].setText(i+"");
		}
			StartText.setText("");
			StopText.setText("");
			StepText.setText("");
			
		}
		
	}		
		
}	
	
