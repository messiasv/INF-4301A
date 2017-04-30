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
			case "Plus":
				return ""+visit(((Unary)e).getFactor());
			case "Minus":
				return "-" + visit(((Unary)e).getFactor());
			case "Eq":
				return visit(((Bin)e).getLeft()) +" = "+ visit(((Bin)e).getRight());
			case "Ne":
				return visit(((Bin)e).getLeft()) +" <> "+ visit(((Bin)e).getRight());
			case "Le":
				return visit(((Bin)e).getLeft()) +" <= "+ visit(((Bin)e).getRight());
			case "Lt":
				return visit(((Bin)e).getLeft()) +" < " + visit(((Bin)e).getRight());
			case "Ge":
				return visit(((Bin)e).getLeft()) +" > " + visit(((Bin)e).getRight());
			case "Gt":
				return visit(((Bin)e).getLeft()) +" > " + visit(((Bin)e).getRight());
			case "Var":
				return "var "+((Var)e).getName()+" := "+visit(((Var)e).getValue());
			case "Print":
				Exp tmp = ((Print)e).getPrint();
				if(tmp.getClass().getSimpleName().equals("Var")){
					return "print("+((Var)tmp).getName()+")";
				}else
					return "print("+visit(tmp)+")";
			case "IfThenElse":
				return "if (" + visit(((IfThenElse)e).getCond()) + ") then "
					+ visit(((IfThenElse)e).getTrueBranch())
					+ " else " + visit(((IfThenElse)e).getFalseBranch());
		}
		return e.getClass().getSimpleName();
	}
}
