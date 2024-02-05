package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx1 {
	//필드
	Scanner sc = new Scanner(System.in);
	
/*(자바에서의) 배열(자료구조)
 * - Java에서의 배열
 * 	->같은 자료형의 변수를 하나의 묶음으로 다루는 것
 * JS에서는 한 배열로 묶이는 것들의 자료형이 달라도 됐었음!!
 * 
 * - 생성된 배열의 요소는 index를 이용해서 구분
 * - 생성된 배열을 활용하기 위해서는
 * 		배열을 참조하는 "참조형 변수"를 이용한다. 
 * [참조형 변수]
 * -값이 아닌 참조하고 있는 "주소"를 저장하는 변수
 * -변수 사용 시 저장된 주소로 찾아가서 
 * 		그곳에 위치한 배열/객체를 참조한다.
 * -기본 자료형 8개를 제외한 나머지는 모두 참조형 변수이다. 
 * */
	/**
	 * 배열 선언, 할당, 초기화
	 */
	public void method1() {
//		int num; //배열이 아닌, 변수 선언
		//Stack영역에, int자료형을 저장할 수 있는 변수를 생성하고,
		//그 변수의 이름을 num으로 지정
		
		int[] arr; //배열 선언
		//Stack 영역에, int[] 자료형을 참조할 변수를 생성하고
		//그 변수의 이름을 arr로 지정
		//참조하는 것은 아직 없음 ->할당 해야함
		
		arr=new int[4];//배열 할당
		//new -> Heap영역에, int자료형 4개를 가지는 배열을 할당한 후
		//생성된 배열의 주소를 arr 변수에 대입해라
		//->arr을 이용해서 배열을 참조할 수 있음
		
		
		//배열 초기화(처음으로 값 대입하기)
		// 1) 초기화 전 : 빈칸으로 있을 수 없어서 기본값(0)으로 초기화돼있음
		//											->0이 대입돼있는지 확인해보기(Debug 이용)
		//		* Bug : 프로그램 수행 중 발생하는 오류 (==Error)
		//		* Debug : 프로그램 수행 중 특정 시점이나 원하는 지점에 어떤 값을 지니고 있는지 확인하는 것
		//							->코드 상태, 오류 등을 발견, 분석할 수 있음 (버그를 잡는 것)
		//		* Patch : 설치?
		System.out.println("초기화 전");
		//옆에 행 번호 더블클릭 시 점 생기는데, 
		//그 점 = break point(해당 줄 코드 해석 "전"에! 그 줄에 멈추는 점)
		//더블클릭 후 
		// Run파일에서 위에 벌레모양 누르면 디버그 모드 시작!프린트로 매번 찍기보다 디버그모드 사용
		// 2) 인덱스를 이용한 초기화
		arr[0] = 100;
		arr[1] = 2000;
		arr[2] = 9;
		arr[3] = 7777;
		System.out.println("초기화 후");
		/*이클립스 디버그 모드 사용 방법
		 * 1) 확인하고 싶은 코드의 줄이 아닌, "그 다음줄"에 더블클릭해서 break point추가
		 * 2) 실행 파일에서 debug 모드로 실행(위의 벌레아이콘 또는 F11번 누르기)
		 * 3) 팝업창에서 debug 화면으로 switch버튼 누른 후
		 * 4) break point가 여러개일 경우, resume 또는 F8번 눌러가며 순서대로 확인해보기
		 * 5) 확인 끝났으면 자바 모드로 다시 돌아오기
		 * */
		
		
	}
	/**
	 * 정수 4개를 입력 받아 배열에 차례대로 대입 후
	 * 결과를 디버그 모드로 확인해보기
	 */
	public void method2() {
		
		int[] arr = new int[4];//배열 선언 + heap영역에 4칸 할당
		//주소만 저장할 수 있는 참조형 변수
		
		//배열명.length : 배열 길이
		//i = 0,1,2,3
		for(int i=0 ; i<arr.length; i++) {
			System.out.print(i+"번째 인덱스 :");
			arr[i] = sc.nextInt(); //i번째 인덱스 요소에 입력값을 대입하겠다
		}
		System.out.println("결과 확인"); //이 줄 수행 전에 멈춤(break point찍기)
	}
	/**
	 * 배열 선언과 동시에 초기화
	 */
	public void method3() {
		//과목이 작성되어있는 배열 생성
		String[] subjects = {"Java", "HTML", "CSS", "JavaScript"};//String배열
		//length가 4인 배열 만들어짐 각각 0,1,2,3번 인덱스에 들어감
		
		//subjects 변수가 참조하는 배열에 있는 모든 요소의 값을
		//역순으로 출력하기
		for(int i=3 ; i>=0 ;i--) {
			System.out.printf("subjects[%d] : %s \n", i, subjects[i]);
		}
		
	}
	/**
	 * 배열의 길이를 입력 받아
	 * 입력받은 길이만큼의 배열을 생성(할당)한 후
	 * 모든 인덱스 요소에 0부터 배열 길이 미만의 난수를 대입시키기
	 * 3칸 입력 ->3칸짜리 배열 만들고 ->0,1,2 사이의 난수를 대입(중복 고려 X)
	 */
	public void method4() {
		//배열의 길이를 입력 받아
		System.out.print("배열 길이 :");
		int len = sc.nextInt();//length는 겹치니까 len 또는 leng으로 함 
		
		//입력받은 길이만큼의 배열을 생성(할당)한 후
		int[] randoms = new int[len]; //입력받은 수만큼의 배열 길이 필요
		
		//모든 인덱스 요소에 0부터 배열 길이 미만의 난수를 대입시키기
		// randoms.length ==len
		for(int i=0 ; i<randoms.length ;i++) {
			randoms[i] = (int)(Math.random()*len);
			//			Math.random(); ->0.0이상 1.0미만 double형 난수
			//double -> int로 강제 형변환
			//데이터 손실을 이용한 소수점 제거
		}
		// Arrays.toString(배열참조변수)
		//		->배열의 모든 요소를 [a,b,c] 형태 문자열로 반환해줌
		System.out.println(randoms); //직접적인 주소가 아닌 암호화된 주소 비스무리한 것 보여줌
		//randoms에는 주소만 저장돼있으니까
		System.out.println(Arrays.toString(randoms)); //배열 요소 출력
		
	}
	
	
	
	
	
}
