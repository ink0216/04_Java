package edu.kh.inheritance.model.dto;
//상속받기 : 부모의 코드를 물려받아 자식이 자신의 코드처럼 사용하는 것
//상속 키워드 : extends (확장하다) ->부모 코드를 자식이 물려받아 자식의 전체 크기가 확장됨

public class Child1 extends Parent{
	//부모와 같은 집에 사는 자식
	//너를 부모 코드를 이용해서 확장시키겠다
	
	//자식만이 가지고 있는 것 만들기
	//필드
	private String computer; //컴퓨터 가지고 있음
	
	//기본 생성자
	public Child1() {
		/*super() : super 생성자/ 부모 생성자*/
		//역할 : -자식 객체 생성 시 부모 생성자를 호출하는 생성자
		//			- 부모 부분이 자식 안에 생성되는거 해주는 애 
		//			-super() 생성자는 항상 자식 생성자 첫 번째 줄에 작성해야 한다.
		//				-두 번째 줄에 쓰면 오류남
		super();  //자식 객체 생성될 때 그 안에 부모 객체도 만들라는 구문
		System.out.println("Child1 기본 생성자로 생성");
	}
	//매개변수 생성자
	public Child1(String computer) {
		super("김", "경기도 부천시", 3000, "티코");//과연 매개변수로도 호출 가능할까?
		//매개변수 생성자로 super생성자 이용해서 부모의 매개변수 생성자 호출 가능? 가능가능!
		this.computer=computer;
		System.out.println("Child1 매개변수 생성자로 생성");
	}
	//alt+[shift]+s ->r : getter/setter 자동완성
	
	public String getComputer() {
		return computer;
	}

	public void setComputer(String computer) {
		this.computer = computer;
	}
	
	public String informChild1() {
		//Child1의 필드 + 물려받은 필드 문자열로 만들어 반환
		//진짜 물려 받았을까?
		return String.format("%s / %s / %d / %s / %s",
				lastName, address, getMoney(), getCar(), computer ); 
		//private붙은 것은 상속은 되지만 그냥 money는 안되고 열쇠로 열어야 함 getMoney()
		
	}
	//부모로부터 상속받은 introduce()메서드를 
	//오버라이딩(재정의)하기
	public String introduce() {
		//자기소개
		return "Child1 입니다.";
	}
	//Object ->Parent 오버라이딩 한 toString()을 물려받고
	//자식에서 또 오버라이딩 하기(원하는 만큼 계속 할 수 있음)
	@Override
	public String toString() {
		return super.toString()+"\nChild1.toString() :" +computer;
		//super.toString() == Parent.toString()
		//이 부분은 오버라이딩 한 것 말고 부모님 것을 쓰고 싶다
		//오버라이딩 조건 : 메서드 선언부는 같아야 하고 중괄호 안의 코드 내용만 달라야 함
		//오버로딩 : 같은 이름의 메서드를 여러 개 쓰는 것(매개변수의 구성이 다르면 사용 가능)
		
	}
	
}
