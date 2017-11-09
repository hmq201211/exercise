package bean;

public class CostomizedAlgorithms {
//	private static ArrayBoundedStack<String> abs = new ArrayBoundedStack<String>();
	private static LinkedStack<String> abs = new LinkedStack<String>();
//	private static ArrayListStack<String> abs = new ArrayListStack<String>();

	public static double calculate(String s) {

		String[] s1 = s.split(" ");
		double f1;
		double f2;
		double result = 0.0;

		try {
			for (int i = 0; i < s1.length; i++) {
				if (s1[i].equals("+") || s1[i].equals("-") || s1[i].equals("*") || s1[i].equals("/")) {
					f2 = Double.parseDouble(abs.top());
					abs.pop();
					f1 = Double.parseDouble(abs.top());
					abs.pop();
					result = specify(f1, f2, s1[i]);
					abs.push(String.valueOf(result));
				} else {
					abs.push(s1[i]);
				}

			}
			result = Double.parseDouble(abs.top());
			abs.pop();
		} catch (StackUnderflowException sue) {
			throw new NotEnoughOperands("not enough operands");
		}
		if(!abs.isEmpty()) {
			throw new TooManyOperands("too many operands");
		}
		return result;
		
		
	}

	public static double specify(double d1, double d2, String s) {
		switch (s) {
		case "+":
			return d1 + d2;
		case "-":
			return d1 - d2;
		case "*":
			return d1 * d2;
		case "/":
			return d1 / d2;
		default:
			return 0.0;
		}
	}

}
