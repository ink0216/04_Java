package edu.kh.oop.field.pack3;

public class Korean {
//한국인 만들기
	//추상화 이용 공통점
	
	public static int nationalCode =82; //국가 코드 휴대폰번호 가짐
	//static = 정적 메모리 영역에 생성(칠판에 써둠) 
	
	//static이 붙은 필드는 프로그램 실행 시 
	//static메모리 영역에 할당된다
	
	/* static 필드 앞에 public을 99.9% 작성하는 이유
	 * ->어디서든지 누구든지 공유할 수 있도록 하는 게 목적이기 때문에
	 * name, id를 쓰려면 객체 생성을 해야하는데(heap메모리에 할당) 
	 * static 붙은 애들은 이미 static 영역에 할당돼있어서 객체생성 안해도 쓸 수 있다
	 * 그때에는 private쓰기도 함 */
	
	//static이랑 final을 같이 쓸 수 있다. 그 경우 테스트해보기
	public static final String ANCESTOR = "단군 할아버지";
	//static과 final의 순서는 바꿔서 써도 문제 없음
	//public : 어디서든지 쓸 수 있고
	//static : 공유할거다
	//final : 근데 공유하는 데이터가 안바뀔거다
	
	//공유할건데 절대로 변하면 안되는 값일 경우 사용
	//static final 대표적 예시 
	//	-Math.PI
	//	-Integer.MAX_VALUE / Integer.MIN_VALUE
	
	
	
	//이름 주민번호
	private String name;//이름
	private String id; //주민등록번호(식별번호)
	
	{// 초기화 블럭 : 객체 생성 시 여러 필드(변수)를 {}내부의 값으로 한번에 초기화 
		//따로따로 해두면 가독성이 안좋아서 쓰는데 많이 쓰진 않음 ->나중에 더 강력한거 나와서 그거씀 
		name="김길동";
		id="981122-1234567";
//		nationalCode=1; //이렇게 하면 객체 생성될 때마다 이 초기화 블럭 코드가 실행됨
										//Static이 붙은 것들은 static 블럭 따로 만듬
	}
	//static 초기화 블럭(static붙은 구문은 프로그램 실행 시 1회만 읽음
	//	->Korean 객체가 100만번 생성되어도 처음 1회만 읽고 사라짐
	static {
		nationalCode=10;
	}
	//여기까지가 필드 쓴 것임 필드 완료!
	
	/*메서드(기능)*/
//	private은 외부에서 접근 불가능하니까 간접접근방법 만들기
	// 간접적으로 이름 집어넣는 것과 가져가는 기능
	//이름 집어넣는 기능
	public void setName(String name) {
		
		this.name = name;
		//매개변수로 전달받아온 값(String name)을
		//현재 객체의 name필드에 대입하겠다(간접접근)
	}
	//아이디 집어넣는 기능
	public void setId(String id) {
		
		this.id = id;
		//매개변수로 전달받아온 값(String id)을
		//현재 객체의 id필드에 대입하겠다(간접접근)
	}
	//외부에서 이름 얻어가는 기능
	public String getName() {
		//받아올 건 없으니 매개변수 안씀
		//void ==반환하는 게 없다
		//지금은 반환하는 것이 있으니 반환하는 name의 자료형인 String을 void자리에 써야 함
		return name;
		//반환형 String : 메서드 종료 시 String 객체를 반환
	}
	//외부에서 아이디 얻어가는 기능
	public String getId() {
		//받아올 건 없으니 매개변수 안씀
		//void ==반환하는 게 없다
		//지금은 반환하는 것이 있으니 반환하는 id의 자료형인 String을 void자리에 써야 함
		return id;
		//반환형 String : 메서드 종료 시 String 객체를 반환
	}
	
	
}
