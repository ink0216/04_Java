package edu.kh.exception.pack2.model.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingService2 {
/*finally : 마지막에 반드시 수행하는 구문
 * 
 * - try 구문에서 예외 발생 여부와 관계 없이
 * 		무조건 수행해야 하는 구문을 작성
 * 
 *  = try ~ catch ~ finally 
 *  		또는
 *  	try ~ finally
 *  
 *  finally : 꼭 실행해야 하는 것이 있을 때 사용
 *  */
	private Scanner sc = new Scanner(System.in);
	/**
	 * finally 확인하기
	 */
	public void method1() {
		System.out.print("1. 정상 수행 / 2. 강제 예외 발생시키기");
		int input = sc.nextInt();
		//둘 중 하나만 입력한다고 가정
		try {
			if(input ==1) System.out.println("[정상 수행]");
			else throw new RuntimeException(); //예외 객체 생성만으로는 안되고 던지는 것도 써야 함
			//던져야지 캐치로 받을 수 있음
		} catch(Exception e) {
			//Exception : 발생하는 모든 자식 예외를 잡아서 처리할 수 있는 최상위 부모(다형성 업캐스팅 적용)
			System.out.println("catch문 수행됨");
			//catch문 내부의 코드는 예외가 발생해야지만 수행됨
		} finally {
			//try에서 예외 발생 여부 관계 없이, try가 끝나고 나서 무조건 실행하는 코드
			System.out.println("**** 무조건 수행 finally ****");
		}
		
	}
	/**
	 * finally 사용 예시 (언제 사용할까?)
	 * - Java 프로그램 - 외부 프로그램/장치 가 연결되어 사용될 때 그 연결을 끊기 위해 주로 사용함
	 * 외부와 연결해주는 종이컵 전화기 역할 하는 객체가 있는데 그 객체를 만들어야 함
	 * 연결돼있던 두개 중 하나가 사라지면 그 객체(연결해주는 종이컵 객체)는 쓰레기 됨
	 * 객체는 생성되면 Heap 메모리 영역에 남아있음 ->청소되는 데에 오래걸려서 메모리 계속 차지하고 있음
	 * 안쓰면 버려주는 것을 무조건 수행하기 위해 finally를 수행
	 */
	public void method2() {
		Scanner scan = new Scanner(System.in); //finally에 close 구문 쓰면 scan밑에 있던 노란 줄 생김(사용 후 삭제 안해서)
		//Resource leak: 'scan' is never closed == 리소스 누출 : scan이 닫히지 않았습니다.
		//램을 많이 차지할 수록 leak이 커짐
		//Scanner : 외부 장치(키보드)와 연결해서 입력받을 수 있게 해주는 객체(종이컵 전화기 역할)
		// -> 입력받은 이후에는 이제 필요 없어지는데 
		//		프로그램 수행 후에도 계속 scan이 메모리에 남아있어서
		//		메모리 누수 (쓸 데 없는 메모리 차지) 발생
		//	[해결 방법]
		// Scanner를 close(지우다, 메모리 반환) 해주면 해결됨!
		//	->코드에서 예외가 발생 하든 말든 무조건 수행돼야 하므로 
		//	finally 구문 사용!!!!! -> 이 코드를 수행하는 데에 부합함
		//  finally : 외부 장치와의 연결을 끊어내는 데에 사용됨(무조건 없애야 하지, 안그러면 메모리 차지함)
		System.out.println("정수 입력 : ");
		try {
			int input = scan.nextInt();
			System.out.println("입력한 정수*10 : "+(input*10));
		}catch(InputMismatchException e) {
			//정수 입력하라 했는데 손가락 삐끗한 경우
			System.out.println("잘못 입력함");
		} finally {
			if(scan != null) {
				//scan이 참조하는 것이 존재할 때에만
				//(scan이 가끔 만들어지다가 실패하는 경우 있음)
				scan.close();
			}
		}
	}
}
