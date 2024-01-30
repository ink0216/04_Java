package edu.kh.variable.ex;

public class VariableEx1 {
public static void main(String[] args) {
	// 변수 : 메모리에 값을 저장하기 위한 공간
	// 				이 때, 저장되는 값이 변할 수 있어 변수라고 한다


	// 자료형(data type)
	//		-변수 또는 값의 크기와 형식
	
	/*	자바 기본 자료형(Java Primitive Types)
	 * 
	 * 	[논리형]
	 *  boolean (1byte) - true / false만 저장 가능
	 *  
	 *  [정수형]
	 *  byte	(1byte)
	 *  short (2byte)
	 *  int		(4byte) *정수 기본형*
	 *  long	(8byte) * 숫자 뒤에 L 붙여야 함
	 *  그냥 100으로 쓰면 byte의 범위에 들어가지만 기본형인 int로 인식됨
	 * 
	 *  [실수형]
	 *  float	(4byte) * 숫자 뒤에 f 붙여야 함
	 *  double(8byte) * 실수 기본형*
	 *  
	 *  [문자형]
	 *  char	(2byte) * 문자 하나, 문자 양옆에''
	 *  String : 객체(char 여러개가 붙은 객체)
	 * */
	
	//변수 선언하기 : 메모리에 공간 할당(변수 넣는 박스 만들기)
	boolean isTrue ; //메모리에 boolean 1byte의 저장 공간을 할당하고 그 공간은 isTrue(변수명)라고 부름
	
	double number1; // 메모리에 double 저장 공간 8byte 할당하고 그 공간은 number1(변수명)이라고 부름
	
	// 값 대입하기 : 변수에 값을 집어 넣는 것
	//								이미 값이 들어있는 변수에 대입하면 덮어쓰기 됨
	isTrue = true; 
	
	//sysout => ctrl+space
	System.out.println("isTrue :" +isTrue); //true
	
	//실행 단축키 : ctrl + f11
	isTrue = false;
	System.out.println("isTrue :" +isTrue); //false
	
	// 변수 선언 + 초기화(변수에 처음으로 값 대입하는 것) + 값의 범위 확인
	int number2 = 2100000000; //21억은 오류 안남
	long number3 = 2200000000L; // int22억은 오류남 -> int의 범위를 초과
	//[해결 방법] : int보다 범위가 큰 자료형으로 변경하기
	//							->자료형을 long, 숫자 뒤에 L추가하는 리터럴 표기법 추가
	//							->'L', 'f'같은 리터럴 표기법은 
	//									컴파일러가 자료형을 구분하기 위한 기호일 뿐,
	//									출력 시 보여지지는 않는다
	System.out.println("number2 : " +number2);
	System.out.println("number3 : " +number3);
	
	//다른 리터럴 표기법 확인
	char temp1 = '강'; //한 글자만 쓸 수 있음
	float temp2 = 1.23f; //숫자 뒤에 f 안붙이면 에러남
	
	double temp3 =3.14;
	
	//--------------------------------------------------------------------
	// String(문자열)
	/* 기본 자료형은 다 소문자로 시작하므로 String은 기본 자료형 아님
	 * -기본 자료형(한 개밖에 저장 못함)이 아닌 객체(여러 개를 저장할 수 있음)임
	 * - String을 저장하는 변수는 객체 대신 주소를 저장( == 참조)하기 때문에
	 * "참조형"이라고 한다
	 * (저장된 주소에 위치한 객체를 참조)
	 * 문자열은 크기가 너무 커서 char에 못 넣어서 그 주소만 넣고 필요할 때마다 주소 찾아가서 값 읽어옴
	 * 
	 * -String의 리터럴 표기법 : 쌍따옴표("")
	 */
	String str1 = "쌍따옴표가 String 리터럴 표기법";
	System.out.println(str1);
	//형 변환 : boolean을 제외한 자료형을 바꾸는 것
	// 1+1.3 : 서로 다른 자료형이어서 계산 불가 ->계산 위해 형 변환함
	// ->1.0 + 1.3 : 결과도 실수형으로 2.3나옴
	
	//형변환을 명시해야 할 때와 명시하지 않아도 될 때(자동 형변환)가 있음
	//컴파일러 : 사람이 쓴 코드를 컴퓨터가 이해하는 2진법 코드로 바꿔주는 기계
	//2(int)+3.1(double) 의 경우 컴파일러가 int를 자동으로 double로 바꿔줌
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
