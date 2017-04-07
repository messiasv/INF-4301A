package ast;

public abstract class Unary extends Exp{
	protected Exp factor;

	public Unary(Exp factor){
		this.factor = factor;
	}

	public Exp getFactor(){
		return factor;
	}

	public void setFactor(Exp factor){
		this.factor = factor;
	}
}
