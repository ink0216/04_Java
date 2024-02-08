package edu.kh.poly.pack3.model.dto;
//인터페이스는 다중 상속이 가능하다
//각자 구현한 계산기
//계산기의 틀과, 계산기도 기계이므로 기계도 받아옴
public class LIKCalculator implements Calculator, Machine {
	//LIKCalculator가 Calculator와 Machine을 둘 다 상속받은 것임(인터페이스는 다중 상속이 가능)
	//클래스는 다중 상속 불가
	@Override
	public void powerOn() {
		System.out.println("이인경 계산기 실행");
	}

	@Override
	public void powerOff() {
		System.out.println("이인경 계산기 종료");
	}

	@Override
	public int plus(int a, int b) {
		return a+b;
	}

	@Override
	public int minus(int a, int b) {
		return a-b;
	}

	@Override
	public int multi(int a, int b) {
		return a*b;
	}

	@Override
	public double div(int a, int b) {
		if(b==0) return 0.0;
		return (double)a/b;//a,b가 int인데 
		// b==0 ? 0.0 : (double)a/b; 삼항연산자로 해도 됨
	}

	@Override
	public int mod(int a, int b) {
		return a%b; 
	}

	@Override
	public int sum(int... numbers) {
		int sum=0;
		for(int i : numbers) {
			sum +=i;
		}
		return sum;
		/* ...: 가변인자
		 * : 전달 인자(전달되는 값)의 개수가 정해져있지 않은 매개변수(전달 인자)
		 * 		전달되는 값의 개수가 변할 수 있음
		 * 		이거 하나로 두 개 더하기 할 수도 , 세 개 더하기 할 수도... 있음
		 * 가변인자 사용의 대표적 예시 : printf()
		 * 				->표현하고 싶은 변수 개수를 마음대로 바꿔서 사용 가능
		 * 가변인자 사용법 : 전달인자를 배열로 저장하고 있음
		 * 		이 경우 numbers라는 int배열 타입에   */
	}

	@Override
	public double areaOfCircle(double r) {
		return Calculator.PI*r*r;
		//static이 붙은 것은 클래스명/인터페이스명.필드명 쓰는 것이 정석!
	}

	@Override
	public boolean rangeCheck(int num) {
		
		return num >= Calculator.MIN_NUM && num <= Calculator.MAX_NUM;
		//이게 맞으면 true, 아니면 false반환됨
	}

	@Override
	public int pow(int a, int x) {
		//방법1
		int result = 1;
		for(int i=0; i<x ; i++) {
			result *=a;
		}
		return result;
	}

	@Override
	public String toBinary(int num) {
		return Integer.toBinaryString(num);
	}

	@Override
	public String toHexadecimal(int num) {
		return Integer.toHexString(num);
	}

}
