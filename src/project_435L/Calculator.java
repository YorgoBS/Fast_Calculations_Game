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

	public void GenerateRandomNumbers() {
		
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
			this.firstNumber = rdInt.nextInt(100);
			this.secondNumber = rdInt.nextInt(100);			
			this.thirdNumber = rdInt.nextInt(100);	
		}
	}
	
	public List<String> GenerateRandomExpression() {
		Random rdOp = new Random();
		List<String> expResult = new ArrayList<String>();
		if(this.level < 3) {
			this.op = rdOp.nextInt(2);
			switch(this.op) {
			case 0:
				expResult.add(Integer.toString(this.firstNumber + this.secondNumber));
				expResult.add(Integer.toString(this.firstNumber) + "+" + Integer.toString(this.secondNumber));
			case 1:
				expResult.add(Integer.toString(this.firstNumber - this.secondNumber));
				expResult.add(Integer.toString(this.firstNumber) + "-" + Integer.toString(this.secondNumber));
		}
//		else {
//			this.op = rdOp.nextInt(4);
//			switch(this.op) {
//			case 0:
//				this.result = this.firstNumber + this.secondNumber + this.thirdNumber;
//				return Integer.toString(this.firstNumber) + "+" + Integer.toString(this.secondNumber);
//			case 1:
//				this.result = this.firstNumber - this.secondNumber + this.thirdNumber;
//				return Integer.toString(this.firstNumber) + "-" + Integer.toString(this.secondNumber);
//			case 2:
//				this.result = this.firstNumber * this.secondNumber + this.thirdNumber;
//				return Integer.toString(this.firstNumber) + "*" + Integer.toString(this.secondNumber);
//			case 3:
//				this.result = this.firstNumber / this.secondNumber + this.thirdNumber;
//				return Integer.toString(this.firstNumber) + "*" + Integer.toString(this.secondNumber) ;
//			}
//		}
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
			GenerateRandomNumbers();
			List<String> exp = GenerateRandomExpression();
			this.expressions.add(exp.get(1));
			this.result.add(Integer.valueOf(exp.get(0)));
			
		}
	}
	
}
