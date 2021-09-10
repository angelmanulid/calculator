package calculator_v2_03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SimpleCalc_GUI implements ActionListener{
	

	JPanel topPanel = new JPanel();
	JPanel numPanel1 = new JPanel();
	JPanel numPanel2 = new JPanel();
	JPanel func1Panel = new JPanel();
	JPanel func2Panel = new JPanel();
	JTextField field = new JTextField();
	JButton[] funcbuttons = new JButton[8];
	JButton[] numbuttons = new JButton[10];
	JButton addbutton, subbutton, mulbutton, divbutton, eqbutton, decbutton;
	JButton clrbutton, delbutton, sqrootbutton, sqrbutton;
	

	char operator;
	
	//For counting
	int numcount = 0;
	int opcount = 0;
	
	
	public SimpleCalc_GUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		
		// Create frame and layout
		JFrame frame = new JFrame("Calculator");
		frame.setSize(560,480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
	
		// Buttons
		addbutton = new JButton("+");
		subbutton = new JButton("-");
		mulbutton = new JButton("\u00D7");
		divbutton = new JButton("\u00F7");
		eqbutton = new JButton("=");
		decbutton = new JButton(".");
		clrbutton = new JButton("CLR");
		delbutton = new JButton("DEL");
		sqrootbutton = new JButton("\u221A");
		sqrbutton = new JButton("x\u00B2");
		
		
		// Add function buttons to function button array
		funcbuttons[0] = addbutton;
		funcbuttons[1] = subbutton;
		funcbuttons[2] = mulbutton;
		funcbuttons[3] = divbutton;
		funcbuttons[4] = decbutton;
		funcbuttons[5] = eqbutton;
		funcbuttons[6] = clrbutton;
		funcbuttons[7] = delbutton;
		
		//Add function buttons to function panel
		for (int i=0; i<8; i++) {
			 if(i<4) {
			 func1Panel.add(funcbuttons[i]);
			 }
			 else func2Panel.add(funcbuttons[i]);
			 funcbuttons[i].addActionListener(this);
			 funcbuttons[i].setFocusable(false);
			 funcbuttons[i].setFont(new Font("Verdana", Font.PLAIN, 28));
		}
		
		
		//Put value to number buttons and add to number panel
		for (int i=0; i<10; i++) {
			numbuttons[i] = new JButton(String.valueOf(i));
			
			if(i<9) {
				numPanel1.add(numbuttons[i]);
			} else {
				numPanel2.add(sqrbutton);
				numPanel2.add(numbuttons[i]);
				numPanel2.add(sqrootbutton);
				sqrbutton.setFont(new Font("Verdana", Font.PLAIN, 28));
				sqrootbutton.setFont(new Font("Verdana", Font.PLAIN, 20));
				sqrbutton.addActionListener(this);
				sqrootbutton.addActionListener(this);
				
			}

			numbuttons[i].addActionListener(this);
			numbuttons[i].setFocusable(false);
			numbuttons[i].setFont(new Font("Verdana", Font.PLAIN, 28));
		}
	
		// Set Layout for Number Panels
		numPanel1.setBounds(15, 100, 300, 225);
		numPanel1.setLayout(new GridLayout(3,4,5,5));
		numPanel2.setBounds(15, 328, 300, 70);
		numPanel2.setLayout(new GridLayout(1,1,5,5));
		
		// Set Layout for Function Panels
		func1Panel.setBounds(340, 100, 90, 300);
		func1Panel.setLayout(new GridLayout(4,1,10,10));
		func2Panel.setBounds(440, 100, 90, 300);
		func2Panel.setLayout(new GridLayout(4,1,10,10));
		
		// Set colors
        Color MINT = new Color(207, 255, 229);
        frame.getContentPane().setBackground(MINT);
        numPanel1.setBackground(MINT);
        numPanel2.setBackground(MINT);
        func1Panel.setBackground(MINT);
        func2Panel.setBackground(MINT);
        
        // Set font
		field.setFont(new Font("Verdana", Font.PLAIN, 28));
		field.setBounds(15, 25, 515, 60);
        
        // Add all panels to frame
		frame.add(numPanel1);
		frame.add(numPanel2);
		frame.add(func1Panel);
		frame.add(func2Panel);

		frame.add(field);
		frame.setVisible(true);


	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
		
		for(int i=0; i<10; i++) {
			if(e.getSource() == numbuttons[i]) {
				field.setText(field.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decbutton) {
			field.setText(field.getText().concat("."));
		}
		if(e.getSource() == addbutton) {
			String current = field.getText();
			field.setText("");
			if (current.charAt(current.length()-1) == '+' 
					|| current.charAt(current.length()-1) == '-' 
					|| current.charAt(current.length()-1) == '\u00D7'
					|| current.charAt(current.length()-1) == '\u00F7') {
				for (int i=0; i<current.length()-1; i++) {
					field.setText(field.getText() + current.charAt(i));
				}
				field.setText(field.getText() + "+");
			} else field.setText(current.concat("+"));
		}
		if(e.getSource() == subbutton) {
			String current = field.getText();
			field.setText("");
			if (current.charAt(current.length()-1) == '+' 
					|| current.charAt(current.length()-1) == '-' 
					|| current.charAt(current.length()-1) == '\u00D7'
					|| current.charAt(current.length()-1) == '\u00F7') {
				for (int i=0; i<current.length()-1; i++) {
					field.setText(field.getText() + current.charAt(i));
				}
				field.setText(field.getText() + "-");
			} else field.setText(current.concat("-"));
		}
		if(e.getSource() == mulbutton) {
			String current = field.getText();
			field.setText("");
			if (current.charAt(current.length()-1) == '+' 
					|| current.charAt(current.length()-1) == '-' 
					|| current.charAt(current.length()-1) == '\u00D7'
					|| current.charAt(current.length()-1) == '\u00F7') {
				for (int i=0; i<current.length()-1; i++) {
					field.setText(field.getText() + current.charAt(i));
				}
				field.setText(field.getText() + "\u00D7");
			} else field.setText(current.concat("\u00D7"));
		}
		if(e.getSource() == divbutton) {
			String current = field.getText();
			field.setText("");
			if (current.charAt(current.length()-1) == '+' 
					|| current.charAt(current.length()-1) == '-' 
					|| current.charAt(current.length()-1) == '\u00D7'
					|| current.charAt(current.length()-1) == '\u00F7') {
				for (int i=0; i<current.length()-1; i++) {
					field.setText(field.getText() + current.charAt(i));
				}
				field.setText(field.getText() + "\u00F7");
			} else field.setText(current.concat("\u00F7"));
		}
		if(e.getSource() == sqrbutton) {
			field.setText(field.getText().concat("\u00B2"));
		}
		if(e.getSource() == sqrootbutton) {
			field.setText(field.getText().concat("\u221A"));
		}
		if(e.getSource() == eqbutton) {
			SimpleCalc_Operation.compute(field);
		}
		if(e.getSource() == clrbutton) {
			field.setText("");
		}
		if(e.getSource() == delbutton) {
			String current = field.getText();
			field.setText("");
			for (int i=0; i<current.length()-1; i++) {
				field.setText(field.getText() + current.charAt(i));
			}
		}
		
		} catch (Exception ex) {
			System.err.print(ex);
		}
		
	}
}
