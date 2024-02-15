package edu.kh.io.pack3.model.dto;

import java.io.Serializable;

//직렬화(Serializable) : 객체를 직선 형태로 길게 변형시키기

//직렬화 방법 => Serializable 인터페이스를 상속만 받으면 끝!

//Serializable 인터페이스 : 추상 메서드가 하나도 없는 인터페이스여서 오버라이딩 필수로 안해도 됨
//													상속만 받아도 입/출력 시 직렬화가 가능하다는 의미만 제공하는 것!
//													(이 객체는 생성되면 출력될 때 필요하면 직렬화할 수 있어! 알려만 줌)
//													(스트림에 들어갈 때 짜부러져서 직선 형태로 들어가야 해 하고 알려줌(마크))
//				->이런 인터페이스들 == 마커 인터페이스

// serialVersionUID : 직렬화 식별 번호
//				->직렬화/역직렬화 시 같은 객체가 맞는지 확인하는 식별 번호
//					별도로 작성하지 않으면 JVM이 알아서 지정해주니까 지금은 신경 안써도 됨!
public class Member implements Serializable{
	
	//필드
	private String id;
	private String pw;
	private String name;
	private int age;
	
	//기본 생성자(객체 생성 시 필드 초기화 + 기능 수행)
	public Member() {}
	
	//매개변수 생성자
	public Member(String id, String pw, String name, int age) {
		//멤버 객체 생성될 때 필드 초기화
		super(); //부모 생성자 호출 (Object)
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
	}
	
	//캡슐화로 인해서 직접접근이 차단돼있어서
	//getter / setter(필드 간접 접근 방법)

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	//Object.toString() 오버라이딩
	//오버라이딩 == 부모로부터 상속받은 메서드를 자식이 재정의하는 것
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	

}
