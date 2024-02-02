package edu.kh.oop.field.pack1;

public class FieldTest1 {
//필드(Field)
	//-객체의 속성을 나타냄
	//- 필드 == 멤버 변수 (같은 말임!)
	// 필드가 또 두 종류로 나눠짐
	//*[작성법]*
	// [접근제한자][예약어] 자료형 변수명[=초기값];
	
	//접근 제한자별 필드 선언+초기화
	//모든 접근제한자 다 써보겠따
	public int publicValue=10;
	protected int protectedValue=20;
	int defaultValue=30; //default는 앞에 아무것도 안적음
	private int privateValue=40;
	
	public void method1() {
		System.out.println(publicValue); //오류 안남 public은 누구나 쓸 수 있어서
		System.out.println(protectedValue); //오류 안남 같은 패키지 내에서 쓸 수 있어서
		System.out.println(defaultValue); //오류 안남 같은 패키지 내에서 쓸 수 있어서
		System.out.println(privateValue); 
		//여기서는 같은 클래스 내부이므로 네 가지의 접근제한자 모두 오류 안남
		//모든 접근 제한자가 같은 클래스 내부에 접근 가능하기 때문에 오류 없음
		
		
	}
}
