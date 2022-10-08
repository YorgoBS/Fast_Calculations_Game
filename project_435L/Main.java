package project_435L;

import java.util.List;

public class Main {

	public static void main(String[] args) {
	Calculator calc = new Calculator(3);
	calc.GenerateExpressionList(40);
	List<String> expressions = calc.getExpressions();
	List<Integer> results = calc.getResult();
	for(int i = 0;i<40;i++) {
		System.out.println(expressions.get(i));
		System.out.println(results.get(i));
	}

}
}
