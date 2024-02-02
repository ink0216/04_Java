package edu.kh.oop.cls.pack1;

public class ClassTestRun {
public static void main(String[] args) {
	//ClassTest1 객체를 생성
	ClassTest1 t1 = new ClassTest1(); //같은 패키지 내이므로 문제 없음
	//가져와서 나 저 클래스 내용대로 객체 만들거야 해도 문제 없음
	t1.method1();
}
}
