import ast.*;

public class PrettyPrinter{
	public static String visit(Exp e){
		switch(e.getClass().getSimpleName()) {
			case "Add":
				return "("+ visit(((Bin)e).getLeft()) +" + "+ visit(((Bin)e).getRight())+")";
			case "Sub":
				return "("+ visit(((Bin)e).getLeft()) +" - "+ visit(((Bin)e).getRight())+")";
			case "Div":
				return "("+ visit(((Bin)e).getLeft()) +" / "+ visit(((Bin)e).getRight())+")";
			case "Mul":
				return "("+ visit(((Bin)e).getLeft()) +" * "+ visit(((Bin)e).getRight())+")";
			case "Num":
				return ""+((Num)e).getValue();
		}
		return e.getClass().getSimpleName();
	}
}
