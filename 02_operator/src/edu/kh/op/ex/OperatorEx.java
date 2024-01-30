package edu.kh.op.ex;
import java.util.Scanner; //Scanner 클래스 수입해오기(설계도만 가져와서 새로 만들기(객체생성))
/**
 * 기능용(예재) 클래스
 */
public class OperatorEx {
	//메서드(기능) 호출 테스트
public void test() {
	System.out.println("다른 클래스에 작성된 기능");
}

/**
 * 입력 받은 정수가 3의 배수가 맞는지 확인하기
 */
public void method1() {
	//메인메서드 안에 객체 생성해서 사용가능하게 만들기
	//Scanner 객체 생성
	Scanner sc = new Scanner(System.in);
	System.out.print("정수 입력 :");
	int input =sc.nextInt(); //int는 4바이트, 32비트!
	
	//boolean 변수 이름은 보통 앞에 is단어 붙임
	boolean isTrue = input % 3 ==0; //3으로 나눈 나머지가 0이면 true가 저장되고 아니면 false 저장됨
	System.out.printf("%d는 3의 배수 : %b", input, isTrue); 
} //3의 배수 확인하기 함수 만들어만 놓음 -> Run파일에서 호출


/**
 * 첫 번째 입력받은 수가 
 * 두 번째 입력받은 수의 배수가 맞는지 확인해보기
 */
public void method2() {
	//값 입력받는 스캐너 필요하므로 스캐너 객체 생성
	Scanner scanner = new Scanner(System.in); //꼭 sc로 안해도 됨
	System.out.print("첫 번째 수 입력 :");
	int input1 = scanner.nextInt();
	
	System.out.print("두 번째 수 입력 :");
	int input2 = scanner.nextInt();
	
	boolean isTrue = input1 % input2 == 0;
	
	System.out.printf("%d는 %d의 배수가 맞는가? %b", input1, input2, isTrue);
}


/**
 * 입력 받은 정수가 짝수인지 홀수인지 판별하기
 * <pre>
 * 정수 입력 : [입력값]
 * {입력값}은 짝수/홀수 입니다. 출력
 * </pre>
 */
public void method3() {
	//스캐너 객체 생성
	Scanner sc = new Scanner(System.in);
	System.out.print("정수 입력 : ");
	int input = sc.nextInt();
	
	//삼항 연산자 : 조건식 ? 참 : 거짓
	boolean isTrue = input %2 ==0;
	String result = isTrue ? "짝수" : "홀수"; //짝수면 짝수를 result에 대입
	System.out.printf("%d은/는 %s 입니다.", input, result);
}

/** [홀짝 검사기 Version2]
 * <p>
 * 입력 받은 정수가 홀수 또는 짝수 또는 0인지 판별하기
 * </p>
 * <pre>
 * 정수 입력 : 0 
 * 0 입니다.
 * 
 * 정수 입력 : 4
 * 짝수 입니다.
 * 
 * 정수 입력 : 7
 * 홀수 입니다.
 * </pre>
 */
public void method4() {
	//Scanner 객체 생성
	Scanner sc = new Scanner(System.in);
	//입력받기
	System.out.print("정수 입력 : ");
	
	int input = sc.nextInt();
	
//	String result = input ==0 ? "0" : (input%2==0 ? "짝수" : "홀수");
//	System.out.printf("%d은/는 %s입니다.", input, result ); 이렇게 해도 되고 아래처럼 하나씩 해도 됨
	boolean isZero = input ==0; //0인지 검사해서 맞으면 true, 다르면 false 저장
	boolean isTrue = input%2==0; //짝수 맞으면 ture 저장
	String result1 = isZero ? "0" : (isTrue ? "짝수" : "홀수"); 
	
	System.out.println(result1 +"입니다");
}
//제어문-조건문(if, switch), 반복문(for, while, do while), 분기문(break, continue)
//for 반복문 해석 순서
//1-2-3-4-(2-3-4)-(2-3-4) false나올때까지 반복
//초기식은 맨 처음에만 읽음
//초기식에 변수 하나뿐 아니라 여러개도 넣을 수 있음
//for :끝이 정해진 경우에 사용
//while : 끝이 정해지지 않은 경우(기약은 없고 종료되는 조건만 있음, 언제 끝날지는 모름)에 사용
//do while : 





}
