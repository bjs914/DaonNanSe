package calc;

import java.util.ArrayList;
import java.util.List;

public class Calc4 {
	private float a;
	private float b;
	private String c;	
	private float sum;	//사칙연산 다넣음
	private List<String> cList;	//새로운 리스트를 만들어 미리 그 안에 calc.jsp에서 select option의 값을 넣어놓음.
	
	public Calc4() {
		this.a = 0.0f;
		this.b = 0.0f;
		this.c = null;
		this.sum = 0.0f;
		
		this.cList = new ArrayList<String>();	//List안에 사칙연산 기호 넣음
		cList.add("+");
		cList.add("-");
		cList.add("*");
		cList.add("/");
	}
	
	public Calc4(float a, float b, String c) {
		this.a = a;
		this.b = b;
		this.c = c;
		
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}
	
	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}

	public List<String> getcList() {
		return cList;
	}


	public float calc() {
			
		if(c.equals("+")) {
			this.sum=this.a+this.b;
			return this.sum;
		}
		else if(c.equals("-")) {
			this.sum=this.a-this.b;
			return this.sum;
		}
		else if(c.equals("*")) {
			this.sum=this.a*this.b;
			return this.sum;
		}
		else {
			this.sum=this.a/this.b;
			return this.sum;
		}
	}
}
