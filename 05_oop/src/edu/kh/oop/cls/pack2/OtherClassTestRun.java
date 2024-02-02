package edu.kh.oop.cls.pack2;

import edu.kh.oop.basic.Account;
import edu.kh.oop.basic.Nation;

public class OtherClassTestRun {
//ClassTest1과 다른 패키지에 존재하는 클래스
//	여기서 ClassTest1을 호출 가능? 노! ClassTest
			public static void main(String[] args) {
				//1. 다른 패키지에 존재하고, public class인 Nation과 Account 클래스를 이용해서 객체 생성 가능?
//				Nation 쓰고 자동완성 해서 import 해야함
				Nation n1 = new Nation(); //문제없음(임포트도 잘 됨)
				Account a1 = new Account(); //문제 없음(임포트도 잘 됨) 가능가능~~~
				
				//2. default class인 ClassTest1 클래스를 이용해 객체 생성가능?
				//ClassTest1 : 자동완성 해도 import안됨 ->default로 돼있어서 패키지 다르면 접근 불가능함(보이지 않게 됨)
				//ClassTest1 c1 = new ClassTest1(); //해도 안됨!
				//	->다른 패키지에 존재하기 때문에 import가 불가능하다(외부에서 저 클래스에 접근 불가)
				//	->default 접근 제한자는 다른 패키지에서 접근 불가능하다
				//	->같은 패키지 내에서만 접근 가능하다
				
//				클래스의 접근 제한자 2개
//				public 
//				default
//				속성, 기능 앞에도 접근제한자 두 종류 더 있음
				
			}
}
