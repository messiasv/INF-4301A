import ast.*;

public class Evaluateur{
	public static double visit(Exp e){
		switch(e.getClass().getSimpleName()) {
			case "Add":
				return visit(((Bin)e).getLeft()) + visit(((Bin)e).getRight());
			case "Sub":
				return visit(((Bin)e).getLeft()) - visit(((Bin)e).getRight());
			case "Div":
				return visit(((Bin)e).getLeft()) / visit(((Bin)e).getRight());
			case "Mul":
				return visit(((Bin)e).getLeft()) * visit(((Bin)e).getRight());
			case "Num":
				return ((Num)e).getValue();
		}
		return 34404;
	}
}