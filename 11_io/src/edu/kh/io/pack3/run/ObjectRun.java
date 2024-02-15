package edu.kh.io.pack3.run;

import edu.kh.io.pack3.model.service.ObjectService;

public class ObjectRun {
public static void main(String[] args) {
	ObjectService service = new ObjectService();
//	service.objectOutput();
	service.objectInput(); //파일에서 짜부러져있던 내용을 읽어온 거임
}
}
