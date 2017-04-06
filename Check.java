import ast.*;


public class Check {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";

	public static void main(String[] args) throws AssertionError {
			System.out.println("1 + 4 =? 5");
			assert Evaluateur.visit(new Add(new Num(1), new Num(4))) == 5.0;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);


			System.out.println("1 - 4 =? -3");
			assert Evaluateur.visit(new Sub(new Num(1), new Num(4))) == -3.0;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);


			System.out.println("1 * 4 =? 4");
			assert Evaluateur.visit(new Mul(new Num(1), new Num(4))) == 4.0;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);


			System.out.println("1 / 4 =? 4");
			assert Evaluateur.visit(new Div(new Num(1), new Num(4))) == 1.0/4.0;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);


			System.out.println("1 + 4 * 2 =? 9");
			assert Evaluateur.visit(new Add(new Num(1),new Mul( new Num(4), new Num(2)))) == 9.0;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);


			System.out.println("(1 + 4) * 2 =? 10");
			assert Evaluateur.visit(new Mul(new Add(new Num(1), new Num(4)), new Num(2))) == 10;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);


			System.out.println("1 + 2 + 3 =? 6");
			assert Evaluateur.visit(new Add(new Add(new Num(1), new Num(2)), new Num(3))) == 6.0;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);
	}
}
