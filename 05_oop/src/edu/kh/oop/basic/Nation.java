package edu.kh.oop.basic;

//클래스 : 객체가 가져야 할 속성(값), 기능(메서드)를
//글(코드)로 작성해 둔 문서(설계도)
//		== 객체에 대해 정의한 문서
/**
 * 국민 객체를 만들 것인데
 * 국민 객체를 만들기 위한 클래스 작성
 * 우선 공통점 먼저 추출해보기
 */
public class Nation {
//Nation = 국민(객체)
	
	
	//공통점 뽑아내기
	
	//속성(값)을 기록할 수 있는 공간(변수)마련하기
	String name; //이름 //변수만 딱 만들어둠
	int age; //나이
	char gender; //성별(char-한글자, 남 or 여)
	String juminNumber; //주민번호는 int가 아닌 String으로 하는 게 좋음
	String tel; //전화번호도 int가 아닌 String으로 하는 게 좋음
	String address; //주소
	
	//기능(메서드) 무슨 동작을 공통적으로 할 수 있나? -추상화로 클래스 만들기
	public void speakKorean() {
		System.out.println("가나다라 한국어 가능");
	}
	public void welfare() {
		System.out.println("우리나라에서 제공하는 복지를 누릴 수 있음");
	}
	//기능(메서드) 무슨 동작을 의무적으로 할 수 있는지도 할 수 있음
	public void 납세의의무() {
		//만 19세 이상인 성인만 세금을 낸다고 가정
		if(age>=19) {
			
			System.out.printf("%s님은 세금 납부 대상자 입니다.\n", name);
		} else {
			System.out.printf("%s님은 %d세 미성년자로, 세금 납부 대상자가 아닙니다.\n", name, age);
		}
	}
	/**
	 * 자기소개 기능
	 */
	public void introduce() {
		System.out.printf("이름은 %s이고, %d세 %c성입니다.\n", 
				name,age,gender); //여기서는 n1.안붙여도 됨
	}
	
	
	
	
	
	
}
