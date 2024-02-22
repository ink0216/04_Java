package 프로그래밍언어응용재재시험;

import java.util.ArrayList;
import java.util.List;

public class answersheet {
//20240222재재시험
	/* int 자료형만 저장할 수 있는 List를 만들어 양수,음수,0을 임의로 저장한 후
	 * List에 저장된 값을 순서대로 꺼내어 양수, 음수, 0일때 출력되는 방법을 서로 다르게 지정하는 코드를 작성하였으나
	 * 오류 발생 및 정상 수행되지 않았다.
	 * 
	 * 요구사항
	 * - List에서 꺼낸 요소의 값이 양수 또는 음수이면 절대값의 크기만큼 반복하며 문자를 출력
	 * - 양수일 경우 '+', 음수일 경우 '-'
	 * - List에서 꺼낸 요소의 값이 0인 경우 "@@@@@@@@@@" 한 줄을 출력*/
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(); //*******
		list.add(4);
		list.add(-5);
		list.add(0);
		list.add(-3);
		list.add(2);
		list.add((int)1.23456);//******강제형변환
		for(int num : list) {
			char ch;
			if(num<0) { //********
				ch = '-';
			//int Math.abs(정수) : 정수의 절대값을 반환
				for(int i=0; i<Math.abs(num); i++) { //********
					System.out.print(ch);
				}
			} else if(num>0) {
				ch = '+';
			//int Math.abs(정수) : 정수의 절대값을 반환
				for(int i=0; i<Math.abs(num); i++) { //********
					System.out.print(ch);
				}
			} else {
				System.out.println("@@@@@@@@@@");
				continue;
			}
			
			System.out.println();
		}
	}
}
