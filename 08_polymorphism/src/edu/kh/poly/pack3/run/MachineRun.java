package edu.kh.poly.pack3.run;

import edu.kh.poly.pack3.model.service.MachineService;

public class MachineRun {
public static void main(String[] args) {
	MachineService service = new MachineService(); //객체 생성
	service.method1();
	//머신이라는 접점(인터페이스)을 이용해서 컴퓨터와 세탁기를 한 번에 묶어서 다룸
}
}
