package edu.kh.collection.pack1.model.service;

import java.util.List;
import java.util.Scanner;

import edu.kh.collection.pack1.model.dto.Book;

import java.util.ArrayList;

//컬렉션 : Java에서 자료구조(데이터가 저장되는 형식)를 만들어서 모아둔 것
//java.util 패키지에 있음! ->import 필요

/*특징
 * -1. 크기 제한 없음(크기가 부족하면 자동으로 크기 증가함)
 * -2. 추가, 수정, 삭제, 검색 등 다양한 기능이 구현되어 있음
 * -3. 객체(참조형)만 저장 가능
 * 			->기본자료형은 저장 안됨... 하지만! Wrapper 클래스를 이용하면 된다!
 * 만들어진 것을 그대로 쓰면 됨 -> 컬렉션 프레임워크
 * 프레임워크 : 이대로만 하세요 하고 제공하는 것*/
public class ListService {
//List : 자료를 순차적으로 나열한 자료 구조(배열 비슷한 것)
	//	-> 인덱스가 존재함
	//	-> 인덱스로 순서가 구분되기 때문에 중복 데이터를 저장할 수 있다.(모두 a를 넣어놔도 인덱스번호로 구분 가능)
	/**
	 * List 사용해보기
	 */
	public void method1() {
		//List 객체 생성
		//- List(인터페이스)
		//인터페이스로는 객체 생성 불가함 ->다형성을 이용하기!!
		// - ArrayList(List의 후손이며, 클래스임) 
//		List list = new ArrayList();//기본 생성자로 만듦
		//기본 생성자로 만들면 10칸짜리가 생성됨
		List list = new ArrayList(3); //3칸짜리 배열 비슷한 것 생김
		//	반환형  메서드명(매개변수)
		//상속받은 애를 이용해서 객체 생성
		// E(Element) : 자료형이 아니고, 요소를 뜻하는 상징적인 글자
		//				== Object, String, Student 등 자료형 가리지 않고 들어갈 수 있다
		
		//리스트는 Object[]이어서 아무거나 다 참조할 수 있다(아무 자료형이나 다 담을 수 있다)
		
		// 1. boolean add(E e) : 마지막 요소로 추가
		//				->이 메서드 호출 시 boolean이 반환됨
		list.add("아무거나"); //String은 들어갈 수 있음
		//String일 때에는 추가적인것 해보도록
		list.add(new Object()); //객체도 들어갈 수 있음
		list.add(123123); //int가 Integer(Wrapper 클래스)로 변환되어 저장됨
		//자바에서 우리가 안했는데 되는 것 : 컴파일러가 자동으로 변환해줌 -> 123123 -> new Integer(123123)
		list.add(3.123123); //크기가 3이었는데 초과했을 때 오류가 발생하지 않음->자동으로 크기가 늘어남
		list.add(false);
		System.out.println(list);
		
		//추가한 것을 하나씩 꺼내보기
		// 2. E get(int index) : List에서 index번째 요소 반환받기(얻어오기)
		//E : 자료형아니고, 어떤 자료형인지 모르겠지만 요소가 반환될 거다
		
		// 3. int size() : List에 저장된 요소(객체)의 개수를 반환해줌
		System.out.println("저장된 개수 : "+list.size()); //add 5개 했음
		//list는 무한정 늘어나니까 list의 전체 칸 수가 중요하지 않고 그 안에 들어있는 객체의 수가 중요
		for(int i=0; i<list.size(); i++) {
			//0번부터 list에 저장된 객체의 개수 미만까지 1씩 증가하며 반복
			//(0번부터 마지막인덱스까지)
			System.out.printf("%d 번째 인덱스 : ", i);
			System.out.println(list.get(i)); //객체의 주소가 얻어와짐 ->참조하고 있는 객체가 String인가?
			//->instanceof사용
			
			//List의 i번째 요소가 String인 경우
			if(list.get(i) instanceof String) {
				//i번째 요소가 스트링을 참조하고 있는 객체이면
				System.out.println("[String 자료형 입니다.]\n");
				continue; //다음 바퀴로 이동
			} 
			//List의 i번째 요소가 int 자료형인 경우 ->Integer로 변환됨
			if(list.get(i) instanceof Integer) {
			//if(list.get(i) instanceof int)
			//Incompatible conditional operand types Object and int
				// 객체와 int를 비교할 수 없다
				System.out.println("***[Integer 자료형 입니다.]***\n");
				continue; //다음 바퀴로 이동
			}
			//List의 i번째 요소가 double(->Double 변환)인 경우
			if(list.get(i) instanceof Double) {
				//if(list.get(i) instanceof int)
				//Incompatible conditional operand types Object and int
				// 객체와 int를 비교할 수 없다
				//실제로 참조하고 있는 것이 Wrapper클래스 Double인지 검사
				
			// list.get(i) ==> Object 반환
				//
				Double d = (Double)list.get(i); //다운 캐스팅
				//Object가 반환됨
				//부모 타입이 자식 타입을 참조하면 자식 내부의 부모 부분만 사용가능
				//자식 전체를 참조하고 싶으면 다운캐스팅 해야 함
				
				
				//Object 타입은 아무거나 다 참조할 수 있다!!!!!(최상위 부모이니까)
				//왜 리스트에 아무 자료형이나 넣을 수 있을까? -> 
				//Object 클래스는 모든 클래스의 부모클래스
				//부모 타입의 변수의 참조변수로 자식객체를 참조 -> 업캐스팅 적용
//				Object[] test = new Object[5]; // 다형성 (업캐스팅)
//				test[0] = "아무거나";
//				test[1] = 123123;
//				test[2] = new Object();
//				test[3] = 3.123123;
				
				System.out.println("@@@[Double 자료형 입니다.]@@@\n");
				System.out.println("double의 바이트 크기 : "+d.BYTES);
				continue; //다음 바퀴로 이동
//				List도 저장하는 타입이 Object 배열같은 것이라고 생각하면 됨
				//Object[]에서 하나씩 꺼낸 것은 Object타입이 됨
			}
			
			
		}
	}
	/**
	 * 컬렉션 List +제네릭(타입 제한)
	 */
	public void method2() {
		//컬렉션의 장점 중 "여러 타입 저장 가능"이 
		//코드 길이를 늘리는 주범!!!
		//장점이었는데 단점이 돼버려서
		//	->타입을 하나로 제한(제네릭을 이용해서)해서 코드 길이를 감소시킴 
		//->컬렉션을 쓸 떄에는 무조건!! 제네릭을 같이씀
		List<String> strList = new ArrayList<String>();
		//String타입으로 제한된 ArrayList 객체 생성해서 부모 타입인 List가 참조
		
		//제네릭의 타입 제한 확인
		strList.add("닭갈비");
		strList.add("치킨");
		strList.add("보쌈");
		//strList.add(123); //String만 저장 가능한데 String이 아니라서 에러
		strList.add("족발");
		strList.add("카레돈까스");
		strList.add("한우불고기버거");
		
		//다 꺼내보기
		for(int i=0 ; i<strList.size(); i++) {
			//배열의 길이가 아닌, 컬렉션의 크기로 해야함 (size())
			String foodName = strList.get(i); //String이 반환됨
			System.out.println(foodName);
			//타입이 제한되니까 instanceof이런거 안써도 되고 코드가 쉬워짐
		}
		
		// 3. void add(int index, E e) : index 번째에 중간 삽입
		strList.add(1, "찜닭"); //1번 인덱스자리에 찜닭을 넣겠다
		
		// 4. String toString() : List에 저장된 모든 요소를 문자열로 반환
//		System.out.println(strList.toString()); //중간에 넣으면 뒤에 있던 것들은 자동으로 밀리게 됨
		System.out.println(strList); //toString()안써도 된다
		//strList는 기본자료형 아닌, 주소를 저장하고 있는데 주소를 보고싶은게 아니므로 toString()안써도 자바가 알아서 그 객체 보여줌
		//참조변수에 print구문 있으면 toString안써도 그 주소가 아닌 내용을 문자열로 자동으로 만들어줌
		//5. E Set(int index, E e) : index 번째 요소를 e로 수정
		//			->수정 전 요소가 반환됨
		//치킨을 양념치킨으로 바꾸고, 치킨이 수정됨 보고싶음
		String before = strList.set(2, "양념치킨");
		System.out.println("수정 전 : "+before); //전에는 뭐였고
		System.out.println("수정 후 : "+strList.get(2)); //수정된 건 뭐고
		System.out.println(strList); //전체를 문자열로 변환해서 출력
		
		// 6. int indexOf(E e) : List 내부에 e와 같은 요소가 있으면 해당 인덱스 번호
		//										없으면 -1 반환(JS에서 해봤음)
		System.out.println(strList.indexOf("보쌈")); //3번인덱스에 있고
		System.out.println(strList.indexOf("막국수")); //없으니까 -1이 나옴
		
		// 7. boolean contains(E e) : List 내부에 e와 같은 요소가 있으면 true, 없으면 false를 반환
		System.out.println(strList.contains("보쌈")); //있으니까 true
		System.out.println(strList.contains("막국수")); //없으니까 false
		
		// 8. E remove(int index) : index번째 요소를 제거(추출, 뽑아냄) ->뽑아낸 것이 반환되고 제거됨
		// 닭갈비 없애보기
		String target = strList.remove(0); //0번 인덱스 요소를 뽑아내어 변수에 저장(리스트에서 뽑혀나와 리스트에서는 없어짐)
		//뽑아내면 그 뒤에 있는 것들이 한 칸씩 인덱스 당겨짐(자동으로)
		System.out.println("제거된 요소 : "+target);
		System.out.println(strList);
	}
	//도서 관리
	/**
	 * Book으로 제한된 List 객체를 생성한 후
	 * - 추가, 조회, 수정, 제거 구현해보기(while문으로 무한히 돌리면서)
	 */
	public void bookManage() {
		/*ArrayList는 배열처럼 다닥다닥 붙어있음 -> 옆으로 이동하며 하나씩 탐색하는 것이 편함
		 * ArrayList : 배열 형태의 리스트
		 * -장점 : 검색이 빠름(많은 데이터 중 특정한 것 찾기)
		 * -단점 : 중간 삽입, 제거가 느림(뒤의 것 밀고 넣거나, 뒤의 것 당기고 삭제하거나)
		 * 					중간 삽입, 제거가 필요한 경우엔 ArrayList 부적절->LinkedList사용
		 * 
		 * *******LinkedList*******
		 * 데이터 저장되는 부분은 맨 아랫칸밖에 없고 그 위의 두 칸은 옆 칸들과 연결된 곳
		 * 중간의 객체를 삭제하고 싶으면 없애고 화살표만 연결하면 됨
		 * 근데 LinkedList는 검색이 느린 단점
		 * LinkedList : 연결된 형태의 리스트(기차, 줄줄이 소세지)
		 * -장점 : 중간 삽입, 제거가 빠름
		 * -단점 : 검색이 느림
		 * */
		List<Book> bookList = new ArrayList<Book>();
		//LinkedList로 바꾸고 싶으면 바로 윗줄의 ArrayList를 LinkedList로 바꾸면 됨
		//LinkedList와 ArrayList 둘다 List를 상속받았기 때문에 
		Scanner sc = new Scanner(System.in);
		int input = 0; //메뉴 입력 받기
		do {
			System.out.println("------ 도서 관리 프로그램 ------");
			System.out.println("1. 추가");
			System.out.println("2. 전체 조회");
			System.out.println("3. index로 조회");
			System.out.println("4. 수정");
			System.out.println("5. 제거");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 번호 입력 >>>");
			input = sc.nextInt(); 
			sc.nextLine(); //스캐너 버퍼에 남아있는 개행문자(Enter) 제거
			//nextInt()한 후에는 nextLine()무조건 쓰는게 좋음
			switch(input) {
			case 1 : 
				System.out.print("제목 입력 :");
				String title = sc.nextLine(); //띄어쓰기도 입력할 수 있음(한 줄 입력)
				
				System.out.print("글쓴이 입력 :");
				String writer = sc.nextLine();
				
				System.out.print("가격 입력 :");
				int price = sc.nextInt();
				//리스트에 추가하기
				if(bookList.add(new Book(title, writer, price))) {
					//bookList.add(null)이거 수행하면 추가 성공하면 true 반환됨 실패하면 false 반환됨
					//객체를 만들어서 그걸 매개변수로 줘야 함
					System.out.println("추가 성공!!!!!");
				}
				
				
				break;
			case 2 : 
				System.out.println("\n------ 전체 조회 ------\n");
				//향상된 for문
				for(Book b: bookList) System.out.println(b); 
					//:오른쪽에는 배열이나 컬렉션 쓰면 됨
				//하나씩 꺼내서 조회
				//for문이나 if문 코드에 한 줄밖에 없으면 중괄호 생략 가능
				
				break;
			case 3 : 
				System.out.print("조회할 책의 인덱스 입력 : ");
				int index = sc.nextInt();
				if(index>=0 && index<bookList.size()) {
					//정상일 때
					System.out.println(bookList.get(index));//index번째 얻어와서 출력해준다
				} else {
					//잘못 입력
					System.out.println("\n인덱스 범위가 옳지 않습니다 >>>\n");
				}
				
				break;
			case 4 : 
				//인덱스를 정상적으로 입력했음을 가정하기
				//책의 정보를 수정하기
				System.out.println("\n[책 수정]\n");
				System.out.print("수정할 인덱스 번호 입력 : ");
				index = sc.nextInt();
				sc.nextLine(); //버퍼 개행문자 제거 ->이거 안하면 뒤에 제목 입력 등을 못함
				
				System.out.print("수정할 책 제목 : ");
				title=sc.nextLine();
				
				System.out.print("수정할 책 글쓴이 : ");
				writer=sc.nextLine();
				
				System.out.print("수정할 책 가격 : ");
				price=sc.nextInt();
				
				Book after = new Book(title, writer, price); //바꿀려는 새 책
				Book before = bookList.set(index, after); //바꾸기 전의 이전 책을 추출
				
				System.out.println("전 :"+before);
				System.out.println("후 :"+after);
				break;
			case 5 : 
			//인덱스를 정상적으로 입력했음을 가정하기
				System.out.println("\n[책 제거]\n");
				System.out.print("제거할 인덱스 번호 입력 : ");
				index = sc.nextInt();
				
				Book target = bookList.remove(index); 
				System.out.println("제거된 책 :"+target);
				break;
			case 0 : System.out.println("\n[프로그램 종료]\n");break;
			default : System.out.println("\n[잘못 입력]\n");
				//디폴트에는 break; 있어도 되고 없어도 됨
			}
		} while(input !=0); //0이 아닐 때 반복
	}
	
	
	
	
	
}
