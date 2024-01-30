package edu.kh.condition.ex;
//같은 패키지에 있는 다른 클래스는 import를 안해와도 된다
//같은 패키지는 같은 나라 옆 동에 있는 것임, 수입 안해도 됨
//다른 패키지에 있으면 import해와야  함
/**
 * 조건문 실행용 클래스
 */
public class ConditionRun {
	//메인 메서드
public static void main(String[] args) {
	ConditionEx ex=new ConditionEx(); //객체를 만들었다. 
	//같은 패키지여서 import안해도 오류 안난다
//	ex.method1();//객체 안의 method1을 호출하겠다
//	ex.method2();
//	ex.method3();
//ex.method3a();
//	ex.method3b();
//	ex.method3c();
//	ex.method4();
	ex.method5();
}
}
