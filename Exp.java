public abstract class Exp{
	void accept(Visiteur v){
		v.visit(this);
	}
}
