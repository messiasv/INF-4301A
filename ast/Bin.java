package ast;

public abstract class Bin extends Exp{
	protected Exp right;
	protected Exp left;

	public Bin(Exp l, Exp r){
		right=r;
		left=l;
	}

	public Exp getRight(){
		return right;
	}

	public Exp getLeft(){
		return left;
	}

	public void setRight(Exp right){
		this.right = right;
	}

	public void setLeft(Exp left){
		this.left = left;
	}
}
