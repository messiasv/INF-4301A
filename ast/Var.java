package ast;

public class Var extends Exp {
	private String lhs;
	private Exp rhs;

	public Var (String l, Exp r){
		this.lhs = l;
		this.rhs = r;
	}

	public String getName() {
		return lhs;
	}

	public Exp getValue() {
		return rhs;
	}
}
