package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class TicTacToe implements ActionListener{
	
	Random random;
	JFrame frame;
	JPanel title_panel,button_panel;
	JButton[] button;
	JLabel textf;
	boolean X_turn;
	
	TicTacToe(){
		frame = new JFrame();
		title_panel = new JPanel();
		button_panel = new JPanel();
		textf = new JLabel();
		button = new JButton[9];
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(600,600);
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		textf.setBackground(Color.black);
		textf.setForeground(Color.green);
		textf.setFont(new Font("Ink Free",Font.ITALIC,40));
		textf.setText("TIC TAC TOE");
		textf.setHorizontalAlignment(JLabel.CENTER);
		textf.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 600, 80);
		title_panel.add(textf);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(Color.DARK_GRAY);
		
		for(int i=0;i<9;i++) {
			button[i]=new JButton();
			button_panel.add(button[i]);
			button[i].setBackground(Color.LIGHT_GRAY);
			button[i].setFocusable(false);
			button[i].setFont(new Font("MV Boli",Font.ITALIC,75));
			button[i].addActionListener(this);
		}
		
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		firstturn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource()==button[i]) {
					if(X_turn==true) {
						if(button[i].getText()=="") {
							button[i].setForeground(Color.red);
							button[i].setText("X");
							X_turn=false;
							textf.setText("O turn");
							check();
						}
					}
					else {
						if(button[i].getText()=="") {
							button[i].setForeground(Color.blue);
							button[i].setText("O");
							X_turn=true;
							textf.setText("X turn");
							check();
						}
				}
			}
		}
		
	}
	public void firstturn() {
		if(random.nextInt(2)==0) {
			X_turn=true;
			textf.setText("X turn");
		}
		else {
			X_turn=false;
			textf.setText("O turn");
		}
	}
	public void check() {
		//check x win
		if((button[0].getText()=="X")&&(button[1].getText()=="X")&&(button[2].getText()=="X")) {
			xwin(0,1,2);
		}
		if((button[3].getText()=="X")&&(button[4].getText()=="X")&&(button[5].getText()=="X")) {
			xwin(3,4,5);
		}
		if((button[6].getText()=="X")&&(button[7].getText()=="X")&&(button[8].getText()=="X")) {
			xwin(6,7,8);
		}
		if((button[0].getText()=="X")&&(button[4].getText()=="X")&&(button[8].getText()=="X")) {
			xwin(0,4,8);
		}
		if((button[2].getText()=="X")&&(button[4].getText()=="X")&&(button[6].getText()=="X")) {
			xwin(2,4,6);
		}
		if((button[0].getText()=="X")&&(button[3].getText()=="X")&&(button[6].getText()=="X")) {
			xwin(0,3,6);
		}
		if((button[1].getText()=="X")&&(button[4].getText()=="X")&&(button[7].getText()=="X")) {
			xwin(1,4,7);
		}
		if((button[2].getText()=="X")&&(button[5].getText()=="X")&&(button[8].getText()=="X")) {
			xwin(2,5,8);
		}
		//check o win
			if((button[0].getText()=="O")&&(button[1].getText()=="O")&&(button[2].getText()=="O")) {
				owin(0,1,2);
			}
			if((button[3].getText()=="O")&&(button[4].getText()=="O")&&(button[5].getText()=="O")) {
				owin(3,4,5);
			}
			if((button[6].getText()=="O")&&(button[7].getText()=="O")&&(button[8].getText()=="O")) {
				owin(6,7,8);
			}
			if((button[0].getText()=="O")&&(button[4].getText()=="O")&&(button[8].getText()=="O")) {
				owin(0,4,8);
			}
			if((button[2].getText()=="O")&&(button[4].getText()=="O")&&(button[6].getText()=="O")) {
				owin(2,4,6);
			}
			if((button[0].getText()=="O")&&(button[3].getText()=="O")&&(button[6].getText()=="O")) {
				owin(0,3,6);
			}
			if((button[1].getText()=="O")&&(button[4].getText()=="O")&&(button[7].getText()=="O")) {
				owin(1,4,7);
			}
			if((button[2].getText()=="O")&&(button[5].getText()=="O")&&(button[8].getText()=="O")) {
				owin(2,5,8);
			}
			if((button[0].getText()!="")&&(button[1].getText()!="")&&(button[2].getText()!="")&&(button[3].getText()!="")&&(button[4].getText()!="")&&(button[5].getText()!="")&&(button[6].getText()!="")&&(button[7].getText()!="")&&(button[8].getText()!="")) {
				draw();
			}
	}
	public void draw() {
		for(int i=0;i<9;i++) {
			button[i].setEnabled(false);
		}
		textf.setText("draw");
	}
	public void xwin(int a, int b,int c) {
		button[a].setBackground(Color.green);
		button[b].setBackground(Color.green);
		button[c].setBackground(Color.green);
		for(int i=0;i<9;i++) {
			button[i].setEnabled(false);
		}
		textf.setText("X win");
	}
	public void owin(int a, int b,int c) {
		button[a].setBackground(Color.green);
		button[b].setBackground(Color.green);
		button[c].setBackground(Color.green);
		for(int i=0;i<9;i++) {
			button[i].setEnabled(false);
		}
		textf.setText("O win");
	}
}
