package project_435L;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**This class serves as the business logic for the calculations game.
 * 
 * @author Yorgo Bou Samra
 * @version 1.0
 * @since 09/10/2022
 */
public class Calculator {
	
	private int level;
	private int firstNumber;
	private int secondNumber;
	private int thirdNumber;
	private int op;
	private HashMap<String,Integer> expMap;
	
	/**
	 * Default Constructor
	 */
	public Calculator() {
		this.level = 1;
		this.expMap = new HashMap<String,Integer>();
	}
	/**
	 * Parameterized Constructor
	 * @param level Level number the user wants to play. Takes values 1-3 inclusive.
	 */
	public Calculator(int level) {
		this.level = level;
		this.expMap = new HashMap<String,Integer>();
}
	/**
	 * Generates the random integers that serve as the numbers in an expression. Called in the function {@link project_435L.Calculator#generateRandomExpression() generateRandomExpression}
	 * @param divisor Tells function whether or not there is an integer division in the expression. 0 means no, 1 means the first operator, 2 means the 2nd operator
	 */
	public void generateRandomNumbers(int divisor) {
		
		Random rdInt = new Random();
		if(this.level == 1) {
			this.firstNumber = rdInt.nextInt(10);
			this.secondNumber = rdInt.nextInt(10);					
		}
		else if(this.level == 2) {
			this.firstNumber = rdInt.nextInt(100);
			this.secondNumber = rdInt.nextInt(100);
		}
		else {
			
			switch(divisor) {
			case 0:
				this.firstNumber = rdInt.nextInt(100);
				this.secondNumber = rdInt.nextInt(100);			
				this.thirdNumber = rdInt.nextInt(100);
				break;
			case 1:
				
				this.firstNumber = rdInt.nextInt(100);
			    if(this.firstNumber == 0) {
			    	this.secondNumber = rdInt.nextInt(99)+1;
			    }
			    else {
					List<Integer> firstNumDivisors = getDivisors(firstNumber);

				    int divisorsRandIndex = rdInt.nextInt(firstNumDivisors.size());
				    this.secondNumber = firstNumDivisors.get(divisorsRandIndex);
			    }
				this.thirdNumber = rdInt.nextInt(100);
				
				break;
			case 2:
				this.firstNumber = rdInt.nextInt(100);
				this.secondNumber = rdInt.nextInt(100);	
			    if(this.secondNumber == 0) {
			    	this.thirdNumber = rdInt.nextInt(99)+1;
			    }
			    else {
					List<Integer> secondNumDivisors = getDivisors(secondNumber);

				    int divisorsRandIndex = rdInt.nextInt(secondNumDivisors.size());
				    this.thirdNumber = secondNumDivisors.get(divisorsRandIndex);
			    }
				break;
			case 3:
				this.firstNumber = rdInt.nextInt(99)+1;
			    List<Integer> divisors = getDivisors(firstNumber);
			    int divisorsRandIndex = rdInt.nextInt(divisors.size());
				this.secondNumber = divisors.get(divisorsRandIndex);
				divisors = getDivisors(firstNumber/secondNumber);
			    divisorsRandIndex = rdInt.nextInt(divisors.size());;
				this.thirdNumber = divisors.get(divisorsRandIndex);
				
				break;
				

			}
		}
	}
	/**
	 * Gets all divisors of an integer. Is used when generating random integers in the {@link #generateRandomNumbers(int) generateRandomNumbers} function for division expressions.
	 * @param number Integer to find divisors for.
	 * @return List of all divisors of integer passed into the function.
	 */
	private static List<Integer> getDivisors(int number) {
	    List<Integer> divisors = new ArrayList<>();

	    for (int i=1;i<=number;i++) 
	        if (number%i==0) 
	            divisors.add(i);
	            
	    return divisors;
	 }
	/**
	 * Function to randomly generate the full expression, including the operators.
	 * @return Array (serving as a tuple) where the first element is the result of the expression and the second element is the expression as a String.
	 */
	public List<String> generateRandomExpression() {
		Random rdOp = new Random();
		int a;
		int b;
		int c;
		List<String> expResult = new ArrayList<String>();
		if(this.level < 3) {
			this.op = rdOp.nextInt(2);
			generateRandomNumbers(0);
			a = this.firstNumber;
			b = this.secondNumber;
			c = this.thirdNumber;
			
			switch(this.op) {
			case 0:
				expResult.add(Integer.toString(a + b));
				expResult.add(Integer.toString(a) + "+" + Integer.toString(b));
				break;
			case 1:
				expResult.add(Integer.toString(a - b));
				expResult.add(Integer.toString(a) + "-" + Integer.toString(b));
			}
		}
		else {
			this.op = rdOp.nextInt(16);
			if(this.op == 10 || this.op == 12 || this.op == 14) {
				generateRandomNumbers(1);

			}
			else if(this.op == 9 || this.op == 11 || this.op == 13) {
				generateRandomNumbers(2);
			}
			else if(this.op == 15) {
				generateRandomNumbers(3);
			}
			else {
				generateRandomNumbers(0);
				
			}
			
			a = this.firstNumber;
			b = this.secondNumber;
			c = this.thirdNumber;
			
			switch(this.op) {
			case 0:
				expResult.add(Integer.toString(a + b + c));
				expResult.add(Integer.toString(a) + "+" + Integer.toString(b) + "+" +  Integer.toString(c));
				break;
			case 1:
				expResult.add(Integer.toString(a + b - c));
				expResult.add(Integer.toString(a) + "+" + Integer.toString(b) + "-" +  Integer.toString(c));
				break;

			case 2:
				expResult.add(Integer.toString(a - b + c));
				expResult.add(Integer.toString(a) + "-" + Integer.toString(b) + "+" +  Integer.toString(c));
				break;

			case 3:
				expResult.add(Integer.toString(a - b - c));
				expResult.add(Integer.toString(a) + "-" + Integer.toString(b) + "-" +  Integer.toString(c));
				break;

			
			case 4:
				expResult.add(Integer.toString(a + b * c));
				expResult.add(Integer.toString(a) + "+" + Integer.toString(b) + "*" +  Integer.toString(c));
				break;

			case 5:
				expResult.add(Integer.toString(a * b + c));
				expResult.add(Integer.toString(a) + "*" + Integer.toString(b) + "+" +  Integer.toString(c));
				break;

			case 6:
				expResult.add(Integer.toString(a - b * c));
				expResult.add(Integer.toString(a) + "-" + Integer.toString(b) + "*" +  Integer.toString(c));
				break;

			case 7:
				expResult.add(Integer.toString(a * b - c));
				expResult.add(Integer.toString(a) + "*" + Integer.toString(b) + "-" +  Integer.toString(c));
				break;

			
			case 8:
				expResult.add(Integer.toString(a * b * c));
				expResult.add(Integer.toString(a) + "*" + Integer.toString(b) + "*" +  Integer.toString(c));
				break;

			case 9:
				expResult.add(Integer.toString(a + b / c));
				expResult.add(Integer.toString(a) + "+" + Integer.toString(b) + "/" +  Integer.toString(c));
				break;

			case 10:
				expResult.add(Integer.toString(a / b + c));
				expResult.add(Integer.toString(a) + "/" + Integer.toString(b) + "+" +  Integer.toString(c));
				break;

			case 11:
				expResult.add(Integer.toString(a - b / c));
				expResult.add(Integer.toString(a) + "-" + Integer.toString(b) + "/" +  Integer.toString(c));
				break;

			
			case 12:
				expResult.add(Integer.toString(a / b - c));
				expResult.add(Integer.toString(a) + "/" + Integer.toString(b) + "-" +  Integer.toString(c));
				break;

			case 13:
				expResult.add(Integer.toString(a * b / c));
				expResult.add(Integer.toString(a) + "*" + Integer.toString(b) + "/" +  Integer.toString(c));
				break;

			case 14:
				expResult.add(Integer.toString(a / b * c));
				expResult.add(Integer.toString(a) + "/" + Integer.toString(b) + "*" +  Integer.toString(c));
				break;
			case 15:
				expResult.add(Integer.toString(a / b / c));
				expResult.add(Integer.toString(a) + "/" + Integer.toString(b) + "/" +  Integer.toString(c));
			}
					
		}
		
		return expResult;
	}
	/**
	 * Getter of the hashmap containing all expressions as keys and results as values.
	 * @return HashMap containing all expressions as keys and answers as values.
	 */

	public HashMap<String, Integer> getExpMap() {
		return expMap;
	}
	/**
	 * Function to generate n expressions using the {@link #generateRandomExpression() generateRandomExpression} function.
	 * @param n An integer n representing how many expressions to generate.
	 */
	public void generateExpressionList(int n) {
		
		for(int i = 0;i<n;i++) {
			
			List<String> exp = generateRandomExpression();
			this.expMap.put(exp.get(1), Integer.valueOf(exp.get(0)));
			
		}
	}

	
}
