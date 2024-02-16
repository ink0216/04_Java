package edu.kh.todoList.view;
//view : 보여지는 부분(내용 출력/키보드로 입력받는 것) 역할
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;

public class TodoListView {
	//메뉴 만들어서 넣기, 입력하세요
	//필드(객체가 가지고 있는 속성)
	private TodoListService service = null; //서비스 참조변수 만듦
	//	view가 서비스에 일 시킬거임
	private BufferedReader br = null; //키보드 입력 스트림 참조 변수
	//스캐너 말고 버퍼드리더로 하기
	//---------------------------------------------------------------------------------------------
	//기본생성자 : ctrl + space
	public TodoListView() {
		//TodoListView 객체가 생성될 때 TodoListServiceImpl, BufferedReader 객체를 만들도록 함
		
		//try-catch 문 쓰는 이유 : 객체 생성 시 발생되는 예외를 여기서 모아서 처리할 예정
		try {
			service = new TodoListServiceImpl(); //다형성 업캐스팅 적용
		//부모 타입 참조 변수 = 자식 객체 참조 -> 업캐스팅
			
			br = new BufferedReader(new InputStreamReader(System.in));
			
		} catch(Exception e) {
			//얘/얘가 호출한 함수가 호출한 함수들의 예외들을 다 여기로 던져서 여기서 한번에 처리
			//Exception이 다 잡아서 처리
			e.printStackTrace();
		}
	}
	//---------------------------------------------------------------------------------------------
	/**
	 * TodoList 프로그램 시작 화면이 될 거임
	 */
	public void startView() {
		int input = 0; //선택한 메뉴 번호를 저장하는 변수
		do {
			try {
				//세 가지 처리
				//입력 스캐너 말고 BufferedReader썼는데 형변환을 해줘야 함
				//Integer.parseInt(null); //숫자 안 썼을 경우의 NumberFormatException 발생 가능
				
				//선택한 번호가 반환되어 input에 저장됨
				input = selectMenu();
				
				switch (input) {
				case 1: todoListFullView(); break; 
				case 2: todoDetailView(); break; 
				case 3: todoAdd(); break; 
				case 4: todoComplete(); break; 
				case 5: todoUpdate(); break; 
				case 6: todoDelete(); break; 
				
				case 0: System.out.println("@@@ 프로그램 종료 @@@"); break; 
				default: System.out.println("### 메뉴에 작성된 번호만 입력해 주세요 ###");
				}
				
				System.out.println("=====================================================================");
				//밑줄 하나씩 넣어주기
				
				
				
				
			}catch(NumberFormatException e) {
				System.out.println("### 숫자만 입력해 주세요 ###");
				input =-1; //첫 반복에 종료되는 것을 방지
			} catch(IOException e) {
				System.out.println("### 입/출력 관련 예외 발생 ###");
				e.printStackTrace();//예외가 어디서 났는지 추적
			} catch(Exception e) {
				//기타 나머지 예외들 모두 처리
				e.printStackTrace();
			} //catch 구문 순서 꼬이면 Unreachable 발생할 수 있어서 순서 꼬이지 말기
		}while(input !=0);
		//최소 1회 반복 보장
	}
	
	

	// ------------------------------------------------------------------------------------------------------
	
	
	/**
	 * 할 일 목록 모두 조회하기
	 */
	private void todoListFullView() {
		System.out.println("\n===============[1. Todo List Full View]===============\n");
		//TodoList.dat에 할일들이 저장돼있던 것을 읽어오면 DAOImpe의 todoList에 저장돼있음
		//View에서 DAO까지 가서 가져오면 됨(근데 흐름을 지키면서 다녀와야 함)
		//view에서 service먼저 호출해야 함
		//할 일 목록 + 완료된 개수 카운트한 값 얻어오기 ->로직 처리하는 서비스에 이 기능 구현
		//(List 타입) + (int 타입) => Map으로 묶어서 반환 받기
		//메서드는 하나만 반환 가능
		//두개를 반환하면 돼서 두 개를 덩어리 하나처럼 묶기(Map을 이용해서!!)
		//완료된 개수 / 전체 할일 수 카운트
		Map<String, Object> map = service.todoListFullView();
		//value로 List가 올 수도 있고 int를 받아올 수도 있으므로 최상위 객체로 함
		//근데 int가 Integer로 Autoboxing진행돼서 들어옴
		//반환 받아옴
		
		//반환 받은 map의 요소를 분리하기(뜯어내기) (묶여서 온 것 두개로 뜯어내기)
		//뜯어서 저장할 변수
		List<Todo> todoList = (List<Todo>)map.get("todoList"); //key값이 todoList인 것을 다운캐스팅해서 얻어오기
		int completeCount = (int)map.get("completeCount"); //int로 다운캐스팅 해서 얻어오기
		
		
		//출력하는 화면
		
		System.out.printf("[ 완료된 Todo 개수 / 전체 Todo 수 : %d / %d ]\n"
				, completeCount, todoList.size());

		System.out.println("--------------------------------------------------------------------");
		System.out.printf("%-3s %10s   %10s     %s\n", "인덱스", "등록일", "완료여부", "할 일 제목");
		System.out.println("--------------------------------------------------------------------");
		
		for(int i=0, len = todoList.size(); i < len; i++) {
			//todoList : DAO에서 가져온 서비스에서 가져온 map에서 가져온것 
			//todoList : DAO에서 전달받아온 것, 파일이 없다면 만들어소 가져옴
			String title = todoList.get(i).getTitle(); //todoList에서 i번째 요소(Todo타입)를 얻어와서 제목을 얻어와 저장 
			String completeYN = todoList.get(i).isComplete() ? "O" : "X";  //삼항연산자, 왼쪽이 true면 가운뎃거, false면 뒤에거 실행
			String regDate = service.dateFormat(todoList.get(i).getRegDate()); //등록일 ->service를 호출 ->안만들어져서 null나옴
			System.out.printf("[%3d]  %20s    (%s)       %s\n", i, regDate, completeYN, title);
		
		}
		
		
	}
	/**
	 * 할 일 상세 조회(인덱스 번호 입력 받기)
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private void todoDetailView() throws NumberFormatException, IOException {
		System.out.println("\n===============[2. Todo Detail View]===============\n");
		System.out.print("인덱스 번호 입력 : ");
		int index = Integer.parseInt(br.readLine()); //IOException를 호출한 곳(startView())으로 던짐->거기서 처리
		//br.readLine(); : String이어서 parsing해야 함
		//Parsing : String 데이터를 원하는 기본 자료형으로 변경
		
		//예외 발생 안했으면 서비스 호출하기
		//할 일 상세 조회하는 서비스 호출 후 결과 반환 받기(원하는 모양으로 결과를 만들어서 하나의 스트링으로 가공)
		String todoDetail = service.todoDetailView(index);
		
		if(todoDetail ==null) {System.out.println("### 입력한 인덱스 번호가 존재하지 않습니다 ###");
		return;
		}
		System.out.println(todoDetail); //상세 내용 출력
	}
	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * 할 일 추가하기(제목, 상세내용만 입력받음)
	 * 완료 여부는 처음엔 false해두면 되고
	 * 등록 시간은 now() 쓰면 됨
	 * @throws IOException 
	 */
	private void todoAdd() throws IOException {
		System.out.println("\n===============[3. Todo Add]===============\n");
		System.out.print("할 일 제목 입력 : ");
		String title = br.readLine(); //예외 던지기
		
		System.out.println("세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)");
		//!wq 작성될 떄까지 무한반복하다가(while(true)) StringBuilder(문자 그동안 입력된것 누적) String비교(equals)
		System.out.println("------------------------------------------------------------------");
		StringBuilder sb = new StringBuilder();//입력받은 것을 누적할 StringBuilder
		while(true) {
			//문자열 입력 받기
			String content = br.readLine(); 
			
			//!wq이면 반복 멈추기
			if(content.equals("!wq")) break; //!wq입력 시 반복 종료
			
			//if문 실행 안된 경우에는 누적
			sb.append(content); //입력받은 값 계속 누적
			sb.append("\n"); //줄 바꿈 추가
		}
		System.out.println("------------------------------------------------------------------");
		//입력 받은 것을 Service 거쳐서 DAO로 보내면 DAO가 파일에 넣어줄거임
		//할 일 추가 서비스 호출 후 결과 반환 받기
		//성공 시 추가된 위치의 인덱스, 실패 시 -1이 반환됨
		int index=service.todoAdd(title, sb.toString());  //인덱스 번호나 -1이 나옴
		if(index ==-1) {
			//실패
			System.out.println("### 추가 실패 ###");
			return;
		}
		//성공
		System.out.printf("[%d] 인덱스에 추가 되었습니다.\n", index);
	}
	/**
	 * 할 일 완료 여부 변경하기(X이면 O로 바꾸고 O면 X로 바꾸기)
	 * - index번호 입력 받기
	 * 정상 입력
	 * 범위 초과인 경우
	 * 이상한 것 입력한 경우 ->예외 던져서 처리
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private void todoComplete() throws NumberFormatException, IOException {
		System.out.println("\n===============[4. Todo Complete]===============\n");
		System.out.print("O <-> X 변경할 인덱스 번호 입력 : ");
		int index = Integer.parseInt(br.readLine());
		
		//이걸 서비스로 보냄
		//서비스 호출하고 결과(true or false) 반환 받기
		boolean result = service.todoComplete(index); //index보내면 boolean나옴
		if(result) {
			//변경 성공 시(true일 때)
			System.out.println("[변경 되었습니다]");
		} else {
			//index 범위를 넘어서서 요소가 없을 때
			System.out.println("### 인덱스가 존재하지 않습니다 ###");
		}
	}
	/**
	 * 할 일 수정하기
	 * - 인덱스 번호를 입력 받아
	 * 		정상 범위 내의 인덱스 값인지 확인해서
	 * 		범위 벗어나면 수정 불가
	 * 		정상 범위 index인 경우 제목, 상세 내용만 수정
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private void todoUpdate() throws NumberFormatException, IOException {
		System.out.println("\n===============[5. Todo Update]===============\n");
		System.out.print("수정할 인덱스 번호 입력 : ");
		int index = Integer.parseInt(br.readLine()); //예외는 던지기!
		
		//(2번 메뉴에 있던)상세 조회 서비스를 재활용하기(인덱스 범위 초과 시 null반환)
		String todoDetail = service.todoDetailView(index);
		if(todoDetail ==null) {
			//저장된 주소가 없었다!
			System.out.println("### 인덱스가 존재하지 않습니다 ###");
			return;
		}
		//있다는 얘기!
		//수정 전의 상세내용 출력해주기
		System.out.println("@@@@@@@@@@ [수정 전] @@@@@@@@@@");
		System.out.println(todoDetail); //출력
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"); 
		
		//수정할 제목, 내용 입력 받기
		//위에 있던 추가한다는 코드 복붙(3번 메뉴에 있던 것)
		System.out.print("수정할 제목 입력 : ");
		String title = br.readLine(); //예외 던지기
		
		System.out.println("수정할 세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)");
		//!wq 작성될 떄까지 무한반복하다가(while(true)) StringBuilder(문자 그동안 입력된것 누적) String비교(equals)
		System.out.println("------------------------------------------------------------------");
		StringBuilder sb = new StringBuilder();//입력받은 것을 누적할 StringBuilder
		while(true) {
			//문자열 입력 받기
			String content = br.readLine(); 
			
			//!wq이면 반복 멈추기
			if(content.equals("!wq")) break; //!wq입력 시 반복 종료
			
			//if문 실행 안된 경우에는 누적
			sb.append(content); //입력받은 값 계속 누적
			sb.append("\n"); //줄 바꿈 추가
		}
		System.out.println("------------------------------------------------------------------");
		//수정 서비스 호출 후 결과 반환 받기
		boolean result = service.todoUpdate(index, title, sb.toString());
		//수정 성공 실패는 boolean값으로 많이 함
		//수정 성공 시 true, 실패 시 false
		if(result) System.out.println("[수정 되었습니다]");
		else System.out.println("### 수정 실패 ###");
	}
	/**
	 * 할 일 삭제하기
	 * - 인덱스 번호 입력 받아 일치하는 인덱스번째 요소 삭제하기
	 * 	->인덱스 범위 체크하기
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private void todoDelete() throws NumberFormatException, IOException {
		System.out.println("\n===============[6. Todo Delete]===============\n");
		System.out.print("삭제할 인덱스 번호 입력 : ");
		int index = Integer.parseInt(br.readLine());
		
		//삭제 서비스 호출 후 결과 반환받기
		//삭제서비스 인터페이스 어떻게 하자고 선생님이 주심!
		String title = service.todoDelete(index); 
		//index를 보내면 삭제된 요소의 제목(String) 또는 null이 반환됨
		if(title ==null) {
			//실패하는 경우는 인덱스 범위 초과한 경우밖에 없음
			System.out.println("### 인덱스가 존재하지 않습니다 ###");
		} else System.out.printf("[%s]가 삭제 되었습니다\n", title);
	}
	/** 메뉴 출력 및 선택할 수 있음
	 * @return 선택한 메뉴 번호 반환
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private int selectMenu() throws NumberFormatException, IOException {
		//int를 반환하는 메서드
		System.out.println("\n====== Todo List =====\n");
		
		System.out.println("1. Todo List Full View");
		System.out.println("2. Todo Detail View");
		System.out.println("3. Todo Add");
		System.out.println("4. Todo Complete");
		System.out.println("5. Todo Update");
		System.out.println("6. Todo Delete");
		System.out.println("0. EXIT");
		
		
		System.out.print("select menu number >>> ");
		
		//String을 int로 바꿈
		int input = Integer.parseInt(br.readLine());
		System.out.println();
		
		return input;
	}

	
	// ------------------------------------------------------------------------------------------------------
	
	
	
}
