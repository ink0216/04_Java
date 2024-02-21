package edu.kh.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/* 10회만 반복하며 List에 과일 이름을 추가하고, 
 * 반복이 종료되면 List에 저장된 모든 과일을 출력하는 코드를 작성하였으나 오류 발생 및 정상 수행되지 않았다.
 * 요구사항과 소스 코드를 분석하여 원인(문제점 + 발생 원인), 조치 내용(해결 방법)을 작성하시오.
 *
 * 요구 사항
 * 1. 같은 이름의 과일이 List에 존재하지 않을 때만 추가
 * 2. 같은 이름의 과일이 존재하면 "OOO - 삭제" 그 이름의 과일을 List에서 제거
 * 3. 10회가 반복되지 않았어도 "END" 입력 시 "입력 종료"가 출력 되면서 반복 종료
 * 문제점 7-8개 존재!!!
 */
public class Supplement1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<String> fruitsList = new ArrayList<String>(); //*****
		
		for(int i=1 ; i<11 ; i++) { //*******
			
			System.out.print(i+"번째 과일 입력 : ");
			String input = sc.next();
			//아래의 두 if문의 순서를 안바꾸면 END라는 값을 입력하면 중복되는 이름 없어서 리스트에 저장된 후 위로 올라감
			//그 후에 END를 한번 더 써야 중복되므로 중복검사 if문 실행 안되고 그제서야 반복문 종료하는 if문으로 가서 종료됨
			// ->순서바꾸기
			if(input.equals("END")){//*********
				System.out.println("입력 종료");
				break; //반복문 종료
			}
			if(!fruitsList.contains(input)) {
				//포함되지 않은 경우 
				fruitsList.add(input); //*******
				continue; //continue 해석 시 그 이후의 코드는 해석 안하고 for문의 다음 반복으로 넘어가므로
				//add코드가 continue 코드 뒤에 있으면 add코드가 unreachable 코드가 돼서 오류남->순서 바꾸기
				
			}
			
			
			
			int index = fruitsList.indexOf(input);
			//fruitsList에서 input와 같은 것을 찾아서 인덱스를 반환해서 제거
			fruitsList.remove(index);
			System.out.println(input + " - 삭제");
		}
		
		
		System.out.println("-----------------------");
		for(int i=0 ; i<fruitsList.size() ; i++) {//********
			//length : 배열에서 사용
			//list에 저장된 객체의 수를 얻어오는 size()로 고친다.
			System.out.println(fruitsList.get(i)); //*******
			//fruitList는 배열이 아닌 컬렉션이어서 [i]로 쓰면 안되고 get 써야 함
		}
		
	}
}
