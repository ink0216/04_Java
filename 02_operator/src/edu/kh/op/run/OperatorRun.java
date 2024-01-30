package edu.kh.op.run;

import edu.kh.op.ex.OperatorEx; //OperatorEx 클래스 가져옴(수입해옴) : 클래스 위에 적어야됨
//가져와서 코드만 그대로 가져옴 ->만들어야 쓸 수 있음 -> 만드는 건 메인메서드 안에서 쓰기
/**
 * 실행용 클래스
 */
//함수 설명 : eclipse주석 : 함수에 마우스 클릭 후 alt + shift +j

public class OperatorRun {
	
	//메인 메서드
public static void main(String[] args) {
	OperatorEx ex = new OperatorEx(); //가져온 클래스를 이용해 객체 생성
//	ex.test(); 
//	ex.method1(); //3의 배수 확인하기 함수 호출
//	ex.method2(); //첫 번째 입력받은 수가 두 번째 입력받은 수의 배수가 맞는지 확인
//	  ex.method3(); //입력받은 수가 짝수인지 홀수인지 판별
	ex.method4(); //입력받은 수가 0인지, 짝수인지, 홀수인지 판별
}
}
