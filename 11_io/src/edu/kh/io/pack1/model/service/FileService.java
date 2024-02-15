package edu.kh.io.pack1.model.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileService {
/*File 클래스
 * - java.io 패키지에 존재하는 클래스
 * (자바에서 제공하는 패키지 중에서 입출력 관련된 패키지 있음)
 * 
 * - 파일 / 디렉토리(폴더)를 관리하는 클래스
 * 		(파일 / 디렉토리의 존재 유무와 관계 없음)
 * 		(있으면 있는대로 , 없으면 없는대로 관리)
 * - 파일 생성, 제거, 이름 얻어오기, 크기, 마지막 수정일, 존재 여부 등의 기능 제공
 * 
 * 파일을 참조하는 것이 아닌 파일클래스 사용시 경로를 적음
 * 없는 파일을 참조할 수도 있는데 없는 경우 만들어낼 수도 있고
 * 있으면 있는대로 관리할 수 있음
 * 
 * - File 클래스 메서드
 * 
	 * <반환형>
	 * boolean  mkdir()          : 디렉토리 생성
	 * boolean  mkdirs()         : 경로상의 모든 디렉토리 생성
	 * boolean  createNewFile()  : 파일 생성
	 * boolean  delete()         : 파일/디렉토리 삭제
	 * String   getName()        : 파일 이름 반환
	 * String   parent()         : 파일이 저장된 디렉토리 반환
	 * String   getPath()        : 전체 경로 반환
	 * boolean  isFile()         : 현재 File 객체가 관리하는게 파일이면 true
	 * boolean  isDirectory()     : 현재 File 객체가 관리하는게 디렉토리 true
	 * boolean  exists()         : 파일/디렉토리가 존재하면 true, 아님 false
	 * long     length()         : 파일 크기 반환
	 * long     lastModified()   : 파일 마지막 수정일 (1970.01.01 09:00 부터 현재까지 지난 시간을 ms 단위로 반환)
	 * String[] list()          : 디렉토리 내 파일 목록을 String[] 배열로 반환 ->객체 배열로 반환
	 * File[]   listFiles()     : 디렉토리 내 파일 목록을 File[] 배열로 반환  -> 객체 배열로 반환
	 * 
	 * dir = 디렉토리
 * */
	
	/*[개발자 상식!!]
	 * OS : 운영 체제
	 * 운영 체제 별로 폴더/경로 표시 방법, 용어 다름
	 * 
	 * 
	 * (windows)  /  (Linux, Mac)
	 * ===========================================
	 *    폴더    /    디렉토리
	 *    
	 *<경로 표기 방법(하위 폴더로 접근)>
	 *
	 * 백슬래시(\)/    슬래시(/)  ==>자바에서는 둘 중 아무거나 써도 됨!!!!!!
	 * 
	 * windows ->
	 * Linux, Mac -> 
	 * -Java 언어의 특징 : 플랫폼(OS)에 독립적 ->OS 관계 없이 똑같은 코드 작성이 가능
	 * 										->이 특징을 유지하기 위해 \, / 둘 다 호환 가능하게 만들어 둠
	 * 											(런타임 시, 실행되는 OS에 맞게 자동으로 변경됨)
	 * ===========================================================================
	 * - 경로 표기 방법
	 * 
	 * 1) 절대 경로 : 하나의 (절대적인) 기준으로부터 목표까지의 경로를 "모두" 표기하는 방법
	 * ex. , 서울시 중구 남대문로 OOO 서브웨이 => 기준 == 서울
	 * 
	 * <기준이 되는 최상위>
	 * [Windows] : C:/ , D:/ 로 시작
	 * [Linux, Mac] : /Users, /로 시작
	 * 
	 * 2) 상대 경로 : 현재 위치를 기준으로 목표까지의 경로를 표기하는 방법
	 * ex. 현재 견물로부터 왼쪽으로 5번째 건물, 옆 강의장
	 * 
	 * ==>상황에 따라서 둘 중 편한 것을 쓰면 됨!
	 * */
	/**
	 * File 클래스로 객체 생성하기
	 * + 폴더가 존재하지 않으면 폴더 생성하기
	 */
	public void method1() {
		//언어 가리지 않고, 제일 앞의 "/" : 최상위 폴더(==root, 절대 경로의 기준점)를 의미
		//우리는 Java 폴더를 C드라이브에 만들었으니까 / == C 드라이브 의미 
		
		// C드라이브 밑에 io_test 밑에 20240215라는 폴더 만들기 해보기
		File directory = new File("/io_test/20240215"); //String으로 경로를 적는 생성자를 가장 많이 씀
		// / : 리눅스 방법
		// -> 처음에는 존재하지 않는 폴더라서, 존재하지 않는 폴더를 관리하는 File 객체 생성함
		
		System.out.println("존재 여부 확인 : "+ directory.exists()); 
		//exists()는 파일 객체가 제공하는 메서드이니까 directory.써야 함
		if(!directory.exists()) {
			//디렉토리가 존재하지 않으면
			//생성
			//경로상의 폴더 모두 생성하기
			directory.mkdirs();
			System.out.println(directory.getName()); // 파일 이름 반환
			System.out.println(directory.getPath()); // 전체 경로 반환
			
		}
		
	}
	/**
	 * File 객체를 이용해서 
	 * 지정된 위치에 파일 생성하기
	 */
	public void method2() {
		File file = new File("\\io_test\\20240215\\파일생성.txt");
		// 문자열에서 "\" 표기하는 방법 : "\\" (escape 문자)(두개를 써야 기능 사라지고 문자로 인식됨)
		//Invalid escape sequence (valid ones are  \b  \t  \n  \f  \r  \"  \'  \\ )
		//잘못된 방법으로 썼다
		// \n, \t : excape문자(뒤의 알파벳 하나와 합쳐져서 기능 수행)
		
		//있으면 안만들고 없으면 만들겠다
		try {
			
				if(!file.exists()) {
					//존재하지않으면 생성
					if(file.createNewFile()) { //예외 처리가 안되어있다
						//파일 생성을 성공하면
						
						//예외 처리 방법 2가지 : try-catch, 또는 throws
						System.out.println(file.getName()+"파일이 생성 되었습니다.");
					}
				}
		} catch(IOException e) {
			e.printStackTrace(); //예외의 정보, 예외가 발생한 위치까지의 메서드를 모두 추적(에러를 상세하게 출력)
		}
		//파일 만드는 것은 할 수 있는데, 파일의 내용 쓰는 것은 파일 클래스로는 할 수 없음!
	}
	/**
	 * File 클래스 제공 기타 메서드 활용하기
	 */
	public void method3() {
		//File 객체 생성
		File directory = new File("\\workspace\\04_Java\\11_io");
		// \\  : C드라이브 
		// \\: 그 안에 있는~~
		
		//지정된 디렉토리에 있는 모든 파일 / 디렉토리를 File[] 형태로 얻어오기
		File[] files = directory.listFiles(); //다 얻어왔다
		
		//향상된 for문으로 하나씩 꺼내서 확인해보기 -> for(요소 저장 변수 : 배열 or 컬렉션){}
		for( File f : files ) {
			//System.out.println(f.toString()); 
			// f.toString() : 지정된 파일/디렉토리의 절대경로가 출력됨(.toString()안 써도 됨)
			//향상된 for문 -> JS에서는 :자리에 in이나 of를 쓰고, Java에서는 :를 씀
			
			//파일명 얻어오기
			String fileName = f.getName();
			
			//마지막으로 수정한 날짜 얻어오기
			long lastModified = f.lastModified();
			//System.out.println(lastModified);
			//컴퓨터는 시간을 1970.01.01부터 현재까지 지난 시간을 ms 단위로 변환하여 저장함
			//1970.01.01 00:00:00:000 ==0(long 수치)으로 저장
			
			//SimpleDateFormat : 간단히 날짜 형식을 지정할 수 있는 객체
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a h:mm");
			//2024-02-15 오전 9:16 이런 패턴으로 나오도록 지정하기 (알파벳 개수는 글자 수 원하는대로 쓰면 됨)
			
			//String SimpleDateFormat.format(long); : String이 반환됨
			// 매개변수 long값을 지정된 패턴 형식으로 변환하여
			// 문자열 형태로 반환해줌
			
			String date = sdf.format(lastModified);
			//System.out.println(date);
			
			//파일 유형 검사하기
			String type = null;
			if(f.isFile()) {
				//파일인 경우
				type = "파일";
			} else type = "폴더";
			
			//파일 크기(byte단위로)
			String size = f.length()+"B"; //하나의 String으로 만들기
			//폴더일 때에는 바이트 나오는 구문이 없어야 함
			if(f.isDirectory()) size=""; //폴더이면 빈 문자열로 바꾸기
			//System.out.println(size);
			//0B짜리들은 폴더임
			
			String result = String.format("%-20s %-20s %-5s %10s",
					fileName, date, type, size);// %-30s : 30칸 만들어서 왼쪽 정렬
			
			System.out.println(result);
			
		}
	}
}
