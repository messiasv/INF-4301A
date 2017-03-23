public class Number extends Exp{

	private double value;

	public Number(double value){
		this.value = value;
	}

	public double getValue(){
		return value;	
	}

	public void setValue(double value){
		this.value = value;
	}

void accept(Visiteur v){
		v.visit(this);
	}

}
