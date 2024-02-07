package edu.kh.poly.pack1.run;

import edu.kh.poly.pack1.model.service.PolyService;

public class PolyRun {
//다형성 Run
	//PolyService 메서드 하나씩 호출할 거임
	public static void main(String[] args) {
		PolyService service = new PolyService(); 
		//heap메모리 영역에 PolyService 자료형인 PolyService 객체를 기본생성자로 (매개변수 없음)만들어서 
		//그 객체의 주소를 참조형 변수 service에 대입해서
		//service 변수가 객체를 참조하는 형태로 만듦
//		service.method1();
//		service.method2();
//		service.method4();
//		service.method5();
//		service.method6();
//		service.method7();
//		service.method8();
		service.method9();
	}
}
