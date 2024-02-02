package edu.kh.oop.method;

public class StudentRun {
public static void main(String[] args) {
	//메인 메서드
//	new StudentService(); //새롭게 heap에 StudentService 객체를 만든다
	//원래는 객체 생성해서 그 객체의 주소를 참조형 변수에 저장했었는데
	//생성된 StudentService 객체를 1회성으로 사용
	new StudentService().displayMenu(); //실행하면 메뉴가 화면에 출력
	//studentRun이 studentService를 실행하고studentService가 Student를 실행
}
}
