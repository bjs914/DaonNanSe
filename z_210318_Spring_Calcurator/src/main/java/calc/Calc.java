package calc;

public class Calc {
	private float a;
	private float b;
	private float sum;	//덧셈계산

	
	public Calc() {
		this.a = 0.0f;
		this.b = 0.0f;
		this.sum = 0.0f;
	}
	
	public Calc(float a, float b) {
		this.a = a;
		this.b = b;
			
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
	
	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}
	
	public float calc() {
		return this.sum=this.a+this.b;
	}
}