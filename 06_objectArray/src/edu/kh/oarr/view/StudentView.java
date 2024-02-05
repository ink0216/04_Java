package edu.kh.oarr.view;

import java.util.Scanner;

import edu.kh.oarr.model.dto.Student;
import edu.kh.oarr.model.service.StudentService;

//입력, 출력만 담당하는 클래스
//보여지는 용도의 클래스이므로
public class StudentView {
	//클래스 : 객체의 속성과 기능을 코드로 정의한 설계도
	
	//필드 : 객체의 속성 작성 (필드 ==멤버변수)
	//static이 붙은 필드 == 클래스 변수
	//static이 안 붙은 필드 == 인스턴스 변수
	//인스턴스 : new해서 만들어진 객체
	private Scanner sc = new Scanner(System.in);
	//필드 하나 만듦
	//이거 적는다고 메모리 생기는 거 아니라 
	//new StudentView();구문이 실행됐을 때 정의된 내용대로 할당됨
	//스캐너 객체 생성해서 참조하도록 만듦
	private StudentService service = new StudentService();
	
/**
 * 메뉴 표시 기능
 */
public void displayMenu() {
	int input=0; //메뉴 번호를 입력 받을 변수
	do {
		System.out.println("\n----- 학생 관리 프로그램 -----");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 전체 조회");
		System.out.println("3. 학생 1명 정보 조회(인덱스)"); //인덱스 번호 입력받아서 걔만 보여주기
		//인덱스 번호 입력받기 -> 범위 내의 인덱스 맞는지 확인 ->그 인덱스에 학생 있는지 확인 -> 학생 정보 출력
		System.out.println("4. 학생 이름으로 조회"); //동명이인 없다고 가정
		System.out.println("5. 학생 정보 수정(인덱스)");
		System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
		System.out.println("7. 평균 최고점, 최저점 학생");
		System.out.println("0. 종료");
		
		System.out.print("메뉴 선택 >>");
		input=sc.nextInt();
		switch(input) {
		//input값에 따라서 실행
		//		case 1 : break; 이거 쓰고 복붙하기
		case 1 : 
			addStudent(); //이거 호출할거다
			break;
		case 2 : 
			selectAll();
			//select : 골라서 본다(==조회하다)
			break;
		case 3 : selectIndex(); break;
		case 4 : 
			selectName();//이름으로 조회하는 메서드 호출
			break;
		case 5 : updateStudent(); break;
		case 6 : selectScore();break;
		case 7 : 
			selectMaxMin();
			break;
		case 0 :  System.out.println("[프로그램 종료]"); break;
		default : System.out.println("[잘못 입력]");
		}
	}while(input !=0); //최소 한 바퀴는 보장
	//입력 받아서 service로 보낼 건데 너무 학생 여러개이므로 매개변수도 많아서
	//배열로 묶어서 보내기
	
	
	
	}
/**학생 추가 화면(입력 출력만 담당)
 * 입력받기
 * 학번, 이름, 성별을 입력받아
 * StudentService의 students 배열에 추가
 * 
 */
private void addStudent() {
	System.out.println("\n----- 학생 추가 -----");
	System.out.print("학번 : ");
	String studentNumber = sc.next();
	System.out.print("이름 : ");
	String name = sc.next();
	System.out.print("성별(M/F) : ");
	char gender = sc.next().toUpperCase().charAt(0);
	//sc.next() : String으로 반환
	//문자열.toUpperCase() : 문자열 전체를 영어 대문자로 변경해서
	//그 문자열의 0번째 인덱스 한글자만 떼어오겠다
	
	//학생 추가 Service 메서드 호출 후 결과 반환 받기
	boolean result 
	= service.addStudent(new Student(studentNumber, name, gender));
	//new 연산자로 heap 영역에 Student클래스 보고 학생 객체 만들어서 매개변수가 있는 생성자 호출
	//할당된 주소를 service에 있는 addStudent에 보내주면
	//service가 일을 하면 결과가 boolean값으로 나옴(true or false)
	if(result) {
		//result에 true가 들어있는 경우
		System.out.println(name +"학생이 추가 되었습니다.");
	} else {
		//result에 false가 들어있는 경우
		System.out.println("학생을 더 이상 추가할 수 없습니다.");
	}
	
}
/**
 * 등록된 학생 전체 출력, 인덱스번호도 나오도록
 */
private void selectAll() {
	System.out.println("\n -----학생 전체 조회 -----");
	Student[] studentList = service.getStudents();
			//service에 있는 
	//getStudents 메서드가 students 배열반환. 참조 주소를 반환 받아서
//	Student[] 자료형인 studentList에 대입
	for(int i=0 ; i<studentList.length ; i++) {
		//학생이 없는 인덱스인 경우 반복 종료
		if(studentList[i]==null) break;
		System.out.println(i + "번째 인덱스\n" +studentList[i].toString());
		//studentList의 i번째
		//studentList는 Student배열 자료형, 그것의 i번째 인덱스는 Student 자료형임
		//Student에 있는 toString()호출
		System.out.println(); //줄바꿈
	}
}
/**학생 1명 정보 조회(index 검색)
 * 
 */
private void selectIndex() {
	System.out.println("\n----- 학생 1명 정보 조회(index 검색) -----");
	System.out.print("인덱스 입력 :");
	int index = sc.nextInt();
	//service에 있는 배열에 index 전달 후 일치하는 학생이 있으면 반환 받기
	Student std = service.selectIndex(index);
	//service가 갖고있는 selectIndex 메서드를 실행할 것인데 index를 매개변수로 보낼것임
	//일치하는 정보가 있으면 std에 저장할 것이다
	if(std==null) System.out.println("해당 인덱스에 학생이 존재하지 않습니다.");
	else			{
//		System.out.println(std.toString()); //있으면 있는 그대로 보여줌
		System.out.println("학번 :"+std.getStudentNumber());
		String temp = null;
		if(std.getGender()=='F') temp = "여성";
		else temp = "남성";
			//문자열 비교는 기본자료형이 아니니까 equals이용해서 비교하교
			//기본 자료형은 ==로 비교
		System.out.println("성별 :"+temp);
	//java.lang.ArrayIndexOutOfBoundsException:
	//  Index 20 out of bounds for length 10
	// ==배열 index 범위를 초과했다
	// index 범위 : 0 ~ (배열 길이-1)
		System.out.println("이름 :"+std.getName());
		System.out.println("----- 점수 -----");
		System.out.println("HTML :"+std.getHtml());
		System.out.println("CSS :"+std.getCss());
		System.out.println("Js :"+std.getJs());
		System.out.println("Java :"+std.getJava());
		
	}
}
/**
 * 이름으로 학생 조회
 */
private void selectName() {
	System.out.println("\n----- 이름으로 학생 조회 -----");
	System.out.print("이름 입력 : ");
	String name = sc.next(); //입력 받기
	//Student로 name전달해서 일치하는 학생 Student를 가져온다
	Student std = service.selectName(name);
	
	
	if(std == null) 
		System.out.println("같은 이름의 학생이 존재하지 않습니다");
	
	else {
		System.out.println("학번 : " + std.getStudentNumber());
		
		String temp = null;
		if(std.getGender() == 'F' ) temp = "여성";
		else											  temp = "남성";
		
		System.out.println("성별 : " + temp);
		
		System.out.println("이름 : " + std.getName());
		
		System.out.println("----- 점수 -----");
		System.out.println("HTML : " + std.getHtml());
		System.out.println("CSS  : " + std.getCss());
		System.out.println("Js   : " + std.getJs());
		System.out.println("Java : " + std.getJava());
	
	
}
}
/**
 * 인덱스를 먼저 입력 받아
 * 해당 인덱스에 학생이 존재 하면
 * HTML, CSS, JS, Java  점수를 입력 받아
 * 해당 학생에게 set해라
 */
private void updateStudent() {
	System.out.println("\n----- 학생 정보 수정(점수 수정) -----");
	System.out.print("수정할 학생의 인덱스 번호 입력 :");
	int index = sc.nextInt();
	Student std = service.selectIndex(index); //따로 꺼내서 변수에 넣어놓기
	if(std==null) {
		//		selectIndex() 호출하면 그 인덱스번째에 학생이 있는지 없는지가 나옴
		System.out.println("해당 인덱스에 학생이 존재하지 않습니다.");
		return;
	}
	//HTML, CSS, JS, Java 점수 입력 받아서 바로 std에 세팅
	System.out.print("HTML, CSS, JS, Java 순서로 입력 :");
	std.setHtml(sc.nextInt());
	std.setCss(sc.nextInt());
	std.setJs(sc.nextInt());
	std.setJava(sc.nextInt());
	//네 번 입력하면 하나하나에 쏙쏙 들어갈 것
	System.out.println("수정 완료");
}
/**학생 점수 조회
 * 각각의 점수, 합계, 평균 조회
 * 1) 인덱스를 입력 받아 해당 학생이 존재하는지 확인
 * 2) 있을 경우 service.selectScore(인덱스)를 호출한 후
 * 		HTML(50) CSS(80) JS(100) Java(30)
 * 		합계 : 260
 * 		평균 : 65.0
 * 
 * 		형태의 문자열로 반환 받아와서 출력
 * 
 */
private void selectScore() {
	System.out.println("\n----- 인덱스로 학생 점수 조회 -----");
	System.out.print("조회할 학생의 인덱스 번호 입력 :");
	int index = sc.nextInt();
	Student std = service.selectIndex(index); //따로 꺼내서 변수에 넣어놓기
	if(std==null) {
		System.out.println("해당 인덱스에 학생이 존재하지 않습니다.");
		return;
	}
	//	service.selectScore(index)
	String result = service.selectScore(index); //호출한 후 문자열로 반환받아와 저장
	System.out.println(result);
	
}
/**
 * 평균 최고점, 최저점 학생 조회하기
 */
private void selectMaxMin() {
	System.out.println("\n----- 평균 최고점, 최저점 학생 조회 하기 -----");
	String result = service.selectMaxMin();//호출한 후 문자열 형태로 반환받아와서
	System.out.println(result); //출력
	
	
	
	
}
}
