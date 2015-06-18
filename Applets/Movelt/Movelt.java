package chapter6;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/**
 * BAO DOAN
 * Dec 2, 2013
 * Program: Movelt.java
 * Purpose: An Applet to direct the movement of a Graphic
 */

public class Movelt extends Applet implements ActionListener {
	private Image cup;
	private Panel keyPad;
	public int top = 15;
	public int left = 15;
	private Button keysArray[];
	
	public void init()
	{
	cup = getImage(getDocumentBase(), "chapter6/cup.gif");
	Canvas myCanvas = new Canvas();
	
	keyPad = new Panel();
	keysArray = new Button[5];
		keysArray[0]= new Button("Up");
		keysArray[1]= new Button("Left");
		keysArray[2]= new Button("Right");
		keysArray[3]= new Button("Down");
		keysArray[4]= new Button("Center");
		
	this.setBackground(Color.BLUE);
	
	this.setLayout(new BorderLayout());
	keyPad.setLayout(new BorderLayout());
	
	// Add components to appropriate areas
	keyPad.add(keysArray[0],BorderLayout.NORTH);
	keyPad.add(keysArray[1],BorderLayout.WEST);
	keyPad.add(keysArray[2],BorderLayout.EAST);
	keyPad.add(keysArray[3],BorderLayout.SOUTH);
	keyPad.add(keysArray[4],BorderLayout.CENTER);
	
	
	
	this.add(myCanvas, BorderLayout.NORTH);
	this.add(keyPad, BorderLayout.SOUTH);
	
	// Add ActionListener to Buttons
	for(int i = 0; i<keysArray.length; i++)
		keysArray[i].addActionListener(this);

	
	}
	
	public void paint(Graphics g)
	{
	g.drawImage(cup, left, top, this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		if (command.equals("Up"))
				top = top - 15;
		else if (command.equals("Down"))
				top = top + 15;
		else if (command.equals("Left"))
				left = left - 15;
		else if (command.equals("Right"))
				left = left + 15;				
		else if (command.equals("Center"))
		{		top = 60;
				left = 125;
		}
		
		repaint();
		
	}

}
