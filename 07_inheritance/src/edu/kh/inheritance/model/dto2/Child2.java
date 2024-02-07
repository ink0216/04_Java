package edu.kh.inheritance.model.dto2;

import edu.kh.inheritance.model.dto.Parent;

//final 클래스 -> 상속 불가 ->상속이 안되므로 오버라이딩도 안됨
//						-> 제공되는 클래스 그대로 사용해야 하는 경우
//							-> ex) String
//final 메서드 : 상속은 되지만(Child1을 GrandChild1으로 상속했음) 오버라이딩이 안됨

public final class Child2 extends Parent {
	//집 나간 자식
	//얘도 부모(다른패키지에 존재하므로 import 해야 함) 상속받도록 만들기
	//Parent가 가지던 접근제한자(public, protected, default, private) 중 public, protected만 쓸 수 있음
	//자식만 가지고 있는 것 만들기
	private String smartPhone;
	//첫째는 컴퓨터 가지고 있었는데 얘는 스마트폰 가지고 있음
	
	//생성자
	public Child2() {
		//안에 부모객체 만들어야 함
		super();
		//super(); 생성자 미작성 시 컴파일러가 super();구문을 자동으로 추가해줌
		//상속 받았으면 부모 객체 만들어야 할 것 아니냐!
		System.out.println("Child2 기본 생성자");
	}
	//매개변수 생성자(매개변수로 부모 필드 + 자식 필드 것 모두 받아오기)
	//스마트폰만 초기화하는 것이 아니라 부모의 값도 한번에 다른 것으로 초기화
	public Child2(String lastName, String address, int money, 
			String car, String smartPhone) {
		//전달 받은 매개 변수 5개 중 4개는 
		//Child2 내부에 생성된 Parent 객체에 초기화 되어야 하는 값들이다.
		// -> 부모(Parent)의 매개변수 생성자를 호출하자
		//부모님 이름 부르지 않고 super로 부름
		super(lastName, address, money, car); //그러면 부모부분이 만들어지면서 초기화됨
		this.smartPhone=smartPhone; //전달 받은 스마트폰 값을 대입
		System.out.println("Child2 매개변수 생성자로 객체 생성");
	}
	public String getSmartPhone() {
		return smartPhone;
	}
	public void setSmartPhone(String smartPhone) {
		this.smartPhone = smartPhone;
	}
	public String informChild2() {
		return inform()+" / "+smartPhone; // 코드 길이 많이 짧아짐 
		//부모로부터 상속 받았으므로 부모의 메서드를 자기 것처럼 사용 가능
		//앞의 네개는 자식 것이 아닌 부모것임
		//Parent inform메서드 + 자식 필드 내용
		//	->중복되는 코드를 제거해서 코드 길이를 감소시킴
		//	==코드 재사용성 증가
	}
	//부모로부터 상속받은 introduce()메서드 오버라이딩(재정의)하기
	//+ 오버라이딩 코드를 잘 작성하고 있는지 컴파일러에게 검사해달라고 하기(@Override)
	// @ == Annotation(어노테이션)
	@Override
public /*int*/ String introduce/*123*/() {
		//The return type is incompatible with Parent.introduce()
		//Parent의 introduce와 리턴 타입이 서로 용납하지 않는다
		//반환형을 int로 잘못 쓰니까 부모 코드랑 다르다고 오류 발생
		return "Child2 입니다." + super.introduce(); //이거 하니까 이제 Parent입니다 안나오고 Child2라고 나옴
		//return "Child2 입니다." + introduce(); 
		//앞에 super.을 안쓰고 실행하면 introduce가 부모 것이 실행될 줄 알았는데 자식 것이 실행되고 오류남
		//super : this(나)의 부모를 참조하는 변수
		//super쓰면 오버라이딩 전에 있던 부모 코드도 쓸 수 있다
		
	}
	//toString() 오버라이딩
	@Override
	public String toString() {
		return super.toString()+"\nChild2 :"+smartPhone;
	}
	
}
