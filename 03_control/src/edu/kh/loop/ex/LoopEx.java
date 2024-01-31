package edu.kh.loop.ex;
//반복문(loop)

import java.util.Scanner;

public class LoopEx {
	//필드(객체의 속성 ==변수 선언하는 부분)
	//스캐너는 java.util이라는 패키지에 존재하므로 수입 필요
	
	//스캐너 객체 생성
	//System.in == 키보드
	Scanner sc = new Scanner(System.in);
/**
 * 1부터 10까지 출력하기
 */
public void method1() {
	//자바에는 let이라는 것 없음 -> int쓰기
	for(int i=1 ; i<11 ; i++) {
		System.out.println(i);
	}
}
/**
 * 첫 번째 입력받은 수 부터
 * 두 번째 입력받은 수 까지
 * 1씩 증가하며 출력하기
 */
public void method2() {
	System.out.print("입력 1 2 :");
	int input1 = sc.nextInt(); //첫 번째 입력 들어감
	int input2 = sc.nextInt(); //두 번째 입력 들어감
	for(int i=input1 ; i<=input2 ; i++) {
		System.out.println(i);
	}
}
/**
 * 10부터 1까지 1씩 감소하며 출력하기
 */
public void method3() {
	for(int i=10 ; i>0 ; i--) {
		System.out.println(i);
	}
}
/**
 * 두 수를 입력받아서 반복 출력하는 구문 작성
 * 첫 번째 입력=A, 두 번째 입력=B
 * 조건 1 : B가 A보다 큰 경우 -> A에서 B까지 1씩 증가하며 출력
 * 조건 2 : A가 B보다 큰 경우 -> A에서 B까지 1씩 감소하며 출력
 * 조건 3 : A와 B가 같은 경우 -> "같은 수 입력됨" 출력
 */
public void method4() {
	System.out.print("입력(1, 2)");
	int a = sc.nextInt(); //A
	int b = sc.nextInt(); //B
//	변수명 대문자는 그 변수가 상수일때만 사용
	
	//요즘에는 if else if else 로 안함
	//가장 먼저 하나 골라낼 수 있으면 그거부터 골라내기
	if(a==b) {
		System.out.println("같은 수 입력됨");
		return; //현재 메서드 종료 후 호출한 곳으로 돌아감
	}
	if(a<b) {
		for(int i =a ; i<=b ; i++) {
			System.out.println(i);
		}
	} else {
		//a가 b보다 큰 경우
		for(int i=a ; i>=b ; i--) {
			System.out.println(i);
		}
	}
	
}

/**
 * 두 수를 입력 받아 1씩 증가하며 반복 출력하기
 * 첫 번째 입력=A, 두 번째 입력=B
 * 입력 받은 두 수 중 작은 값이 초기식, 큰 값이 조건식에 사용되게 작성
 * 두 수의 크기가 같은 경우, 초기식=A, 조건식=B 써라
 */
public void method5() {
	System.out.print("입력(1,2) :");
	int a = sc.nextInt();
	int b = sc.nextInt();
	if(a<=b) {
		for(int i=a; i<=b; i++) System.out.println(i);
	} else {
		for(int i=b; i<=a; i++) System.out.println(i);
	}
	
}
/**
 * for문을 한 번만 사용해서 구현하기(최대,최소 이용)
 */
public void method5a() {
	System.out.print("입력(1,2) :");
	int a = sc.nextInt();
	int b = sc.nextInt();
	int min;
	int max;
	if(a<=b) {
		min=a;
		max=b;
	} else {
		min=b;
		max=a;
	}
	for(int i=min ; i<=max; i++) System.out.println(i);
}

/**
 * 버전 2 (Math이용) (Java API(자바에서 만들어서 제공하는 기능)을 이용한 방법)
 */
public void method5b() {
	System.out.print("입력(1,2) :");
	int a = sc.nextInt();
	int b = sc.nextInt();
	int min=Math.min(a, b); //Math.min( , ) : a, b중 작은 값을 반환하는 메서드
	int max=Math.max(a, b); //두 수 중 큰 값을 반환하는 메서드
	for(int i=min ; i<=max ; i++) {
		System.out.println(i);
	}
	
}
/**
 * 변수 값 교환(swap : 서로 바꿈)
 */
public void method5c() { //이거 왜안됨!!!!!!!!!!!!!!!!!!!!!!!!!!
	System.out.print("입력(1,2) :");
	int a = sc.nextInt();
	int b = sc.nextInt();
	if(a>b) {
		//swap하는 코드
		//동시에 주고받기 못함
		int temp = a; //temp에다가 a값 복사해놓고
		a=b; //a에 b값 넣기
		b=temp; //b에 복사해둔 a값 다시 넣기
		
	}
	for(int i=a; i<=b; i++) System.out.println(i);



}
/**
 * 1부터 100 사이 7의 배수의 개수 세기
 */
public void method6() { //이거 왜안됨!!!!!!!!!!!!!!!!!!!!!!!!!!
	int count =0;
	for(int i=1 ; i<=100 ; i++) {
		if(i%7==0) count++; //i가 7의 배수일 때 count값을 1씩 증가시킨다
	}
	System.out.println("count :" +count);
}

/**
 * 1부터 100 사이 7의 배수의 개수 세기
 */
public void method6a() {
	int count =0;
	for(int i=7 ; i<=100 ; i+=7) count++;
	//알아서 7의 배수에서만 반복
	System.out.println(count);
}
/**
 * 1부터 100사이 정수 중
 * 3의 배수의 개수와,
 * 3의 배수를 제외한 수들의 합, 두 가지를 출력
 */
public void method7() {
	int count=0;
	int sum=0;
	for(int i=1 ; i<=100 ; i++) {
		if(i%3==0) count++;
		else			sum+=i; //3의 배수 아니면 sum에 누적해라
	}
	System.out.println("count :" +count);
	System.out.println("sum :" +sum);
	
}
/**
 * <pre>
 * 구구단 5단 출력하기
 * 5 x 1 =  5 (한 자리면 오른쪽 정렬)
 * 5 x 2 = 10
 *  ...
 * 5 x 9 = 45
 * </pre>
 */
public void method8() {
	for(int i=1 ; i<=9 ; i++) {
		System.out.printf("5 X %d = %2d \n", i, 5*i);
		}
}










}
