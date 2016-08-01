package pshroom;

public class Equation {

	private int number;
	public Equation(int number){
		setNumber(number);
	}
	public String getEquation(){
		
			return "__ x 10 = " + getNumber() + "0";
	
	}
	public String getAnswer(){
		return getNumber()+" x 10 = " +getNumber() + "0";
				
	}

	public void setNumber(int number){
		this.number= number;
	}
	public int getNumber(){
		return number;
	}
	
}
