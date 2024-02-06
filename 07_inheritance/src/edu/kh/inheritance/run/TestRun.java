package edu.kh.inheritance.run;

import edu.kh.inheritance.model.dto.Child1;
import edu.kh.inheritance.model.dto.Parent;
import edu.kh.inheritance.model.dto2.Child2;

public class TestRun {
public static void main(String[] args) {
	//메인 메서드
	//부모 객체 Parent 생성
	//객체 생성 : 클래스를 보고 heap영역에 만들어라->주소 배정됨->그 주소를 저장할 참조변수 만들기
	//기본 생성자
	Parent p1= new Parent();
	
	//매개변수 생성자
	Parent p2= new Parent("김", "서울시 어딘가", 2000, "G80");
	System.out.println("-----------------------------------------");
	Child1 c1 = new Child1(); //기본생성자로 자식 객체 한명 만듦 
	//Child1 생성되었다는 것만 나와야할 것 같은데 왜 부모 객체 생성된것도 나왔을까
	
	//Child1 자식이 가지고 있는 기능
	c1.setComputer("삼성 갤럭시 북4");
	
	//Child1 내부에 생성된 Parent의 기능
	String str1 = c1.inform(); // 자동완성에 parent써져있으면 부모것이라는 뜻
	//이걸 str1에 저장하고
	System.out.println("str1 : "+ str1); //오류 안남->부모 것을 자기 것처럼 쓰고 있음
	
	//Child1 자식의 기능
	String str2 = c1.informChild1();
	System.out.println("str2 : "+ str2);
	
	System.out.println("---------------------------------------------------------");
	//Child1 매개 변수 생성자를 이용해서 객체 생성
	Child1 c2 = new Child1("2024 LG GRAM"); //매개변수 생성자 만듦?
	String str3 = c2.informChild1();	
	System.out.println("str3 : "+ str3);
	
	System.out.println("-----------------------------------------------------------");
	//Child2 객체 생성(매개변수 생성자 이용)
	Child2 c3 = new Child2("최", "서울시 강남구", 999_999_999, "벤츠", "아이폰15");
	//자식객체를 생성하면 그 전에 부모객체가 그 안에 먼저 생성되고 자식 객체가 생성됨
	String str4 = c3.informChild2(); //자식이 가지고 있는 기능을 호출하면 부모의 것이 실행됨
	System.out.println("str4 :"+ str4);
	
	System.out.println("==================================================================");
	System.out.println("==================================================================");
	System.out.println("==================================================================");
	System.out.println("[상속을 이용해서 공통된 규약 설정하기]\n");
	//Parent - Child1
	//				-Child2
	//Parent를 상속 받은 Child1, Child2는 서로 비슷한 모양을 띄게 된다.
	//(같은 부모를 상속 받았기 때문에)
	//형제는 존재하지 않고 부모-자식 관계만 존재
	//Parent에 코드를 추가하면 어떻게 될까?
	Child1 ch1 = new Child1();
	Child2 ch2 = new Child2();
	
	ch1.testMethod();
	ch2.testMethod();
	//부모에게 코드 추가해도 이미 상속 받아있는 모든 자식에게도 그 코드가 추가된다
	//부모의 코드를 수정하면, 그 부모에게서 상속받은 자식들의 코드도 다 수정됨
	
	//오버라이딩 확인하기(Parent-Child1)
	System.out.println("----- 오버라이딩 -----");
	System.out.println(ch1.introduce()); //Child1입니다
	System.out.println(ch2.introduce());//Parent입니다. //얘는 재정의 안하고 부모한테 받은거 그대로 씀(나중에 했음)
	//Parent도 무언가를 상속받고있음
	//Object가 모든 클래스의 최종 부모요소임
	
	System.out.println("----- toString()  오버라이딩 -----");
	System.out.println(p1.toString());
	System.out.println(ch1.toString());
	System.out.println(ch2.toString()); //Object에서 정의한 그대로 됨 클래스명-
	//오버라이딩 전
	//	edu.kh.inheritance.model.dto.Parent@67b64c45
	//	edu.kh.inheritance.model.dto.Child1@4411d970
	//	edu.kh.inheritance.model.dto2.Child2@6442b0a6
	
	//Parent에서 오버라이딩 후
	//->오버라이딩 된 Parent의 toString()을 Child1, Child2가 상속 받음
	//오버라이딩 된 것도 상속이 됨
	//	Parent.toString() : 홍 / 서울시 중구 남대문로 120 / 100000000 / 그랜져
	//	Parent.toString() : 홍 / 서울시 중구 남대문로 120 / 100000000 / 그랜져
	//	Parent.toString() : 홍 / 서울시 중구 남대문로 120 / 100000000 / 그랜져
	//Parent만 오버라이딩 했는데 자식들도 Parent를 상속했으니까 
	//오버라이딩 된 것을 부모님이 상속했는데 자식에서 그걸 또 재정의 할 수 있음
}
}
