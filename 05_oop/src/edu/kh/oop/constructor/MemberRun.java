package edu.kh.oop.constructor;

public class MemberRun {
public static void main(String[] args) {
	//매개변수로는 스트링 배열 받아올 수 있다
	
	//회원 객체 생성
	// ->기본 생성자를 이용해서 생성한 것!
	Member member1 = new Member(); //기본생성자
	
	member1.inform(); //멤버1의 인폼 메서드 호출
	//null == "참조하는 객체가 없다" 를 나타내는 값
	//		 == "저장된 주소가 없다"
	//			!== "비어있다"
	
	
	//member1 객체가 참조하는 Member객체의 필드값을 세팅
	member1.setMemberId("member01");
	member1.setMemberPw("pass01");
	member1.setMemberName("김회원");
	member1.setMemberAge(27);
	
	//새로운 멤버 객체 생성 후 필드값 세팅
	Member member2 = new Member(); //기본생성자로 만듦
	member2.setMemberId("member02");
	member2.setMemberPw("pass02");
	member2.setMemberName("최회원");
	member2.setMemberAge(30);
	
	//두 객체의 정보 출력하기
	System.out.println("[member1]");
	member1.inform();
	
	System.out.println("[member2]");
	member2.inform();
	
	//회원을 더 만들면 이 긴 세트를 회원 수대로 다 써야함 ->불편!
	//	->만들면서 바로 초기화 하는 방법 없을까?
	//	->매개변수 생성자!!!! 이걸로 세번째 멤버 만들기 ->코드 길이 감소를 위해 사용
	
	//-----------------------------------------------------------------------
	//매개 변수 생성자를 이용해서 Member3객체 생성
	Member member3 = new Member("member03", "pass03", "박회원", 20); //매개변수 생성자
	//객체 생성하자마자 필드가 작성됨
	System.out.println("[member3]");
	member3.inform();
	
	Member member4 = new Member("member04", "pass04", "이회원", 40); //매개변수 생성자
	//객체 생성하자마자 필드가 작성됨
	System.out.println("[member4]");
	member4.inform();
	
	//생성자에 들어가있는 오버로딩 기술 : 다형성과도 연관 있음
	// 프로그래밍 언어에서 변수명, 함수명, 메서드명 등의 중복을 허용하지 않음
	// 헷갈리고 잘못 호출할까봐
	//근데 Member()와 매개변수 있는 Member()의 생성자함수 이름이 겹치는데 허용됨
	//하는 일이 달라서 (한 애는 입력한 값을 대입하고 한 애는 값을 전달받아서 대입함)
	
	
	
	//변수명 중복
		int a=10;
	//	int a=20;
	
	}

//메서드명 중복
public void test() {}
//public void test() {}



}
