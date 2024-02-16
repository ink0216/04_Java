package edu.kh.io.pack4.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterService {
/*문자 기반 스트림
 * - 2byte 문자(char) 단위로 입/출력 하는 스트림
 * - Reader(입력), Writer(출력) 최상위 인터페이스를 상속받음
 * - 문자만 작성된 파일, 채팅, 인터넷 요청 시 데이터 전달 시 사용됨
 * 주소창에 네이버 주소 입력(요청)하면 네이버의 HTML/CSS(문자 기반 스트림)를 보내줌*/
	/**
	 * 문자 기반 파일 입력(파일 읽어오기)
	 *  + 보조 스트림 Buffered 사용
	 */
	public void fileInput() {
		FileReader fr = null; //문자 기반 파일 입력 스트림(외부 파일에 있는 것을 읽어오겠다)
		//BufferedReader : 키보드 입력받는 것도 문자이니까 키보드 입력받을 때 써봤음
		BufferedReader br = null; //문자 기반 보조 스트림
		//버퍼 = 모아서 한 번에 가져온다(속도 빨라짐)
		
		//입출력 시 예외 생길 가능성 있어서 try-catch구문 써두고 시작하기
		//IOException이라고 해도 되고 그 부모인 Exception이라고 해도 됨(다형성 적용됨)
		try {
			//문자 기반 스트림 -> 한글자씩 읽어옴 -> 너무 느려서 보조스트림 이용
			fr = new FileReader("/io_test/노래가사2.txt"); //경로 적기
			//파일은 미리 만들어놨었음!
			//저 경로에 있는 것 읽어와야징~~
			// / : 절대경로 시작점(최상위 부모 C드라이브)
			
			//보조스트림 생성
			br = new BufferedReader(fr); //기반스트림을 매개변수로 이용해서 보조스트림 생성
			//바이트기반에는 readAllBytes는 하나씩 읽어오는 것
			//readLine() : 한 줄씩 읽어옴 ->몇 줄인지 모르니까 while문 사용
			//br.readLine()
			String line = null; //한 줄을 읽어와 저장할 변수
			while(true) {
				//무한반복 돌리기
				line = br.readLine(); //한 줄을 읽어와서 저장하기
				if(line == null) {
					//br.readLine() : 더 이상 읽을 내용 없을 때 null을 반환함
					//더 이상 읽어올 내용이 없을 때 
					break; //반복 종료
				}
				System.out.println(line); //읽어온 내용이 있으면 콘솔에 출력
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//사용 완료된 스트림 객체를 메모리 반환(제거, 닫기)
			//보조 스트림만 close()해도 연결된 기반 스트림도 같이 close()됨
		
			
				try {
					if(br !=null) br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	/**
	 * 문자 기반 파일 출력하기
	 * 	 + 보조 스트림 Buffered 이용
	 */
	public void fileOutput() {
		StringBuilder sb = new StringBuilder(); //String의 불변성 문제를 해결한 객체 -> 메모리 효율이 좋음
		sb.append("오늘은 2월 16일 금요일입니다.\n");
		sb.append("벌써 금요일이라니! 기부니가 좋군요!\n");
		sb.append("다들 힘내서 공부합시당\n");
		sb.append("(지켜보고 있다....)");
		
		String content = sb.toString(); //String 형태로 바꾸기
		
		//content에 저장된 문자열을 
		// /io_test/출력테스트.txt 파일로 출력하기
		//		File directory = new File("/io_test/출력테스트.txt");
		FileWriter fw = null; //
		BufferedWriter bw = null; //
		try {
			//if(directory.exists()) directory.createNewFile();
			fw = new FileWriter("/io_test/출력테스트.txt"); //이파일 없으면 자동으로 만들어줌!!!!
			//파일과 출력 스트림 연결(파일이 없으면 생성됨)
			//이걸 이용하면 한글자씩 내보냄
			bw = new BufferedWriter(fw); //이걸 이용해서 뭉텅이로 내보냄(성능 향상, 속도 *효율 상승)
			bw.write(content);
			//			bw.flush(); //출력할 때에는 이걸 썼었다
			System.out.println("출력 완료!");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//사용 완료된 보조스트림 삭제
			try {
				if(bw !=null) bw.close();
				//close구문 안에 flush구문 포함돼있어서 flush()안 써도 잘 됨
				//	->근데 혹시라도 가능성 없애려고 flush()또 써도 됨
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
