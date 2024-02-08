package edu.kh.poly.pack3.run;

import edu.kh.poly.pack3.model.dto.Calculator;
import edu.kh.poly.pack3.model.dto.LIKCalculator;
import edu.kh.poly.pack3.model.dto.Machine;

public class CalculatorRun {
public static void main(String[] args) {
	//인터페이스 장점:
	// 상속 받은 클래스들의 형태가 똑같거나 비슷하기 때문에
	// 코드 유지 보수 시
	//참조하는 객체만 변경하면 유지 보수가 완료된다!!!
	//아래의 LIKCalculator()부분을 LIKCalculator2()로만 바꿔주면 됨
	Calculator cal = new LIKCalculator();
	System.out.println(cal.plus(1, 2));
	System.out.println(cal.pow(2, 10));
	System.out.println(cal.toBinary(15));
	System.out.println(cal.toHexadecimal(15));
	System.out.println(cal.areaOfCircle(2.0));
	//Machine것을 이용하고싶으면 강제형변환 해서 해야 함
	((Machine) cal).powerOn(); //왜 안될까!
	//cal을 상속받은 
	//powerOn, powerOff는 Machine한테 상속받은거여서 calculator로는 여기에 접근 불가
	//LIKCalculator안에 부모 두개가 따로 있어서
	//Cal을 쓰려면 같은 자료형(Machine)으로 만든 후 접근해야 한다. 
	System.out.println("sum : "+cal.sum(2,3,4,5,6,7));
}
}
