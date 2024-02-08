package edu.kh.poly.pack3.model.dto;
//컴퓨터와 세탁기는 공통부분이 없어서 인터페이스 이용
//같은 부모를 가졌다기 보다는 기계라는 공통점만 있다
//기계라는 접점으로 이어주자 ->이때 인터페이스 사용

//클래스, 추상 클래스 상속 키워드 : extends(확장하다)
//인터페이스 상속 키워드 : inplements(구현하다)
//	->머신을 상속받와와도 몸집이 커지지 않고 그냥 구현하는 거기 때문에

//Washer : 세탁기
public class Washer implements Machine{

	@Override
	public void powerOn() {
		System.out.println("세탁기의 터치식 전원 버튼을 누름");
	}

	@Override
	public void powerOff() {
		System.out.println("세탁기가 켜져 있을 때 다시 전원 버튼을 누름");
	}

}
