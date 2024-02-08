package edu.kh.poly.pack3.model.service;

import edu.kh.poly.pack3.model.dto.Computer;
import edu.kh.poly.pack3.model.dto.Machine;
import edu.kh.poly.pack3.model.dto.Washer;

public class MachineService {
//기계 서비스
	public void method1()	{
		//인터페이스(접점)을 쓸 수 있다
		//컴퓨터와 세탁기에게 기계라는 접점을 만들어 준 것을
		//머신으로 객체 만들 수 없음(머신 클래스는 추상클래스이기 때문에)
		//대신에 인터페이스도 부모 타입 참조변수로 사용될 수 있음
		//	->다형성의 업캐스팅이 적용된다는 얘기
		//			->+ 매개변수의 다형성
		//			->+ 반환형의 다형성
		//			->+ 부모 타입 객체 배열
		//			->+ 동적 바인딩
		//			모두 가능
		Machine[] arr = new Machine[2];
		//좌변 : Machine 배열을 참조하는 주소를 저장할 참조형 변수 arr을 선언 
		//우변 : new 연산자로 heap 영역에 Machine 참조 변수 2칸짜리 Machine[] 배열을 생성
		//							->Machine 객체를 참조하는 참조 변수를 2개 생성
		//	생성된 배열 주소를 arr에 대입
		
		//업캐스팅 적용
		arr[0] = new Computer(); //컴퓨터 만들어서 집어넣기
		arr[1] = new Washer(); //세탁기 만들어서 집어넣기
		
		//향상된 for문 : 배열의 모든 요소에 순차접근
		for(Machine temp : arr) {
			//arr 배열에서 temp를 하나씩 꺼내서
			//첫 바퀴에서는 0번인덱스 꺼내와서 temp에 저장
			//두 번째 바퀴에서는 1번인덱스 꺼내와서 temp에 저장
			temp.powerOn();
			temp.powerOff();
			System.out.println("-------------------------------------------------------");
		}
	}
}
