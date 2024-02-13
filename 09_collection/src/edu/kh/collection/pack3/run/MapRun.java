package edu.kh.collection.pack3.run;

import edu.kh.collection.pack3.model.service.MapService;

public class MapRun {
	public static void main(String[] args) {
		//어디서든지 접근 가능
		//static 메모리 영역에 올라가는
		//반환하는게 없는 메인
		//매개변수로 String배열을 받음
		MapService service = new MapService();
//		service.method1();
//		service.method2();
//		service.method3();
		service.method4();
	}
}
