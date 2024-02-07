package edu.kh.poly.pack1.model.dto;
//얘가 부모 클래스 될 거임
public class SmartPhone {
//스마트폰이라면 공통적으로 가져야 할 것
	private String display; //화면
	private String newsAgency; //통신사
	private String ap; //스마트폰에 들어가는 cpu
	
	//생성자
//	public SmartPhone()	{
//		
//		super(); //생성자 안에 아무것도 안쓰면 컴파일러가 추가해줌
//	}
//	//매개변수 생성자
//	public SmartPhone(String display, String newsAgency, String ap) {
//		super();
//		this.display=display;
//		this.newsAgency=newsAgency;
//		this.ap=ap;
//	}
	//기본 생성자 자동완성 : ctrl + space -> enter
	public SmartPhone() {}
	
	//매개변수 생성자 자동완성 : alt +[shift] +s ->o(영어o)

	public SmartPhone(String display, String newsAgency, String ap) {
		super();
		this.display = display;
		this.newsAgency = newsAgency;
		this.ap = ap;
	}
	//getter/setter 자동완성 alt + [shift] +s ->r 
	
	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getNewsAgency() {
		return newsAgency;
	}

	public void setNewsAgency(String newsAgency) {
		this.newsAgency = newsAgency;
	}

	public String getAp() {
		return ap;
	}

	public void setAp(String ap) {
		this.ap = ap;
	}
	
	//toString() 오버라이딩 자동 완성 : alt +[shift] + s ->s
	@Override
	public String toString() {
		return "SmartPhone [display=" + display + ", newsAgency=" + newsAgency + ", ap=" + ap + "]";
	}
	
	
	//메서드
	
}
