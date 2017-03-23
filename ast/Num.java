package ast;

public class Num extends Exp{

	private double value;

	public Num(double value){
		this.value = value;
	}

	public double getValue(){
		return value;
	}

	public void setValue(double value){
		this.value = value;
	}

}
