package project_435L;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Calculator {
	private int level;
	private int firstNumber;
	private int secondNumber;
	private int thirdNumber;
	private int op;
	private List<Integer> result;
	private List<String> expressions;
	
	
	public Calculator(int level) {
		this.level = level;
		this.result = new ArrayList<Integer>();
		this.expressions = new ArrayList<String>();
}

	public void GenerateRandomNumbers(int divisor) {
		
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
			case 1:
				this.firstNumber = rdInt.nextInt(50)*2;
				this.secondNumber = rdInt.nextInt(50)*2;
				if(this.secondNumber ==0) {
					this.secondNumber = rdInt.nextInt(50)*2;
				}
				this.thirdNumber = rdInt.nextInt(100);
			case 2:
				this.firstNumber = rdInt.nextInt(100);
				this.secondNumber = rdInt.nextInt(50)*2;			
				this.thirdNumber = rdInt.nextInt(50)*2;
				if(this.thirdNumber ==0) {
					this.thirdNumber = rdInt.nextInt(50)*2;
				}
			case 3:
				this.firstNumber = rdInt.nextInt(50)*2;
				this.secondNumber = rdInt.nextInt(50)*2;
				if(this.secondNumber ==0) {
					this.secondNumber = rdInt.nextInt(50)*2;
				}
				this.thirdNumber = rdInt.nextInt(50)*2;
				if(this.thirdNumber ==0) {
					this.thirdNumber = rdInt.nextInt(50)*2;
				}
			}
		}
	}
	
	public List<String> GenerateRandomExpression() {
		Random rdOp = new Random();
		int a;
		int b;
		int c;
		List<String> expResult = new ArrayList<String>();
		if(this.level < 3) {
			this.op = rdOp.nextInt(2);
			GenerateRandomNumbers(0);
			a = this.firstNumber;
			b = this.secondNumber;
			c = this.thirdNumber;
			switch(this.op) {
			case 0:
				expResult.add(Integer.toString(a + b));
				expResult.add(Integer.toString(a) + "+" + Integer.toString(b));
			case 1:
				expResult.add(Integer.toString(a - b));
				expResult.add(Integer.toString(a) + "-" + Integer.toString(b));
			}
		}
		else {
			this.op = rdOp.nextInt(16);
			if(this.op == 10 || this.op == 12 || this.op == 14) {
				GenerateRandomNumbers(1);

			}
			if(this.op == 9 || this.op == 11 || this.op == 13) {
				GenerateRandomNumbers(2);

			}
			if(this.op == 15) {
				GenerateRandomNumbers(3);
			}
			else {
				GenerateRandomNumbers(0);
			}
			a = this.firstNumber;
			b = this.secondNumber;
			c = this.thirdNumber;
			switch(this.op) {
			case 0:
				expResult.add(Integer.toString(a + b + c));
				expResult.add(Integer.toString(a) + "+" + Integer.toString(b) + "+" +  Integer.toString(c));
			case 1:
				expResult.add(Integer.toString(a + b - c));
				expResult.add(Integer.toString(a) + "+" + Integer.toString(b) + "-" +  Integer.toString(c));
			case 2:
				expResult.add(Integer.toString(a - b + c));
				expResult.add(Integer.toString(a) + "-" + Integer.toString(b) + "+" +  Integer.toString(c));
			case 3:
				expResult.add(Integer.toString(a - b - c));
				expResult.add(Integer.toString(a) + "-" + Integer.toString(b) + "-" +  Integer.toString(c));
			
			case 4:
				expResult.add(Integer.toString(a + b * c));
				expResult.add(Integer.toString(a) + "+" + Integer.toString(b) + "*" +  Integer.toString(c));
			case 5:
				expResult.add(Integer.toString(a * b + c));
				expResult.add(Integer.toString(a) + "*" + Integer.toString(b) + "+" +  Integer.toString(c));
			case 6:
				expResult.add(Integer.toString(a - b * c));
				expResult.add(Integer.toString(a) + "-" + Integer.toString(b) + "*" +  Integer.toString(c));
			case 7:
				expResult.add(Integer.toString(a * b - c));
				expResult.add(Integer.toString(a) + "*" + Integer.toString(b) + "-" +  Integer.toString(c));
			
			case 8:
				expResult.add(Integer.toString(a * b * c));
				expResult.add(Integer.toString(a) + "*" + Integer.toString(b) + "*" +  Integer.toString(c));
			case 9:
				expResult.add(Integer.toString(a + b / c));
				expResult.add(Integer.toString(a) + "+" + Integer.toString(b) + "/" +  Integer.toString(c));
			case 10:
				expResult.add(Integer.toString(a / b + c));
				expResult.add(Integer.toString(a) + "/" + Integer.toString(b) + "+" +  Integer.toString(c));
			case 11:
				expResult.add(Integer.toString(a - b / c));
				expResult.add(Integer.toString(a) + "-" + Integer.toString(b) + "/" +  Integer.toString(c));
			
			case 12:
				expResult.add(Integer.toString(a / b - c));
				expResult.add(Integer.toString(a) + "/" + Integer.toString(b) + "-" +  Integer.toString(c));
			case 13:
				expResult.add(Integer.toString(a * b / c));
				expResult.add(Integer.toString(a) + "*" + Integer.toString(b) + "/" +  Integer.toString(c));
			case 14:
				expResult.add(Integer.toString(a / b * c));
				expResult.add(Integer.toString(a) + "/" + Integer.toString(b) + "*" +  Integer.toString(c));
			case 15:
				expResult.add(Integer.toString(a / b / c));
				expResult.add(Integer.toString(a) + "/" + Integer.toString(b) + "/" +  Integer.toString(c));
			}
			
			
		}
		return expResult;
	}
	
	public List<Integer> getResult() {
		return result;
	}


	public List<String> getExpressions() {
		return expressions;
	}


	public void GenerateExpressionList(int n) {
		
		for(int i = 0;i<n;i++) {
			
			List<String> exp = GenerateRandomExpression();
			this.expressions.add(exp.get(1));
			this.result.add(Integer.valueOf(exp.get(0)));
			
		}
	}
	
}
