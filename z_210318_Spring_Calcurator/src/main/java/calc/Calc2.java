package calc;

public class Calc2 {
	private float a;
	private float b;
	private String c;	//calc2.jsp에서 넘겨주는 select(파라미터 c저장)의 value값들을 받음
	private float sum;	//사칙연산 다넣음

	
	public Calc2() {
		this.a = 0.0f;
		this.b = 0.0f;
		this.c = null;
		this.sum = 0.0f;
	}
	
	public Calc2(float a, float b, String c) {
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
