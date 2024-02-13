package edu.kh.collection.pack4.model.service;

import java.util.ArrayList;
import java.util.List;

public class JavaAPIService {
/*Wrapper Class
 * - wrap : 감싸다, 포장하다
 * - 기본 자료형 8가지를 객체(속성, 기능으로 구성)로 감싸는(포장하는) 클래스
 * 		->기본 자료형의 객체화(기본 자료형을 객체로 만들 때 사용)
 * 		->컬렉션 처럼 객체만 취급 가능한 상황에서 기본 자료형도 취급 가능한 형태로 바꾸기 위해서 사용
 * 
 * 포장하는 과정 : Boxing (박스에 담다)
 * 포장된 것을 푸는 과정 : Unboxing
 * 
 *               <포장>
 * boolean <--> Boolean
 * byte    <--> Byte
 * short   <--> Short
 * int     <--> Integer
 * long    <--> Long
 * float   <--> Float
 * double  <--> Double
 * char    <--> Character
 * 
 * * Boxing, Unboxing을 자동으로 수행되도록 Java에 구현되어 있음
 * 		->AutoBoxing, AutoUnboxing
 * 
 * + Wrapper Class를 이용해 객체화 되었을 때
 * 추가적인 필드, 기능을 제공함
 * 
 * */
	/**
	 * AutoBoxing, AutoUnboxing 확인
	 */
	public void method1() {
		int num1 = 100; //int자료형
		//Integer wrap1 = new Integer(num1); //예전에 쓰던 방식->권장되지 않는, 삭제 예정인 방법(쓰지마 ㅠㅠ)
		Integer wrap1 = num1;  //이렇게 하면 됨 int인데 Integer로 컴파일러가 AutoBoxing 수행 코드 추가해줌
		//(int) num1 -> (Integer) num1 바꾼 후 대입
		//int num2 = wrap1.intValue(); //wrap1에 있는 정수값을 뽑아서 num2에 대입 : 추천하지 않는 옛날방식
		int num3 = wrap1; //Integer를 int에 대입(컴파일러가 AutoUnboxing 수행 코드 추가해줌)
		//(Integer) wrap1 -> (int) wrap1 바꾼 후 대입
		
		//Integer와 int 거의 같다고 취급해도 됨(컴파일러가 알아서 맞춰줌)
		long num4= 10_000_000_000L; //100억
		Long wrap2 = num4; //AutoBoxing
		long num5 = wrap2; //AutoUnboxing
		
		List<Integer> list = new ArrayList<Integer>();
		//		Integer 객체만 저장하는 List
		//Integer만 들어가는 List만들기
		list.add(1000); //(int) 1000 -> (Interger) 1000로 되어 추가됨 : Autoboxing됨
		list.add(2000);
		list.add(3000);
		System.out.println(list.get(0)+ list.get(1)+list.get(2));
		//객체에 print구문 사용하면 자동으로 toString구문 호출되는데 
		//더해진 것을 보니 toString 호출 전에 Wrapper클래스로 만든 객체를 참조할 때
		// .toString()을 호출하는 것이 아닌
		//AutoUnboxing을 진행해서 기본 자료형으로 변경하는 것이 먼저 수행됨
		//그래서 더해진 숫자인 6000이 출력됨
		
	}
	/**
	 * Wrapper Class가 제공하는 필드, 메서드
	 * ->대부분이 static!!!!!!!!
	 * 		->static이 붙은 메서드 호출 시
	 * ->static(정적 메모리 영역)이란 한 번 생기면 프로그램 끝날 때까지 없어지지 않음
	 *	->static이 붙은 코드들을 가장 먼저 읽히고 클래스명.필드명 / 클래스명.메서드명()으로 사용해야 함(이름 그대로)
	 *		->객체 만들어서 하는 것 아님
	 * ->Heap(동적 메모리 영역) 
	 */
	public void method2()	{
		//필드
		//정수형 ,실수형 공통(BYTES, SIZE, MAX_VALUE, MIN_VALUE)
		System.out.println("byte의 용량 :"+Byte.BYTES+"바이트"); //1바이트
		System.out.println("byte의 용량 :"+Byte.SIZE+"비트"); // 8비트
		System.out.println("byte의 최대값 :"+Byte.MAX_VALUE); 
		System.out.println("byte의 최소값 :"+Byte.MIN_VALUE); 
		
		//실수형에서만 사용가능한, JS에서도 쓰는 것
		System.out.println(Double.NaN); //말도 안되는 연산 했을 경우
		System.out.println(Double.NEGATIVE_INFINITY); //+ 무한대
		System.out.println(Double.POSITIVE_INFINITY); // - 무한대
		
		//Boolean(논리형)은 true/false밖에 없음
		System.out.println(Boolean.FALSE);
		System.out.println(Boolean.TRUE);
		//------------------------------------------------------------------------
		//String -> 기본 자료형 변환 : 매우 대표적인 Wrapper Class 제공 기능
		//HTML 연결 시(요청 데이터 처리) 많이 사용
		//HTML에서 입력하는 모든 것들은 String으로 인식됨 ->그래서 Number()로 감싸서 숫자로 만들었었음
		//	->HTML에 관련된 모든 값은 String임 ->이걸 기본 자료형으로 변환해야 써먹을 수 있다. 
		//			단, char(Character)는 별도로 존재하지 않음
		System.out.println("======================================================");
		System.out.println("[String -> 기본 자료형 변환]");
		byte b = Byte.parseByte("1");
		short s = Short.parseShort("2");
		int i = Integer.parseInt("3"); //중요
		long l = Long.parseLong("4"); //중요
		float f = Float.parseFloat("0.1");
		double d = Double.parseDouble("0.2"); //중요
		boolean bool = Boolean.parseBoolean("true");
		//매개변수 자리에 쓰인 것들이 모두 String인데 모두 변환되어 저장됨
		//parse : 데이터의 타입 바꾸기
		
		System.out.println("변환 확인"); //쌍따옴표 벗겨진 상태로 저장됨
		
		System.out.println("======================================================");
		System.out.println("[기본 자료형 -> String 변환]");
		
		//Wrapper Class를 이용하는 방법(권장되는 방법) : 코드는 길지만 효율은 좋다
		int test1 = 400;
		String change1 = Integer.valueOf(test1).toString(); //test1의 값을 Integer로 변환해서 문자열로 변환해서 대입
		
		double test2 = 4.321;
		String change2 = Double.valueOf(test2).toString();
		
		//String 이어쓰기를 이용한 방법(비추하는 방법)
		long test3 = 12345678910L;
		String change3 = test3+"";  //이게 코드는 짧지만, 효율은 좋지 않음(속도, 메모리 저하)
		//long형과 String을 더하면 이어쓰기되면서 하나의 String으로 변함
		//long + String -> String + String으로 변함 ->이어쓰기 됨(근데 빈 문자열이므로 이어써진 값은 없음)
		//이어쓰기 할 때 Long.valueOf가 호출됨
		
		
	}
	/**
	 * String의 불변성(상수처럼 변하지 않는 성질)
	 */
	public void method3() {
		String str = "hello"; //str은 hello가 들어있는 String객체를 참조해서 그 주소를 담고있어서 그 뒤에서 값 바꾸면
		//얕은복사 될까? NO!
		System.out.println(str);
		System.out.println(System.identityHashCode(str));
		
		//System.identityHashCode(str) : 필드가 아닌 주소값을 이용해서 만든 해시코드(식별번호)
		//						-> 같은 객체에 저장된 값이 변했어도 주소는 일정
		//						-> identityHashCode도 일정해야 한다.
		
		str = "world"; //그 주소에 가서 
		System.out.println(str);
		System.out.println(System.identityHashCode(str));
		
		str +="!!!";
		System.out.println(str);
		System.out.println(System.identityHashCode(str));
		
		// System.identityHashCode(str) ->다 다른 값이 나옴
		//		->str이 참조하고 있는 객체가 변하고 있다!!!
	}
}
