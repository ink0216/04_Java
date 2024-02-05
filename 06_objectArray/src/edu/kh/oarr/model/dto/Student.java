package edu.kh.oarr.model.dto;
//DTO : Data Transfer Object (값 전달용 객체)
public class Student {
//MVC : model view controller 이 모양대로 하기
	//Run이 항상 앞에서 실행
	//Run - View - Service - DTO 순서대로 위의 탭 배열해두기
	//실행하면 View에서 보여짐
	private String studentNumber; //학번
	private String name; //이름
	private char gender; //성별
	
	private int html;
	private int css;
	private int js;
	private int java;
	
	//생성자
	//매개변수 생성자
	public Student(String studentNumber, String name, char gender) {
		//세 개만 전달돼서 오면 필드에 세팅하겠다
		//전달 받은 값을 현재 객체의 값에 세팅하겠다
		this.studentNumber = studentNumber;
		this.name = name;
		this.gender = gender;
	}
	
	//간접접근 getter, setter만들기
	
	//getter, setter 많이 써서 자동완성 기능 있음
	//alt + [shift] +s ->소스 열림 ->영어 r 누르면 generate getters and setters 열림
	//-> select all 클릭하고 generate누르기
	//studentNumber getter/setter
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	//name getter/setter
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}

	public int getCss() {
		return css;
	}

	public void setCss(int css) {
		this.css = css;
	}

	public int getJs() {
		return js;
	}

	public void setJs(int js) {
		this.js = js;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}
	/**
	 *객체.toString() : 객체의 필드를 하나의 문자열로 만들어서 반환
	 */
	public String toString() {
		return String.format("%s / %c / %s \n"
				+ "HTML : %d / CSS : %d / JS : %d / Java : %d", 
				studentNumber, gender, name, html, css, js, java);
		//문자열 패턴 만들어서 반환
		
		// 학번/성별/이름
		//HTML : 100 / CSS : 50 / JS : 70 / Java : 100
		//		두 줄짜리로 출력
	}
	
	
	
	

}
