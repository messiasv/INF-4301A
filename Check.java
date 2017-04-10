import ast.*;


public class Check {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";

	public static void main(String[] args) throws AssertionError {
			Exp foo = new Eq(new Add(new Num(1), new Num(4)), new Num(5)); // 1 + 4 = 5
			System.out.println(PrettyPrinter.visit(foo) + " ?");
			assert Evaluateur.visit(foo) == 1.0;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);


			foo = new Eq(new Sub(new Num(1), new Num(4)), new Num(-3)); // 1 - 4 = -3
			System.out.println(PrettyPrinter.visit(foo) + " ?");
			assert Evaluateur.visit(foo) == 1.0;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);


			foo = new Eq(new Mul(new Num(1), new Num(4)), new Num(4)); // 1 * 4 = 4
			System.out.println(PrettyPrinter.visit(foo) + " ?");
			assert Evaluateur.visit(foo) == 1.0;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);

			foo = new Eq(new Div(new Num(1), new Num(4)), new Num(0.25)); // 1 / 4 = 0.25
			System.out.println(PrettyPrinter.visit(foo) + " ?");
			assert Evaluateur.visit(foo) == 1.0;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);


			foo = new Eq(new Add(new Num(1),new Mul( new Num(4), new Num(2))), new Num(9)); // 1 + 4 * 2 = 9
			System.out.println(PrettyPrinter.visit(foo) + " ?");
			assert Evaluateur.visit(foo) == 1.0;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);


			foo = new Eq(new Mul(new Add(new Num(1), new Num(4)), new Num(2)), new Num(10)); // (1 + 4) * 2 = 10
			System.out.println(PrettyPrinter.visit(foo) + " ?");
			assert Evaluateur.visit(foo) == 1.0;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);


			foo = new Eq(new Add(new Add(new Num(1), new Num(2)), new Num(3)), new Num(6)); // 1 + 2 + 3 = 6
			System.out.println(PrettyPrinter.visit(foo) + " ?");
			assert Evaluateur.visit(foo) == 1.0;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);


			foo = new Eq(new Add(new Minus(new Num(8)), new Minus(new Num(7))), new Num(-15)); // -8 + -7 = -15
			System.out.println(PrettyPrinter.visit(foo) + " ?");
			assert Evaluateur.visit(foo) == 1.0;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);


			foo = new Eq(new Minus(new Add(new Num(42), new Num(51))), new Num(-93)); // -(42 + 51) = -93
			System.out.println(PrettyPrinter.visit(foo) + " ?");
			assert Evaluateur.visit(foo) == 1.0;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);


			foo = new Lt(new Add(new Minus(new Mul(new Num(3), new Num(7))), new Num(28)), new Num(14)); // -(3 * 7) + 28 < 14
			System.out.println(PrettyPrinter.visit(foo) + " ?");
			assert Evaluateur.visit(foo) == 1.0;
			System.out.println(ANSI_GREEN + "\t\t\t\t\t\t\t\tOk" + ANSI_RESET);
	}
}
