package edu.kh.io.pack2.model.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteService {
/*스트림(Stream) : 데이터가 이동하는 통로
 * 									기본적으로 한 방향으로만 흐름(단방향)
 * 
 * Byte 기반 스트림
 * - 1byte 단위로 데이터를 입/출력하는 스트림
 * 		(1byte만 들어갈 수 있는 통로!)
 * 
 * - 최상위 인터페이스 : InputStream, OutputStream
 * 모든 바이트 기반 스트림은 이 둘을 상속받아서 구현함
 * 스트림에서는 다형성 잘 쓰지는 않음
 * 
 * - 문자열, 이미지, 영상, 오디오, pdf 등 
 * 		모든 것을 입/출력 할 수 있음
 * 		(단, 큰 덩어리를 1바이트로 쪼개서 좁은 통로로 이동시켜서 속도가 조금 느림) 
 * */
	
	//*****************************************************************************************************
	// IO(입출력) 관련 코드는 IOException이 발생될 가능성이 높다!!!!
	//	->거의 모든 메서드가 throws IOException이 써져 있음
	//	->IOException 예외 처리 구문을 작성하는 것이 필수!!!!!
	//*****************************************************************************************************
	
	
	
	
	/**
	 * 바이트 기반 파일 출력하기
	 */
	public void fileByteOutput() {
		FileOutputStream fos = null; //FileOutputStream을 참조하는 변수 fos를 선언했는데 아직 참조하는 것이 없다
		//지역변수가 아닌 상위 단계로 올려놔야 try{}, catch{}, finally{}에서 모두 사용 가능
		try {
			//fos = new FileOutputStream("경로"); //경로에 작성된 파일과 연결된, 파일 출력 스트림 객체 생성 
			//			->출력 스트림에 연결된 파일이 존재하지 않으면 자동으로 생성해줌
			//				(단, 폴더는 생성되지 않음 ->io_test와 20240215폴더는 생성되지 않으므로 미리 만들어 놓아야 함)
			
			//new FileOutputStream("경로")
			// 기존 파일이 존재하면 내용을 덮어쓰기 함!!!(내용 추가하면 추가되고, 내용 삭제하면 그 부분만 삭제됨)
			
			//new FileOutputStream("경로", true)
			// ->기존 파일이 존재하면 내용을 이어쓰기( !=덮어쓰기) 함
			
			fos = new FileOutputStream("/io_test/20240215/바이트기반_테스트.txt", true); //텍스트 파일 만들것임
			//파일아웃풋스트림 객체 생성
			//뒤에 true 쓰면, 덮어쓰기가 아닌, 이전 내용들 그대로 두고 이어쓰기
			
			//StringBuilder : String 불변성 문제를 해결한 객체(가변성)
			StringBuilder sb = new StringBuilder();
			sb.append("Hello World!!!\n");
			sb.append("1234567890\n");
			sb.append("!@#$%^~~^&&&&&&#@$@#$\n");
			sb.append("가나다라마바사\n");
			sb.append("와 자바 재밌당\n");
			sb.append("선생님 저 공부 열심히 할게요!");
			sb.append("진짜로!!!!");
			sb.append("정말로!!!!");
			sb.append("화이팅!!!!");
			
			// StringBuilder -> String으로 변환하기
			String content = sb.toString(); //하나의 문자열로 합치기
			
			//출력 방법 1 : 통로가 좁으니까 한 글자(char == 2byte)씩 쪼개어 파일로 출력하기
			// -> 2byte 범주의 문자(키보드에 존재하는 영어, 숫자, 기본 특수문자 제외한 나머지)는
			//		1byte 기반 스트림 통과 시 데이터가 잘리는 데이터 손실이 발생해서
			//		한글 글자가 깨지는 문제가 발생!!!(1바이트 넘는 것은 그냥 잘라서 버림)
			
			//fos는 1byte짜리 출력 스트림(통로)임
			//영어 알파벳 = 1byte
			//숫자 = 1byte
			//한글 = 2byte ->한글이 깨져서 출력됨
			//동영상 = byte단위로 돼 있음 -> 이 방법 사용
			
			/*
			for(int i=0, len=content.length();i<len;i++) {
				char ch = content.charAt(i); //i번째 글자 반환 (쪼개서 한 글자씩 반환)
				
				//fos(파일 아웃풋 스트림) 이용해서 내보내기
				fos.write(ch); //출력 스트림이 연결된 파일에 ch를 쓰기
			} //글자 수만큼 반복하면서 다 쓸 것임
			*/
			
			//시작 (출력하는 write의 소요 시간 구해보기)
			//System.nanoTime(); : 1070.01.01 09:00:00 기준으로 현재 시간까지의 차이를 ns(nano second)단위로 반환
			
			//1ms(밀리 s) == 1/1000 s
			//1us(마이크로 s) == 1/1000 ms
			//1ns(나노 s) == 1/1000 us
			
			long startTime = System.nanoTime();
			//출력 방법 2 : String을 byte[]로 변환 후 출력
			//String == char[]
			//2바이트 짜리를 1바이트 짜리 인덱스 두 칸으로 쪼개서 저장해놓고 나중에 합치면 됨
			fos.write(content.getBytes()); //getBytes() : 스트링을 바이트로 내보냄
			//	(1바이트 넘는 글자는 쪼개서 버리지 않고, 다음 인덱스에 저장해둠)
			// -> 한글 안깨지게 됨
			
			//출력을 하는 객체가 다 내보냈다고 없애버리는 경우, 받아들이는 데에 시간이 걸려서 
			//그 출력을 받아들이는 객체가 아직 못받은 스트림이 있을 수 있음
			//만약 ab라는 데이터가 아직 스트림 안에서 이동하던 중에 그 통로를 없애버리면 ab는 전달이 안되게 됨
			//->방지하려고 flush구문 사용
			
			//끝
			long endTime = System.nanoTime();
			
			System.out.println("[수행 시간] : "+(endTime-startTime)+"ns");
			
			
			fos.flush(); //스트림 안에 남아있는 데이터를 모두 밀어냄
			System.out.println("출력 완료!");
			
		} catch(IOException e) {
			e.printStackTrace(); //예외가 발생한 메서드까지 추적해 출력
			//trace = 추적하다
		} finally {
			//try안에서 예외가 발생하든 안하든 무조건 수행되는 코드
			
			//사용 완료한 스트림을 제거(닫기, 메모리 반환)하는 코드 필수 작성 ->finally에서 작성
			try {
				
				if(fos !=null) {
					//stream이 정상 생성된 경우
					//있는 것만 없애기 사용 완료된 통로 없애야 메모리 낭비 없음
					fos.close(); //얘도 IOException을 발생시킬 수 있음->try-catch 구문 쓰기
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	/**
	 * 버퍼를 이용한 파일 출력하기
	 * - BufferedOutputStream 보조 스트림 이용! (이 방법을 권장!!!!)
	 */
	public void bufferedFileByteOutput() {
		
		/*버퍼(Buffer)란?
		 * - 데이터를 모아두는 박스, 장바구니같은 메모리 공간
		 * 
		 * 버퍼링 = 동영상 볼 때 나오던 것
		 * 	-	인터넷 속도 낮음 + 스트리밍 코드가 효율이 안좋음
		 * 	-> 동영상 재생 중에  
		 * 			현재 재생 위치보다 이후에 재생될 부분을 미리 다운받아놔서
		 * 			영상을 끊김 없이 볼 수 있게 한 것
		 * 	->미리 다운 받은 것을 저장해 두는 공간 == 버퍼
		 *  */
		
		/*BufferedOutputStream / BufferedInputStream : 실무에서도 가장 많이 쓰는 것!!!!!!!필수!!!!
		 * 이 보조스트림을 쓰는게 좋다!
		 *-위에서 한 FileOutputStream은 1바이트 씩 데이터를 입출력함
		 * ->100바이트면 100번 왔다갔다 함
		 * 
		 * BufferedOutputStream / BufferedInputStream 
		 * : 스트림 중간에 바구니 만들어놓고 어느정도 차면 바구니에 있는 것들을 스트림을 이용해 한번에 보냄
		 * 		->시간 효율이 굉장히 좋아진다!
		 * : 버퍼에 입출력할 내용을 "모아서 한번에" 입출력함
		 * 		->스트림을 이용하는 횟수가 적어짐
		 * 		-> 성능, 시간 효율 up!! (쓰는 게 좋다!)
		 * 
		 * BufferedOutputStream
		 * BufferedInputStream
		 * */
		
		FileOutputStream fos = null; //try, finally에서 사용할 예정이라 여기에 참조변수만 선언해두고, 
		//아직 참조하는 곳은 없음 
		
		BufferedOutputStream bos = null; //보조 스트림 선언
		try {
			fos = new FileOutputStream("/io_test/20240215/바이트기반_테스트_Buffered.txt");
			
			//보조스트림은 혼자 쓰일 수 없음
			//기반 스트림 fos를 이용해 보조스트림 bos를 생성
			bos = new BufferedOutputStream(fos);
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("Hello World!!!\n");
			sb.append("1234567890\n");
			sb.append("!@#$%^~~^&&&&&&#@$@#$\n");
			sb.append("가나다라마바사\n");
			sb.append("와 자바 재밌당\n");
			sb.append("선생님 저 공부 열심히 할게요!");
			sb.append("진짜로!!!!");
			sb.append("정말로!!!!");
			sb.append("화이팅!!!!");
			
			// StringBuilder -> String으로 변환하기
			String content = sb.toString(); //하나의 문자열로 합치기
			
			//[출력 시간 측정해보기] -> fileByteOutput보다 이게 더 빠르다!
			long startTime = System.nanoTime();
			bos.write(content.getBytes()); //스트링 콘텐트를 바이트 배열로 바꿔서 한번에 쓰겠다
			long endTime = System.nanoTime();
			System.out.println("[수행 시간] : "+(endTime-startTime)+"ns");
			
			bos.flush(); // 스트림, 통로안에 남아있는 데이터 밀어내기/쏟아내기
			//스트림 다 쓰고나면 닫아줘야 하므로 
			System.out.println("출력 완료!");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			
			
			try {
			//사용 완료된 스트림 메모리 닫을 때에도 IOException 발생 가능(닫기, 제거, 메모리 반환)
				if(bos !=null) bos.close();
				//보조 스트림 close();시
				//보조 스트림 생성에 사용된 기반 스트림도 같이 close()됨!
				//보조스트림만 닫으면 기반 스트림도 닫힘
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 바이트 기반 파일 입력
	 * 외부 파일"노래가사"를 이 자바 프로그램에 입력받기
	 * ->입력용 스트림 만들기
	 * 방법 2
	 */
	public void fileByteInput() {
		//입출력은 IOException발생 가능성 커서 미리 try-catch 구문 써두기
		
		//파일 입력용 바이트 기반 스트림
		FileInputStream fis = null; //FileInputStream을 참조하는 참조변수 fis 선언, 근데 아직 참조하는 것은 생성되지 않음
		try {
			fis=new FileInputStream("\\io_test\\20240215\\노래가사.txt"); 
			
			// \가 문자열로 인식되려면 두개씩 써야한다
			
			//읽어오는 방법 1 : 파일 내부 내용을 1byte씩 끊어서 가져오기
			//아까는 한글이 깨지는 문제가 있었는데 여기서도 있을까?
			//여기서도 깨졌다!!!한글은 2바이트여서
			//	->2바이트 범주의 글자들이 모두 깨지는 문제가 발생!!!!! ->방법 2로 하기(한 번에 뭉텅이로 가져오기)
			
			//자바에서 byte는 정수형
			//	->byte 데이터는 다루기 힘들기 때문에 정수 기본형인 int로 변환해서 사용하는 경우가 많다
			int value = 0; //읽어온 바이트 값을 저장할 변수
			
			StringBuilder sb = new StringBuilder(); //가변형 문자열 다루는 객체
			while(true) {
				//무한반복
				value = fis.read(); //1바이트씩 끊어서 읽어오는 메서드
				//A를 읽어오면 숫자 65로 읽어와지고, 다른 문자들도 다 숫자로 읽어와지는데,
				//더 이상 읽어올 값이 없으면 -1이 반환됨!
				if(value==-1) break; //다 읽어왔으면 반복을 멈춤(break)
				
				//if문 실행 안됐으면 아직 읽어올 값이 있다는 것임
				//읽어온 값을 StringBuilder 객체에 누적추가하기
				sb.append((char)value); //숫자인 65같은 숫자를 원하는게 아니므로 char로 강제 형변환해서 글자 형태로 추가
			}
			System.out.println(sb.toString()); //while문에서 읽어와 누적된 내용 문자열로 출력
			//fis.flush(); 여기에는 왜 이거 안될까? 자바가 외부 파일 읽어올 때 끝까지 쪽쪽 얻어와서 없어도 됨
			//InputStream은 flush() 없음
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			//사용 완료된 Stream 메모리 반환(제거, 닫기)
			try {
				if(fis !=null) fis.close();
				//실제로 참조하고 있는 것이 있을 때에만 없애주겠다
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 바이트 기반 파일 입력
	 * 외부 파일"노래가사"를 이 자바 프로그램에 입력받기
	 * ->입력용 스트림 만들기
	 * 방법 2
	 */
	public void fileByteInput2() {
		//입출력은 IOException발생 가능성 커서 미리 try-catch 구문 써두기
		
		//파일 입력용 바이트 기반 스트림
		FileInputStream fis = null; //FileInputStream을 참조하는 참조변수 fis 선언, 근데 아직 참조하는 것은 생성되지 않음
		try {
			fis=new FileInputStream("\\io_test\\20240215\\노래가사.txt"); 
			
			// \가 문자열로 인식되려면 두개씩 써야한다
		
			//방법 2 : 외부 파일에 저장된 모든 byte 값을 일단 다 읽어와
			//				byte[] 형태로 반환 받기
			//				-> 이후 byte[]을 이용해서 String 객체 생성
			//				-> String 생성 시 배열 요소 2개씩 묶어 한 글자로 해석해
			//						깨지는 글자 없이 문자열로 반환
			// "가" 를 반으로 쪼개서 가져와서 0,1번 인덱스에 저장해뒀다가
			// 스트링 객체를 생성해서 0,1번에 있던 것을 하나로 묶어서 글자 하나로 만드는 코드가 들어있음
			//파일을 byte로 쪼개서 하나도 놓치지 않고 다 가져오기
			byte[] bytes = fis.readAllBytes(); //전부 바이트로 얻어오기
			String content = new String(bytes); //String 생성자 중에서 byte[]를 이용하는 생성자가 이미 있음
			System.out.println(content);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			//사용 완료된 Stream 메모리 반환(제거, 닫기)
			try {
				if(fis !=null) fis.close();
				//실제로 참조하고 있는 것이 있을 때에만 없애주겠다
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * BufferedInputStream 보조 스트림을 이용한 성능 향상
	 * 하나씩 읽어오는 게 아니라 모아놓았다가 한 번에 가져와서 시간 단축 (이 방법을 권장!!!!)
	 */
	public void bufferedFileByteInput() {
		//스트림 참조 변수 선언
		FileInputStream fis = null; //FileInputStream 참조 변수 선언
		BufferedInputStream bis = null;
		
		//선언만 하고 생성은 나중에 하는 경우 많음!!!
		try {
			//기반 스트림 생성
			fis = new FileInputStream("/io_test/20240215/노래가사.txt");
			//텍스트 파일 읽어옴
			
			//보조 스트림 생성
			bis = new BufferedInputStream(fis); //fis를 이용해서 bis를 만들겠다
			
			String content = new String(bis.readAllBytes());
			//bis를 이용해서 파일 내용을 전부 바이트로 읽어와서 스트링을 만들고 스트링 참조 객체에 그 주소를 저장
			System.out.println(content);
		} catch(Exception e) {
			e.printStackTrace();
			//Exception은 IOException 부모이므로 (다형성 업캐스팅이 적용돼서 얘가 다 잡아서 처리할 수 있음)
		} finally {
			try {
				//보조 스트림(bis)만 close()해도 기반 스트림도 같이 close()된다!!!!
				if( bis != null) bis.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 파일 복사하기
	 * 
	 * 파일 경로를 입력 받아 
	 * 지정된 파일과 같은 경로에 복사된 파일 출력하기(만들기) 
	 * 
	 * [실행 화면]
	 * 파일 경로 입력 : /io_test/20240215/노래가사.txt 
	 * 이렇게 쓴 경우
	 * 복사 완료 : /io_test/20240215/노래가사_copy.txt
	 * 같은 폴더에 복사된 파일 만들어내기
	 * 
	 *
	 * 
	 * 복사 : 안의 내용도 똑같아야 함
	 * 1. 입력된 경로에 파일이 있는지 우선 검사해보기
	 * 				File.exists();이용
	 * 2. 있는 경우, 파일 내용을 모두 읽어오기 -> FileInputStream이용
	 * 																							+BufferedInputStream 사용(성능 향상)
	 * 3. 읽어온 내용을 같은 위치에 파일명_copy 라는 이름으로 출력
	 * 																					-> FileOutputStream 이용 (파일을 내보내니까)
	 * 																							+BufferedOutputStream 사용!
	 * 4. Scanner 대신 BufferedReader 이용!!!(입력받을 때)
	 * reader : 2바이트씩 입력받는 문자 기반의 입력스트림 
	 * 
	 * 텍스트 파일 뿐 아니라 이미지, 동영상 파일 등 이걸로 다 복사 할 수 있음!!
	 */
	public void fileCopy() {
		//스트림 참조 변수 다 선언해놓기 ->객체 생성은 필요한 곳에서!
		BufferedReader br = null; //문자열 입력용 스트림
		
		FileInputStream fis = null; //파일 입력
		BufferedInputStream bis = null; //입력 보조
		
		FileOutputStream fos = null; //파일 출력
		BufferedOutputStream bos = null; //출력 보조
		
		try {
			//키보드 입력을 받기 위한 스트림 객체 생성
			br = new BufferedReader(new InputStreamReader(System.in));
			//InputStream : 1바이트씩
			//Reader : 1바이트씩
			//InputStreamReader -> 1바이트 짜리를 2바이트로 확장시켜줌 ->그걸 버퍼로 더 빠르게 가져오겠다
			//ㄱ + ㅏ -> 가
			
			//경로 입력 받기
			System.out.print("파일 경로 입력 : ");
			String target = br.readLine(); //입력된 한 줄 읽어오기
			
			//해당 경로에 파일/폴더가 존재하는지 확인하기
			//폴더까지만 쓰면 폴더의 존재 유무 확인 가능
			//파일의 존재 유무까지 확인하고싶으면 파일까지 쓰면 됨
			File file = new File(target); //File 객체 생성
			if(!file.exists()) {
				//해당 경로에 파일이 존재하지 않으면
				System.out.println("[해당 경로에 파일이 존재하지 않습니다.]");
				return; //복사 못하게 하겠다 여기서 커트!
			}
			//if문 실행 안된 경우는 있는 경우임 ->입력받고(읽어오고) 출력하기 하면 됨
			//-------------------------------------------------------------------------------------------------
			//<입력>
			//target이 가리키는 파일로부터 입력 받을 수 있도록
			//입력용 스트림 생성
			fis = new FileInputStream(target); //기반 스트림
			bis = new BufferedInputStream(fis); //fis를 이용해 bis 보조스트림 객체 생성
			
			//입력용 스트림을 이용해서 target 읽어오기/입력받기
			//byte배열로 얻어오기
			byte[] bytes = bis.readAllBytes(); //바이트 배열로 모두 얻어옴 ->이걸 그대로 출력하면 됨
			//입력 받기 완료
			
			//-------------------------------------------------------------------------------------------------
			//<출력할 파일의 경로 + _copy가 붙은 파일 이름 만들기>
			// target :  /io_test/20240215/노래가사.txt
			// copy :  /io_test/20240215/노래가사_copy.txt

			StringBuilder sb = new StringBuilder();
			sb.append(target); ///io_test/20240215/노래가사.txt 이만큼 집어 넣음
			int insertPoint = target.lastIndexOf(".");//집어넣을 위치 집어줄 것임 ->마지막 점 위치를 찾으면 됨
			//int String.lastIndexOf("문자열")
			// - 입력받은 String 뒤에서부터 검색해서
			//		"문자열"과 일치하는 부분의 인덱스를 반환
			//		일치하는 부분이 없으면 -1을 반환하는 메서드
			
			sb.insert(insertPoint, "_copy"); //찾은 위치에 "_copy"를 집어넣겠다
			//	   /io_test/20240215/노래가사_copy.txt 이렇게 잘 들어가진다
			//System.out.println(sb.toString());
			String copy = sb.toString(); //복사할 파일의 경로
			//<출력>
			fos = new FileOutputStream(copy); //복사본 경로 넣기
			bos = new BufferedOutputStream(fos);
			
			//읽어왔던 내용 bytes를, bos를 이용해서 출력하기
			bos.write(bytes);
			bos.flush(); //입력이 아닌 출력은 스트림에 데이터 남아있을 수 있어서 스트림에 남아있는 내용 모두 밀어내기
			
			System.out.println("복사 완료 : "+copy);
			
		} catch(Exception e) {
			//모든 예외 다 잡아서 처리
			e.printStackTrace();
		} finally {
			//사용 다 한 스트림들 없애주는 코드
			try {
				//사용한 스트림 메모리 반환(닫기, 제거)
				//보조스트림 세 종류만 닫으면 됨
				if(br !=null) br.close();
				if(bis !=null) bis.close();
				if(bos !=null) bos.close();
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
