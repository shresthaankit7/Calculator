package com.src.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JTextArea;

public class MainWindow {

	private JFrame frame;
	//public JButton button7;
	//public JButton button8;
	//public JButton buttonequals;
	public JTextArea textarea;
	public Data data;
	public int flag= 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
		*/	
			MainWindow window = new MainWindow();
			window.initialize();
			window.frame.setVisible(true);
			window.checkAnswerFlag();
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		this.data = new Data(this);
		initialize();
	}
	
	public void checkAnswerFlag(){
		//while(true){
			if(this.data.flag == 0){
				;
			}else{
				//System.out.println(this.data.returnAnswer());
			}
		//}
	}
	
	public void displayAnswer(String answer){
		//System.out.println(answer);
		this.textarea.setText(answer);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		
		frame = new JFrame();
		frame.setBounds(100, 100, 396, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textarea = new JTextArea();
		textarea.setColumns(8);
		textarea.setFont(new Font("Dialog", Font.PLAIN, 70));
		textarea.setTabSize(15);
		textarea.setLineWrap(true); //Auto down line if the line is too long
		textarea.setWrapStyleWord(true); //Auto set up the style of words
		textarea.setBounds(12, 28, 370, 85);
		frame.getContentPane().add(textarea);
		

		JButton button1 = new JButton("1");
		button1.addActionListener(this.data);
		button1.setActionCommand("1");
		button1.setBounds(12, 278, 65, 63);
		frame.getContentPane().add(button1);
		
		JButton button2 = new JButton("2");
		button2.addActionListener(this.data);
		button2.setActionCommand("2");
		button2.setBounds(89, 278, 65, 63);
		frame.getContentPane().add(button2);
		
		JButton button7 = new JButton("7");
		button7.addActionListener(this.data);
		button7.setActionCommand("7");
		button7.setBounds(12, 125, 65, 73);
		frame.getContentPane().add(button7);
		
		JButton button8 = new JButton("8");
		button8.addActionListener(this.data);
		button8.setActionCommand("8");
		button8.setBounds(89, 125, 65, 73);
		frame.getContentPane().add(button8);
		
		JButton button9 = new JButton("9");
		button9.addActionListener(this.data);
		button9.setActionCommand("9");
		button9.setBounds(166, 125, 65, 73);
		frame.getContentPane().add(button9);
			
		JButton button4 = new JButton("4");
		button4.addActionListener(this.data);
		button4.setActionCommand("4");
		button4.setBounds(12, 210, 65, 63);
		frame.getContentPane().add(button4);
		
		JButton button5 = new JButton("5");
		button5.addActionListener(this.data);
		button5.setActionCommand("5");
		button5.setBounds(89, 210, 65, 63);
		frame.getContentPane().add(button5);
		
		JButton button6 = new JButton("6");
		button6.addActionListener(this.data);
		button6.setActionCommand("6");
		button6.setBounds(166, 210, 65, 63);
		frame.getContentPane().add(button6);
		
		
		
		
		
		JButton button3 = new JButton("3");
		button3.addActionListener(this.data);
		button3.setActionCommand("3");
		button3.setBounds(166, 278, 65, 63);
		frame.getContentPane().add(button3);
		
		JButton button0 = new JButton("0");
		button0.addActionListener(this.data);
		button0.setActionCommand("0");
		button0.setBounds(12, 355, 65, 73);
		frame.getContentPane().add(button0);
		
		JButton buttonequals = new JButton("=");
		buttonequals.setActionCommand("equals");
		buttonequals.addActionListener(this.data);
		buttonequals.setBounds(89, 355, 142, 73);
		frame.getContentPane().add(buttonequals);
		
		JButton buttonclear = new JButton("C");
		buttonclear.setActionCommand("clear");
		buttonclear.addActionListener(this.data);
		buttonclear.setBounds(243, 125, 65, 73);
		frame.getContentPane().add(buttonclear);
		
		JButton buttondelete = new JButton("del");
		buttondelete.setActionCommand("delete");
		buttondelete.addActionListener(this.data);
		buttondelete.setBounds(319, 125, 65, 73);
		frame.getContentPane().add(buttondelete);
		
		JButton buttonmul = new JButton("*");
		buttonmul.setActionCommand("mul");
		buttonmul.addActionListener(this.data);
		buttonmul.setBounds(243, 210, 65, 63);
		frame.getContentPane().add(buttonmul);
		
		JButton buttondiv = new JButton("/");
		buttondiv.setActionCommand("div");
		buttondiv.addActionListener(this.data);
		buttondiv.setBounds(319, 210, 63, 63);
		frame.getContentPane().add(buttondiv);
		
		JButton buttonadd = new JButton("+");
		buttonadd.addActionListener(this.data);
		buttonadd.setActionCommand("add");
		buttonadd.setBounds(243, 278, 65, 63);
		frame.getContentPane().add(buttonadd);
		
		JButton buttonsub = new JButton("-");
		buttonsub.addActionListener(this.data);
		buttonsub.setActionCommand("sub");
		buttonsub.setBounds(319, 278, 63, 63);
		frame.getContentPane().add(buttonsub);
		
		JButton buttonsquare = new JButton("x^2");
		buttonsquare.addActionListener(this.data);
		buttonsquare.setActionCommand("square");
		buttonsquare.setBounds(243, 355, 65, 73);
		frame.getContentPane().add(buttonsquare);
		
		JButton buttonsqrt = new JButton("-/");		//square root
		buttonsqrt.addActionListener(this.data);
		buttonsqrt.setActionCommand("sqrt");
		buttonsqrt.setBounds(319, 355, 63, 73);
		frame.getContentPane().add(buttonsqrt);
	}
	/*
	public void checkTextArea(){
		System.out.println("checkTextArea");
		String s = this.data.returnAnswer();
	}
	*/
}
