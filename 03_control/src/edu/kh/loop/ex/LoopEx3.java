package edu.kh.loop.ex;

import java.util.Scanner;

public class LoopEx3 {
	//필드에 스캐너 만들기
	Scanner sc=new Scanner(System.in);
/**
 * 문자열 한 글자씩 출력하기
 */
public void method1() {
	String str="Hello World!!!!";
	//int length =str.length(); //미리 문자열의 길이를 한 번 세어놓기
	//													->뒤에서 계속 새로 안 세고 가져다 쓰기
	//													-> 뒤에서 str.length()구문을 재호출할 필요가 없어짐
	//문자열.charAt(인덱스) : 문자열의 인덱스번째 문자 하나를 얻어와 반환
	//JS에서 문자열(String)의 길이 얻어오기 : 문자열.length
	
	//자바에서는 문자열.length() (String일 때에만 소괄호 붙임)
	//배열의 길이 얻어오는건 자바에서도 ()안붙임 arr.length
	int a=10, b=20, c=30; //이렇게 한꺼번에 선언 가능한데 비추
	for(int i=0, length=str.length(); i<length ; i++) {
		//이 for문 안에서 쓸 것을 두개를 만듦
		//초기식, 증감식은 여러 개를 선언할 수 있다
		//
		//for문 해석 순서 : 초기식->(조건식->중괄호 안->증감식)
		//2번 과정을 갈때마다 str.length()값 얻어오는건 비효율적!! 효율적으로 하려면?
		//																							->앞에 length라는 것으로 미리 세두기
		System.out.println(str.charAt(i));
	}
}
/**<pre>
 * while문(반복의 끝이 정해지지 않은 반복문)
 * -1이 입력될 때까지 정수를 계속 입력 받아
 * 입력받은 수의 누적된 합계를 구하기
 * </pre>
 */
public void method2() {
	int sum=0; //합계 누적용 변수
	int input=0; //입력값을 저장할 변수
	while(input!=-1) {
		//입력값이 -1이 아닐 때 반복
		//입력값이 -1이면 반복을 멈추라는 뜻
		System.out.print("정수 입력 :");
		input=sc.nextInt();
		if(input !=-1) sum+=input; //-1까지 더해지지 않도록
	}
	System.out.println("합계 :"+sum);
}

//do ~while문
// -조건식이 뒤에 작성된 while문
// -최소 1회 이상의 반복을 보장(반드시 최소1번은 반복을 한다)
/**
 * 0이 입력될 때까지 정수를 계속 입력 받고
 * 0 입력 시 그동안 누적된 합계 출력하기
 */
public void method3() {
	int sum=0; //합계 누적용 변수
	int input=0; //입력값을 저장할 변수 //0으로 쓰면 while문을 돌지 않음
	 do{
		System.out.print("정수 입력 :");
		input = sc.nextInt(); //위에 아무 숫자 넣어놨던 것이 여기서 입력값으로 덮어씌워짐
		sum+=input;
	}while(input !=0);
	 //do while구문 : input이 0이었을때 while문의 순서 바꾸기 전에는 입력을 한번도 못했지만
	 //do while구문을 쓰면 한번은 입력할 수 있음
	System.out.println("합계 :"+sum); 
}
/**
 * 0이 입력될 때까지 정수를 계속 입력 받고
 * 0 입력 시 그동안 누적된 합계 출력하기
 */
public void method4() {
	int sum=0;
	int input=0;
	
	while(true) {
		//true를 쓰면 끝나지 않는 무한 반복이 됨 ->이거 쓰면 아래의 코드들이 오류 남
		System.out.print("정수 입력 :");
		input = sc.nextInt();
		if(input ==0) break; // reachable하게 하려고 0을 입력하면 반복을 멈추는 구멍 엶
		sum+=input;
	}
	
	
	System.out.println("합계 :"+sum);
	//Unreachable code == dead code : 도달할 수 없는 코드, 죽은 코드
}


/*배열(Array)
 * JVM 메모리 구조
 * Static : static
 * Heap : new
 * Stack : 지역변수, 매개변수
 * 
 * 배열의 변수 한칸
 * int[] arr =new int[3]; : int[]만 저장할 수 있는 arr에 
 *Heap이라는 영역에 새로 int로만 구성된 세칸짜리 배열을 만듦
 *Heap의 세 칸의 한칸한칸의 자료형은 모두 int임 ->각각 0,1,2 인덱스 부여됨
 *세칸을 통째로 묶은 것의 자료형은 int가 아닌 int배열(int[] 자료형)
 *
 *0x300(배열의 시작 주소)가 할당됨
 *세 칸짜리를 한 칸 짜리에 대입할 수 없으므로 세 칸짜리의 "주소"가 한 칸짜리에 들어감
 *이 주소를 "참조"하고 있다 
 *arr[0], arr[1], ... arr이 참조하고 있는 곳의 몇 번 인덱스
 *arr은 값을 저장하는 것이 아닌 "주소"를 저장하는 "참조형 변수"
 *
 *자바의 자료형 총 9개 : 기본자료형 8개 +참조형
 *
 *자바에서 가장 중요 : 참조, 객체
 *
 * 배열은 Stack에 한 칸으로 저장되고 그 배열의 인덱스 변수들은 Heap에 한칸씩 저장됨
 * 배열의 자료형은 int가 아닌 int[] 임 
 * new 연산자 : Heap메모리 영역에 새로운 공간(배열, 객체가 사용하는 공간)을 할당함 
 * * Heap메모리 영역 내에서는 변수 또는 할당된 요소들이 빈칸으로 존재할 수 없음
 * 세입자 들어오기 전까지 공실로 있을 수 없어서 
 * 별도의 초기화 내용이 없을 경우 각 자료형의 기본값으로 초기화 된다.!!!!!
 * 배열과 for문은 친함 for문의 i = index
 * 배열 선언과 동시에 초기화시, JS에서는 []사용했지만 자바에서는 {}사용!!!!!!!!!!!
 * [기본값]
 * 숫자 : 0
 * 
 * */












}
