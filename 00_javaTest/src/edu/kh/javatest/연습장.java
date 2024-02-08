package edu.kh.javatest;

import java.util.Arrays;
import java.util.Scanner;

public class 연습장 {
public void method1()	{
		// [보충 수업 문제] // 과일 바구니 만들기
		// 과일이름을 5개 담을 수 있는 배열을 생성하고
		// 과일 이름이 5개가 배열에 저장될 때 까지 반복 입력
		// 단, 중복되는 과일이 존재하는 경우 추가 X
		// 시작 인덱스 == 0
		// 끝   인덱스 == 4 (배열길이 - 1)
		String[] fruits = new String[5]; // 5칸 짜리 과일이름 저장 배열 생성
		Scanner sc = new Scanner(System.in);
		int index = 0; // 과일 이름이 대입될 인덱스를 지정하는 변수
		while(true) { // 무한 반복
			System.out.print("과일 이름 입력 >>> ");
			String name = sc.next(); // 문자열을 입력 받아 name에 저장
			// [중복 검사]
			// flag == true  : 같은 과일이 존재하지 않음 (중복 X)
			// flag == false : 같은 과일이 존재함        (중복 O)
			boolean flag = true;
			// 0번 인덱스 부터 index가 가리키는 곳 전까지
			// 입력 받은 name을 들고가서 fruits[i] 과 비교
			for(int i=0 ; i < index ; i++) {
				// 입력 받은 name과 fruits[i]번째의 값이 같을 경우
				// == 중복되는게 존재한다!
				if( fruits[i].equals(name) ) { 
					flag = false; // 존재한다는 신호로 변경!
					break; // 추가 검사 불필요 -> for문 종료
				}
			}
			// 중복 검사 결과
			// 중복되는 과일이 없다면 (flag == true)
			if(flag) {
				// fruits의 index번 인덱스에 name 저장
				fruits[index] = name;
				// index 1 증가
				index++;
			}
			// index가 5가 되었을 때 반복 종료
			// == 배열의 인덱스를 초과했을 때 반복 종료
			if(index == 5) {
				break; // while문 종료
			}
		}
		// 결과 출력
		System.out.println(Arrays.toString(fruits));
}
public void method2()	{
	Scanner sc = new Scanner(System.in);
	String str = sc.nextLine();
}
}
