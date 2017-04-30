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
			case "Plus":
				return visit(((Unary)e).getFactor());
			case "Minus":
				return - visit(((Unary)e).getFactor());
			case "Eq":
				return visit(((Bin)e).getLeft()) == visit(((Bin)e).getRight()) ? 1 : 0;
			case "Ne":
				return visit(((Bin)e).getLeft()) != visit(((Bin)e).getRight()) ? 1 : 0;
			case "Le":
				return visit(((Bin)e).getLeft()) <= visit(((Bin)e).getRight()) ? 1 : 0;
			case "Lt":
				return visit(((Bin)e).getLeft()) <  visit(((Bin)e).getRight()) ? 1 : 0;
			case "Ge":
				return visit(((Bin)e).getLeft()) >= visit(((Bin)e).getRight()) ? 1 : 0;
			case "Gt":
				return visit(((Bin)e).getLeft()) >  visit(((Bin)e).getRight()) ? 1 : 0;
			case "Var":
				return visit(((Var)e).getValue());
			case "Print":
				System.out.println("Print:\n  "+visit(((Print)e).getPrint()));
				return 0;
			case "IfThenElse":
				if(visit(((IfThenElse)e).getCond()) == 1.0) {
					return visit(((IfThenElse)e).getTrueBranch());
				} else {
					return visit(((IfThenElse)e).getFalseBranch());
				}
			case "LetInEnd":
				double eval = 0;
				for(Exp inst : ((LetInEnd)e).getInstructions()) {
					eval = visit(inst);
				}
				return eval;
			default:
				throw new Error("Unknown case found!");
		}
	}
}
