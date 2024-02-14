package edu.kh.exception.pack3.model.exception;

/**
 * 100 초과하면 예외를 강제로 발생시키기
 * - RuntimeException 상속
 * 		->UnChecked Exception
 * 		->예외 처리 구문 작성 해도 그만, 안해도 그만
 * 
 * - 사용자 정의 예외는 RuntimeException을 상속 받는 경우가 많음!!
 * 		(예외 처리 하고싶으면 하고 안하고 싶으면 안해도 되도록 하려고)
 */
public class MoreThanAHundredException extends RuntimeException{
//Exception이든 RuntimeException이든 그냥 부모 클래스 상속받으면 됨
	//기본생성자
	public MoreThanAHundredException() {
		super("100을 초과 하였습니다."); //에러 메시지 뜰 때 이 메시지 나올 것임
		//super 는 부모인데?
	}
	public MoreThanAHundredException(String message) {
		super(message); //전달 받은 메시지가 그대로 보이게 만듦
	}
}
