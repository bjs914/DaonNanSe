package calc;

public class CalcService {	//컨트롤러와 연계시켜주는 역할
	public CalcService() {
		
	}
	
	public Calc calc(Calc calc) {	//덧셈만 연산
		calc.calc();
		return calc;
	}
	
	public Calc2 calc2(Calc2 calc) {	//사칙연산
		calc.calc();
		return calc;
	}
	
	public Calc3 calc3(Calc3 calc) {	//jstl tag choose, when 사용
		calc.calc();
		return calc;
	}

	public Calc4 calc4(Calc4 calc) {	//jstl tag foreach, choose, when 사용
		calc.calc();
		return calc;
	}
}
