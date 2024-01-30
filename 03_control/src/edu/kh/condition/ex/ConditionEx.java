package edu.kh.condition.ex;

import java.util.Scanner;

/**
 * 조건문 기능용 클래스
 */
public class ConditionEx {
	//클래스 바로 아랫부분에 만드는 변수 : 필드( ==객체의 속성==객체가 가지고 있는 값/변수)
	//클래스 중괄호가 아닌, 클래스 중괄호 바로 밑에 있는 것!
//	Scanner 쓰고 ctrl space하면 자동완성 시키면 위에 자동으로 import 구문 생김
	Scanner sc = new Scanner(System.in);
/**
 * 나이를 입력 받아 
 * 19세 이상은 "성인", 미만은 "성인이 아닙니다"
 * if문으로 만들어보기
 */
public void method1() {
	System.out.print("나이 입력 :");
	int age = sc.nextInt();
	
	if(age>=19) {
		System.out.println("성인");
	} else {
		System.out.println("성인이 아닙니다.");
	}
} 

/**
 * 나이를 입력 받아
 * 13세 이하이면 "어린이"
 * 13세 초과 18세 이하 "청소년"
 * 18세 초과 "성인"
 */
public void method2() {
	System.out.print("나이 입력 :");
	int age = sc.nextInt();
	String result;
	
	if(age<=13) 				result = "어린이";
	else if(age<=18) 		result = "청소년";
	else 								result = "성인";
	
	System.out.println(result);
}

/**
 * 달(월)을 입력 받아 해당 계절 출력하기
 * <ul>
 * <li>봄 : 3,4,5월</li>
 * <li>여름 : 6,7,8월</li>
 * <li가을 : 9,10,11월</li>
 * <li>겨울 : 12,1,2월</li>
 * <li>그 외 : 잘못 입력</li>
 * </ul>
 */
public void method3() {
	System.out.print("달(월) 입력 :");
	int month = sc.nextInt();
	String result;
	if(3<=month && month<6) result="봄";
	else if(month>=1 && month <3 ||month==12) result="겨울";
	else if(month>=9 && month<12) result="가을";
	else if(month>=6 && month<9) result="여름";
	else result="잘못 입력";
	System.out.println(result);
}

/**
 * 다른 방법 -이렇게 하면 조금더 줄일 수 있다, 생각하는 순서를 바꿈
 */
public void method3a() {
	System.out.print("달(월) 입력 :");
	int month = sc.nextInt();
	String result;
	if(month<1 ||month>12)  result="잘못 입력";
	else if(3<=month && month<6) result="봄";
	else if(month>=9 && month<12) result="가을";
	else if(month>=6 && month<9) result="여름";
	else result="겨울";
	System.out.println(result);
}
/**
 * 잘못된 경우에 메서드를 중간에 종료
 */
public void method3b() {
	System.out.print("달(월) 입력 :");
	int month = sc.nextInt();
	if(month<1 ||month>12) {
		System.out.println("잘못 입력");
		return; //메서드를 종료하고 호출한 곳으로 돌아감/ 잘못됐으면 뒤에 볼 것 없음
	}
	String result;
	if(3<=month && month<6) result="봄";
	else if(month>=9 && month<12) result="가을";
	else if(month>=6 && month<9) result="여름";
	else result="겨울";
	System.out.println(result);
}
public void method3c() {
	System.out.print("달(월) 입력 :");
	int month = sc.nextInt();
	String result;
	switch(month) {
//	case 3 : //switch문에서 break없으면 다음 케이스로 넘어감
//	case 4 : 
//	case 5 : result="봄"; break;
//	//3,4,5를 입력하면 result가 봄으로 나옴
	case 3,4,5 : result ="봄"; break;
	case 6,7,8 : result ="여름"; break;
	case 9,10,11 : result ="가을"; break;
	case 12,1,2 : result ="겨울"; break;
	default : result = "잘못 입력"; 
	}
	System.out.println(result);
}
/**
 * Pass/Fail 판별하기
 * <pre>
 * 중간고사, 기말고사, 과제 점수를 입력 받아
 * 총점 60점 이상일 경우 PASS, 아니면 FAIL
 * 
 * *반영 비율 : 중간고사(40%), 기말고사(50%), 과제(10%)
 * *각각 100점 만점
 * 
 * +PASS인 경우
 * 90점 이상 : A
 * 80점 이상 : B
 * 70점 이상 : C
 * 60점 이상 : D
 * </pre>
 */
public void method4() {
	System.out.print("중간고사 점수 :");
	int midTest = sc.nextInt();
	
	System.out.print("기말고사 점수 :");
	int finalTest = sc.nextInt(); //변수명에 final은 쓸 수 없음, 상수 선언하는 단어이므로
	
	System.out.print("과제 점수 :");
	int homeWork = sc.nextInt();
	
	//각 비율이 적용된 총 점수
	double overall = 0.4*midTest +0.5*finalTest +0.1*homeWork;
	//소수(더블)와 int인 input값을 계산 시 int가 자동으로 double로 자동형변환됨
	
	String result = null;//""해도 됨/이전에 있을 수 있는 쓰레기 없애기
	//변수에 아무런 값도 대입되지 않은 경우 사용 불가능(에러)발생
	// 해결법 1) 모든 경우에 result 변수에 값을 대입하게 하거나
	// 해결법 2) result 변수 선언 시 어떤 값이든 특정한 값으로 초기화 해두기
	
	// ->숫자는 0, String은 null/"", boolean은 false로 많이 초기화 해둠
	//		이외의 객체들은 null로 초기화 많이 해둠
	
	//Switch문 매개변수로는 정수, 문자열,문자만 가능
	
	if(overall>=60) {
		switch((int)(overall/10)){
			case 10 : result = "A"; break;
			case 9 : result = "A"; break; //90점대
			case 8 : result = "b"; break; //80점대
			case 7 : result = "C"; break; //70점대
			case 6 : result = "D"; break; //60점대
		}
	} else {
		result="FAIL";
	}
	
	
	System.out.println(result);
}

/**
 * <pre>
 * 국어, 영어, 수학, 사탐, 과탐 점수를 입력 받아
 * 40점 미만 과목이 하나라도 있으면 FAIL
 * 평균이 60점 미만인 경우도 FAIL
 * 모든 과목이 40점 이상이고 평균 60점 이상인 경우 PASS
 * 
 * [출력 예시]
 * 1) 40점 미만 과목이 존재하는 경우
 * 		-> FAIL [40점 미만 과목 : 국어, 영어]
 * 2) 평균이 60점 미만인 경우
 * 		-> FAIL [점수 : 50.4 (평균 미달)]
 * 3) PASS인 경우
 * 		-> PASS [점수 : 83.4 /100] 
 * </pre>
 * 
 */
public void method5() {
	System.out.print("점수 입력(국어 영어 수학 사회 과학) : ");
	int kor = sc.nextInt();
	int eng = sc.nextInt();
	int mat = sc.nextInt();
	int soc = sc.nextInt();
	int sci = sc.nextInt();
	
	//true : 40점 미만이 있을 경우
	//false : 40점 미만이 없는 경우
	//flag라는 신호체계를 만듦
	boolean flag = false;
	String result = ""; //비어있는 문자열
	
	if(kor < 40) { result += "국어 "; flag = true; }
	if(eng < 40) { result += "영어 "; flag = true; }
	if(mat < 40) { result += "수학 "; flag = true; }
	if(soc < 40) { result += "사회 "; flag = true; }
	if(sci < 40) { result += "과학 "; flag = true; }
	//비어있는 문자열에 누적시킴
	
	if(flag) {
		//flag가 true인 경우 실행
		//하나라도 40점 미만인 경우 실행
		System.out.printf("FAIL [40점 미만 과목 : %s] \n", result);
		return; //이 시점에서 멈추고 돌아가라
	}
	
	int sum = kor + mat + eng + soc + sci;
	double avg = sum / 5.0;
	
	if(avg < 60.0) {
		System.out.printf("FAIL [점수 : %.1f (평균 미달)] \n", avg);
		return;
	}
	
	System.out.printf("PASS [점수 : %.1f / 100] \n", avg);
}

	
}




