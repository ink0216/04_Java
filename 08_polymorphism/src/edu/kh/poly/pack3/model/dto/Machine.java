package edu.kh.poly.pack3.model.dto;
//Interface : 접점 (클래스 간의 접점을 만드는 용도)
public interface Machine {
//인터페이스는 상수형 필드(public static final)만 작성 가능!
	// -> 작성하는 모든 필드가 public static final
	// -> public static final 구문을 명시적으로 작성하지 않아도
	//    묵시적으로 public static final로 인식된다! 
	//이렇게 쓰는 거구나 이해하기
	//public static final int VOLT = 220;
	int VOLT = 220;
	
	//인터페이스는 추상 메서드(public abstract)만 작성 가능
	//	->public abstract 생략 가능(안써도 자동으로 public abstract로 인식됨)
	public abstract void powerOn(); //추상메서드는 {}없음
	void powerOff(); //public abstract 안써도 된다
	
}
