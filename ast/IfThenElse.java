package ast;

public class IfThenElse extends Exp{

  private Exp cond;
  private Exp trueBranch;
  private Exp falseBranch;

	public IfThenElse (Exp cond, Exp trueBranch, Exp falseBranch){
    this.cond         = cond;
    this.trueBranch  = trueBranch;
    this.falseBranch = falseBranch;
	}

  public Exp getCond() {
    return this.cond;
  }

  public Exp getTrueBranch() {
    return this.trueBranch;
  }

  public Exp getFalseBranch() {
    return this.falseBranch;
  }
}
