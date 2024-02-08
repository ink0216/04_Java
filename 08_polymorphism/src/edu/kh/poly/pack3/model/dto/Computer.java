package edu.kh.poly.pack3.model.dto;

public class Computer implements Machine{

	@Override
	public void powerOn() {
		System.out.println("컴퓨터의 power 버튼을 눌러서 켠다.");
	}

	@Override
	public void powerOff() {
		System.out.println("컴퓨터의 시스템 종료 기능을 수행한다.");
	}

}
