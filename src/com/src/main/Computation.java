package com.src.main;

public class Computation {
	
	/* code for computation
	   + = 1;
	   - = 2;
	   * = 3;
	   / = 4;
	   x^2 = 5 ;
	   sqrt x = 6;
	 
	 
	 */ 
	private int tempAnswer; 
	private int computationCode = 0;
	private String dataString;
	private String outputString;
	private String arg1;
	private String arg2;
	public int argset = 0;   //0 means arg1 is unset
							//1 means arg1 is already set
	
	public void setData(String s){
		//System.out.println("Data input for computation");
		this.dataString = s;
		
		// send the dataString for computation
	}
	
	/*to check input string*/
	public void displayDataString(){
		System.out.println(this.dataString);
	}
	
	public void computation(){			
		//System.out.println("computation");
		String data = this.dataString;
		int computationCode = this.computationCode;
		double d;		// for sqrt
		
		int a1,a2;
		int res;
	
		//computation part
			switch(computationCode){
				case 1:	a1 = Integer.parseInt(arg1);		
						a2 = Integer.parseInt(arg2);
						res = a1 + a2;
						this.outputString = Integer.toString(res);	
						break;
					
				
				case 2:	a1 = Integer.parseInt(arg1);
						a2 = Integer.parseInt(arg2);
						res = a1 - a2;
						this.outputString = Integer.toString(res);
						break;
						
				case 3: a1 = Integer.parseInt(arg1);
						a2 = Integer.parseInt(arg2);
						res = a1 * a2;
						this.outputString = Integer.toString(res);
						break;
						
				case 4: a1 = Integer.parseInt(arg1);
						a2 = Integer.parseInt(arg2);
						res = a1 / a2;
						this.outputString = Integer.toString(res);
						break;
						
				case 5: a1 = Integer.parseInt(arg1);
						res = a1 * a1;
						this.outputString = Integer.toString(res);
						this.computationCode = 0; //reset
						break;
						
				case 6: a1 = Integer.parseInt(arg1);
						d = Math.sqrt(a1);		//make it square root function
						this.outputString = Double.toString(d);
						this.computationCode = 0; //reset
						break;
					
				default:System.out.println("INVALID CODE");
			}
		
		//set output
		//this.outputString = data; //data is output;
		System.out.println(this.outputString);
	}
	
	public void swapArgAnswer(){
		this.arg1 = this.outputString;
		this.outputString = null;
		this.setArgset();
	}
	public void setArg(String s){
			if(argset == 0){
				System.out.println("ARG1 set");
							if( this.arg1 == "-"){		//check if "-" is entered;
								this.arg1.concat(s);
							}else{			//normal enter of arg1
								this.arg1 = s;
								this.argset = 1 ;
							}
			}else{
				if(s!=""){
					System.out.println("ARG2 set");
					this.arg2 = s;
					this.argset = 2;
					this.computation();
				}else{		//s==""
					System.out.println("error in argument");
					this.arg1 = null;
					this.argset = 0;
				}
			}
	}
	public void setArgset(){		//means is answer is set to args and a compuationcode is set for next operation
		this.argset = 1;
	}
	
	public void setArgset(int i){
		this.argset = i;
	}
	public int getArgSet(){
		return this.argset;
	}
	
	public void setComputationCode(int i){
		this.computationCode = i;
	}
	
	public int getComputationCode(){
		return this.computationCode;
	}
	
	public void setOutputString(){
		this.outputString = null;
	}
	
	public void clearParameters(){
		this.outputString = null;
		this.argset = 0;
		this.computationCode = 0;
	}
	
	public void setArg1Negative(){
		String temp= "";
		temp.concat("-");
		this.arg1.concat(temp);	
	}
	

	public String getAnswer(){ 
		//this.outputString = "answer"; // delete this line
		return this.outputString;
	}
}
