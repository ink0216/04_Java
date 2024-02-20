package edu.kh.collection.pack2.model.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.pack2.model.dto.Person;

public class SetService {
/*Set(집합, 주머니)
 * - 기본적으로 순서를 유지하지 않음(근데 순서를 유지하는 Set도 있음)
 * 		(index 없음!!!!!!!!중요!!!!!!!!!->get() 메서드가 없음(하나만 꺼내오는 것))
 * 																		->하나만 꺼내는 다른 방법 존재
 * 
 * - 중복 데이터 저장 불가(같은 객체가 들어오면 덮어쓰기 함, 계속 덮어씌워서 하나만 가지도록 유지)
 * 
 * <Set 인터페이스의 자식 클래스>
 * 
 * 1. HashSet(대표적, 가장 많이 사용) : 처리 속도가 빠른 Set(hashCode를 사용해서)
 * 2. LinkedHashSet : 순서를 유지하는 Set(첫 번째 들어온 것, 두 번째 들어온 것,...)
 * 3. TreeSet : 자동 정렬되는 Set(들어오면 자동적으로 오름/내림차순 시킬 수 있음)
 * */
	/**
	 * HashSet 사용법!
	 * -컬렉션은 객체만 저장 가능(기본자료형은 불가)
	 * - HashSet은 사용 조건이 더 있음
	 * -HashSet의 사용 조건 1 : 객체에 equals()가 오버라이딩 되어있어야 함
	 * -HashSet의 사용 조건 1 : 객체에 hashCode()가 오버라이딩 되어있어야 함
	 * 		->String, Integer 등 자바에서 제공하는 객체는 모두 오버라이딩 되어있는 상태!!
	 * 		->String을 많이 사용(Map 할 때에도)
	 */
	public void method1() {
		//HashSet 객체 생성
//	 Set<String> : String만 저장하는 Set
	 Set<String> set = new HashSet<String>(); //Set적으면 안되고 자식객체 써서 다형성-업캐스팅 적용해야 함
		//LinkedHashSet으로도 해보기
	 
	 
	 //1. boolean add(E e) : Set에 추가하기
	 set.add("네이버");
	 set.add("카카오");
	 set.add("라인");
	 set.add("쿠팡");
	 set.add("배달의민족");
	 set.add("당근마켓");
	 set.add("토스");
	 set.add("직방");
	 set.add("야놀자");
	System.out.println(set); //객체의 주소를 볼 것 아니므로 set.toString()자동 호출됨
		//순서 유지 안되는 것 확인
	
	//중복 저장 확인 -> 중복저장 X
	set.add("배달의민족");
	set.add("배달의민족");
	set.add("배달의민족");
	set.add("배달의민족");
	set.add("배달의민족");
	
	//null : 참조하는 객체가 없음 (!=비어있다)
	//null도 중복 안되는 것 확인 ->1회만 출력됨
	set.add(null);
	set.add(null);
	set.add(null);
	set.add(null);
	System.out.println(set);
	
	//2. int size() : Set에 저장된 객체(참조변수)의 수 반환
	System.out.println("set.size() :" +set.size());
	System.out.println("================================================================");
	
	//3. boolean remove(E e) : 전달받은 요소를 제거한 후에 boolean값 내보냄
	//			전달받은 e를 Set에서 제거 ->그 요소가 있어서 제거 성공 시 true, 없어서 제거 실패 시 false 반환
	
	System.out.println(set.remove("배달의민족"));
	System.out.println(set.remove("LG유플러스"));
	System.out.println(set);
	System.out.println("================================================================");
	//4. boolean contains(E e) : 전달받은 e가 Set에 있으면 true, 없으면 false
	System.out.println("쿠팡 있는지 확인 :" +set.contains("쿠팡"));
	System.out.println("삼성 있는지 확인 :" +set.contains("삼성"));
	System.out.println("================================================================");
	//5. void clear() : Set에 저장된 내용 모두 삭제하기
		set.clear(); //여기서 내용 다 지움
		System.out.println("================================================================");
	//6. boolean isEmpty() : 비어 있으면 true, 아니면 false
		System.out.println("비어 있음??"+set.isEmpty());
	}
	/**
	 * Set은 순서가 없음 Set에 저장된 요소(객체) 꺼내는 세 가지 방법
	 *  1. Set안의 Iterator(반복자) 이용
	 *			반복자 있는 애들만 향상된 for문 사용 가능(JS)
	 *	2. List로 변환
	 *	3. 향상된 for문 이용
	 */
	public void method2()	{
		Set<String> set = new HashSet<String>();
		set.add("홈런볼");
		set.add("몽쉘");
		set.add("포카칩");
		set.add("쿠크다스");
		set.add("빈츠");
		
		//1. Iterator(반복자) 이용 ->import해야 함
		// - 컬렉션 객체에 저장된 요소를 하나씩 순차접근 하는 객체
		//Iterator Set.interator() : 현재 Set을 순차접근할 수 있는 Iterator 객체를 반환해서 it라는 변수에 저장
		Iterator<String> it = set.iterator(); //여기서도 String으로 타입 제한
		//set이 String만 타입 제한해서 모은 것이므로 하나씩 꺼낸 것도 String
		
		//boolean Iterator.hasNext() : 다음 순차 접근할 요소가 있으면 true, 없으면 false 반환
		//			->조건식에 사용
		System.out.println("[Iterator 이용]");
		while(it.hasNext()) {
			//다음요소가 있으면 반복, 없으면 반복 멈춤
			
			// E Iterator.next() : 다음 요소가 있으면 다음 요소를 꺼내와 반환
			String temp=it.next(); //String이니까 String 변수에 저장
			System.out.println(temp);
			//Iterator : 주머니 내 요소들에 하나씩 접근해서 하나씩 꺼내오는 객체
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("[List로 변환]");
		List<String> list = new ArrayList<String>(set);
		//Set에 저장된 객체를 이용해서 List를 생성
		
		//일반 for문
		for(int i=0; i<list.size(); i++)	{
			//list.length(배열)아니고 그 안에 저장된 객체의 수 -> list.size()
			System.out.println(list.get(i)); 
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("[향상된 for문 이용(가장 많이 사용)]");
		for(String snack:set) {
			// : 오른쪽 : 배열이나 리스트 
			// : 왼쪽 : 배열이나 리스트에서 하나씩 꺼내와서 저장할 변수(타입 맞추기)
			System.out.println(snack);
		}
		
	}
	/**
	 * 직접 만든 클래스(Person)이용해 만든 객체를 Set에 저장(중복 제거 확인)
	 */
	public void method3()	{
		Person p1 = new Person("홍길동", 25, '남');
		Person p2 = new Person("홍길동", 25, '남');
		Person p3 = new Person("홍길동", 30, '남');
		Person p4 = new Person("김길순", 20, '여');
		
		System.out.println("p1 :"+p1.hashCode());
		System.out.println("p2 :"+p2.hashCode());
		System.out.println("p3 :"+p3.hashCode());
		System.out.println("p4 :"+p4.hashCode());
		//hashCode : 정수로 된 객체 식별 번호
		// 필드로 만든 것이어서, 같은 필드 값을 가진 객체는 번호가 같다!
		
		//p1과 p2가 같음
		
		//A.equals(B) : A와 B가 가지고 있는 필드 값이 같다면 true
		System.out.println("p1.equals(p2) : "+p1.equals(p2));
		System.out.println("p1.equals(p3) : "+p1.equals(p3));
		
		//Set 중복 제거 확인
		Set<Person> personSet = new HashSet<Person>();
		personSet.add(p1);
		personSet.add(p2);
		personSet.add(p3);
		personSet.add(p4);
		System.out.println("--------------------------------------");
		for(Person p : personSet) {
			System.out.println(p); //25세 홍길동이 한번만 출력됨(중복 제거됨)
			//네 줄이 나올까 세 줄이 나올까
		}
	}
	//**************************************************************************************
	//Hash라는 단어가 포함된 컬렉션 이용 시
	//hashCode(), equals() 오버라이딩 필수적으로 진행해야 함!!!!!!!!!!
	//**************************************************************************************
	/**
	 * TreeSet : 이진 트리 구조를 이용해 객체를 저장하는 Set(Set이라 중복제거도 됨)
	 * -> 기본적으로 오름차순 정렬됨
	 * 이걸 쓰기 위한 전제 조건 : 저장되는 객체는 Comparable이라는 인터페이스를 필수적으로 상속받아야 함!!
	 */
	public void method4() {
		//1부터 45까지 난수 생성
		// 1) Math.random() 사용
		// 2) Random.nextInt() : Random클래스 이용
		Random random = new Random();
		//Integer(객체, Wrapper Class) <==> int(기본자료형)
		Set<Integer> lotto = new TreeSet<Integer>(); //Integer만 저장하는 TreeSet, 오름차순으로 중복되지 않게 저장
		while(lotto.size()<6)	{
			//로또 번호 수 = 6개
			//lotto에 저장된 객체의 수
			//lotto에 저장된 값이 6개 미만이면 반복
			// ==6개가 되면 반복 멈춤
			lotto.add(random.nextInt(45)+1); //1~45 사이 난수 추가
			//중복되는 것 있으면 알아서 덮어쓰기 됨
			//random.nextInt(); : 0이상 1미만 난수
		}
		System.out.println(lotto);//중복 제거와 오름차순 정렬까지 자동으로 됨
	}
	
	/**
	 * 로또 번호 생성기
	 * 금액을 1000원 단위로 입력 받아
	 * 1000원 당 1회 씩 번호를 생성해서 List에 저장한 후
	 * 생성 종료 시 한 번에 출력하기
	 * 
	 * <pre>
	 * 금액 입력 : 3000
	 * 1회 : [11,20,34,35,42,43]
	 * 2회 : [1,12,22,33,35,44]
	 * 3회 : [5,6,24,43,44,45]
	 * </pre>
	 */
	public void lottoNumberGenerator()	{
//		System.out.print("금액 입력 :");
//		Scanner sc = new Scanner(System.in);
//		int cycle = sc.nextInt()/1000;
//		Set<Integer> list = new TreeSet<Integer>();
//		Random random = new Random();
//		for(int i=0 ; i<cycle; i++) {
//			list.clear();
//			while(list.size()<6) {
//			list.add(random.nextInt(45)+1);
//			
//			}
//			System.out.printf("\n%d회 : "+list, i+1);
//		}
		Scanner sc = new Scanner(System.in);
		System.out.print("금액 입력 :");
		int amount = sc.nextInt();
		Random random = new Random();
		
		//생성된 로또 번호 묶음을 저장할 List
		List<Set<Integer>> lottoList = new ArrayList<Set<Integer>>();
		//인티저만 저장하는 세트만 들어가는 리스트 생성
		
		//List는 객체만 저장(정확히는 객체의 주소를 저장)
		//얕은 복사
		for(int i=0, end=amount/1000; i<end; i++) {
			//for문이 반복될 때마다 새로운 Set 객체를 생성 ->그 때 마다 새 주소를 가진 객체가 생성돼서
			//얕은복사가 일어날 일이 없음, 이렇게 하면 clear쓸 필요 없음
			Set<Integer> lotto = new TreeSet<Integer>();
			//초기식에 여러 개 쓸 수 있다.
			//for문 한바퀴씩 돌 때마다 한 줄씩 나오도록
			while(lotto.size() < 6) {
				lotto.add( random.nextInt(45) + 1 ); // 1 ~ 45 사이 난수 추가
			}
			lottoList.add(lotto); //List에 Set 추가(담기)
			//List 각 인덱스에 서로다른 Set 참조 주소가 저장된다! 
		}
		//출력용 반복문
		for(int i=0 ,size =lottoList.size() ; i<size; i++) {
			System.out.println((i+1)+"회: "+lottoList.get(i));
		}
		//효율때문에 객체 하나만 만들고 하면 얕은복사 일어날 수 있음
		//얕은 복사 시, 여러 객체가 하나의 주소를 참조해서, 하나의 객체에서 주소의 내용 수정 시,
		//같은 주소를 참조하고 있던 여러 객체에서도 내용 다 똑같이 바뀜
		//객체를 다 따로 만들면 얕은복사 일어나지 않음
		
		
	}
	
}
