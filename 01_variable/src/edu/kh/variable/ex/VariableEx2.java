package edu.kh.variable.ex;

public class VariableEx2 {
/*메인 메서드 : 정처기에 나옴*/
//	public static void main(String[] args) {} 이 구문 외우기!
	
	//메인 메서드(이게 있어야 자바 코드가 실행될 수 있다)
	public static void main(String[] args) {
		/*
		 * 컴퓨터의 값 처리 원칙
		 * - 같은 자료형 끼리 연산 가능, 연산 결과도 같은 자료형! 
		 * 
		 * 형변환
		 * - 다른 자료형끼리 연산하는 경우,
		 * 		자료형을 맞게 변환시키는 것
		 * 
		 * 자동 형변환
		 * - 연산 시 값의 범위가 상대적으로 작은 변수의 자료형을 
		 * 		값의 범위가 상대적으로 큰 변수의 자료형으로 변환*/
		
		//자동 형변환 확인 1
		int num1 = 9;
		long num2 = 10_000_000_000L; //100억 _쓰면 자릿수 구분 가능
		// int +long -> long + long으로 자동 형변환 됨
		// 그럼 계산 결과도 long으로 나오는데, 
		// long형인 num1+num2를
		// int형 변수 result1에 long을 억지로 쑤셔 넣으려고 해서 오류 발생
		//		int result1 = num1 +num2;
		long result1 = num1 +num2;
		System.out.println("result1 :" +result1); //100억 9
		
		//자동 형변환 확인 2
		int num3 = 300; //기본값
		double num4 = 12.34; //기본값
		//int(300) + (double)12.34
		//int(300) + (double)12.34 = (double)312.34
		
		// 바이트 크기로 따지면 안되고, 표현 가능한 값의 범위로 봐야 함
		//상대적으로 값의 범위 좁은 int가 double로 변환되어 계산결과가 double로 나옴
		//그 값을 저장하기 위한 변수도 double로 하면 됨
		double result2 = num3 +num4;
		System.out.println("result2 " +result2);
		
		//자동 형변환 확인 3
		long num5 = 20L;
		float num6 = 3.14f;
		// long(20) + float(3.14) 
		//->float(20.0f) + float(3.14f) 
		// 
		// (double) result3 = (float) 23.14f //넣을 수 있긴 한데 연산 위해서는 더블로 바꿈
		// (double) result3 = (double) 23.14f //
		double result3 = num5 +num6;
		System.out.println("result3 :" +result3);
		//double, float는 큰 값을 대략 잡은 거라 정확하지 않음
		//(참고)
		//double, float는 실수를 근사치로 표현해서 정확하지 않은 자료형!
		//	-> 은행이나 숫자에 민감한 프로젝트에서는 안씀(부동소수점의 문제)
		// 	-> Big Integer로 소수의 숫자배열과 소수점 위치를 문자열로 저장
		
		
		
		
		
		
		
		
	}
}
