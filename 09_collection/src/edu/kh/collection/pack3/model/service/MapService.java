package edu.kh.collection.pack3.model.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import edu.kh.collection.pack2.model.dto.Person;

public class MapService {
/* Map : 특정 키워드(Key)를 입력하면
 * 				해당되는 상세한 값(Value)를 얻을 수 있는 컬렉션 객체
 * - K : V 형식으로 구성됨
 * - K : V 한 쌍을 Entry라고 부름
 * - Key : 키워드 역할 (== 변수명)
 * 		1) 중복 불가 ->중복되는 Key 입력 시 나중 것으로 Value값을 덮어씌움
 * 									->Key 역할의 객체는 hashCode(), equals() 오버라이딩 필수!!!
 * 		2) 순서 유지 안됨( 단, LinkedHashMap(순서 유지) 제외) 
 * 
 * Key만 묶어서 보면, Set과 같은 특징을 지니고 있음(위의 두 특징)
 * 		-> Map.keySet() / Map.EntrySet() 제공
 * 				Key만 보면 Set같아서 Set으로 사용할 수도 있게 해줌
 * 
 * - Value : 키워드에 해당하는 상세한 값
 * 		-> Key로 인해서 모든 Value가 구분됨
 * 		-> Map.get(Key) / Map.remove(Key) (인덱스번호 안쓰고 Key를 씀)
 * */
	
	
	public void method1()	{
		//HashMap 생성
		//참조변수는 부모타입으로 만들기
		Map<Integer, String> map = new HashMap<Integer, String>();
		//key로 Integer, value로는 String이 들어감
		
//		V : Value (반환값)
		
		//1. V put(K k ,V v) : Map에 추가
		//		-Map에 추가 시
		//			중복되는 Key가 없으면 null
		//			중복되는 Key가 있으면 이전 Value 반환
		System.out.println(map.put(1, "에그마요"));
		System.out.println(map.put(2, "로티세리바베큐"));
		System.out.println(map.put(3, "스테이크앤치즈")); 
		System.out.println(map.put(3, "스파이시쉬림프")); //3중복
		System.out.println(map);
		
		//2. V get(K k) : Key에 해당되는 Value 반환
		//								일치하는 Key가 없으면 null 반환
		System.out.println("------------------------------------------------------------");
		System.out.println(map.get(1)); //키가 1인 애 //에그마요
		System.out.println(map.get(0)); //키가 0인 애는 없으니까 null나옴
		
		String temp1 = map.get(2); //get해오면 String변수들이 나옴
		System.out.println("temp1 :"+temp1); //"로티세리바베큐"
		
		//3. int size(); : Map에 저장된 Entry(K:V쌍)의 개수
		System.out.println("size :"+map.size()); //3개 했음
		
		
		//4. V remove(K k)
		//		-Key가 일치하는 Entry 통째로 제거
		//		-일치하는 Key가 있다면 Value, 없다면 null반환
		// (V가 Value를 뜻해서 반환값 Value임)
		//매개변수는 대부분 Key이고, 반환값은 대부분 Value임
		System.out.println("---------------------------------------------------------------");
		System.out.println("remove(2) :"+map.remove(2)); //2번 인덱스 아니고, Key가 2인 것임
		System.out.println("remove(5) :"+map.remove(5));
		System.out.println(map);
		
		//5. void clear() : 모든 Entry를 삭제
		
		//6. boolean isEmpty() : 비어있는지 확인
		System.out.println("clear() 전 isEmpty():" + map.isEmpty()); //두개 들어있었으니까
		map.clear();
		System.out.println("clear() 후 isEmpty():" + map.isEmpty());
		
		
		
	}
	/**
	 * Map 요소(Entry)에 순차 접근하기 1
	 * - Map.keyset() 이용하기
	 */
	public void method2() {
		Map<String, String> map = new HashMap<String, String>();
		//Key, Value 모두 String
		map.put("학원", "서울시 중구 남대문로");
		map.put("집", "서울시 강서구");
		map.put("롯데타워", "서울시 송파구");
		map.put("63빌딩", "서울시 영등포구");
		//Set<K> Map.keyset() : 호출 시 Set이 반환되는데 그 Set은 Key의 타입으로 제한됨 (이 경우 String)
		//Map에서 Key만 뽑아내서 Set 형태로 만들어 반환해줌
		Set<String> set = map.keySet();
		System.out.println("keyset :"+set); //key들만 나옴
		
		//set은 get존재하지 않음
		//향상된 for문으로 set에 순차접근
		for(String key:set) {
			//set에서 하나씩 꺼낸 것은 String타입 key에 저장
			System.out.printf("%s : %s\n", key, map.get(key));
			//key값을 하나씩 얻어와서 넣기
		}
		//JS const obj = {"집" : "서울시 강서구" , "롯데타워" : "서울시 송파구"}
		//JS -> for of, for in
		//JS ->객체 : for( key in obj){}
		
		
	}
	/**
	 *  Map 요소(Entry)에 순차 접근하기 2
	 * - Map.entrySet() 이용하기
	 * entry = key + value
	 */
	public void method3() {
		Map<String, String> map = new HashMap<String, String>();
		//Key, Value 모두 String
		map.put("학원", "서울시 중구 남대문로");
		map.put("집", "서울시 강서구");
		map.put("롯데타워", "서울시 송파구");
		map.put("63빌딩", "서울시 영등포구");
		
		Set<Entry<String, String>> entrySet =  map.entrySet();
		//향상된 for문+EntrySet
		for( Entry<String, String> entry: entrySet) {
			//entrySet에서 하나씩 꺼내면 Entry<String, String> entry임
			System.out.printf("key : %s, value : %s\n", 
													entry.getKey(), entry.getValue()); 
			//Entry.getKey() : Key만 얻어오기
			//Entry.getValue() : Value만 얻어오기
			
		}
	}
	/**
	 * Map 활용하기 - DTO 대체하기
	 * - 서로 다른 데이터를 한 번에 묶어서 관리해야 하는 경우
	 */
	public void method4() {
		
		//DTO 이용 방법
		Person p1 = new Person(); //기본생성자로 만듦
		p1.setName("홍길동");
		p1.setAge(25);
		p1.setGender('남');
		System.out.printf("이름 : %s, 나이 : %d, 성별 : %c\n", 
						p1.getName(), p1.getAge(), p1.getGender());
		System.out.println("==================================================================");
		//DTO 대신 Map 활용하기
		//	- Key는 무조건 String을 활용하는 게 Best(변수 이름짓듯이 하므로)
		//	- Value의 타입이 모두 다름
		//	-> 모든 타입을 참조가능한 Object를 부모 타입 참조 변수로 활용
		//			-->다형성(업캐스팅 + 동적 바인딩)
		Map<String, Object> p2 = new HashMap<String, Object>();
		//String타입, Obect 타입
		
		//데이터 추가
		p2.put("name", "김길순"); 
		p2.put("age", 22); //int -> Integer로 변환될 것임
		p2.put("gender", '여'); // char -> Character 로 변환될 것임
		//Map도 객체만 저장 가능해서 기본자료형은 Wrapper클래스로 변환해서 저장
	
		//데이터 얻어오기
		System.out.printf("이름 : %s, 나이 : %d, 성별 : %c\n", 
				p2.get("name"), p2.get("age"), p2.get("gender"));
		
		//p2.get("name")
		//toString이 호출되는데, Object.toString()이 호출되지 않고 String.toString()이 호출되는 동적바인딩 일어남
		// 실제로 참조하고 있는 것의 메서드가 호출됨
		
		//p2.get("age")
		//toString이 호출되는데, Object.toString()이 호출되지 않고 Integer.toString()이 호출되는 동적바인딩 일어남
		
		//p2.get("gender")
		//toString이 호출되는데, Object.toString()이 호출되지 않고 Character.toString()이 호출되는 동적바인딩 일어남
		
		//다형성 적용
						
	}
	//JS 객체를 JSON으로 얻어와서 Map으로 바꿀 수 있는데 JACKSON라이브러리 이용하면 DTO로 바꿀 수도 있음
}
