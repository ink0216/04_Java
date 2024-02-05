package edu.kh.oop.method;

public class Student {
//학생 객체 셋 정도 만들어서 활용하기
	
	
	
	//필드 작성(학생이라면 가져야 하는)
	//모든 학생들이 공통적으로 쓸 수 있는 필드
	public static String schoolName="KH대학교";
	//final int  : int형 상수
	//누구든지 쓸 수 있는데 바뀌면 안되는 값
	public static final int MIN_VALUE =0; //스킬 역량 최소치
	public static final int MAX_VALUE =100; //스킬 역량 최대치
	//int형 상수
	
	private String name; //이름
	private String studentNumber; //학번
	private char gender; //성별
	private int java; //그 사람의 자바 스킬 역량을 수치화
	private int html; //그 사람의 html 스킬 역량을 수치화
	
	//생성자 작성 
	public Student() {
		//기본 생성자 이걸로는 아무것도 안할 거임
	}
	
	//매개변수 생성자
	public Student(String name, String studentNumber, char gender) {
		//매개변수 타입, 순서, 개수 등이 다르면 같은 이름이어도 사용 가능
		// == 오버로딩 적용
		this.name = name;
		this.studentNumber = studentNumber;
		this.gender = gender;
	}
	
	
	
	
	
	
	
	//메서드 작성(학생이라면 가져야 하는)
	//static이 안들어가있는 private를 이용하기 위해 getter,setter 만들어 간접접근
	
	//setter 만들기
	public void setName(String name) {
	//void : 반환하는 것 없음
		this.name=name;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber=studentNumber;
	}
	public void setGender(char gender) {
		this.gender=gender;
	}
	public void setJava(int java) {
		this.java=java;
	}
	public void setHtml(int html) {
		this.html=html;
	}
	//메서드 만들 때 잘 모르겠으면 일단 public void쓰기 그리고 setter는 set으로 시작, getter는 get으로 시작
	//getter 만들기 : 매개변수 없어야 하고 반환형, return써야함
	//이 객체에 있는 것 외부에서 가져갈 수 있도록 해주는 기능
	public String getName() {
		//void : 반환하는 것 없음
		return name;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public char getGender() {
		return gender;
	}
	public int getJava() {
		return java;
	}
	public int getHtml() {
		return html;
	}
	
	
	
	
}
