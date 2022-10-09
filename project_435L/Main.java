package project_435L;

import java.util.Map;

public class Main {

	public static void main(String[] args) {
	Calculator calc = new Calculator(3);
	calc.GenerateExpressionList(100);
		Map<String,Integer> testMap = calc.getExpMap();
		for (Map.Entry<String,Integer> entry : testMap.entrySet())  
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue()); 
    } 
}

