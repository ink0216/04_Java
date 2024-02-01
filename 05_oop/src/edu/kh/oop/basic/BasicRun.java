package edu.kh.oop.basic;

public class BasicRun {
//여기에 실제 국민 객체 만들기
	public static void main(String[] args) {
		//국민 객체 생성
		// ==국민(Nation)클래스의 내용대로 똑같이
		//	Heap 영역에 할당하는 것
		
		Nation n1 = new Nation(); // Heap이라는 메모리 영역에 Nation클래스의 내용 그대로 만들어짐
		//n1에 주소만 저장됨
		//n1이 참조하고 있는 객체
		
		//점, 하위 접근 연산자(.) (~안에 있는 것 중에서)
		//객체의 속성/기능에 접근, 호출, 실행시키는 연산자
		n1.name = "홍길동"; //n1이 참조하고 있는 객체에서 각각의 정보를 꺼내와서 대입하기
		//n1이 참조하고 있는 객체의 name 변수에 직접 "홍길동" 직접 접근하는 것
		//		->이러한 데이터(속성)으로의 직접접근을 제한하는 것이 원칙!
		//		->캡슐화
		n1.age = 34;
		n1.gender = '남';
		//자기소개 시키기
		System.out.printf("이름은 %s이고, %d세 %c성입니다.\n", 
				n1.name,n1.age,n1.gender);
		
		
		//국민 객체 하나 더 생성
		Nation n2=new Nation(); //Heap영역에 Nation객체를 새로 만든다
		//Nation클래스 보고 Nation객체 그대로 만듦
		//만들어진 객체의 주소를 n2에 저장한다
		
		//Nation 객체 참조 변수 n2에
		//Heap영역에 Nation클래스를 이용해 생성된 객체의 주소를 대입
		
		n2.name = "신짱구";
		n2.age =5;
		n2.gender = '남';
		n2.introduce(); //짱구야 자기소개해봐
		
		
		
		
		//국민 객체 하나 더 생성
		Nation n3=new Nation();
		n3.name="봉미선";
		n3.age =29;
		n3.gender ='여';
		//만약 국민이라면 모두 자기소개 해야 한다고 가정
		//->모두에게 다 쓰면 코드 너무 길어지니까 Nation에 추상화 써서 기능 만들기
		n3.introduce(); //봉미선 자기소개
		
		//모두 다 납세의 의무 확인해보기
		n1.납세의의무(); //n1이 홍길동 객체 나타냄
		n2.납세의의무(); //n2이 신짱구 객체 나타냄
		n3.납세의의무(); //n3이 봉미선 객체 나타냄
		
		
		System.out.println("객체 생성 확인");
	}
}
