import ast.*;
import java.util.HashMap;

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
				return ((Var)e).getName();
			case "Print":
				return "print("+visit(((Print)e).getPrint())+")";
			case "IfThenElse":
				return "if (" + visit(((IfThenElse)e).getCond()) + ") then "
					+ visit(((IfThenElse)e).getTrueBranch())
					+ " else " + visit(((IfThenElse)e).getFalseBranch());
			case "LetInEnd":
				String LetInEndStr = "let\n";
				for(HashMap.Entry<String,Exp> var : ((LetInEnd)e).getVariables().entrySet()) {
					LetInEndStr += "  var " + var.getKey() + " := " + visit(var.getValue()) + "\n";
				}
				LetInEndStr += "in\n";
				for(Exp instr : ((LetInEnd)e).getInstructions()) {
					LetInEndStr += " " + visit(instr) + "\n";
				}
				return LetInEndStr + "end\n";
		}
		return e.getClass().getSimpleName();
	}
}
