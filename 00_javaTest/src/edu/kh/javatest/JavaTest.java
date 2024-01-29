package edu.kh.javatest;
// : 한 줄 주석
// 클래스 이름 첫 글자는 반드시 대문자로 써야 함! 
//주석 : 컴파일러가 해석하지 않는 구문
//		->코드 설명 작성 시 사용
//자바는 항상 프로젝트, 패키지 만들고 코드 짬
public class JavaTest {
	//class - 자바 코드를 작성하는 영역
	//			- 객체의 내용(속성, 기능)을 정의함
	//			(JS의 생성자 함수와 비슷한 형태 <-둘다 객체지향 언어여서)
	
	// alt + shift + j : 클래스/메서드를 설명하는 용도의 주석(html 방식으로 작성)
	/** main 메서드 
	 * <p>
	 * 자바 프로그램을 실행시키기 위해서 반드시 필요한 구문(기능)
	 * </p>
	 * @param args
	 */
	public static void main(String[] args){
		// 자바 코드 실행 방법
		// 1) 위에 Run 버튼(재생버튼 처럼 생긴 것) 클릭
		// 2) 실행 단축키 ctrl +f11
		
		// System.out.println();
		// ->()안의 문자열을 console에 출력 후 줄바꿈
		// JS에서 ""가 문자열이었는데 여기서도 똑같음
		System.out.println("Hello World");
		System.out.println("Java는 코드 끝에 꼭 ;(세미콜론)을 붙여야 됩니다!");
		System.out.println("println()구문 자동완성은 sysout ->ctrl space");
		System.out.println(100*200); // 숫자 연산도 가능
		//console.log(JS) == println(Java)
		System.out.println(100 + 30 +"입니다"); //이어쓰기도 똑같음
		System.out.println("합계 : " + 2222 + 333 +"원");// 합계 : 2555원 ? //이어써짐!!
		//더하기는 앞에서부터 하나씩 더해짐
		//문자열과 숫자가 더해지면 문자열이 생김(합계 : 2222)
		// 사칙연산 우선순위 적용
		//먼저 연산하고 싶은 부분은 소괄호()로 묶어준다
		System.out.println("합계 : " + (2222 + 333) +"원");
		// Java API DOC 확인 : 알아보고 싶은 것 클릭 후 shift +f2 하면 페이지 열림
		// 많이 이용함! 
		// Java API DOC : 자바가 만들어서 제공하는 코드에 대한 설명 문서
		
	}
	

}
