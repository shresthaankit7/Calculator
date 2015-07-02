package com.src.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;


public class Data implements ActionListener {

	public String answerString;
	public String inputString;
	private Computation compute;
	public int negSetFlag = 0;		//0 is not negative, 1 means a number is set -ve
	private MainWindow mw;
	public int flag;
	
	public Data(MainWindow mw){
		this.mw = mw;
		this.inputString = "";  //null string;
		//System.out.println("INVOKED");
		this.compute = new Computation();
	}
	
	public void actionPerformed(ActionEvent e) {
		int a=-1;		//initialize switch non other than 0 to 9;
		
		String st = e.getActionCommand();
		if( st.length()>1){		//add, sub or other;
			//System.out.println(st);
			
			if(st == "add"){			//for "+" addition
				if( this.inputString == ""){		// if the input string is nothing
					this.answerString = this.compute.getAnswer();
					this.returnAnswer();
				}else if( this.compute.getArgSet() == 0 ){		//for the purpose of setting first argument
					this.compute.setArg(this.inputString);
					this.compute.setComputationCode(1);
					this.inputString = "";
					this.displayDigit(this.inputString );  // to display blank ;
					
				}else{							// compute multiple times 
					this.compute.setArg(this.inputString);
					this.answerString = this.compute.getAnswer();
					this.inputString = "";
					this.returnAnswer();
					this.compute.setComputationCode(1);
					this.compute.swapArgAnswer();
				}
				
			}else if( st == "sub"){				// for "-" subtraction
							
						if( (this.inputString == "") && (this.compute.getArgSet() == 0 )){	//ie first "-" is entered
							this.negSetFlag = 1;
							this.displayDigit("-");
						}else if( (this.inputString =="")&&(this.compute.getArgSet() == 1)){	//2nd arg -ve
							this.negSetFlag = 1;
							this.displayDigit("-");
						}
				
				if( (this.inputString!="")&&(this.compute.getArgSet() == 0) ){
					this.compute.setArg(this.inputString);
					this.compute.setComputationCode(2);
					this.inputString = "";
					this.displayDigit(this.inputString);
				}else if( (this.inputString!="")&&(this.compute.getArgSet()==1) ){
					this.compute.setArg(this.inputString);
					this.answerString = this.compute.getAnswer();
					this.inputString = "";
					this.returnAnswer();
					this.compute.setComputationCode(2);
					this.compute.swapArgAnswer();
				}
				
				
				
			}else if( st== "mul"){		//for "*" multiplication	
					if( this.compute.getArgSet() == 0 ){		// first input
						this.compute.setArg(this.inputString);
						this.compute.setComputationCode(3);
						this.inputString = "";
						this.displayDigit(this.inputString);
					}else{										//if args1 is already set
						this.compute.setArg(this.inputString);
						this.answerString = this.compute.getAnswer();
						this.inputString = "";
						this.returnAnswer();
						this.compute.setComputationCode(3);
						this.compute.swapArgAnswer();
					}
					
					
			}else if( st == "div"){			// for "/" division
				if( this.compute.getArgSet() == 0 ){		// first input
					this.compute.setArg(this.inputString);
					this.compute.setComputationCode(4);
					this.inputString = "";
					this.displayDigit(this.inputString);
				}else{										//if args1 is already set
					this.compute.setArg(this.inputString);
					this.answerString = this.compute.getAnswer();
					this.inputString = "";
					this.returnAnswer();
					this.compute.setComputationCode(4);
					this.compute.swapArgAnswer();
				}
				
			}else if( st == "square"){			// for square ie . x*x
					if( this.compute.getArgSet() == 0 ){			//	 for the first argument
						this.compute.setArg(this.inputString);
						this.compute.setComputationCode(5);
						this.compute.computation();
						
						this.answerString = this.compute.getAnswer();		//for output
						this.returnAnswer();
						
						this.inputString = this.answerString;		//to make set as nothin has been done previosly
						this.compute.clearParameters();				//to make set as nothin has been done previosly
						
					}else if( this.compute.getArgSet() != 0 ){		// ie one value and compuatation code set
						this.compute.setArg(this.inputString);	//calculation performed and value is in outputstring
				
						this.inputString = this.compute.getAnswer(); 	// input string has output
						this.compute.clearParameters();		//every thing in the compute class cleared
						
			
						this.compute.setArg(this.inputString);
						this.compute.setComputationCode(5);
						this.compute.computation();
						this.answerString = this.compute.getAnswer();
						this.returnAnswer();
						
						this.inputString = this.answerString;			//to make set as nothin has been done previosly
						this.compute.clearParameters();				//to make set as nothin has been done previosly		
					}
				
				
			}else if( st == "sqrt"){		//for sqrt ie  sqrt(x)
					if( this.compute.getArgSet() == 0){				//when nothing has been done previosly
						this.compute.setArg(this.inputString);
						this.compute.setComputationCode(6);
						this.compute.computation();
						
						this.answerString = this.compute.getAnswer();	//for output
						this.returnAnswer();							
						
						this.inputString = this.answerString;		//to make set as nothin has been done previosly
						this.compute.clearParameters();
					}else if( this.compute.getArgSet() != 0 ){		// ie one value and compuatation code set
						this.compute.setArg(this.inputString);	//calculation performed and value is in outputstring
					
						this.inputString = this.compute.getAnswer(); 	// input string has output
						this.compute.clearParameters();		//every thing in the compute class cleared
					
		
						this.compute.setArg(this.inputString);
						this.compute.setComputationCode(6);
						this.compute.computation();
						this.answerString = this.compute.getAnswer();
						this.returnAnswer();
					
						this.inputString = this.answerString;			//to make set as nothin has been done previosly
						this.compute.clearParameters();				//to make set as nothin has been done previosly		
				}
				
			}else if( st == "equals"){		//for "=" sign
				//System.out.println(st);
				//this.compute.setData(this.inputString);
				try{
					if( this.inputString != "" && this.compute.argset == 0){	//whatever entered is printed
																				//at first
						this.answerString = this.inputString;
						this.returnAnswer();
						
					}else if( (this.inputString =="")&&(this.compute.argset == 1)){			// _ argument =        
																					//must work with x^2 and sqrt();
						//check for x^2 and sqrt() by checking computation code, if not them it is error;
		if((this.inputString == "")&&(this.compute.getComputationCode()!=5||this.compute.getComputationCode()!=6)){
							this.answerString = "ERROR";
							this.returnAnswer();
							}
							
					}else{				//if any computationcode is set   ie give final answer
						this.compute.setArg(this.inputString);
						//this.compute.computation();
						this.inputString = "";	//to make empty again after equals is pressed;
						this.answerString = this.compute.getAnswer();
						this.compute.setOutputString(); //make output string null;
						this.returnAnswer();
					}
					
				}catch(Exception equalError){
					System.out.println("error");
				}
				
			//for clear
			}else if( st == "clear" ){
				System.out.println("clear");
				this.compute.clearParameters();
				this.inputString = "";
				this.answerString = this.inputString;
				this.returnAnswer();
				
			// for delete a character
			}else if( st == "delete"){
				if(this.inputString ==""){		//do nothing
					;
				}else{
					String temp = "";
					int i = this.inputString.length();
					i -= 1;
					temp = this.inputString.substring(0, i);
					this.inputString = temp;
					this.returnAnswer(this.inputString);
				}
			}
			
		}else{						// to input the digits 
			a = Integer.parseInt(st);		
				
				if(this.negSetFlag == 1){		//set no -ve,ie first no is -ve
					this.inputString = "-";
					this.negSetFlag = 0;
				}else if( (this.inputString == "-")&&(this.compute.getArgSet() == 1)){
					this.inputString = "-";
				}
				
				
			switch(a){
				case 0: //System.out.println("0");
					this.inputString = inputString.concat("0");
					//	this.compute.setData(this.inputString);
					this.displayDigit(this.inputString);
					break;
				case 1: //System.out.println("8");
						this.inputString = inputString.concat("1");
						//	this.compute.setData(this.inputString);
						this.displayDigit(this.inputString);
						break;
				case 2: //System.out.println("8");
					this.inputString = inputString.concat("2");
					//	this.compute.setData(this.inputString);
					this.displayDigit(this.inputString);
					break;
				case 3: //System.out.println("8");
						this.inputString = inputString.concat("3");
						//	this.compute.setData(this.inputString);
						this.displayDigit(this.inputString);
						break;
				case 4: //System.out.println("8");
						this.inputString = inputString.concat("4");
						//	this.compute.setData(this.inputString);
						this.displayDigit(this.inputString);
						break;
				case 5: //System.out.println("8");
						this.inputString = inputString.concat("5");
						//	this.compute.setData(this.inputString);
						this.displayDigit(this.inputString);
						break;
				case 6: //System.out.println("8");
						this.inputString = inputString.concat("6");
						//	this.compute.setData(this.inputString);
						this.displayDigit(this.inputString);
						break;
				case 7: //System.out.println("7");
						this.inputString = inputString.concat("7");
					//	this.compute.setData(this.inputString);
						this.displayDigit(this.inputString);
						break;
				case 8: //System.out.println("8");
						this.inputString = inputString.concat("8");
					//	this.compute.setData(this.inputString);
						this.displayDigit(this.inputString);
						break;
				case 9: //System.out.println("8");
						this.inputString = inputString.concat("9");
				//	this.compute.setData(this.inputString);
						this.displayDigit(this.inputString);
						break;
					
		
				
				default: System.out.println("invalid input");
			}
		}
	}
	
	public void displayDigit(String s){
		this.mw.displayAnswer(s);
	}
	
	public void returnAnswer(){
		//System.out.println("Answer");
		if(this.answerString.length() > 8 )	//delete this	
			this.mw.displayAnswer("Overflow");	//delete this
		else
			this.mw.displayAnswer(this.answerString);
	}
	
	public void returnAnswer(String s){	//overloaded version of the returnAnswer();
		if(s.length()>8) // if greater than 8 digit	//delete this
			this.mw.displayAnswer("Overflow");	//delete this
		else
			this.mw.displayAnswer(s);
	}
	
	public void setflag(){
		//System.out.println("Flag Setted, Answer ready");
		this.mw.flag = 1;
		this.returnAnswer();
	}
}
