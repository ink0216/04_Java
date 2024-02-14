package edu.kh.exception.pack3.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.kh.exception.pack3.model.exception.MoreThanAHundredException;

public class ExceptionHandlingService3 {
/*Checked Exception / Unchecked Exception
 * check : 확인하다
 * 
 * Checked Exception : 반드시 확인해야 하는 예외
 * 	== 예외 처리 구문(try~catch, throws)을 반드시 작성해야 하는 예외
 * 
 * Unchecked Exception : 확인 안해도 되는 예외
 *  == 예외 처리 구문(try~catch, throws)을 써도 그만, 안써도 그만인 예외
 * */
 /**
 * Checked / Unchecked(RuntimeException의 자식) 구분하기
 */
public void method1() {
	 //RuntimeException 또는 RuntimeException의 자식 예외 강제 발생시키기
	int result =1;
	if(result==1) {
		/**** Unchecked Exception ****/
		throw new RuntimeException(); //컴파일 에러(빨간 줄) 안뜸
		//이건 Unchecked여서 
	}
	//---------------------------------------------------------------------------------
	//RuntimeException, RuntimeException의 자식 제외한 나머지 예외 강제 발생
	else {
		try {
			/**** Checked Exception ****/
			throw new IOException(); // 얘는 예외 처리 안하니까 컴파일 에러 뜸 (극명한 차이!)
			//Unhandled exception type IOException == 예외 처리가 안되어있다!
			//			->예외처리 꼭 해라!
		} catch(IOException e) {
			System.out.println("예외 처리 필수!!");
		}
	}
}
/**
 * Checked Exception 확인하기
 *  - 강제 발생 시키는 것 말고
 *  	이미 만들어져 있는 Java 코드 이용 시
 *  	예외 처리가 꼭 필요한 경우(Checked Exception인 상황)
 */
public void method2() {
	//백준 알고리즘 문제 -> 키보드 입력받는 것보다 훨씬 빠른 것 있음 근데 코드가 더 긴데 이걸 많이 씀
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//System.in : 키보드
	//InputStreamReader(System.in) : 키보드의 입력을 읽는 객체
	//BufferedReader : 빨리, 효율적으로 읽어오는 객체
	//->키보드 입력을 읽어올 때 빠르고 효율적으로 읽어오는 객체 만듬
	
	//br.read() : 한 글자 한글자를 숫자로 얻어옴(byte코드)
	//br.readLine() : 한 줄을 뭉텅이로 얻어옴
	
	//스캐너는 정수/문자열 등 구분해서 가져올 수 있고
	//Scanner보단 기능이 부족하지만, 속도가 압도적으로 빠름
	//->Scanner보다는 BufferedReader 많이 사용!!!!
	
	//부족한 기능(int, double 입력받기 등등)은
	//Wrapper 클래스에서 제공해주는
	//Integer.parseInt(문자열), Double.parseDouble(문자열)을 이용하면 해결됨
	
	System.out.print("문자열 입력 : ");
	//읽어올 때 String으로 반환됨
	try { //br.readLine() 때문에 작성한 예외 처리 구문 (try~ catch구문 안 쓰면 오류남)
		String input = br.readLine(); 
		//br.readLine(); : 엔터까지 입력된 한 줄 읽어오기
		//br.readLine(); : 예외 처리 반드시 해야 함
		//public String readLine() throws IOException
		//-> IOException 예외 처리 구문이 필수적으로 작성 되어야 함!!!!!!
		System.out.println("입력 받은 문자열 : "+input);
	} catch(IOException e) {
		System.out.println("예외 잡아서 처리함");
	}
}
/**
 * CheckedException, UncheckedException
 * 두 종류 예외가 섞어서 쓰는 예제
 */
public void method3() {
	//BufferedReader를 이용해서 입력 받기
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String input = null; //참조형 변수이므로 참조형 변수의 기본값인 null로 초기화해두기
	try {
		System.out.print("아무거나 입력하세요 : ");
		input = br.readLine(); //CheckedException
		//입력받으면 다 String으로 저장됨
		// 123 입력 -> "123"
		
		//입력 받은 내용이 정수(문자열 안에 숫자만 있는 문자열인 경우) -> 곱하기 2해서 출력하기
		//입력 받은 내용이 문자열 -> 앞 뒤에 ### 붙이기 
		
		//입력 받은 문자열 input을 정수로 변환
		
		int temp = Integer.parseInt(input); //Unchecked Exception(try~catch안써도 돼서 안썼더니 예외 발생)
		//parse : 데이터의 형태를 완전히 다른 것으로 바꾸는 것(String<->int)
		// java.lang.NumberFormatException 발생
		//	-> 내부에 있는 문자열이 숫자가 아닌데 숫자로 바꾸려니까 안됨
		//	-> 파싱하려는 문자열 input이 숫자의 형태가 아니라서 예외 발생
		System.out.println(temp*2);
	}catch(IOException e) {
		System.out.println("IOException 처리");
	} catch(NumberFormatException e) {
		//정수가 아닌 문자열이 입력되어 NumberFormatException이 발생한 경우
		//	->"아무거나" 등 문자열이 입력되었다는 소리!
		System.out.println("###"+input+"###");
		//문서 보는 방법 : 클릭 후 shift+f2키
	}
} 
/**
 * throws != throw
 * 
 * throws : 메서드 내부에서 발생된 예외를 호출한 곳으로 던짐(저기로 던질거야)
 * throw : 예외 객체를 현재 위치에서 던짐 (예외 강제 발생 구문)(앞에서 해 봄)(여기서 던질거야)
 */
public void method4() {
	//inputString() 메서드를 이용해서
	//문자열을 두 번 입력 받아
	//하나로 합쳐서 출력하기
	
	try {
		
		System.out.print("첫 번째 문자열 입력 : ");
		String str1 = inputString(); 
		//inputString()호출 ->throws IOException 작성됨->호출한 곳에서 처리하겠다
		// -> 예외 처리 코드(try~catch, throws)를 호출한 곳에서 작성하면 됨
		//	throws : 던져서 받은 것을 한 번 더 던지는 것도 가능
		
		System.out.print("두 번째 문자열 입력 : ");
		String str2 = inputString(); 
		
		//		System.out.println(str1+str2); : 문자열끼리 더하는 것은 효율 안좋음....
		// ->StringBuilder 쓰기!!!!
		StringBuilder sb = new StringBuilder();
		sb.append(str1);
		sb.append(str2);
		
		System.out.println(sb.toString());
	} catch(IOException e) {
		System.out.println("IOException 잡아서 처리함");
	}
}
/**BufferedReader를 이용해서 문자열 입력 받기
 * @return 입력 받은 문자열을 그대로 반환할 것임
 */
public String inputString() throws IOException{
	//throws IOException : 현재 메서드에서 발생할 수 있는(던져질 수 있는) IOException을
	//현재 메서드를 호출한 곳으로 던져서 
	//상황에 맞게 별도로 처리하게 함
	//(여기서 고정된 방식으로 처리하는 것이 아닌, 각자의 방식으로 처리할 수 있도록)
	//->method4(){}에서 호출할 것임
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//키보드는 외부장치여서 BufferedReader도 종이컵전화기 역할 해서 사용 후에는 지우는 구문 써야 함
	
	String str = br.readLine();
	//br.close(); //사용 끝난 br객체 반환(제거)(메모리 반환)
	//System.in은 한 번 닫으면 재사용 불가해서 일단은 br.close() 쓰지 말기
	
	return str; //키보드 입력받은 것을 돌려보내줌 근데 IOException이 발생된다면 호출한 곳으로 던질거임
	
	//여기서 예외처리 안 하고 호출한 사람이 호출할 때 각자의 방법대로 처리하도록 하기
} 
/**
 * 사용자 정의 예외 사용하기 ->나중에 엄청 많이 사용!
 * (MoreThanAHundredException)
 */
public void method5() {
	try {
		System.out.println("[두 정수를 입력 받아 합계 출력하기]");
//		inputString() : IOException을 던질 가능성 있음 ->밑에 catch로 잡아서 처리할 준비 해둠
		System.out.print("정수 1 : ");
		int number1 = Integer.parseInt(inputString());
				//입력 받은 문자열을 입력 받자마자 정수로 바꾸어 저장
		
		System.out.print("정수 2 : ");
		int number2 = Integer.parseInt(inputString());
		int result = number1 + number2;
		//합이 100을 넘으면 심각함!
		if(result>100) {
			//100초과한 경우가 심각한 상황이라 가정
//			throw new MoreThanAHundredException(); //기본생성자로 만듦
			//100초과라는 예외는 자바에 없음 ->우리가 만들어서 던지기!
			throw new MoreThanAHundredException("100을 초과하다니....."); //특정 구문 쓰고 싶으면
		}
		System.out.println(result); //결과 출력
	}catch(IOException e) {
		System.out.println("IOException 처리");
	} catch(NumberFormatException e) {
		//숫자만 적힌 문자열 적어야 하는데 실수로 숫자 외에도 다른 것 있는 것 입력한 경우
		System.out.println("잘못 입력");
	} catch(MoreThanAHundredException e) {
		//e : 예외 객체 참조 변수( JS에서는 이벤트 객체였음)
		
		//e.printStackTrace();
		// - print : 출력하다
		// - Stack : JVM메모리 중 Stack 메모리 영역(호출한 메서드가 차곡차곡 쌓여 있는 곳)
		// - Trace : 추적하다
		//	-> 호출한 메서드를 순서대로 따라가면서 발생한 예외를 모두 추적해서 출력해줌
		
		e.printStackTrace();
		/*edu.kh.exception.pack3.model.exception.MoreThanAHundredException: 100을 초과 하였습니다.
	at edu.kh.exception.pack3.model.service.ExceptionHandlingService3.method5(ExceptionHandlingService3.java:186)
	at edu.kh.exception.pack3.run.ExceptionHandlingRun3.main(ExceptionHandlingRun3.java:11)*/
	}
}



}
			
