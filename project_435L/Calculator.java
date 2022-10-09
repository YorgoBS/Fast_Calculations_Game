package project_435L;

import java.util.ArrayList;
import java.util.HashMap;
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
	private HashMap<String,Integer> expMap;
	
	
	public Calculator(int level) {
		this.level = level;
		this.result = new ArrayList<Integer>();
		this.expressions = new ArrayList<String>();
		this.expMap = new HashMap<String,Integer>();
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
				break;
			case 1:
				
				this.firstNumber = rdInt.nextInt(50)*2;
				this.secondNumber = rdInt.nextInt(50)*2;
				this.thirdNumber = rdInt.nextInt(100);

				while(this.secondNumber ==0){
					this.secondNumber = rdInt.nextInt(50)*2;
				}
				if(this.secondNumber>this.firstNumber && this.firstNumber != 0) {
					
					int temp = this.firstNumber;
					this.firstNumber = this.secondNumber;
					this.secondNumber = temp;
				}
				break;
			case 2:
				this.firstNumber = rdInt.nextInt(100);
				this.secondNumber = rdInt.nextInt(50)*2;			
				this.thirdNumber = rdInt.nextInt(50)*2;
				while(this.thirdNumber == 0) {
					this.thirdNumber = rdInt.nextInt(50)*2;
				}
				if(this.thirdNumber>this.secondNumber && this.secondNumber != 0) {
					int temp = this.secondNumber;
					this.secondNumber = this.thirdNumber;
					this.thirdNumber = temp;
				}
				break;
//			case 3:
//				this.firstNumber = rdInt.nextInt(50)*2;
//				this.secondNumber = rdInt.nextInt(50)*2;
//				if(this.secondNumber ==0) {
//					this.secondNumber = rdInt.nextInt(50)*2;
//				}
//				this.thirdNumber = rdInt.nextInt(50)*2;
//				if(this.thirdNumber ==0) {
//					this.thirdNumber = rdInt.nextInt(50)*2;
//				}
//				if(this.secondNumber>this.firstNumber && this.firstNumber != 0) {
//					int temp = this.firstNumber;
//					this.firstNumber = this.secondNumber;
//					this.secondNumber = temp;
//				}
//				if(this.thirdNumber>this.secondNumber && this.secondNumber != 0) {
//					int temp = this.secondNumber;
//					this.secondNumber = this.thirdNumber;
//					this.thirdNumber = temp;
//				}
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
				break;
			case 1:
				expResult.add(Integer.toString(a - b));
				expResult.add(Integer.toString(a) + "-" + Integer.toString(b));
			}
		}
		else {
			this.op = rdOp.nextInt(15);
			if(this.op == 10 || this.op == 12 || this.op == 14) {
				GenerateRandomNumbers(1);

			}
			else if(this.op == 9 || this.op == 11 || this.op == 13) {
				GenerateRandomNumbers(2);

			}
//			if(this.op == 15) {
//				GenerateRandomNumbers(3);
//			}
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

//			case 15:
//				expResult.add(Integer.toString(a / b / c));
//				expResult.add(Integer.toString(a) + "/" + Integer.toString(b) + "/" +  Integer.toString(c));
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
			this.expMap.put(exp.get(1), Integer.valueOf(exp.get(0)));
			
		}
	}

	public HashMap<String, Integer> getExpMap() {
		return expMap;
	}

	public void setExpMap(HashMap<String, Integer> expMap) {
		this.expMap = expMap;
	}
	
}
