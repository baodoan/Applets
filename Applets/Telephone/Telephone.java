package chapter6;
import java.awt.*;
import java.awt.event.*;

/**
 * BAO DOAN
 * Dec 2, 2013
 * Program: KeyPad.java
 * Purpose: A telephone keypad that displays the number user want to call on the screen 
 */

public class Telephone extends Frame implements ActionListener{

	 	Panel keyPad;
		TextField TextField;
		Button[] Keys;
		Label Prompt;
		Boolean foundKey;
	
	public Telephone()  {
				
		keyPad = new Panel();
		TextField= new TextField(20);
		Keys = new Button[12];
		Prompt = new Label("Click each button above to dial your number");
		TextField.setEditable(false);
		
		
			for (int i =0; i<=9; i++)
				Keys[i] = new Button(String.valueOf(i));
				Keys[10]= new Button("*");
				Keys[11]= new Button("#");
				
		this.setBackground(Color.MAGENTA);
		this.setLayout(new BorderLayout());
		keyPad.setLayout(new GridLayout(4,3,10,10));
		
		// Adding buttons into the keypad
				for (int i = 1; i <= 3; i++)
					// 1 , 2 , 3
					keyPad.add(Keys[i]);

				for (int i = 4; i <= 6; i++)
					// 4, 5, 6
					keyPad.add(Keys[i]);

				for (int i = 7; i <= 9; i++)
					// 1, 2, 3
					keyPad.add(Keys[i]);

				keyPad.add(Keys[10]); // *
				keyPad.add(Keys[0]); // 0
				keyPad.add(Keys[11]); // #
		
		//Add ActionListener
		for (int i = 0; i < Keys.length; i++)
			Keys[i].addActionListener(this);
		
		add(TextField, BorderLayout.NORTH);
		add(keyPad, BorderLayout.CENTER);
		add(TextField, BorderLayout.NORTH);
		add(Prompt, BorderLayout.SOUTH);
		
		this.setSize(500,400);
		addWindowListener(
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(0);
						}
					}
				);
	}
	public static void main(String[] args) {
		Telephone frame = new Telephone();
		frame.setBounds(50, 130, 250, 300);
		frame.setTitle("Telephone");
		frame.setVisible(true);
	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i<this.Keys.length;i++){
			if(e.getSource() == Keys[i])
				TextField.setText(TextField.getText() + Keys[i].getLabel());
		}
		
	}

}