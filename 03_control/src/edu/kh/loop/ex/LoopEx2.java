package edu.kh.loop.ex;

import java.util.Scanner;

/**
 * 중첩 반복문
 */
public class LoopEx2 {
	Scanner sc = new Scanner(System.in);
	/**
	 * <pre>
	 * 다음 모양 출력하기
	 * 1234
	 * 1234
	 * 1234 
	 * </pre>
	 */
	public void method1() { 
		for(int j=3; j>=1 ;j--) {//세 번 반복하기만 하면 되므로 거꾸로 해도 됨
			for(int i=1; i<=4 ;i++) {
				System.out.print(i);//줄 안바꾸므로 1234쭉 출력됨
			}
		 System.out.println(); //줄바꿈
		}
	}
	/**<pre>
	 * 다음 모양 출력하기
	 * 4321
	 * 4321
	 * </pre>
	 */
	public void method2() {
		for(int i=1 ; i<=2 ;i++) {
			for(int j=4 ;j>=1 ;j--) {
				System.out.print(j);
			}
			System.out.println(); //줄바꿈
		}
	}
/**
 * <pre>
 * 다음 모양 출력하기
 * (0,0) (0,1) (0,2)
 * (1,0) (1,1) (1,2)
 * (2,0) (2,1) (2,2)
 * </pre>
 * 
 */
public void method3() { //세로 0,1,2 출력
	for(int j=0 ; j<3 ; j++) {
	for(int i=0 ; i<3 ;i++) {
		//가로 0,1,2 출력
		System.out.printf("(%d,%d)", j, i);
	}
	System.out.println(); //줄바꿈
	}
}
/**<pre>
 * 다음 모양 출력하기
 * (2,2) (2,1) (2,0)
 * (1,2) (1,1) (1,0)
 * (0,2) (0,1) (0,0)
 * </pre>
 */
public void method4() {
	for(int j=2 ; j>=0 ; j--) {
		for(int i=2 ; i>=0 ; i--) {
			System.out.printf("(%d,%d)", j, i);
		}
		System.out.println(); //줄바꿈
	}
}
/**
 * <pre>
 * 2단부터 9단까지 모두 출력하기
 * 2X1=2	2x2=4	.. 2x9=18
 * 3X1=3	3x2=6	.. 3x9=27
 *   ...
 * 9X1=9	9x2=18	.. 9x9=81
 * </pre>
 */
public void method5() {
	for(int j=2 ; j<=9 ; j++) {
		for(int i=1 ; i<=9 ; i++) {
			System.out.printf("   %dx%d=%2d", j,i, j*i);
		}
		System.out.println();// 줄바꿈
	}
}
/**
 * <pre>
 * 입력 받은 단 부터 9단까지 구구단 출력하기
 * 단, 입력 값이 2~9 사이가 아니면 "잘못 입력" 출력
 * ex) 단 입력 (2~9 사이) : 7
 * =======7단=======
 * 7x1=7
 * 7x2=14
 * ...
 * 7x9=63
 * =======8단=======
 * ...
 * =======9단=======
 * </pre>
 */
public void method6() {
	
	System.out.print("단 입력 :");
	int input = sc.nextInt();
	if(input<2 ||input>9) {
		System.out.println("잘못 입력");
		return; //뒤에 내용 안가고 바로 나갈거야
	}
	for(int i=input ; i<=9 ; i++) {
		System.out.printf("====%d단==== \n", i);
		for(int j=1; j<=9 ; j++) {
			
			System.out.printf("  %dx%d=%2d \n", i, j, i*j);
		}
	}
	
	
}

/**
 * 다음 모양 출력하기
 * <pre>
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * </pre>
 */
public void method7() {
	int count =1;
	for(int row=0; row<3 ; row++) { //3행 반복
		for(int col=0; col<3 ; col++) { //3열 반복
			System.out.print(count++ + " "); //카운트를 출력하고나서 1증가 그 뒤엔 띄어쓰기
			
		}
		System.out.println(); //줄바꿈
	}

}
/**
 * <pre>
 * ****
 * ****
 * ****
 * **** 출력하기
 * </pre>
 */
public void method8() {
	for(int i=1; i<5; i++) {
		for(int j=1; j<5 ;j++) {
			System.out.print("*");
		}
		System.out.println();//줄바꿈
	}
}
/**
 * <pre>
 * *
 * **
 * ***
 * **** 출력하기
 * </pre>
 */
public void method9() {
	for(int i=1 ; i<5; i++) {
		for(int j=1; j<=i; j++) {
			System.out.print("*");
		}
		System.out.println(); //줄바꿈
	}
}
/**
 * <pre>
 * 위에있는거 상하 뒤집기
 * </pre>
 */
public void method10() {
	for(int i=4 ; i>=1; i--) {
		for(int j=1; j<=i; j++) {
			System.out.print("*");
		}
		System.out.println(); //줄바꿈
	}
}
}
