package edu.kh.oop.field.pack2;

import edu.kh.oop.field.pack1.FieldTest1;

//다른패키지의 클래스
public class FieldRun2 extends FieldTest1{
	// 클래스 뒤에 extends FieldTest1 : 상속 구문
public static void main(String[] args) {
	//FieldTest1 객체 생성
	FieldTest1 f1 = new FieldTest1();
//	FieldTest1은 다른 패키지에 있으니까 import자동완성 해야함
	System.out.println(f1.publicValue);//public이니까 접근가능
	//이 이후부터 아무것도 안됨
//	System.out.println(f1.protectedValue);//같은 패키지 +후손(상속)일 때에만 가능한데 만족 안돼서 오류남
	//protectedValue 되게 하는 방법 : extends FieldTest1 : 상속 구문
	//System.out.println(f1.defaultValue); //default는 같은 패키지 내에서만 가능해서 오류남
	//System.out.println(f1.privateValue); //private은 같은 클래스 내에서만 가능해서 오류남
}
/**
 *protectedValue 되게 하는 방법 : 클래스 뒤에 extends FieldTest1 : 상속 구문
 */
public void method1() {
	System.out.println(protectedValue);//오류 안남
	//FieldRun2에 protectedValue선언한 게 안보이지만
	//FieldTest1이 부모가 돼서 FieldTest1의 코드가 다 FieldRun2(후손)에 들어오게 됨
	//다른 패키지이지만 상속 상태이기 때문에
	//protected 접근 제한자를 작성한 필드에 접근이 가능하다->API, 라이브러리 개발 때 많이 사용
	
}
}
