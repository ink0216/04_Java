package edu.kh.oop.field.pack1;

public class FieldRun1 {
//얘는 같은 패키지에 있으니까 public, protected, default 세개만 됨
public static void main(String[] args) {
	//FieldTest1 객체 생성부터 해야 함
	FieldTest1 f1 = new FieldTest1(); 
	//heap에 FieldTest1객체 만든 다음에 만들어진 객체의 주소를 f1 참조형 변수에 대입한다
	System.out.println(f1.publicValue); //f1이 참조하고 있는 객체의 publicValue를 출력 ->어디서든지 접근가능 
	System.out.println(f1.protectedValue); //f1이 참조하고 있는 객체의 protectedValue를 출력 ->접근가능 
	System.out.println(f1.defaultValue); //f1이 참조하고 있는 객체의 defaultValue를 출력 ->접근가능
	//System.out.println(f1.privateValue); //private은 접근 불가! 
	//-> 같은 클래스 내에서만 접근 가능한데 다른 클래스에 있어서
	
	
}
}
