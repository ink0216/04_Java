package edu.kh.poly.pack1.model.dto;
//자식 역할
public class Galaxy extends SmartPhone{
private int androidVersion; //안드로이드 운영체제 버전
//기본 생성자
public Galaxy() {}
//매개 변수 생성자 자동 완성 + super() 매개변수 생성자 같이 생성하기
//자기것, 부모 것까지 초기화하는 것
//alt + [shift] +s -> o -> 창 열리는 것에서 드롭다운에서 부모 생성자 선택 ->generate
public Galaxy(String display, String newsAgency, String ap, int androidVersion) {
	super(display, newsAgency, ap);
	this.androidVersion = androidVersion;
}
//getter/setter 자동완성 : alt shift s ->r
public int getAndroidVersion() {
	return androidVersion;
}
public void setAndroidVersion(int androidVersion) {
	this.androidVersion = androidVersion;
}
//toString() 오버라이딩
@Override
public String toString()	{
	return "Galaxy AndroidVersion :" +androidVersion + " / " +super.toString();
	//super.toString() : 부모에 작성된 toString()이 호출됨
}



}
