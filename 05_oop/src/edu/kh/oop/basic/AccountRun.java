package edu.kh.oop.basic;

public class AccountRun {
	public static void main(String[] args) {
		
	
		//Account객체를 heap영역에 새로 생성
	Account a1 = new Account(); //계좌 생성
	
	//private이 설정된 값과 설정이 안된 값으로의 접근이 가능한지 확인해보기
	//	a1.accountNumber ="1";
	//	a1.name="홍길동"; //이 둘은 잘 되는데
	
	//	a1.balance;
	//	a1.password; //이 둘은 오류남(처음에는 이 둘에만 private걸어놨었어서)
	//private을 적용한 변수(필드)는 외부에서 보이지 않음
		//The field Account.balance is not visible
	
	
	//간접 접근 기능을 이용해서 값을 세팅
	a1.setName("신형만");
	
	//간접 접근 기능을 이용해서 객체의 속성값을 얻어와 출력하기
	String name1 = a1.getName(); //String으로 얻어와지니까 String에 저장가능
	System.out.println(name1);
	
	a1.setAccountNumber("1234-56-7890"); //우리가 만들 수 있는 계좌번호
	a1.setPassword("7890"); //비밀번호도 우리가 만들 수 있음
	//신형만 계좌 생성 완료! 
	
	//짱아 계좌 생성
	Account a2 = new Account(); //Account라는 클래스를 보고 Heap 영역에 객체 만들고 참조변수에 그 객체의 주소 저장
	a2.setName("신짱아");
	a2.setAccountNumber("111-222-333");
	a2.setPassword("7777");
	//짱아 계좌 생성 완료!
	
	//신형만, 신짱아 각 계좌에 입금
	a1.deposit(1000000); //int자료형으로 써도 long에 들어갈 수 있음
	// =도 대입"연산자"여서 서로 다른 자료형끼리 연산하면 컴파일러가 int자료형을 long형으로 자동형변환해줌
	//근데 찝찝하면 1000000L로 쓰면 됨
	a1.deposit(2345L);
	
	a2.deposit(50000);
	a2.deposit(3000L);
	
	System.out.println("---------------------------------------");
	//각 계좌에서 출금하기
	//비밀번호랑 금액 입력
	a1.withdraw("1234", 2000000); //비밀번호(7890) 불일치
	a1.withdraw("7890", 2000000); //잔액 부족
	a1.withdraw("7890", 50000); //출금 성공
	
	System.out.println("---------------------------------------");
	//각 계좌에서 출금하기
	//비밀번호랑 금액 입력
	a2.withdraw("1234", 2000000); //비밀번호(7777) 불일치
	a2.withdraw("7777", 2000000); //잔액 부족
	a2.withdraw("7777", 50000); //출금 성공
	
	
	}
	
}
