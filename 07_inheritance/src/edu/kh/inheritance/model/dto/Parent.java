package edu.kh.inheritance.model.dto;
//Object 클래스 //Object에 커서 올리고 shift +f2누르면 설명창 뜸
//모든 클래스의 최상위 부모 클래스
// -class 선언부에 상속 구문(extends)이 하나도 작성되지 않으면
//		컴파일러가 "extends Object" 구문을 추가해 줌(초월번역 해 줌)
//모든 클래스는 Object 클래스를 super class로 가지고 있음 - 실제로 존재함
//Child1과 Child2의 코드에서 추상화로 공통된 코드 뽑아내서 Parent에 저장하고 상속시키면 됨 
//Object클래스 : 모든 클래스들이 가져야하는 것들만 다 뽑아놓은 것
//equals(Object obj), hashCode() , toString()를 많이 사용
//toString() == inform() == 모든 필드의 내용을 문자열로 만들어줌
//Object 클래스가 가진 toString()을 Object를 상속받은 클래스들에서 오버라이딩해서 사용(자신들의 필드로 해서 사용)
public class Parent /*extends Object*/{ //아무것도 안적으면 컴파일러가 extends Object 추가해줌
	
	//부모 필드
	//퍼블릭 : 같은 프로젝트 내어디서나
	//protected : 같은 패키지 + 상속
	public String lastName = "홍"; //성 물려받음
	protected String address = "서울시 중구 남대문로 120";//집도 물려받음
	
	private int money = 100_000_000; //1억, _ : 자릿수 구분하도록 찍는 것 가능
	private String car = "그랜져";
	
	//기본 생성자 : 클래스 이름과 동일하게
	public Parent() {
		System.out.println("기본 생성자로 부모 객체 생성됨");
	}
	//매개 변수 생성자
	public Parent(String lastName, String address, int money, String car) {
		this.lastName=lastName;
		this.address=address;
		this.money=money;
		this.car=car;
		System.out.println("매개변수 생성자로 부모 객체 생성됨");
	}
	
	//public, protected는 외부에서 접근 가능하므로 
	//private에 대해서만 getter, setter 만들기
	//money의 getter/setter
	//getter : 외부에서 얻어갈 수 있게 해주는 것 -> 반환해줘야함->반환형 필요
	public int getMoney() {
		return money;
	}
	//setter : 외부에서 받아온 값으로 세팅함 ->매개변수 필요
	public void setMoney(int money) {
		this.money=money;
		//현재 객체의 money에 전달받은 money를 대입
	}
	//car의 getter/setter
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car=car;
	}
	
	//현재 객체의 필드를 문자열로 반환하는 메서드(toString말고 다른 방법)
	public String inform() {
		return String.format(" %s / %s / %d / %s ", lastName, address,money,car);
	}
	//공통된 규약(코드) 추가/수정
	public void testMethod() {
		System.out.println("부모에게 이 메서드 추가함");
	}
	/*Overriding(오버라이딩)*/
	//super 참조 변수 확인하기 (super 참조변수 !=super 생성자)
	//Over : 위에 있다, 넘어서다
	//riding : 타다
	//Overriding : 위에 올라탐 = 부모 코드 위에 자식 코드가 올라탐
	//							==덮어쓰기
	//부모로부터 상속받은 introduce메소드를 자식이 덮어씌움(자식 코드가 올라타서 부모로부터 받은 코드를 가림)
	//부모 메서드 위에 자식 메서드가 올라탐 -> 부모 메서드를 자식이 덮어씌움 
	//== 재정의(Overriding) == 틀은 그대로인데 내용만 바꿀게요
//	부모로부터 introduce() 상속받아서 Child1도 introduce()를 자기 것처럼 쓸 수 있는데
	//Parent입니다 라고 자기소개하면 안되니까 Child1입니다 라고 써야 함
	public String introduce() {
		//자기소개
		return "Parent 입니다.";
	}
	//[메서드에 대한 설명 적는 형식]
	//반환형 클래스명.메서드명()
	//String Object.toString()
	// - 객체의 필드를 문자열로 표현하기 위해서 사용하는 메서드
	// - Object 클래스에 정의된 toString()을 재정의(오버라이딩)해서 사용
	
	@Override //이거 같이 쓰는 게 좋음(컴파일러에게 검사해달라고 하기)
	public String toString()	{
		return String.format("Parent.toString() : %s / %s / %d / %s", lastName, address, money, car);
	}
	
	
	
	
	
	
}
