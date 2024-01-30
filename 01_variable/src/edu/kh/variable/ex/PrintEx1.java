package edu.kh.variable.ex;

public class PrintEx1 {
public static void main(String[] args) {
	/* System.out == (eclipse 기준으로는) console창
	 * 
	 * System.out.print(); == ()내의 값을 console에 출력 후 줄바꿈 안함
	 * System.out.println(); == ()내의 값을 console에 출력 후 줄바꿈 함(ln = line)
	 * 위 둘은 줄바꿈 유무의 차이! 
	 * 
	 * System.out.printf("", 변수 || 값);
	 * -JS에서 백틱(`)으로 하던 것 같은 것임
	 * -정해진 형식(패턴)에 맞게 문자열을 출력하는 구문
	 * -printf()도 함수이므로 ()	안의 것들은 매개변수임
	 * -첫 번째 매개변수 -> 패턴이 적용된 문자열을 작성
	 * 
	 * ->패턴의 종류 : 많음
	 * 	%d : 10진법 정수(Decimal)(byte, short, int, long 가리지 않음) 써라
	 * 	%c : 문자(char) 써라
	 * 	%s : 문자열(String) 써라
	 *  %b : 논리형(boolean) 써라
	 *  %f : 실수형(float/ double 가리지 않음) 써라 
	 *  
	 *   + : 오른쪽 정렬(양수) 
	 *   - : 왼쪽 정렬(음수)
	 *   
	 *   %숫자d : 정수가 출력된 칸을 숫자만큼 확보
	 *   
	 *   ex) %6d : ㅁㅁㅁㅁㅁㅁ 여섯칸 확보되고 10 쓰면 ㅁㅁㅁㅁ10 (양수니까 오른쪽 정렬)
	 *   		%-6d :  ㅁㅁㅁㅁㅁㅁ 여섯칸 확보되고  -10 쓰면 10ㅁㅁㅁㅁ (음수니까 왼쪽 정렬)
	 *   
	 *   %.숫자f : 소수점 아래 몇째 자리 까지 표시할 지 지정
	 *   						(지정된 자리 바로 아래 자리에서 반올림 처리됨)
	 *   
	 *  -두 번째 매개 변수 :
	 *  		-첫 번째 매개변수 문자열 중 패턴에 들어갈 변수|값을 순서대로 작성
	 * */
	
	System.out.print("이름 : "); //이름 : 이인경입니다.
	System.out.print("이인경"); // 오늘도 재밌는 자바 공부~
	
	System.out.println("입니다.");
	System.out.println("오늘도 재밌는 자바 공부~");
	
	System.out.println(); //내용 없이 줄만 바꿈
	//변수 다섯개 선언
	String name = "홍길동";
	int age = 30;
	double height = 178.35;
	char gender = '남'; //한 칸을 차지하면 한 글자임
	boolean javaStudy = true;
	
	//홍길동은 30세 남성으로 키는 178.4cm이고, 자바 공부 여부 : true 출력
	System.out.printf("%s은 %d세 %c성으로 키는 %.1fcm이고, 자바 공부 여부 : %b",
			name ,age,gender,height,javaStudy);
	System.out.println("\n-------------------------------------------------------------");
	//"20240125" 홍길동        10000원 입금   
	//"20240126" 아파트관리비 120000원 출금  
	//"20240127" 식자재마트     3000원 출금
	
	// \n ==개행문자(줄바꿈)
	System.out.printf("%s  %-6s  %7d원  %s \n", 
			"20240125", "홍길동", 10000, "입금"); //꼭 변수명으로 안넣고 값으로 넣어도 됨
	//여섯칸 만들어서 왼쪽정렬
	//숫자는 여섯칸 만들어서 오른쪽 정렬이니까 양수
	
	System.out.printf("%s  %-6s  %7d원  %s \n", 
			"20240126", "아파트관리비", 120000, "출금");
	System.out.printf("%s  %-6s  %7d원  %s \n", 
			"20240127", "식자재마트", 3000, "출금");
	
	
	
	
	
	
	
	
}
}
