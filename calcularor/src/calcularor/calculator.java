package calcularor;

import java.awt.Color;
import java.lang.Math;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class calculator implements ActionListener{
	
	JFrame frame;
	JButton[] numbutton = new JButton[10];	
	JButton[] foncbutton = new JButton[11];
	JButton addbutton,subbutton,mulbutton,divbutton;
	JButton decbutton,equbutton,clear,delbutton,negative,puissance,percentage;
	Font font = new Font("BV Moli",Font.BOLD,30);
	JTextField textfield;
	
	double num1=0,num2=0,result=0;
	char opp;
	
	calculator(){
		frame = new JFrame("calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(font);
		textfield.setEditable(false);
		
		addbutton = new JButton("+");
		subbutton = new JButton("-");
		mulbutton = new JButton("*");
		divbutton = new JButton("/");
		decbutton = new JButton(".");
		equbutton = new JButton("=");
		clear = new JButton("C");
		delbutton = new JButton("supp");
		negative = new JButton("/-");
		puissance = new JButton("^");
		percentage = new JButton("%");
		
		foncbutton [0] = addbutton;
		foncbutton [1] = subbutton;
		foncbutton [2] = mulbutton;
		foncbutton [3] = divbutton;
		foncbutton [4] = decbutton;
		foncbutton [5] = equbutton;
		foncbutton [6] = clear;
		foncbutton [7] = delbutton;
		foncbutton [8] = negative;
		foncbutton [9] = puissance;
		foncbutton [10] = percentage;
		
		for(int i=0;i<11;i++) {
			foncbutton[i].setFocusable(false);
			foncbutton[i].setFont(font);
			foncbutton[i].addActionListener(this);
		}
		for(int i=0;i<10;i++) {
			numbutton[i] = new JButton(String.valueOf(i));
			numbutton[i].setFocusable(false);
			numbutton[i].addActionListener(this);
			numbutton[i].setFont(font);
		}
		
		numbutton[1].setBounds(50,100, 60, 40);
		numbutton[2].setBounds(130,100, 60, 40);
		numbutton[3].setBounds(210,100, 60, 40);
		addbutton.setBounds(290,100, 60, 40);
		numbutton[4].setBounds(50,160, 60, 40);
		numbutton[5].setBounds(130,160, 60, 40);
		numbutton[6].setBounds(210,160, 60, 40);
		subbutton.setBounds(290,160, 60, 40);
		numbutton[7].setBounds(50,220, 60, 40);
		numbutton[8].setBounds(130,220, 60, 40);
		numbutton[9].setBounds(210,220, 60, 40);
		mulbutton.setBounds(290,220, 60, 40);
		decbutton.setBounds(50,280, 60, 40);
		numbutton[0].setBounds(130,280, 60, 40);
		divbutton.setBounds(210,280, 60, 40);
		equbutton.setBounds(290,280, 60, 40);
		negative.setBounds(50,340,60,40);
		puissance.setBounds(130,340,60,40);
		percentage.setBounds(210,340,60,40);
		clear.setBounds(290,340,60,40);		
		
		frame.add(numbutton[1]);
		frame.add(numbutton[2]);
		frame.add(numbutton[3]);
		frame.add(addbutton);
		frame.add(numbutton[4]);
		frame.add(numbutton[5]);
		frame.add(numbutton[6]);
		frame.add(subbutton);
		frame.add(numbutton[7]);
		frame.add(numbutton[8]);
		frame.add(numbutton[9]);
		frame.add(mulbutton);
		frame.add(decbutton);
		frame.add(numbutton[0]);
		frame.add(equbutton);
		frame.add(divbutton);
		frame.add(negative);
		frame.add(puissance);
		frame.add(percentage);
		
		frame.add(clear);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource()==numbutton[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource()==decbutton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addbutton) {
			num1 = Double.parseDouble(textfield.getText());
			opp = '+';
			textfield.setText("");
		}
		if(e.getSource()==subbutton) {
			num1 = Double.parseDouble(textfield.getText());
			opp = '-';
			textfield.setText("");
		}
		if(e.getSource()==mulbutton) {
			num1 = Double.parseDouble(textfield.getText());
			opp = '*';
			textfield.setText("");
		}
		if(e.getSource()==divbutton) {
			num1 = Double.parseDouble(textfield.getText());
			opp = '/';
			textfield.setText("");
		}
		if(e.getSource()==puissance) {
			num1=Double.parseDouble(textfield.getText());
			opp = '^';
			textfield.setText("");
		}
		if(e.getSource()==percentage) {
			num1=Double.parseDouble(textfield.getText());
			num1=num1/100;
			textfield.setText(String.valueOf(num1));
		}
		if(e.getSource()==equbutton) {
			num2 = Double.parseDouble(textfield.getText());
			switch(opp) {
			case '^' : 
				result=Math.pow(num1, num2);
				break;
			case '+' : 
				result=num1+num2;
				break;
			case '-' :
				result=num1-num2;
				break;
			case '*' :
				result=num1*num2;
				break;
			case '/' :
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
		}
		if(e.getSource()==clear) {
			textfield.setText("");
		}
		if(e.getSource()==negative) {
			textfield.setText("-");
			for(int i=0;i<10;i++) {
				if(e.getSource()==numbutton[i]) {
					textfield.setText(textfield.getText().concat(String.valueOf(i)));
				}
			}
		}
	}

}
