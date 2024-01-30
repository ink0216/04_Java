package edu.kh.variable.ex;
//import : 다른 패키지에 존재하는 클래스 가져오기(수입하기)
import java.util.Scanner;
public class ScannerEx1 {
public static void main(String[] args) {
	/*Scanner 클래스
	 * - 사용자로부터 입력을 받기위해 Java에서 제공하는 클래스
	 * - java.util 패키지에 존재
	 * 		-> 본 문서와 서로 다른 패키지에 존재(다른나라->수입해야함)
	 * 		-> import 구문 작성 필요
	 * 
	 * - Scanner.next(); : 단어(String) 1개 입력받기, 공백(enter, space, tab) 입력 시 입력 종료됨
	 * - Scanner.nextLine(); : 문자열(String) 1개 입력받기, 개행문자(enter)입력 시 입력 종료됨
	 * 
	 *  -이 둘의 공통점 : String만 입력받을 수 있음
	 *  
	 *  - Scanner.nextInt(); : int형 정수 1개 입력받기
	 *  - Scanner.nextDouble(); : 실수 1개 입력받기
	 *  - Scanner.nextLong(); : long형 정수 1개 입력받기
	 * */
	
	// Scanner 사용하기
	// 1. 클래스 위에 import 하는 구문 작성하기
	// 2. import 한 Scanner 클래스를 이용해서 Scanner 객체 생성(이용할 수 있는 형태로 변형)
	Scanner sc = new Scanner(System.in); //JS에서의 생성자함수와 비슷 
	// System.in : (이클립스에서) 키보드 의미
	System.out.print("정수 입력 1 :"); //출력 후 줄바꿈 안함
	int num1 = sc.nextInt(); //다음 입력된 정수를 얻어와 num1에 대입
	
	System.out.print("정수 입력 2 :"); //출력 후 줄바꿈 안함
	int num2 = sc.nextInt(); //다음 입력된 정수를 얻어와 num2에 대입
	
	System.out.print("실수 입력 :");
	double num3 = sc.nextDouble(); 
	
	System.out.print("단어 입력(2개) :"); //사과 바나나(엔터)
	String word1 = sc.next(); //사과
	String word2 = sc.next(); //바나나
	
	//********************************************************************
	// - next() / nextInt() / nextDouble()등을 작성한 이후에
	//		nextLine()을 작성해야 하는 상황이 오면
	//		nextLine()구문을 앞에 미리 한 번 작성하기
	sc.nextLine(); //(엔터) 꺼내감
	// 왜 해야하느냐? 
	// Scanner사용 시 
	// 입력 되는 값이 Scanner의 입력 버퍼라는 곳에 저장된 후
	// nextInt()이면 버퍼에 저장된 값 중 정수부분만 추출
	//	->이 때 정수부분 뒤에 입력된 엔터가 버퍼에 남아있게 된다
	// 이후의 nextLine(); 해석 시
	// 버퍼에서 다음 엔터까지 읽어오는 작업이 수행되는데
	// 버퍼에 남아있던 엔터를 읽어오기 때문에 아무것도 입력을 못하는 문제가 생김
	
	//[해결 방법]
	//nextLine()을 한 번 호출해서 남아있던 엔터를 제거
	//	->버퍼가 빈 상태가 되어 입력을 받을 수 있게 됨
	
	//********************************************************************
	System.out.print("문장 입력 :");
	String str = sc.nextLine();
	
	System.out.printf("%d,\t\t %d, %f, %s, %s, %s \\ \" \' \n" , 
											num1, num2, num3, word1, word2, str);
	
	//Java같은 Back-end 언어는 효율 좋게 작성해야된다!!
	//왜?
	//서버 사이드(서버쪽, 컴퓨터 한대) 클라이언트 사이드(클라이언트쪽)
	//서버 사이드 언어(서버에서 코드 해석) : 자바
	//클라이언트가 100만명 오는 경우 그걸 다 처리하기 위한 준비 돼있어야 함
	// html css, js : 클라이언트 사이드 언어
	//클라이언트가 요청 네이버 보여줘! ->클라이언트 브라우저(1개 컴퓨터)에서 해석
	// 클라이언트 사이드(클라이언트에서 코드 해석)
	
	//쉬프트 연산자, 비트 연산자 ->효율 증가
}
}
