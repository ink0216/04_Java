package edu.kh.oop.method;
//기능 제공 클래스

import java.util.Scanner;

public class StudentService {
	//service = 제공하다
	//학생과 관련된 기능을 제공하는 클래스
	//객체에 어떤 기능을 줄 지
	
	//필드
	private Scanner sc = new Scanner(System.in); // 스캐너 객체를 한개 만드는데 매개변수 하나(키보드 내용) 필요
	//키보드 내용을 입력받는 스캐너 객체 하나 생성
	//new StudentService라는 클래스를 이용해 새 객체 만들었을 때 그때 스캐너 객체도 생성됨
	
	/**메인 메뉴 화면
	 * 게임 화면처럼 이걸 켜면 메뉴판이 보이도록
	 */
	public void displayMenu() {
		int input=0; //scanner로 입력받은 메뉴 번호를 저장할 변수
		
		//학생 객체를 참조할 참조형 변수 2개를 선언
		//null == 아직 참조하는 객체가 없음을 의미
		//변수는 만들었는데 제대로된 주소가 아직 안들어있다
		//학생 둘 만듦
		Student std1 = new Student("홍길동", "112233", '남'); // 실행 되자마자 길동이 만들어짐 
		Student std2 = null;
		// do{} while();
		do {
			//반복하며 메뉴판 만들기
			System.out.println(""" 

===== 학생 관리 프로그램 =====
1. 학생 등록
2. 학생 정보 확인
3. 학생 이름 수정
4. Java 공부하기
5. HTML 공부하기
6. Java 역량 서로 비교하기
7. HTML 역량 서로 비교하기
0. 프로그램 종료	
					"""); //println에 쌍따옴표 세쌍쓰면 그 안에 만든 대로 그대로 출력됨
			System.out.print("메뉴 선택 >>");
			input = sc.nextInt();
			switch(input) {
			//input값에 따라서 어떤 기능을 호출할 지 정하기
			case 1 : 
				System.out.print("학생을 등록할 변수 선택(1:std1 / 2:std2) : ");
				int select = sc.nextInt();
				//정상 입력하는 경우 (1아니면 무조건 2만 선택하는 경우 가정)
				if(select ==1) std1 = createStudent(); 
				else					std2 = createStudent(); //메서드로 생성된 학생을 std1/ std2에 대입할거다
				//case와 break 사이에 해당 케이스에 대한 코드 여러 줄로 작성 가능
				
				break;
			case 2 : 
				System.out.print("정보를 조회할 학생 선택(1:std1 / 2:std2) : ");
				String text = null; //학생의 정보가 담긴 문자열을 저장할 변수 // 이 위치에 출력할 것
				if(sc.nextInt() ==1) text=studentInform(std1);
					//입력받은 값이 1인 경우
				else text=studentInform(std2); //입력받은 값이 2인 경우
				System.out.println(text); //반환된 결과 출력
				break;
			case 3 : 
				System.out.print("이름을 수정할 학생 선택(1:std1 / 2:std2) : ");
				if(sc.nextInt()==1)  updateStudentName(std1);
				else								updateStudentName(std2);
				//이건 반환할 것 없으니 void쓰기
				
				
				break;
			case 4 : 
System.out.print("Java 역량을 수정할 학생 선택(1:std1 / 2:std2) : ");
				
				if(sc.nextInt() == 1) updateJava(std1);
				else									updateJava(std2);
				break;
			case 5 : 
System.out.print("HTML 역량을 수정할 학생 선택(1:std1 / 2:std2) : ");
				
				if(sc.nextInt() == 1)	updateHtml(std1);
				else									updateHtml(std2);
				
				
				
				
				break;
			case 6 : 
				String result = compareJava(std1, std2); //둘을 한번에 보내기
				//실행하면 반환된 값이 string에 저장되므로 compareJava는 string을 반환
				System.out.println(result);
				break;
			case 7 : 
				String result2 = compareHtml(std1, std2); //둘을 한번에 보내기
				//실행하면 반환된 값이 string에 저장되므로 compareJava는 string을 반환
				System.out.println(result2);
				
				
				break;
			case 0 : System.out.println("===== 프로그램 종료====="); break;
			default : //위의 것들 중 무엇도 아닌 경우
			}
		} while(input !=0); //input이 0이 아닐 때 반복하겠다
		//	do while -> 조건문을 맨 마지막에 검사해서 최소 1회 이상 반복 보장
	}
	
	
	
	
	
	/**학생 정보를 입력받아 생성된 Student객체를 반환하게 만들 것
	 * @return 생성된 Student 객체 주소 
	 */
	private Student createStudent() {
		//학생 정보 입력받아서 객체를 만들어서
		//그 객체자체가 아닌, 그 객체의 주소를 반환한다(return)
		//일단 모두 잘못 쓰는 경우는 제외. 다 제대로 쓰는 경우 가정
		System.out.print("이름 : ");
		String name = sc.next(); //이름에 띄어쓰기 없음
		
		System.out.print("학번 : ");
		String studentNumber = sc.next(); //이름에 띄어쓰기 없음
		
		System.out.print("성별(남/여) :");
		char gender = sc.next().charAt(0);
		//sc.next()로 입력 받은 문자열 중 
		//0번 인덱스 번째 문자 하나를 반환 받아 gender 변수에 저장(가장 앞글자 하나 떼옴)
		// "남" 중에서 남 하나만 빼오면 '남'으로 바뀜 (char로)
		//sc.next() : 단어를 입력 받음
		
		return new Student(name, studentNumber, gender); 
		//Student 객체를 생성한 후, 그 주소를 호출한 곳으로 반환
	}
	/**매개 변수로 전달받은 학생의 정보를 문자열로 만들어서 반환
	 * @param s : 매개변수 std1 또는 std2(학생 객체 참조 주소가 담겨있음)
	 * @return : 학생 정보가 작성된 문자열 (반환될 것)
	 */
	private String studentInform(Student s) {
		//String.format("패턴", 변수)
		// == 패턴 모양의 문자열을 만들어서 반환해주는 String 메서드
		
		//KH대학교 / 123123 / 남 / 홍길동 / java역량 / html역량 모양으로 출력 
		return String.format("%s / %s / %c / %s / %d / %d",
											Student.schoolName, s.getStudentNumber(),
											s.getGender(), s.getName(), s.getJava(), s.getHtml());
	}
	/**매개변수로 전달받은 학생 객체의 이름 변경
	 * @param s : std1 또는 std2 (학생 객체의 주소가 넘어옴)
	 */
	private void updateStudentName(Student s) {
		System.out.print("수정할 학생 이름 :");
		String newName = sc.next(); //새로운 이름
		
		String beforeName = s.getName(); //수정 전 이름 저장
		s.setName(newName); //새 이름을 세팅
		
		//수정 완료 시 학생 이름이 수정되었습니다
		//홍길동 -> 홍길길
		System.out.println("학생 이름이 수정 되었습니다.");
		System.out.printf("%s -> %s \n", beforeName, newName); //이름 수정 완료
	}
	/**Java 역량이 얼마나 증가(+) 또는 감소(-)했는지 정수로 입력받고
	 * 학생의 자바 역량을 수정
	 * 단, 수정된 자바 역량은 최대값 최소값 범위를 넘어가지 못하게 한다
	 * ex ) 자바 역량이 120으로 되면 ->100(최대값) 으로 되도록
	 * 			자바 역량이 -30인 경우		->0(최소값)으로 되도록
	 * @param s : std1 또는 std2 
	 */
	private void updateJava(Student s) {
		System.out.print("증가 또는 감소한 Java 역량 입력(점수)");
		int input=sc.nextInt();
		//문자열 입력 : String input2 = sc.nextLing(); //한 줄(띄어쓰기 포함해서 한 줄 다 얻어옴)
		//sc.next(); : 단어 얻어오기
		//이전 점수 + 입력 받은 역량점수를 전달 받은 학생에게 세팅
		
		int before=s.getJava();
		s.setJava(s.getJava()+input); //setJava보다 괄호 안의 getJava가 먼저 실행됨
		
		//점수가 최대/최소값을 넘지 못하게 처리하기
		if(s.getJava()>Student.MAX_VALUE) s.setJava(Student.MAX_VALUE); //static에 정의된 것은 클래스명으로 접근하는 게 정석
		if(s.getJava()<Student.MIN_VALUE) s.setJava(Student.MIN_VALUE); //static에 정의된 것은 클래스명으로 접근하는 게 정석
		//s.MAX_VALUE로 하면 경고 뜸
		
		
		System.out.println("Java 역량 수정완료");
		System.out.printf("%d -> %d(%d) \n", before, s.getJava(), input);
		//결과 출력 예시
		//Java 역량 수정 완료
		//70 -> 80 (10)
		//70 -> 50 (-20)
		//50 -> 100( 100)
		//50에서 100만큼 올려도 최대값 범위 초과 안되도록 (100으로 되게)
	}
	private void updateHtml(Student s) {
		System.out.print("증가 또는 감소한 Html 역량 입력(점수)");
		int input=sc.nextInt();
		
		int before=s.getHtml();
		s.setHtml(s.getHtml()+input);
		
		//점수가 최대/최소값을 넘지 못하게 처리하기
			if(s.getHtml()>Student.MAX_VALUE) s.setHtml(Student.MAX_VALUE); //static에 정의된 것은 클래스명으로 접근하는 게 정석
			if(s.getHtml()<Student.MIN_VALUE) s.setHtml(Student.MIN_VALUE); //static에 정의된 것은 클래스명으로 접근하는 게 정석
			//s.MAX_VALUE로 하면 경고 뜸
			
			
			System.out.println("Html 역량 수정완료");
			System.out.printf("%d -> %d(%d) \n", before, s.getHtml(), input);
	}
	/** 매개 변수로 전달받은 두 Student의 Java 점수를 비교
	 * 전달받는 std1과 std2의 자료형은 Student
	 * @param s1
	 * @param s2
	 * @return 결과 문자열
	 */
	private String compareJava(Student s1, Student s2) {
		//직접 학생을 입력하게 하는데, 입력을 안한 경우->비교할 필요 없음
		//전달 받은 s1이 참조하는 Student객체가 없을 경우(학생이 등록안된경우)
		//Student는 참조하는 객체의 주소를 저장하는 참조형 변수
		//근데 참조하는 객체가 없으면 null(참조하는 것이 없다)이 대입돼있음
		//등록된 학생이 없으면 비교 못하게 커트하기
		if(s1==null) {
			return "첫 번째 학생이 등록되지 않았습니다."; //끝내버리기
			
		}
		if(s2==null) {
			return "두 번째 학생이 등록되지 않았습니다."; //끝내버리기
			
		}
		
		String result = String.format("%s : %d / %s : %d \n", 
				s1.getName(), s1.getJava(), s2.getName(), s2.getJava());
		//printf와 작성법 똑같은데 출력 기능/ 문자열로 만들어주기
		//여기까지 왔으면 두 학생의 역량을 비교하기
		if(s1.getJava() > s2.getJava()) {
			return result + s1.getName()+"의 점수가 더 높습니다.";
		}
		if(s1.getJava() < s2.getJava()) {
			return result +s2.getName()+"의 점수가 더 높습니다.";
		}
		//여기까지 온 경우는 두 점수가 같은 경우임
		return result +"점수가 같습니다.";
		//호출한 곳(case6)으로 돌아가는데 값을 가지고 돌아감
		//돌아가서 result에 대입됨
		
		
		
	}
	private String compareHtml(Student s1, Student s2) {
		if(s1==null) {
			return "첫 번째 학생이 등록되지 않았습니다."; //끝내버리기
			
		}
		if(s2==null) {
			return "두 번째 학생이 등록되지 않았습니다."; //끝내버리기
			
		}
		
		String result = String.format("%s : %d / %s : %d \n", 
				s1.getName(), s1.getHtml(), s2.getName(), s2.getHtml());
		
		if(s1.getHtml() > s2.getHtml()) {
			return result + s1.getName()+"의 점수가 더 높습니다.";
		}
		if(s1.getHtml() < s2.getHtml()) {
			return result +s2.getName()+"의 점수가 더 높습니다.";
		}
		//여기까지 온 경우는 두 점수가 같은 경우임
		return result +"점수가 같습니다.";
	}
	
}
