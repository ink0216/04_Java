package edu.kh.io.pack3.model.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import edu.kh.io.pack3.model.dto.Member;

public class ObjectService {
	//입출력할 때 객체를 입출력하기
	/*ObjectInputStream / ObjectOutputStream
	 * - Java 객체 (Instance == Object)를 입/출력 할 때 사용하는
	 * 		바이트 기반 "보조" 스트림
	 * 		(보조 스트림은 단독 사용이 불가능하다!!!!!!!)
	 * 
	 * ***** 직렬화(Serializable) *****
	 * - 객체(Object)를 직선(직렬) 형태로 변환하는 것
	 * - 직렬화가 필수인 이유!!!*/
	
	/**
	 * 객체를 외부 파일로 출력하기
	 */
	public void objectOutput() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("/io_test/20240215/Member.dat"); //이 파일을 만들어서 출력할거다
			//dat 확장자 == data를 담고 있는 파일을 나타내는 확장자(그냥 여기 값이 있다)
			//bat 확장자와는 다른 것임!
			
			oos = new ObjectOutputStream(fos); //객체 보조 스트림 생성
			
			//oos = 1바이트만 통과할 수 있는 통로
			//Member 객체 하나 생성
			Member member = new Member("member01", "pass01!", "김회원", 30);//멤버 하나 만들어짐
			
			/*ObjecOutputStream을 이용해서 Member객체 출력하기(밖에다 씀 ->write)*/
			oos.writeObject(member); //다양한 것 출력하는 것 중에 객체 출력하는 것 찾아서 쓰기
			System.out.println("회원 출력 완료");
			//java.io.NotSerializableException: edu.kh.io.pack3.model.dto.Member
			//직렬화가 안되었다는 예외가 발생!!! ==객체가 너무 덩치가 커서 통로(스트림)를 통과할 수 없음
			//직렬화 == 객체를 얇고 길게 만들어서 스트림에 넣기
			//객체의 모양을 바꿈 ->Member 클래스에서 하면 됨
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos !=null) oos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 외부 파일로부터 객체 입력받기
	 * 짜부러진 객체 입력받으면 다시 원래 객체 모습으로 됨
	 */
	public void objectInput() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			//파일 입력 기반스트림 생성
			fis = new FileInputStream("/io_test/20240215/Member.dat"); //저위치에 있는 것 읽어오겠다
			
			//객체 입력 보조 스트림 생성
			ois = new ObjectInputStream(fis);
			
			//스트림을 이용해 파일에 작성된 
			//직렬화된 Member객체를 읽어와
			//역직렬화를 수행하여
			//정상적인 Member 객체로 변경시키기
			//(일자로 짜부러졌던 것을 원래대로 되돌리기)
			Member member = (Member)ois.readObject(); //객체를 읽어오겠다
			//ois.readObject()의 반환형이 Object여서 다운캐스팅 해주기
			
			//ois.readObject() : 직렬화된 객체를 읽어와 역직렬화 시키기 + 정상적인 Member객체로 변경
			System.out.println(member);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois !=null) ois.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
