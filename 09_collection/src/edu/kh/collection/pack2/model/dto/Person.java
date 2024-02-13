package edu.kh.collection.pack2.model.dto;

import java.util.Objects;

public class Person {
private String name;
private int age;
private char gender;

//getter/setter
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
public char getGender() {
	return gender;
}
public void setGender(char gender) {
	this.gender = gender;
}
//toString
@Override
public String toString() {
	return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
}


public Person() {}
//생성자
public Person(String name, int age, char gender) {
	super();
	this.name = name;
	this.age = age;
	this.gender = gender;
}
//Set의 특징 : 순서 유지 안돼서 중복된 것을 저장 안함
//객체가 같다(동일, 동등)를 어떻게 비교할까??
// -동일 : 가리키고 있는 것이 같다( ex. 백동현    강사님)
// -동등 : 값이 같음(대리, 대리, 과장, 과장)

//자바에서는 동일/동등 비교가 따로 있는데 둘이 보통 같이 씀
//Object가 제공해줌

//동일 비교 : Object.hashCode() 메서드 오버라이딩해서 사용
//hash 함수 : 값을 넣으면 같은 길이의 문자열이 반환되는 함수
// ex. 123 -> qwerty
//				abcdefghi -> asdfg
//		(암호화에 많이 사용)

//hashCode() : 객체별로 식별 코드(객체를 구분하는 정수 값)을 반환
//	(비슷한 예 : 주민등록번호, 학번, 은행 번호표)
//주민등록번호가 같으면 같은 객체라는 것을 알 수 있음
@Override//오버라이딩 잘 하고 있는지 검사
public int hashCode() {
	//필드에 저장된 값을 이용해서 hashCode 생성했음
	//	return name.hashCode()+age*31+ gender*31;
	//31 : 컴퓨터에서 계산이 가장 빠른 소수
	//name, age, gender 중 하나라도 다르면 값이 달라짐
	//Objects: Object 관련 유용한 기능 모음
	return Objects.hash(name, age, gender); //알아서 hashCode만들어줌
} 
//동등 비교(값이 같음을 비교) : Object.equals() 메서드 오버라이딩해서 사용
//Object 타입으로 받아오기
@Override
public boolean equals(Object obj) {
	//현재 객체의 필드와 
	//전달 받은 obj의 필드가 모두 같을 경우 true, 아니면 false를 반환하도록 오버라이딩 함
	if(obj==null) return false; //null과 객체는 비교 불가
	if(obj == this) return true; //비교 대상이 현재 객체(할 필요 없음)
	if(!(obj instanceof Person)) return false;//obj가 참조하는 객체가 Person이 아니면 비교할 필요 없음
	//같은 타입의 객체가 아니면 비교 불가	
	//	Person과 Object를 비교할 수 없으므로 다운캐스팅(강제 형변환) 진행해야 함
	Person other = (Person)obj;
	return name.equals(other.name)  
			&& age == other.age 
			&& gender == other.gender; //양쪽의 타입 같으므로 직접접근 가능(간접접근인 get안써도 됨)
	
}



}
