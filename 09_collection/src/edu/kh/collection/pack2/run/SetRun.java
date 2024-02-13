package edu.kh.collection.pack2.run;

import edu.kh.collection.pack2.model.service.SetService;

public class SetRun {
public static void main(String[] args) {
	SetService service = new SetService(); //SetService를 참조하는 객체를 생성해서 그 주소 대입
//	service.method1();
//	service.method2();
//	service.method3();
//	service.method4();
	service.lottoNumberGenerator();
}
}
