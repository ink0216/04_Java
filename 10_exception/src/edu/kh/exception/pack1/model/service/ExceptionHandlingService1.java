package edu.kh.exception.pack1.model.service;

import java.awt.print.PrinterException;
import java.io.EOFException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingService1 {
/*Exception(예외) : 코드로 처리(해결) 가능한 에러
 * 
 * Exception Handling(예외 처리) : Exception 발생 시 처리하는 구문
 * 예외가 발생했을 때(if문처럼 사용)*/
	//필드 == 클래스 밑
	private Scanner sc = new Scanner(System.in);
	/**
	 * 예외를 발생시키는 코드
	 */
	public void method1()	{
		int[] arr = {10, 20, 30, 40}; //마지막 인덱스 ==3
		for(int i=0; i<=arr.length;i++) {
			//			i == 0 ~ 4
			System.out.println(arr[i]);
			//10
			//20
			//30
			//40
			//예외 발생(배열 인덱스 범위 초과)
			//java.lang.ArrayIndexOutOfBoundsException:
			//Index 4 out of bounds for length 4
			
			/*예외 발생 원리
			 * 실행 중 예외 상황이 발생하는 경우
			 * 예외 상황에 맞는 코드가 수행되며
			 * 지정된 예외 클래스를 찾아 객체로 만들어서 던짐*/
			//인덱스 초과 시 new ArrayIndexOutOfBoundsException();이 자동으로 수행돼 
			//예외 객체 만들어서 던짐->프로그램 멈추고 에러 내용 보여짐
			//	-> throw new ArrayIndexOutOfBoundsException(); 수행되면서 예외가 던져짐!
			
		}
		
	}
	/**
	 * 예외 발생 구문을 try-catch로 처리(예외 처리)
	 * - try{} :{}안에 예외가 발생할 것 같은(가능성이 있는)코드를 시도하는 구문
	 * - catch(예외){} : try 구문 시도 중 예외가 발생되어 던져진 경우,
	 * 										catch(예외)에 작성된 예외와 던져진 예외가 같으면 
	 * 										잡아서 {} 내의 구문을 수행함
	 * 										(이 예외가 발생해서 던져진 경우 이 구문 수행해~~~이런 것)
	 * 					->예외가 발생하고 처리를 안하면 프로그램이 멈추는데,
	 * 					->발생된 예외를 잡아서 처리했기 때문에 프로그램이 멈추지 않고 정상수행됨
	 */
	public void method2() {
		int[] arr = {10, 20, 30, 40};
		try { //예외 발생할 것 같은 구문 시도
			for(int i=0; i<=arr.length;i++) {
				//			i == 0 ~ 4
				System.out.println(arr[i]);
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			//try에서 던져진
			//ArrayIndexOutOfBoundsException 객체를 catch가 잡아서 처리->이거 하면 프로그램 끝까지 수행됨
			System.out.println("[예외 잡아서 처리함]");
		}
		System.out.println("프로그램 종료"); 
		System.out.println("프로그램 종료");
		System.out.println("프로그램 종료");
		System.out.println("프로그램 종료");
		System.out.println("프로그램 종료");
	}
	/**
	 * 예외 처리 구문 활용 예시 1 (언제 사용하는지)
	 * - 보통은 정상수행되다가 가끔 예외가 발생하는 경우
	 * 		+ 그 예외를 if문으로 처리하지 못하거나 애매한 경우 
	 */
	public void method3()	{
		System.out.println("[두 수를 입력 받아 나눈 몫 구하기]");
		
		System.out.print("첫 번째 수 입력 : ");
		int input1 = sc.nextInt();
		
		System.out.print("두 번째 수 입력 : ");
		int input2 = sc.nextInt();
		
		System.out.print("결과 : ");
		try { //예외가 발생할 것 같은 구문
		System.out.println((double)input1/input2);
		// 0으로 나누는 경우
		// java.lang.ArithmeticException: / by zero
		// -> 산술적 예외 : 0으로 나눌 수 없음
		} catch(ArithmeticException e) {
			//오류가 발생 안하면 catch문의 {} 내의 코드 수행되지 않음
			//try에서 던져지는 ArithmeticException 객체를 
			//매개변수를 이용해 잡음
			//e에는 예외와 관련된 내용들이 다 들어있음
			//무한대 == Infinity
			if(input1>=0) System.out.println(Double.POSITIVE_INFINITY); //양의 무한대(Infinity)
			else System.out.println(Double.NEGATIVE_INFINITY); //음의 무한대(-Infinity)
			//Double Wrapper Class
		}
	}
	/**
	 * catch 구문 여러 개 작성하기 1
	 */
	public void method4() {
		//java.util.InputMismatchException
		// - Scanner를 이용해서 int, long, float, double 등
		//		특정 자료형 형태의 문자를 입력 받으려고 했는데
		//		입력된 값이 다른 자료형일 경우 발생되는/던져지는 예외(휴먼에러)
		//  Mismatch = 맞지 않는다
		//굳이 또 효율 생각하자면 입력 관련 예외가 계산 관련 예외보다 
		//먼저 발생할 가능성+자주 발생할 가능성이 있으므로
		//계산 관련 예외보다 먼저 처리하는 게 좋다!!
		
		System.out.println("[두 수를 입력 받아 나눈 몫 구하기]");
		int input1 = 0; //try밖으로 뺌 -> try지역 변수여서 catch 사용 불가능 문제가 있어서
		int input2 = 0;
		try { //예외가 발생할 것 같은 구문
		
		System.out.print("첫 번째 수 입력 : ");
		input1 = sc.nextInt();
		
		System.out.print("두 번째 수 입력 : ");
		input2 = sc.nextInt();
		
		System.out.print("결과 : ");
		System.out.println((double)input1/input2);
		
		}  catch(InputMismatchException e) {
			System.out.println("입력이 올바르지 않습니다.");
		} catch(ArithmeticException e) {
		
			if(input1>=0) System.out.println(Double.POSITIVE_INFINITY); //양의 무한대(Infinity)
			else System.out.println(Double.NEGATIVE_INFINITY); //음의 무한대(-Infinity)
			//Double Wrapper Class
		}
	}
	/**
	 * catch 구문 여러 개 작성하기 2 (해볼 것 두개)
	 * 1) throw : 예외를 강제로 발생(던지기)시키는 구문
	 * 2) 예외 + 다형성
	 * 		- catch문 여러 개 작성 시
	 * 			부모 예외를 처리하는 catch문이 자식 예외도 모두 잡아서 처리함 ->자식 예외 처리 catch문이 Unreachable해짐
	 * 			-> 부모 예외 처리 catch문은 자식 예외 처리 catch문보다 아래에 작성해야 컴파일 에러가 없음
	 */
	public void method5() {
		int input=0;
		do {
			try {
				System.out.println("[예외 강제 발생 시키기]");
				System.out.println("1. ArithmeticException");//ArithmeticException강제로 발생시켜보기
				System.out.println("2. NullPointerException");
				System.out.println("3. ClassCastException");
				System.out.println("4. RuntimeException");
				System.out.println("0. 종료");
				
				System.out.print("예외를 선택하세요 >>>");
				input = sc.nextInt();
				//잘못 입력 -> InputMismatchException이 던져짐->catch가 잡아서 처리
				//스캐너 이용 시 버퍼가 생기는데, 3 \n(엔터) 로 입력되는데 nextint()에서 3만 빼가면 엔터가 남음
				switch(input) { //예외를 던질 때 클래스가 아닌 객체로 만들어서 던져야 함
				
				//throw new 예외(); : 예외 강제 발생
				case 1 : throw new ArithmeticException();  //예외 발생하면 자동으로 종료됨
				case 2 : throw new NullPointerException(); 
				case 3 : throw new ClassCastException();
				//1,2,3번이 객체(자식객체)로 되어 RuntimeException catch문의 매개변수(부모객체)에 대입됨
				//다형성 업캐스팅 적용
				//부모 타입 예외 참조 변수 = 자식 타입 예외 객체
				//	->다형성 업캐스팅이 매개 변수에 적용됨
				//		->case 1,2,3번이 4번 하나로 다 커버됨
				case 4 : throw new RuntimeException(); // 프로그램 실행 중 발생하는 예외
				case 0 : System.out.println("[프로그램 종료]"); break;
				default : System.out.println("[메뉴에 작성된 번호만 입력해 주세요.]");
				
				}
			} //try end
			//자식 예외를 부모 catch문에서 모두 잡아서 처리하기 때문에
			//아래의 자식 catch문까지 코드가 도달할 수 없다! (수행 불가한 죽은 코드 됨)
			
			/*해결 방법 : 부모 catch를 자식 catch 밑에 작성*/
			
//			catch(RuntimeException e) {
//				System.out.println("===== 프로그램 실행 중 발생한 예외 처리 완료 =====");
//			}
			//위의 부모 캐치문에서 싹다 잡아서 처리해서 아래의 주석 catch문들은 Unreachable catch block 오류 생김
			//도달할 수 없는 catch 구문
			
			catch(InputMismatchException e) {
				System.out.println("[잘못 입력]");
				//Scanner 입력 버퍼에 잘못 입력한 값이 계속 남아있어
				//sc.nextInt() 구문이 while문 돌면서 계속 예외 발생!!!!
				// -> 입력 버퍼에 잘못 입력한 값을 제거해야 함
				sc.nextLine(); //버퍼에 남은 값을 제거
				
				input = -1; //첫 반복에서 종료되지 않도록 값을 0이 아닌 값으로 수정
			} 
			//캐치문의 순서는 서로 바뀌어도 상관 없음
			
			catch(ClassCastException e) {
				//ClassCastException : 형변환 실패(업/다운 캐스팅 실패 시 나옴) 
				System.out.println("===== 업/다운 캐스팅 실패 처리 완료 =====");
			}
			catch(ArithmeticException e) {
				System.out.println("===== 산술적 예외 처리 완료 =====");
			}
			catch(NullPointerException e) {
				System.out.println("===== 참조하는 객체가 없는데 참조를 시도한 예외 처리 완료 =====");
			}
			
			catch(RuntimeException e) {
				System.out.println("===== 프로그램 실행 중 발생한 예외 처리 완료 =====");
			}
			
		} while(input !=0);
			//번호를 입력받아서 입력 받은 예외를 강제로 발생시켜보기
			//0이 아닐 때 반복
			
		
	}
	/**
	 * catch문에 부모 타입 예외 처리 구문 작성하기(다형성과 관련)
	 * 
	 * Exception 클래스
	 *  - 모든 예외의 최상위 부모 클래스
	 *  (예외의 최상위이지, 클래스의 최상위 부모는 Object임)
	 *  
	 *  - catch문에 Exception으로 예외를 받기로 하면
	 *  	발생되는 모든 예외를 잡아서 처리할 수 있다!!
	 */
	public void method6() {
		try {
			//이 안에서 각종 예외 강제발생 시켜보기
			//Illegal : 잘못된
			//Argument : 전달 인자 (method6(10); 호출 시의 10)
			//메서드 호출 시에 전달 인자 값을 잘못 쓴 경우
//			throw new IllegalArgumentsException();
			//EOF : End Of File : 읽어들인 파일 내용이 끝남을 나타냄(강제로 
			throw new EOFException();
//			throw new PrinterException(); 
		} catch(IllegalArgumentException e) {
			System.out.println("예외 처리 완료");
		} catch(EOFException e) {
			System.out.println("예외 처리 완료");
		}
	catch(Exception e) {
		System.out.println("예외 처리 완료");
	}
		//혼자서 코드 연습, 나중에 리팩토링(코드 고치기)할 예정인 경우
		//	-> 부모 타입 Exception으로 다 잡아서 처리하기(코드 길이 감소 위해서)
		
		//파이널 프로젝트, 실제 서비스 운영하는 경우
		//	-> 모든 예외 상황마다 대비하는 게 좋다
		//			->코드 길이는 늘어나지만, 모든 예외 상황에 대한 UX(사용자 경험) 가 증가됨
	}
}
				
				
