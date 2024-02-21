package 프로그래밍언어응용재시험;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class answersheet { // 20240221재시험
//	무한히 반복하며 입력 받은 이름을 List에 저장하는 코드를 작성하였으나 오류 발생 및 정상 수행되지 않았다.
//	요구사항과 소스 코드를 분석하여 원인(문제점 + 발생 원인), 조치 내용(해결 방법)을 작성하시오.
//
//	* 요구 사항
//
//	1. 이름 입력 시 "exit"가 입력되면 반복을 종료 후 목록에 저장된 모든 이름 출력
//
//	2. 이름 입력 시 "clear"가 입력되면 목록에 저장된 모든 이름 삭제
//
//	3. 입력된 이름이 이미 목록에 존재하면 "이미 존재하는 이름입니다" 출력 및 추가X
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	List<String> nameList = new ArrayList<String>();
	while(true) {
		System.out.print("추가할 이름을 입력하세요 : ");
		String name=sc.next();
		
		if(name.equals( "clear")) { //********
			
			System.out.println("이름 목록을 초기화 합니다.");
			nameList.clear();
			continue; //**********
		}
		if(name.equals("exit")) {//******
			System.out.println("<<입력 종료>>");
			break; //break; //**********
			
		}
		
		if(nameList.contains(name)) {
			System.out.println("<이미 존재하는 이름입니다>");
		} else {
			nameList.add(name); //*******
			System.out.println(name+" 추가 완료.");
		}
	}
	for(String name : nameList) {
		System.out.println(name);
	}
	
}
}
