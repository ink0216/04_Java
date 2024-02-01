package edu.kh.oop.basic;

/**계좌 클래스
 * 모든 계좌가 공통적으로 가져야 할 것
 * 
 */
public class Account {
//[캡슐화]
	//-객체의 속성(필드) 직접 접근을 제한하는 것이 원칙
	//-직접 접근을 제한하기 위해서 모든 필드에 private이라는 키워드 작성
	//	(private : "현재 객체만 접근 가능한", 사적인, 개인적인)
	
	//속성에 직접 접근할 수 없으므로 
	//그러면 외부에서 필요한 사람들도 여기에 접근을 못하게 된다
	//-외부에서 간접접근할 수 있는 기능을 제공해야 한다! (간접 접근 기능)
	//매개변수, 반환 기능 필요
	
	//객체의 속성 만듦 (값들이 저장될 공간 만듦)
	private String name; //이름(예금주)
	private String accountNumber; //계좌번호
	private long balance; //잔액(큰돈 쓰려고 int아닌 long으로)
	private String password; //비밀번호
	//->private붙였으면 직접적으로는 접근 못하고 간접적으로 접근해야 함
	
	//객체는 Heap영역에 저장돼있는데 Heap영역에 있는 것들은 빈칸으로 존재할 수 없어서
	//초기화 안해둬도 자동으로 0 들어가있음
	
	//	private : 나만 볼 수 있도록
	//이거 없으면 전광판에 공개해 둔 것 과 같음
	//그리고 밑의 코드들에서 바뀔 수 있게 열어둔 것과 같으므로 바뀌면안되는 계좌번호, 이름 같은거는 private로
	
	//name 변수에 값을 세팅하는 간접 접근 기능 만들어보기
	//외부로부터 받아온 이름을 집어넣어주기 -> 매개변수를 써야 함
	//이름 :String자료형
	//JS에서는 자료형은 안써도 됐었음
	
	//반환(return) : 
	//매개변수 : 전달 받아온 값을 저장하는 변수
	
	public void setName(String inputName) {
		//이름을 세팅
		//매개 변수 String inputName ->String타입의 데이터를 전달 받아 저장할 매개변수==inputName
		name=inputName; //전달받은 값을 name속성에 저장해라
	}
	
	//name 변수의 값을 돌려보내주는 간접 접근 기능 만들기
	public String getName() {
		//set<->get
		return name;
		//// Void methods cannot return a value
		//void : 반환할 값이 없다
		//<->반환할 값이 있을 경우, 그 값의 자료형을 작성(반환형, 반환되는 값의 자료형)
		
	}
	
	//accountNumber 값 세팅하는 간접 접근 기능
	//this : 현재 이 객체
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber; 
				//외부에 있는 값을 얻어와서 대입해야하므로 매개변수 필요한데
				//매개변수의 자료형이 String
			//현재 객체가 가지고 있는 accountNumber에 얻어온 값 대입
	}
	
	//accountNumber 값을 반환하는 간접 접근 기능
	public String getAccountNumber() {
		//다른 사람 입장에서 이걸 얻어와보는 것이니까
		return accountNumber; //accountNumber의 자료형이 String이니까 void자리에 String작성
	}
	
	//password 값 세팅하는 간접 접근 기능 (password 값을 반환하는 것은 말이 안되므로 안만듦)
	public void setPassword(String password) {
		this.password = password;//현재 객체가 가지고 있는 패스워드에 새로 입력된 값을 입력받아와서 (매개변수)넣겠다
	}
	
	//balance값 반환하는 간접 접근 기능(balance값을 우리가 세팅한다고 하면 말 안되므로 안만듦)
	public long getBalance()	{
		return balance; //void일 때에는 리턴 불가하므로 반환하려는 balance의 자료형 long을 void자리에 써주기
	}
	
	//모든 계좌에 있어야 하는 기능
	
	//입금 기능
	/**
	 * 전달 받은 금액을 balance에 누적한 후
	 * 현재 balance을 콘솔에 출력하기
	 * 전달받으려면 매개변수 필요
	 * 입금양(amount)도 long형으로 하기
	 */
	public void deposit(long amount) {
		balance +=amount; 
		System.out.println(name+"의 현재 잔액 :"+balance);
	}
	
	//출금 기능
	/**
	 * 비밀번호와 출금할 금액을 전달 받아와(매개변수 2개 필요)
	 * 비밀번호는 String형 금액은 long형
	 * 조건에 맞으면 잔액에서 차감 후 현재 잔액을 출력
	 * 
	 * 조건1) 비밀번호가 일치하지 않으면 "비밀번호 불일치" 출력
	 * 조건2) 출금할 금액이 잔액보다 크면 "잔액 부족" 출력 
	 * 
	 * @param pw : 전달된 비밀번호
	 * @param amount : 출금할 금액
	 * @ :매개변수
	 */
	public void withdraw(String pw, long amount) {
		// 자바에서는 문자열 비교를 ==로 할 수 없음!
		//자바에서 기본 자료형 8개 비교는 ==로 하는 것 맞지만
		//	객체(참조형) 비교는 A.equals(B)로 해야 함
		//String은 기본자료형 아닌 char의 객체임 참조형
		
		//
		//현재 계좌 비밀번호(password)와 
		//전달받은 비밀번호(pw)가 같을 경우 true 반환 ,다르면 false반환
		if(!password.equals(pw)) {
			//password : 전달받은 게 아닌 객체가 갖고 있는 비밀번호
			//비밀번호가 같지 않을 경우에 if문 실행됨
			System.out.println("비밀 번호 불일치"); 
			return; //뒤에 잔액 비교 등 할 필요 없으므로 메서드 종료 +호출한 곳으로 돌아감
		}
		
		//출금하려는 금액이랑 잔액이랑 비교
		//출금할 금액이 잔액보다 큰 경우
		if(amount>balance) {
			System.out.println("잔액 부족");
			return; //더 할 것 없으니 메서드 종료+ 호출한 곳으로 돌아감
		}
		//같은 단어 한번에 수정 : alt shift R 동시에 누르기
		//두 if문을 잘 건너왔으면 비밀번호 맞았고 잔액도 충분한 것!
		//출금 금액만큼 잔액에서 차감하고 나서 잔액 출력
		balance -=amount;
		System.out.printf("%s 계좌에서 %d원 출금\n", accountNumber, amount);
		System.out.println(name + "의 현재 잔액 : " + balance);
	}
	
	
	
}
