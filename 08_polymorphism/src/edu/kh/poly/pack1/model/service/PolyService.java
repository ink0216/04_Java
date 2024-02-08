package edu.kh.poly.pack1.model.service;

import edu.kh.poly.pack1.model.dto.Galaxy;
import edu.kh.poly.pack1.model.dto.Iphone;
import edu.kh.poly.pack1.model.dto.SmartPhone;

//다형성 연습하는 서비스
public class PolyService {
/*다형성 : 다양한 형태를 지니는 성질
 * 두 가지 확인해보기
 * 	-1 ) 상속 관계의 자식 객체의 모습이 여러 모습으로 보임
 * 				-> 자식 객체(자기 자신), 부모 객체, Object객체(최상위 부모) 등으로 변하는 것 처럼 보임
 *  -2 ) 오버로딩도 다형성의 일종
 *  			-> 같은 클래스에서 같은 이름의 메서드를 여러 번 작성하는 기술
 *  			-> 조건 : 메서드명 동일, 매개변수 개수, 타입, 순서 하나라도 달라야 함
 *  			-> 오버로딩의 목적 : 전달 받은 매개 변수에 따른 상황별 처리 방법을 구현하는 것
	*			   sum(a,b) : 두 수 더하기
	*			   sum(a,b,c) : 세 수 더하기
	*			   sum(배열) : 배열 내 요소 모두 더하기
	*			   sum(배열, 배열) : 두 배열의 요소 모두 더하기
	*			  		--> 이름은 sum 하나인데 상황에 따라 처리하는 코드가 변하는 것처럼 보임*/
	
	/**
	 * 다형성 확인 1
	 * 부모 타입 참조 변수 = 자식 객체;
	 * 	->자식 객체가 부모 객체로 변한 것 처럼 보임
	 * 	==Up casting(윗쪽 타입으로 변함)(부모 요소로 거슬러 올라가서 변함)
	 * casting = 형변환
	 * auto casting = 자동 형변환
	 * 
	 * 자식 객체를 참조하는 모양
	 * 원래 안되는 건데 자식 안에 부모객체 와있으면
	 * 부모님 만나러 자식 집 와서 부모님 만나는거니까 됨
	 * ->자식의 것들은 건너뛰고 자식 안의 부모 코드만 사용할 수 있게 됨
	 * 찾아온 것은 자식 집이지만 실제로는 부모만 참조*사용할 수 있게 돼서 자식 부분은 없어진 것처럼 보임
	 * 자식 객체는 그대로 존재하지만 자식이 없어진 것처럼 보여서 자식이 부모가 된 것처럼 보임
	 * 자식 객체 부분 중 부모 객체를 제외한 부분은 참조할 수 없음
	 * + 메모리구조 꼭 같이 확인해보기!!(그리면서)
	 */
	public void method1() {
		//양 변의 자료형 다른데 왜 오류 안나징?
		//SmartPhone자료형 = Iphone / Galaxy 자료형
		//SmartPhone 자료형은 Iphone/Galaxy의 내부 부모 객체 SmartPhone자료형만 참조 가능함
		//	->원래는 컴퓨터 값 처리 원칙에 위배(자동 형변환 대상 X)되지만
		//		자식 객체 내부에 존재하는 부모 타입(SmartPhone)의 객체만 참조하게 된다!
		//	-> 자식 객체의 모습이 부모 객체로 변한 것 처럼 보인다! == 다형성
		//		언제는 자식으로 기능했다가 언제는 부모로 기능하는 것처럼 보임
		//자동 형변환 : 숫자일 때에만 적용됨
		SmartPhone s1 = new Iphone();
		SmartPhone s2 = new Galaxy();
		
		//상속 받은 부모 기능 호출 : 가능 O!
		s1.setDisplay("레티나 디스플레이");
		s2.setDisplay("AMOLED");//발광유기디스플레이
		System.out.println("s1.display :" +s1.getDisplay());
		System.out.println("s2.display :" +s2.getDisplay());
		
		//자식 기능 호출 : 가능 X!
		//s1.setIosVersion(17); //오류
		//s2.setAndroidVersion(14); //오류
		// //이 둘은 자식만 가지고 있는, 부모 객체 외부 부분이어서 사용 불가
		//오류 
		// The method setIosVersion(int) is undefined for the type SmartPhone
		//스마트폰한테 setIosVersion이 정의되지 않았다(==없당)
		
	}
	/**
	 * 다형성 확인 2
	 * (자식 타입) 부모 타입 참조 변수 -> Down Casting, 다운 캐스팅
	 * - 업 캐스팅된 객체(자식이 부모로 보이는 것)를 참조하던 부모타입 참조변수(stack에 위치)를
	 * 		자식 타입으로 강제 형변환 하여 
	 * 		다시 자식 객체를 참조하도록 변경시킴(부모 -> 자식)
	 * - 다운 캐스팅은 업캐스팅 상태가 되어있는 상태에서 가능하고
	 * 		업캐스팅은 상속 관계가 있는 상태에서 가능 
	 */
	public void method2() {
		//업 캐스팅 만들기 (좌변이 부모 타입, 우변이 자식 타입인 것으로 알 수 있음)
		SmartPhone s1 = new Iphone();
		SmartPhone s2 = new Galaxy();
		
		//다운 캐스팅 전 -> 참조변수가 계속 부모라서 자식만의 기능에는 접근 불가
		//									참조변수가 부모 타입이어서 부모 객체의 기능에만 접근 가능
		//	int v1 = s1.getIosVersion();
		//	int v2 = s2.getAndroidVersion();
		
		//다운캐스팅 만들기 ->자식 기능 접근 가능
		//					(참조 변수가 자식 타입으로 변해서 자식 객체 참조 가능)
		int v1 = ((Iphone)s1).getIosVersion();
				//(Iphone)s1으로 강제형변환 해준 다음에
				//그걸 소괄호로 다시 묶고 해야 함
		int v2 = ((Galaxy)s2).getAndroidVersion();
		
		//다운 캐스팅 + 얕은 복사(주소만 복사)
		Iphone i1 = (Iphone)s1; //s1을 Iphone타입으로 강제형변환 해서 타입 맞춰주고 주소를 대입
		
		Galaxy g1 = (Galaxy)s2;
		//앞의 괄호 두 번 쓰는 것 보다
		//참조변수를 하나 만들어 놓고 하는 이 방법이 더 많이 사용됨
		//자식 객체 메서드 참조 코드 작성이 간편해짐
		i1.setIosVersion(20);
		g1.setAndroidVersion(30);
		System.out.println("i1.iosVersion :"+i1.getIosVersion());
		System.out.println("g1.AndroidVersion :"+g1.getAndroidVersion());
	}
	/**
	 * 다형성 확인 3
	 * ->정적 바인딩
	 * : 프로그램이 실행되기 전의 컴파일(번역) 단계에서
	 * 		호출되는 메서드가 어떤 클래스의 메서드와 연결되는지 결정하는 것
	 * 
	 */
	public void method3() {
		SmartPhone s1 = new SmartPhone(); //SmartPhone 객체 생성
		s1.setAp("M1");
		//setAp 메서드를 호출할 것인데 SmartPhone에 써져있는 setAp가 실행됨
		//SmartPhone의 setAp와 연결돼있음 == 정적바인딩
		// void edu.kh.poly.pack1.model.dto.SmartPhone.setAp(String ap)
		// SmartPhone의 setAp() 메서드와 연결된다
		Galaxy g1 = new Galaxy();
		g1.setAndroidVersion(20); //Galaxy클래스에 있는 setAndroidVersion메서드와 연결돼있음
		// void edu.kh.poly.pack1.model.dto.Galaxy.setAndroidVersion(int androidVersion)
		
		 
	}
	/**
	 * 다형성 확인 4 ->동적 바인딩
	 * -프로그램이 실행되기 "전"에 바인딩 하는 것 
	 * 		== 정적 바인딩
	 * 바인딩 == 묶다 연결하다
	 * 
	 * 프로그램 실행 "중" 
	 * -호출되는 메서드를 참조하는 객체의 오버라이딩된 메서드로 연결하는 것 
	 * 		== 동적 바인딩
	 * 
	 * 부모 타입 참조 변수 = 자식 객체( 업캐스팅)
	 * 		->접근 가능한 것은 부모 타입만 참조 가능하지만
	 * 			부모 타입이 참조하는 객체는 실제로는 자식을 통째로 참조하고 있는 것임
	 * 		->오버라이딩 된 메서드 호출 시
	 * 			(부모, 자식이 서로 같은 이름의 메서드를 가지고 있는 경우)
	 * 			실제 참조 하고 있는 자식 타입 객체의 메서드가 우선권을 갖는다
	 *		->부모타입으로 호출했다 ->부모타입이 참조하니까 부모타입의 메서드가 실행될 것 같은데
	 *																자식타입 안에 있는 같은 이름의 메서드가 실행됨 ==동적 바인딩
	 * 			
	 */
	public void method4() {
		//업캐스팅 만들기
		SmartPhone s1 = new Galaxy("AMOLED", "KT", "스냅드래곤", 17); 
		//매개변수 생성자로 갤럭시 객체 만들어지는데 그것을 부모 객체가 참조하므로 
		//갤럭시 객체 내의 부모 부분만 참조 가능하게 됨
		
		//s1.toString() 작성 시 SmartPhone의 toString()이 호출된다고 표시됨 == 정적바인딩
		//	(참조 변수가 부모 타입이니까, 업캐스팅 상태이니까 부모 부분에 있는 toString() 메서드를 호출)
		
		//할 것 같았는데...
	  //하지만 실행을 해 보니....
		// SmartPhone.toString()이 아닌
		// Galaxy.toString() 메서드가 호출됨 == 동적 바인딩
		System.out.println(s1.toString());
		//s1이 부모타입인 스마트폰인데 참조하는 객체는 갤럭시임 실제로 참조하는 것은 부모객체임
	}
	/**
	 * 객체 배열 + 다형성(업캐스팅) +다형성(동적 바인딩)
	 */
	public void method5() {
		//부모 타입 참조변수로 이루어진 객체 배열 생성
		SmartPhone[] arr = new SmartPhone[3];
		//240207 강의 오후 12시 부분 그림 참고
		
		//배열의 각 요소(각각이 SmartPhone 참조 변수)에
		//SmartPhone(부모), Iphone(자식), Galaxy(자식) 
		//객체를 생성해서 그 객체의 주소를 각각 대입
		
		//부모 참조 변수 = 부모 객체 (업캐스팅 상태 X)
		arr[0] = new SmartPhone("LCD", "KT", "엑시노스");
		
		//부모 참조 변수 = 자식 객체( ==업캐스팅 상태 O)
		arr[1] = new Iphone("Retina Display", "SK", "M2 Chip",15);
		arr[2] = new Galaxy("AMOLED", "LG", "스냅드래곤3", 14);
		//객체배열에 업캐스팅이 적용된 상태
		//객체 배열에 담긴 요소들의 자료형이 다 다름(SmartPhone, Iphone, Galaxy)
		//객체배열에 다형성을 적용함으로써
		//배열 하나로 다양한 자료형을 묶음으로 다룰 수 있게 됨
		//	->변수 생성 코드 감소 효과 (배열 하나만 만들면 된다)
		//			for문(반복문)으로 한 번에 제어할 수 있음
		//			==> 전반적으로 코드 길이 감소
		
		//반복문으로 객체 배열 순차 접근하기
		// (향상된 for문 + 업캐스팅 + 업캐스팅(동적 바인딩))
		for(SmartPhone s :arr)	{
			//arr의 타입 : SmartPhone[]
			//매 반복 시 마다 arr의 요소를 하나씩 꺼내 SmartPhone타입인 s에 저장
			//arr(SmartPhone[])의 요소들은 자료형이 SmartPhone임
			// [1], [2] 인덱스에서 업캐스팅이 적용됨
			System.out.println(s.toString());
//			[0] : SmartPhone.toString()이 호출됨(0번은 업캐스팅 상태가 아니어서)
//			[1] : Iphone.toString()이 호출됨(동적바인딩이 됨) 
			//(부모 요소인 SmartPhone의 toString을 호출할려했는데 자식 요소의 toString이 호출됨 == 동적바인딩)
//			[2] : Galaxy.toString()이 호출됨(동적바인딩이 됨)
		}
	}
	/**
	 * 매개 변수에 다형성(업캐스팅) 적용(오버로딩과 관련)
	 */
	public void method6() {
		SmartPhone smartPhone = new SmartPhone("LCD", "KT", "엑시노스");
		
		Iphone iphone = new Iphone("Retina Display", "SK", "M2 Chip",15);
		Galaxy galaxy = new Galaxy("AMOLED", "LG", "스냅드래곤3", 14);
		//이번에는 업/다운캐스팅 없이 따로따로 참조(다형성 적용 안됨)
		//같은 자료형끼리 참조
		printToString(smartPhone); 
		printToString(iphone);  //자식 객체의 주소가 부모 참조변수에 저장된다 == 업캐스팅
		printToString(galaxy); //
		//위의 둘이 바로 아래의 매개변수에 들어간다
	}
	public void printToString(SmartPhone s) {
		//매개 변수가 부모 타입이므로 다형성(업캐스팅)이 적용됨
		//자식이 부모자리에 들어와서 부모인 것처럼 보이게 함
		System.out.println("[전달 받은 객체의 toString() 출력]");
		
		//실제 참조하는 객체가 자식 객체이면
		//자식 객체의 오버라이딩된 toString()을 호출하는 동적바인딩이 적용됨
		System.out.println(s.toString()); //아이폰이 매개변수로 넘어온 경우, 스마트폰 것이 아닌, 아이폰의 것이 호출됨(동적바인딩)
		//코드 상으로는 부모가 자식을 참조하면, 자식 내의 부모 부분의 코드가 실행될 것 같지만(정적 바인딩)
		//실제로 참조하는 것은 자식이므로 자식의 코드가 호출됨(동적 바인딩)
	}

//	밑의 코드 지워도 실행 됨
//	// printToString() 오버로딩
//	public void printToString(Iphone i) {
//		System.out.println("[전달 받은 객체의 toString() 출력]");
//		System.out.println(i.toString());
//	}
//	
//	// printToString() 오버로딩
//	public void printToString(Galaxy g) {
//		System.out.println("[전달 받은 객체의 toString() 출력]");
//		System.out.println(g.toString());
//	}
	/**
	 * 다형성 확인 7
	 * 반환형에 다형성(업캐스팅) 적용하기
	 */
	public void method7() {
		printToString(createPhone(1));
//		createPhone(1)하면 1이 매개변수로 전달되고 SmartPhone이 생성되어 돌아와서 바로 printToString에 보냄
		printToString(createPhone(2)); //new Iphone()으로 생성된 객체 주소가 반환돼서 옴
		printToString(createPhone(3)); //new Galaxy()로 생성된 객체 주소가 반환돼서 옴
	}
	//매개변수 값이 따라 각각의 phone 객체 생성 후 반환하기
	// 1 : SmartPhone / 2 : Iphone / 3 : Galaxy
	public SmartPhone createPhone(int num) {
		if(num ==1) return new SmartPhone();  //스마트폰 객체를 만들고, 그 주소를 반환
		//호출한 곳으로 돌아감 근데 돌아갈 때 new SmartPhone()들고 돌아감
		if(num ==2) return new Iphone(); //아이폰 객체를 만들고 그 주소를 반환
		//스마트폰을 반환한다면서 아이폰 반환하는게 왜 될까?
		//반환형에 업캐스팅이 적용됐기 때문에
		//스마트폰을 내보낼 것인데 스마트폰의 자식인 아이폰을 내보내겠다
		return new Galaxy(); //얘도 반환형에 업캐스팅 적용돼서 오류 안남
	}
	/**
	 * instanceof 연산자
	 *  - [작성법] : 참조변수 instanceof 클래스명
	 *  	-> 참조변수가 참조하는 객체(instance)가 지정된 클래스로 만들어진 객체(instance)가 맞아?라고 물어보는 연산자
	 *  	-> 맞으면 true, 아니면 false가 반환됨
	 *  	-> + 상속검사에 사용되기도 함(부가적인 효과)
	 */		
	public void method8() {
		//instanceof 연산자 연습
		SmartPhone s1 = new SmartPhone(); //다형성 적용 안됨
		//여기의 스마트폰 안에는 Object만 있고 아이폰 등은 없음
		System.out.print("s1 instanceof SmartPhone : ");
		System.out.println(s1 instanceof SmartPhone); //true
		
		System.out.print("s1 instanceof Polyservice : error");
//		System.out.println(s1 instanceof Polyservice); //상속 관계가 아니라서 instanceof검사 자체를 못함
		System.out.println("s1 instanceof Iphone"); //s1이 참조하는 객체가 Iphone클래스로 만들어진 Iphone객체냐
		//s1이 참조하는 객체는 Iphone이 아닌 SmartPhone이라서 false나옴
		System.out.println(s1 instanceof Iphone); //상속관계라서 instanceof 에러나지 않음
		//	->SmartPhone과 Iphone은 상속 관계가 맞으나
		//		s1이 참조하는 객체가 Iphone 클래스로 만들어진 객체인지 물어보는 것이기 때문에
		//		결과로 false가 반환됨
		System.out.println("----------------------------------");
		SmartPhone s2 = new Iphone(); 
		//참조 : 아이폰 타입 객체를 힙 영역에 만들고, 그 객체의 주소를 스마트폰 타입 참조형변수 s2에 저장 
		//힙에 아이폰이 있는데 그 안에 슈퍼 구문으로 부모 부분이 생성됨
		
		System.out.print("s2 instanceof SmartPhone : ");
		System.out.println(s2 instanceof SmartPhone);  //true
		//s2가 참조하는 객체가 스마트폰 클래스로 만들어진 스마트폰 타입 맞아?
		//전체는 아닌데 일부분은 맞으니까 true맞음(일부분이라도 맞으면 true나옴)
		//s2가 아이폰을 참조하고 있는데
		//아이폰이 스마트폰을 상속받아서 아이폰 안에 스마트폰이 부모로 존재하므로
		
		
		System.out.print("s2 instanceof Iphone : "); 
		System.out.println(s2 instanceof Iphone);//true(284번 줄에서 Iphone객체를 참조한다고 돼있으니까)
		
	}
	/**
	 * 객체 배열 + 업캐스팅 + 다운 캐스팅(부모를 자식으로 강제형변환) + instanceof
	 */
	public void method9() {
		//부모 타입의 객체 배열 생성
		SmartPhone[] arr = new SmartPhone[3]; 
		//SmartPhone 참조 변수 3칸짜리 배열 생성
		
		//부모 타입 객체 배열 = 요소 별로 부모/자식 객체 초기화
		//											자식 객체가 대입 됨 == 업캐스팅
		//	+메서드 반환형에 다형성(업캐스팅) 적용
		for(int i=0 ; i<arr.length ; i++) {
			//순차접근 = 반복접근
			arr[i] = createPhone(i+1); 
			//arr[i]의 자료형은 SmartPhone 자료형(SmartPhone 참조 변수)
			//인덱스가 0,1,2..이므로 
			//createPhone에 1,2,3이 전달되면 new SmartPhone(), new Iphone(), new Galaxy()가 반환되어 배열에 초기화됨
			//arr[0] = createPhone(1) == new SmartPhone(); //1변과 3변이 업캐스팅에 의해 가능
			//arr[1] = createPhone(2) == new Iphone();
			//arr[2] = createPhone(3) == new Galaxy();
		}
		//향상된 for문 + instanceof + 다운 캐스팅
		for(SmartPhone s :arr ) {
			//: 오른쪽에는 배열을 씀
			//: 왼쪽에는 오른쪽에서 하나씩 뭘 꺼낼 지 씀
			if(s instanceof Iphone) {
				//s가 참조하는 객체가 Iphone클래스로 만들어진 Iphone타입 객체이면 수행
//				(Iphone)s : 다운캐스팅
				((Iphone)s).setIosVersion(999); //이러면 Iphone만이 가지고 있는 기능을 사용할 수 있음
			} else if(s instanceof Galaxy)	{
				//s가 참조하는 객체가 Galaxy 객체가 맞으면 수행
				((Galaxy)s).setAndroidVersion(333); //이러면 Galaxy만이 가지고 있는 기능을 사용할 수 있음
			} else {
				//Iphone도 Galaxy도 아닌 경우 == SmartPhone인 경우(부모)
				s.setDisplay("부모 화면"); // 이번에는 스마트폰 자체이므로 다운캐스팅 할 필요 없음
			}
		}
		//향상된 for문 + 매개변수 다형성(업캐스팅) + 동적바인딩
		for(SmartPhone s : arr) {
			printToString(s); //s 하나씩 꺼내서 printToString에 보낼거임
		}
	}
}
