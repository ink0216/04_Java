package edu.kh.oop.constructor;
/*오버로딩(Over Loading : 과적)
 * - 한 클래스 내에 동일한 이름의 메서드를 여러 개 작성하는 기법
 * - 같은 이름의 메서드들이 수행하는 기능은 기본적으로 같으나
 * 		전달받은 매개변수에 따라서 조금씩 동작이 달라야 하는 경우에 
 * 		상황별로 정의를 한 것
 * - 하나의 이름으로 다양한 기능을 수행하므로 과적
 * 
 *  -오버로딩의 조건
 *  1) 메서드 이름은 똑같은 경우에
 *  2) 매개 변수는 개수, 타입, 순서가 하나라도 달라야 한다
 *  		->다르면 같은 이름으로 여러 개 만들 수 있다*/

public class Member {
//필드(==멤버변수) 만들기
	// 필드 두개로 나눠짐
	// - 클래스 변수 : static 붙은 변수
	//							->static 메모리에 할당될 때 클래스명.변수명 으로 할당되기 때문에
	//							->앞에 클래스명을 쓰게 돼있어서
	// - 인스턴스 변수 : static 안붙은 변수
	//							->인스턴스(객체)가 생성될 때 heap메모리에 할당되기 때문에
	
	//회원이 가져야 하는 필드 중 인스턴스 변수만 만들기
	//클래스에 필드 쓸 때에는 반드시 private를 써야 한다
	private String memberId; //아이디
	private String memberPw; //비밀번호
	private String memberName; //이름
	private int memberAge; //나이
	
	//필드 끝
	
	//생성자 : 객체 생성 시 필드를 초기화 + 특정 기능 수행하는 일종의 메서드(public void~~)
	//작성 규칙 -1) 반환형(void부분) 없음    -2) 생성자 이름은 클래스명과 동일해야 한다
	
	
	/*기본 생성자
	 * - 매개 변수가 하나도 없는 형태
	 * - 생성자가 하나도 작성되지 않은 경우 컴파일러(번역가)가 자동으로 추가해줌*/
	public Member() {
		//객체가 생성될 때 기능(print) 수행 가능
		//객체 생성 시 수행할 기능
		System.out.println("[기본] 생성자로 Member 객체 생성됨");
		
		//객체 생성 시 객체 초기화
		memberId="ID를 입력해 주세요";
		memberPw="PW를 입력해 주세요";
		memberName="이름을 입력해 주세요";
	}
	
	/*매개변수 생성자
	 * - 객체 생성 시 
	 * 매개변수로 전달된 값을
	 * 생성된 객체의 필드에 초기화하는 용도의 생성자*/
	public Member(String memberId,String memberPw, 
								String memberName, int memberAge) {
		//duplicate : 중복
		//중복되는 이름의 메서드가 존재한다 ->매개변수 써주면 해결됨
		System.out.println("[매개 변수] 생성자로 객체 생성됨");
		this.memberId = memberId; //지금 생성되고 있는 객체의 아이디에 전달받은 아이디를 대입한다
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
	}
	//오버로딩을 이용해서 생성자 더 만들기
	public Member(String memberId) {
		//매개변수 구성이 달라서 이름 같은 메서드 있어도 오류나지 않음
		this.memberId = memberId;
	}
	public Member(String memberId, String memberPw) {
	//매개변수 구성이 달라서 이름 같은 메서드 있어도 오류나지 않음
		this.memberId = memberId;
		this.memberPw = memberPw;
	}
	//매개변수의 개수가 같아도 타입이 다르면 이름이 같아도 오류나지 않음
	public Member(int memberAge) {
		this.memberAge = memberAge;
	}
	//매개변수의 개수가 같아도 타입이 다르면 이름이 같아도 오류나지 않음
	public Member(String memberId, int memberAge) {
		this.memberId = memberId;
		this.memberAge = memberAge;
	}

	//매개변수의 개수가 같아도 매개변수의 순서가 다르면 이름이 같아도 오류나지 않음
	public Member(int memberAge, String memberId) {
		this.memberAge = memberAge;
		this.memberId = memberId;
	}
	
	//오버로딩이 안되는 경우
//	public Member(int memberAge, String memberPw) {
// //컴퓨터에게 변수명은 중요하지 않고, 자료형의 개수, 순서, 타입 이런게 달라야 한다
//		근데 바로 위의 것과 다 같음
//		순서 : int - String
//		타입 : int, String
//	}
//Duplicate method Member(int, String) in type Member
	// -> Member(int, String) 생성자 중복
	// --> 오버로딩은 변수명이 아닌 자료형이 개수,순서,타입 중
	//		 하나라도 달라야 성립!
	//public Member(int memberAge, String memberPw) {}
	
	//오버로딩 - 오버라이딩 비교!!! 둘다 많이 사용
	//=================================================================
	//this : 현재 객체의 시작 지점의 주소가 들어가있는 참조변수 
	//a    new Member() 안의 this ==a 
	//b    new Member() 안의 this ==b
	//a에서 실행했으면 this==a, b에서 했으면 this==b
	//this == 현재 객체를 참조 != 현재 클래스를 참조
	// class != instance(==객체)
	
	/*this() 생성자 ->코드 중복, 길이 감소 용도.근데 거의 안씀*/
	public Member(int memberAge, String memberId, String memberPw)	{
		//세 개 짜리는 없었음
		
	//현재 클래스에 있는 다른 생성자 중에서 매개변수가 두개이면서
	//int, String 순서를 가진 생성자를 호출 ->this 에 ctrl클릭하면 찾아서 감
	this(memberAge, memberId);
	this.memberPw = memberPw;
	}
	
	
	
	
	
	//private이니까 간접접근 방법 만들어야 한다
	//기능(메서드)
	//setter 다 만들기 : 전달받은 매개변수를 현재 객체의 필드에 대입하는 기능
	public void setMemberId(String memberId) {
		//아이디를 전달받아서 세팅할거다
		//매개변수로 전달받아옴
		this.memberId = memberId;
		//전달받아온 아이디를 현재 객체의 아이디에 대입
	}
	public void setMemberPw(String memberPw) {
		//비밀번호를 전달받아서 세팅할거다
		//매개변수로 전달받아옴
		this.memberPw = memberPw;
		//전달받아온 비밀번호를 현재 객체의 비밀번호에 대입
	}
	public void setMemberName(String memberName) {
		//이름을 전달받아서 세팅할거다
		//매개변수로 전달받아옴
		this.memberName = memberName;
		//전달받아온 이름을 현재 객체의 이름에 대입
	}
	public void setMemberAge(int memberAge) {
		//나이를 전달받아서 세팅할거다
		//매개변수로 전달받아옴
		this.memberAge = memberAge;
		//전달받아온 나이를 현재 객체의 나이에 대입
	}
	
	//getter :현재 객체의 필드를 외부에서 얻어갈 수 있게 반환해주는 기능
	//setter,getter의 작성 규칙 지켜서 쓰기!
	public String getMemberId() {
		//반환해주는 아이디가 string이므로 void대신 string쓰기
		return memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public int getMemberAge() {
		return memberAge;
	}
	
	
	/**<pre>
	 * 현재 객체의 필드값을 한번에 출력하기
	 * 회원 정보 보는 것 만들기
	 * </pre>
	 */
	public void inform() {
		//inform = 알리다
		System.out.println("\\n-------------------------------------------");
		System.out.println("memberId : "+memberId);
		System.out.println("memberPw : "+memberPw);
		System.out.println("memberName : "+memberName);
		System.out.println("memberAge : "+memberAge);
		System.out.println("\\n-------------------------------------------");
	}
	
	
	
	
	
	
	
}
