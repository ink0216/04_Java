package edu.kh.oarr.run;

import edu.kh.oarr.view.StudentView;

//자바 프로그램 실행용 클래스
public class StudentRun {
public static void main(String[] args) {
	new StudentView().displayMenu(); 
	//실행 시 StudentView객체 만들고 displayMenu()의 메서드 호출
  //displayMenu()끝나면 메인 메서드도 끝나서 프로그램 종료됨
}
}
