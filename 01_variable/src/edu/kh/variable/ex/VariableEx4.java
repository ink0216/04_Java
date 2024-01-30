package edu.kh.variable.ex;

public class VariableEx4 {
	//메인 메서드 : 자바 프로그램 실행용 구문(기능)
public static void main(String[] args) {
	//상수 : 한 번 값을 기록하면 값을 바꿀 수 없는 변수
	//상수 키워드 : final == 처음이자 마지막으로 수 대입(그 후에는 값 변경 불가)
	//상수명 작성 원칙 : 대문자 작성, 연결되는 단어 사이는 "_"로 구분
	//PI 처럼 절대 변하지 않는 수 넣을 때 사용
	final double PI = 3.1415926538; //원주율
	
	final int MIN = 0; //최소값은 0이야
	final int MAX = 100; // 최대값은 100이야
	System.out.println("최소값 :" +MIN);
	System.out.println("최대값 :" +MAX);
}
}
