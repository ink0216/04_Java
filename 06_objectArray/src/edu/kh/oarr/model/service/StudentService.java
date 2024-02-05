package edu.kh.oarr.model.service;

import java.util.Random;

import edu.kh.oarr.model.dto.Student;

//Service 클래스 : 기능 제공 클래스
//->입력 출력 빼고 나머지 기능 모두 여기서 함
// ex) 로직(if문, for문 ...)을 이용한 데이터 가공, 저장 처리
public class StudentService {
//필드
	private Student[] students = new Student[10];
	//Student배열을 참조하겠다
	//heap영역에 학생 객체 참조 변수 10칸 묶음인 Student[] 생성(할당)하고
	//그 10칸을 하나하나 뜯은 것은 각각 자료형이 Student임
	//학생 객체를 참조하는 참조변수를 10개 묶은 것이지, 학생 객체를 10개를 만든 것 아님
	//Student는 객체아니고 참조변수(주소만 저장)임
	
	//배열의 주소를 students 참조 변수에 대입
	//students의 자료형 : Student[] (Student배열)
	//학생 객체 10개 : new Student() 구문 10줄 쓰는 것
	
	//기본 생성자 : 클래스명 똑같이 써야함
	public StudentService() {
		//학생 객체 배열 (students)에 샘플 학생 3명 추가
		//students의 자료형 : Student[]
		//students[0]의 자료형 : 
		students[0] = new Student("24001", "최미영", 'F');
		//새 객체 만들어서 넣어줌
		students[1] = new Student("24002", "홍길동", 'M');
		students[2] = new Student("24003", "신짱구", 'M');
		
//		Math.random() : 현재 시간을 기준으로 난수 만드는거여서 사실은 난수 아님
		Random random = new Random(); //이게 진짜 랜덤
		//student[3~9] ==null
		//없는데 점수 넣어라 하면 오류나므로 일단 막아두기
		//샘플 학생 점수 초기화
		for(int i=0 ; i<students.length ; i++) {
			//10바퀴 돎
			//i번째 인덱스가 참조하는 학생이 없으면 반복 종료
			if(students[i] ==null) break; //null을 참조하고 있으면 break
			
			students[i].setHtml(random.nextInt(101));
			//random.nextInt(101) : 0이상 101 미만 정수형 난수 생성
			//난수를 생성해서 점수를 집어넣어라
			students[i].setCss(random.nextInt(101));
			students[i].setJs(random.nextInt(101));
			students[i].setJava(random.nextInt(101));
			
		}
	}
	/**전달 받은 학생 객체 주소를 
	 * students 객체 배열에서
	 * 빈칸(null인 칸)에 대입
	 * @param newStd : 전달 받은 학생
	 * @return 대입 성공 시 true, 실패(이미 10명 꽉 찼을 때) 시 false
	 */
	public boolean addStudent(Student newStd) {
		//학생 객체 하나만 전달받음
		
		//10명 중 3명은 이미 들어가있으므로, 7명만 더 추가할 수 있음
		//students 배열의 인덱스 요소 중 맨 처음 null인 부분 찾아서 newStd 대입
		for(int i=0 ; i<students.length ; i++) {
// 			students[i] : 배열의 한칸 한칸들
					if(students[i] ==null) {
						students[i] = newStd;
						return true; //이거 없으면 null인 모든 부분이 한 학생으로 채워짐
					}
					
		}
		
		return false;
	}
	/**학생 객체 배열 (students) 참조 주소를 반환해줌
	 * @return students(주소만 보내주는 것이고, 배열을 통째로 주는 것 아님, 얕은 복사!)
	 */
	
	
	public Student[] getStudents() {
		return students;
	}
	/**학생 1명 정보 조회(index 검색)
	 * @param index
	 * @return 조회된 학생 1명 또는 null이 반환됨
	 */
	public Student selectIndex(int index) {
//		return students[index]; //students의 index 번째를 반환
		if(index<0 || index>=students.length) {
			return null;
		}
		return students[index];
	}
	/**이름이 일치하는 학생 조회
	 * @param name : 입력 받은 이름 전달받아옴
	 * @return 일치하는 학생 정보 또는 null이 반환됨
	 */
	public Student selectName(String name) {
		//students 객체 배열을 순차 접근하여 
		//null이 아니면서 이름이 name과 일치하는 학생 찾아서 return
		/******향상된 for문******/
		//배열.forEach(JS에서만 가능) ,for of, for in
		//향상된 for문의 특징 : 
		//일반 for문은 반복 횟수나 과정을 제어가능
		//순차접근 시 코드를 간단히 쓸 수 있는 방법 = 향상된 for문
		//for(변수 : 배열||컬렉션) : 배열이나 컬렉션(배열 비슷한 것)에서 쓸 수 있음
		// ->배열 또는 컬렉션의 요소를 처음부터 끝까지 순차 접근하는 for문
		// ->매 반복 마다 배열 또는 컬렉션 요소를 하나씩 꺼내와 변수에 저장
		for(Student s : students) {
//			students에서 Student를 하나씩 꺼내옴
			if(s==null) {
				//저장된 학생이 없을 경우
				break; //break 되면 for문이 나가지고 return null됨
			}
			//학생이 있는 경우
			if(s.getName().equals(name)) {
				//현재 접근한 학생의 이름이 전달받은 name이랑 같은지 확인해보기
				//String이니까 기본자료형 아니므로 .equals()를 써야 한다
				//.equals의 소괄호 안에 앞의 것이 무엇과 같은 것인지를 씀 
				return s; //그 학생을 반환한다
			}
		}
		
		
		return null;
	}
	
	
	/**학생 점수 조회
	 * @return
	 */
	public String selectScore(int index) {
		int html = students[index].getHtml();
		int css = students[index].getCss();
		int js = students[index].getJs();
		int java = students[index].getJava();
		int sum = html + css + js + java; //합계
		double avg = sum/4.0; //자동형변환으로 
		String result 
		= String.format("HTML(%d) CSS(%d) JS(%d) Java(%d)", html, css, js, java);
		result+="\n합계 :"+sum;
		result+="\n평균 :"+avg;
		return result;
	}
	/**평균 최고점, 최저점 학생 조회하기
	 * 매개변수 전달받는 것 없다
	 * 이름(평균점수)
	 * @return 최고점 : 홍길동(98.3)
	 * 				 최저점 : 신짱구(45.7)
	 */
	public String selectMaxMin() {
		Student maxStudent = null; //최고점 학생 저장할 변수
		Student minStudent = null; //최저점 학생 저장할 변수
		double maxAvg = 0.0; // 평균 최고점
		double minAvg = 0.0; // 평균 최저점
		//향상된 for문
		for(Student s : students) {
			//처음부터 끝까지 순차접근
			if(s==null) break; //학생이 없으면 멈추겠다
			//학생이 있는 경우
			
			int sum = s.getHtml()+s.getCss()+s.getJs()+s.getJava();
			double avg = sum/4.0; //순차접근하면서 애들 평균 다 구함
			if(maxAvg ==0.0) {
				//첫 번째 바퀴인 경우
				maxStudent = s; //현재 학생 대입
				minStudent = s;
				maxAvg = avg;
				minAvg = avg;
				continue;
			}
			if(maxAvg<avg) {
				//이전 학생들의 평균보다 현재 학생의 평균이 더 높은 경우
				maxAvg = avg;
				maxStudent = s;
			}
			if(minAvg>avg) {
				//기존 최소값보다 현재학생의 평균이 더 작은 경우
				minAvg = avg; //현재 학생의 평균 대입
				minStudent=s;
			}
		}
		return String.format("최고점 : %s(%.1f)\n"
				+ "최저점 : %s(%.1f)\n", 
				maxStudent.getName(), maxAvg, minStudent.getName(), minAvg);
	}
}
