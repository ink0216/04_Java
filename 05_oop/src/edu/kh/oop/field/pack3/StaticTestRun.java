package edu.kh.oop.field.pack3;

public class StaticTestRun {
public static void main(String[] args) {
	//메인메서드 작성
	//Korean 객체 두명 생성(한국인 객체)
	Korean k1 = new Korean();
	Korean k2 = new Korean();
	//이 파일 실행 ->static키워드가 작성된 필드/메서드를 컴파일러가 다 찾아서 static 영역에 할당
	//(할당 시 이름은 클래스명.필드명 or 클래스명.메서드명()   이렇게 할당됨)
	//	앞에 static 키워드 붙은 StaticTestRun.main()과 Korean.nationalCode가 static 영역에 할당됨
	//근데 Korean.nationalCode에는 82라는 값이 들어가있음
	
	//JVM이 메인메서드 찾아서 실행
	//	->Stack에 Korean객체의 주소를 저장하는, Korean자료형인 k1변수를 하나 만들고
	//	-> 그 변수가 참조하는 객체를 heap영역에 만듦
	//	->간접접근방법 통틀어 getter/setter , nationalCode, name, id가 heap에 생성됨
	//한국인 객체 세트를 둘 만듦(stak영역과 heap영역에)
	//그리고 참조하는 객체의 주소를 k1과 k2 변수에 대입한다
	//메모리가 할당되면 주소 생기므로 static에 생긴 두개도 주소가 생김
	//nationalCode가 Korean클래스에 있다
	//근데 heap영역에 만들어진 두 객체의 nationalCode가 static영역에 있는 Korea.nationalCode를 참조함
	//nationalCode가 static이 붙어있어서, 값을 저장하는 게 아닌 static에 있는 Korean.nationalCode의 주소를 저장
	//얕은복사와 비슷 ->한 객체에서 수정하면 다른 객체에서도 수정한 것으로 보임
	//객체는 두개이지만 두 객체가 하나의 static영역의 요소를 참조하므로
	System.out.println("k1의 nationalCode :"+k1.nationalCode);
	System.out.println("k2의 nationalCode :"+k2.nationalCode);
	
	//k1을 이용해서 국가 코드 변경해보기 ->그럼 k2의 값도 바뀔까?
	k1.nationalCode=1; 
	//k1이 참조하고 있는 곳의 nationalCode가 참조하고 있는 곳의 값을 1로 바꾸겠다
	//5000만 국민이 다 같은 것 참조하고 있었으면 한번에 다 바뀜
	
	System.out.println("-----nationalCode 변경 후-----");
	System.out.println("k1의 nationalCode :"+k1.nationalCode);
	System.out.println("k2의 nationalCode :"+k2.nationalCode);
	
	//nationalCode밑에 노란줄(경고, 없는 게 좋음) 있는 이유 
	// The static field Korean.nationalCode 
	// should be accessed in a static way
	// static field에 있는 것은 static만의 방법으로 접근해야 한다
	// ->"static 필드는 static 방법으로 접근해야 한다"
	//		== k1.nationalCode처럼 객체의 필드명/메서드명으로 부르지 말고 
	//				static 영역에 할당돼있는 이름으로 불러라
	//				k1이 가진 nationalCode로 쓰지 말고 (개인적)
	//				한 명만 참조하는 게 아니라 모든 국민들이 공유해서 참조하는 것이기 때문에
	//				객체의 독립된 필드로 인식될 수 있기 때문에
	//				헷갈리지 않게 정해져 있는 이름으로만 부르자!
	//static이라고 써진 애들은
	System.out.println("Korean.nationalCode :"+Korean.nationalCode); //이렇게 쓰면 에러안남
	
	
//static이랑 final을 같이 쓸 수 있다. 그 경우 테스트해보기
	System.out.println("우리의 조상님 : "+Korean.ANCESTOR);
	
	//공유할건데 절대로 변하면 안되는 값일 경우 사용
	//static final 대표적 예시 
	//	-Math.PI
	//	-Integer.MAX_VALUE / Integer.MIN_VALUE
	System.out.println(Math.PI);
	System.out.println(Integer.MAX_VALUE); //자바에서 제공하는 int의 최댓값
	System.out.println(Integer.MIN_VALUE); //자바에서 제공하는 int의 최댓값
	
}
}
