package edu.kh.inheritance.model.dto;
//상속 계층 구조

//Object
//ㄴParent
//ㄴChild1
// ㄴGrandChild1
//Object의 것을 GrandChild1이 쓸 수 있음(대대로 물려줌)

public class GrandChild1 extends Child1{
//grandchild == 손주
	//이름 바꾸기 f2 or 우클릭-refactor-rename
	
	//final 메서드 확인(==오버라이딩이 불가함을 확인해보기)
	
//	@Override
//	public void onlyChild1() {
//		//Cannot override the final method from Child1
//		//Child1의 final method는 오버라이드(재정의) 할 수 없다.
//	}
}
