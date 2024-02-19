package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

	Scanner sc = new Scanner(System.in);
	
	
	/** 
	 * 실습문제 1
	 */
	public void practice1() {

		// 길이가 9인 배열을 선언 및 할당하고,
		int[] arr = new int[9];
		
		// 1부터 9까지의 값을 반복문을 이용하여
		// 순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		//짝수 번째 인덱스 값의 합을 출력하세요
			//(0번째 인덱스는 짝수로 취급)
		int sum=0;
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
			
			if(i%2==0)  sum+=arr[i];
		}
		System.out.println(); //줄바꿈
		System.out.print("짝수 번째 인덱스 합 :");
		System.out.println(sum);
		
	}
	/**<pre>
	 * 실습문제 2
	 * 9 8 7 6 5 4 3 2 1
	 * 홀수 번째 인덱스 합 : 20
	 * </pre>
	 */
	public void practice2() {
		/*길이가 9인 배열을 선언 및 할당하고, 
		 * 9부터 1까지의 값을 반복문을 이용하여
		순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
		*/
		int arr[] = new int[9];
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			arr[i]=9-i;
			System.out.print(arr[i]+" ");
			
			if(i%2==1) sum+=arr[i];
		}
		System.out.println(); //줄바꿈
		System.out.print("홀수 번째 인덱스 합 :"+sum);
		
	}

	
//public void practice3() {
//System.out.print("양의 정수 :");
//int input = sc.nextInt();
//int [] arr = new int[input];
//for(int i=1 ; i<=input ; i++) {arr[i]=i;
//System.out.print(arr[i] +" ");}
//}

	/**
	 * <pre>
	 * 입력 받은 양의 정수만큼 배열 크기를 할당하고
	 * 1부터 입력받은 값까지 배열에 초기화한 후 출력
	 * </pre>
	 */
	public void practice3() {
		System.out.print("양의 정수 :");
		int len= sc.nextInt();
		int[]	 arr = new int[len];
		//1				3			2   	(윗줄 해석 순서)
		//new => heap 메모리에 len칸 만큼의 배열 만드는 것!
		//arr 변수는 stack 영역에 생성되고, 참조형변수임
		//1) Stack 영역에 int[]을 참조하기 위한 참조형 변수 arr 선언
		//2) Heap 영역에 입력받은 len 만큼의 길이를 갖는 int[] 생성
		//			->주소가 할당됨
		//3) arr 변수에 배열 전체가 대입되는 것이 아닌, 배열의 주소를 대입해서
		//				참조할 수 있는 형태로 만듦
		
		//len ==arr.length
		for(int i=0; i<len ; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] +" ");
		}
		
				}
	//초기화 = 처음으로 값을 대입하는 것
	/**<pre>
	 * 정수 5개를 입력받아 배열 초기화하고
	 * 검색할 정수를 하나 입력 받아
	 * 배열에서 같은 수가 있는 인덱스를 찾아 출력
	 * 같은 수가 없을 경우 
	 * "일치하는 값이 존재하지 않습니다"출력
	 * </pre>
	 */
	public void practice4() {
		int[] arr = new int[5];
		for(int i=0 ; i<arr.length; i++) {
			//5라고 쓰지 말고 length로 쓰는 게 나중에 칸 수 변할 때 대비해서 좋음
			System.out.printf("입력 %d :", i);
			arr[i] = sc.nextInt();
			
		}
		System.out.print("검색할 값 :");
		int searchValue = sc.nextInt();
		
		//배열 검색 다 훑어봄
		for(int i=0; i<arr.length ;i++) {
			if(arr[i]==searchValue) {
				//배열의 i번째 요소의 값을 꺼내 봤는데 
				//searchValue와 같을 경우
				//	->같은 경우가 있는 경우
				System.out.println("인덱스 :"+i);
				return; //하나 찾으면 중지하고 밖으로 나감
			}
		}
		//배열 내의 모든 값을 찾아봤는데 없는 경우,
		//for문 수행 중 if문 내의 return 구문이 실행되지 않음
		//코드 수행 중 중간에 멈추는(같은 값이 존재하는 경우) 일이 없으므로
		//바로 다음코드인 아래 코드가 실행됨
		System.out.println("일치하는 값이 존재하지 않습니다.");
		
}
	/**
	 * <pre>
	 * 실습 문제 5
	 * 배열 길이 직접 입력
	 * 배열 선언 및 할다아
	 * 초기화
	 * 값 나열
	 * 인덱스 총합 출력
	 * </pre>
	 */
	public void practice5() {
		System.out.print("정수 :");
		int len=sc.nextInt();
		
		int[] arr = new int[len];
		
		//배열 요소 하나씩 입력받아 넣기
		for(int i=0; i<arr.length; i++) {
			//배열 요소 순차 접근
			System.out.printf("배열 %d번째 인덱스에 넣을 값 :", i);
			arr[i] = sc.nextInt();
		}
		
		int sum=0; //초기화 안하는 것 자바에서는 안됨! 
		//합계 누적용 변수
		
		//만들어진 배열 요소 하나씩 출력
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
			sum+=arr[i]; //sum=sum+arr[i] 더한 값을 sum에 다시 대입
		}
		//합계 구하는 것은 위의 두 for문 중 아무데에서나 해도 됨
		System.out.println("\n총 합:"+sum);
		// \n : 줄바꿈!!!!!! 
		//그 위는 print라서 한줄로 나오는데
		//총합은 다음줄에 나왔으면 좋겠어서;
	}
	/**<pre>
	 * 주민등록번호를 입력받아
	 * char배열에 저장한 후 출력
	 * 단, 뒷자리의 성별 번호 이후부터는 *로 저장 
	 * charAt사용
	 * 주민등록번호(-포함) :
	 * 123456-2****** 총 14자리->char배열 14칸짜리
	 * </pre>
	 */
	public void practice6() {
		//주민등록번호를 저장할 char배열 생성
		char[] arr = new char[14];
		System.out.print("주민등록번호(-포함) :");
		//숫자 : 문자열임! 
		//	->중간에 띄어쓰기 없으므로 -포함한 주민등록번호 전체를 "하나의 단어"로 볼 수 있음
		//		sc.next sc.nextLint 둘다 사용 가능
		String input= sc.nextLine();
		
		//문자열.length() : 문자열(String)의 길이를 반환하는 메서드
		//배열의 길이 반환하는 것은 메서드가 아닌 필드여서 소괄호 안붙여도 됨
		
		//		int len=input.length(); 근데 len이라는 변수를 for문에서만 사용하고 싶으면 초기식에 쓰기
		//초기식은 딱 한번만 실행되고 마니까 효율 나빠지지 않음
		for(int i=0 ,len=input.length(); i<len ;i++) {
			//조건식에 input.length()로 해도 되지만 
			//2번 해석할 때마다 input.length()의 길이 매번 세니까 효율에 안좋음!
			//미리 한번만 세놓고 그거 갖다가 쓰기만 하기 
			
			//7번 인덱스까지는 하나하나 뜯어서 그대로 배열에 대입
			if(i<=7) arr[i] = input.charAt(i);
			
			//else부분(성별 부분)부터는 모두 *을 대입
			else		arr[i] = '*'; //char만 저장하는 배열이므로 String의 ""사용하면 안되고
			//char를 나타내는 ''로 대입해야 함
		}
		
		//배열에 담긴 내용 모두 출력 ->위의 for문에서 넣자마자 출력해도 되는데 나눠서 함
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]);
		}
	}
	/**<pre>
	 * [실습문제 7]
	 * 3이상인 홀수를 입력 받아 
	 * 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
다시 정수를 받도록 하세요.
언제 반복 끝날 지 모르니까 while 구문 사용 ->조건 맞으면 멈추게 하기(break)
숫자가 늘었다 줄었다 
->인덱스 값의 1더한 값 대입하는 방법도 있는데 그거 말고 !
->카운트가 1로 시작해서 절반까지는 증가했다가(++) 감소하도록(--) 해보기! 
</pre>
	 */
	public void practice7() {
		//while문으로 조건에 맞는 수가 입력될 때까지 반복
		//+ break, 
		//배열 요소에 대입되는 숫자는 count값을 ++, --를 이용해 제어
		int len=0; //선언 및 초기화
		while(true) {
			//true쓰면 무한루프 돎
			//3 이상의 홀수가 입력될 때까지 무한반복 할 것임
			System.out.print("정수 :");
			len=sc.nextInt();
			
			//입력받은 len이 3이상의 홀수인지 검사해서 그런 경우 반복 종료시킴
			if(len>=3 && len%2==1) break; //반복 멈춤
			//if문이 실행 안된 경우는 len이 3이상이 아니거나 짝수라는 것 !->굳이 else안써도됨
			System.out.println("다시 입력하세요.");
		}
		//while 종료 후 입력받은 정수 크기만큼의 배열 선언, 할당
		int[] arr = new int[len];
		
		int count=0; //arr 배열 요소에 대입될 수
		for(int i=0; i<len ;i++) {
			
			//배열 길이의 절반(2임, 2.5아님!) 이하인 경우 증가, 넘은 경우 감소
			if(i<=len/2) count++;
			else					count--;
			arr[i] =count; //count값을 배열 요소에 대입
		}
		//Arrays쓰고 ctrl스페이스바 하면 위에 임포트 추가됨
		//Arrays.toString(배열명) : 배열 내 요소를 [1,2,3] 형식의 문자열로 만들어 반환
		System.out.println(Arrays.toString(arr)); //저 모양의 문자열로 바꿔서 콘솔에 출력해라
	}
	
	/**<pre>
	 * 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.
</pre>
	 */
	public void practice8() {
		int[] randoms = new int[10];
		String str=""; //빈 문자열(String이긴 함)
		for(int i=0 ; i<randoms.length ; i++) {
			
			
			//Math.random()*10+1 == 1.0이상 11.0미만
			randoms[i] = (int)(Math.random()*10+1); 
			str +=randoms[i] +"";
		}
		System.out.println("발생한 난수 :" +str);
	}
	/**<pre>
	 * 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.
+최대값, 최소값 구하기
</pre>
	 */
	public void practice9() {
		int[] randoms = new int[10];
		String str=""; //빈 문자열(String이긴 함)
		int max=0; //최대값 저장할 변수
		int min=0; //최소값 저장할 변수
		for(int i=0 ; i<randoms.length ; i++) {
			
			//Math.random()*10+1 == 1.0이상 11.0미만
			randoms[i] = (int)(Math.random()*10+1); 
			str +=randoms[i] +"  ";
			
			if(i==0) {
				//첫 번째 반복인 경우 ->무조건 실행되는 코드
				max=randoms[i];
				min=randoms[i];
				//첫 번째 발생한 난수를 두 값에 넣어놓고
				//더 큰 값이 뒤에 생기면 max값을 교체하고
				//더 작은 값이 뒤에 생기면 min값을 교체
				continue; //아래 코드 더 실행 안하고 다음 반복으로 이동
			} 
			//첫 반복이 아닌 경우->크기 비교하는 코드 작성
			if(randoms[i]>max) max=randoms[i];
			if(randoms[i]<min) min=randoms[i];
			//위에 max와 min에 0이라고 초기화 안하면 바로 위의 두 if문에서 오류남
			
		}
		System.out.println("발생한 난수 :" +str);
		System.out.println("최대값 :" +max);
		System.out.println("최소값 :" +min);
	}
	/**<pre>
	 * 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
1~10 사이의 난수를 발생시켜 "중복된 값이 없게" 배열에 초기화한 후 출력하세요.
</pre>
	 */
	public void practice10() {
		int[] randoms = new int[10];
		String str=""; //빈 문자열(String이긴 함)
		
		//난수 생성용 for문 +중복제거 기능 추가
		for(int i=0 ; i<randoms.length ; i++) {
			//Math.random()*10+1 == 1.0이상 11.0미만
			randoms[i] = (int)(Math.random()*10+1); 
			
			//첫 반복일 때에는 난수 그냥 넣고
			//그 이후 반복일 때에는 그 앞의 모든 인덱스에 같은 값이 있는지 검사해보고
			//없으면 그 값을 넣고. 있으면 그걸 새로 다시 난수 발생시키기 
			//다 채워질 때까지 반복
			/*중복 검사 방법
			 * 현재 인덱스에 대입된 난수와 같은 값이
			 * 앞쪽 인덱스에 하나라도 존재하면
			 * 다시 해당 인덱스에 새로운 난수를 생성해서 대입
			 * */
			for(int x=0 ;x<i ; x++) {
//				현재 인덱스 i의 앞쪽까지만(미만) 순차 접근하는 for문
				//첫번쨰 바퀴(i=0)일 때에는 이 부분 넘어가서 실행되지 않음
				
				//현재 인덱스에 저장된 값(지금 발생한 난수)과
				//앞쪽 인덱스에 저장된 값(이전에 발생한 난수)가
				//같은 경우가 있을 경우 중복으로 판단!
				if(randoms[i] ==randoms[x]) {
					//중복된게있으면 가장 바깥 for문을 증가시키지 않기
					i--; //바깥쪽 for문의 i값 증가를 막아서 
								//현재 인덱스 번째 요소에 다시 새로운 난수를 대입하게 만듦	
					break; //이미 중복된 것 찾았으면 그 뒤에는 검사할 필요 없어서 바로 멈춤
				}
			}
		}
		//str 출력 구문 만들기용 for문
		for(int i=0 ; i<randoms.length ; i++) {
			//Math.random()*10+1 == 1.0이상 11.0미만
			str +=randoms[i] +" ";
		}
		System.out.println("발생한 난수 :" +str);
	}
	
	/**<pre>
	 * [실습문제 11]
	 * 로또 번호 자동 생성기 프로그램을 만들기.
(중복 값 없이 오름차순으로 정렬하여 출력하세요.)
1~45번 숫자
숫자 6개 선택
</pre>
	 */
	public void practice11() {
		//1) 크기가 6인 정수형 배열 생성
		int[] lotto = new int[6];
		
		//2) 1~45사이 중복 없는 난수로 lotto배열 요소 초기화
		for(int i=0 ;i<lotto.length;i++) {
			lotto[i] = (int)(Math.random()*45+1);
			for(int x=0; x<i ;x++) {
				if(lotto[i]==lotto[x]) {
					i--;
					break;
				}
			}
		}
		//숫자 오름차순 정렬 코드(선택정렬)
		//오름차순 정렬 종류 : 선택정렬(가장쉬운방법, 효율은 나쁨), 삽입정렬, 퀵정렬?-시간복잡도, 공간복잡도, log,....
		//0번인덱스에 최소값이 들어가야함
		//1,2번 숫자 비교해서 2가 더 작으면 2,1로 자리바꿈
		//2랑 3이랑 비교해서 3이 더 작으면 3이 맨앞으로 자리바꿈
		//0번인덱스 확정되면 1번인덱스로 이동해서
		//1번인덱스 숫자와 그 뒤 인덱스 숫자 비교해서 그 뒤 숫자가 더 작으면 1번인덱스와 자리바꾸기
		//그 뒤 인덱스 숫자들도 각각을 기준으로 ......반복
		//마지막인덱스는 그냥 남은 숫자 넣으면 되니까 비교할 필요 없음
		for (int i=0; i<lotto.length-1;i++ ) {
			//칸 지정(비교 주체) : 누구를 중심으로 비교할 지 지정
			//마지막 인덱스는 비교할 필요 없으니까 마지막거 뺴야하므로 -1함
			for(int x=i+1; x<lotto.length;x++) {
				//이건 비교 주체 뒤에 애들과 비교하는 것(비교대상)
				if(lotto[i] >lotto[x]) { //왼쪽의 부등호 방향만 반대로<이렇게 하면 내림차순 정렬이 됨
					// 주체>대상 : 오름차순
					// 주체<대상 : 내림차순
					
					//lotto[i] = 비교 기준
					//lotto[x] = 비교 기준 뒤에 있는 비교대상들
					//비교 주체(비교 기준)가 비교대상보다 크면 자리 교체하기(Swap)
					//다른 변수 하나 만들기 (지하철 보관소)
					int temp = lotto[i];
					lotto[i]= lotto[x];
					lotto[x]=temp; //자리가 바뀌면서 순서가 바뀜
					
				}
			}
		}
		
		//Arrays.sort(lotto); 
		//자바에서 만들어서 제공하는 배열 오름차순 정렬 기능(위 코드 안쓰고 이걸로 해도 됨)
		//자바 제공 기능 : API 
		//sort : 정렬
		
		//결과 출력
		System.out.println(Arrays.toString(lotto));
	}
	/**<pre>
	 * [실습 문제 12]
	 * 
	 * 문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
	문자의 개수와 함께 출력하세요. (중복 제거)
	[실행 화면]
문자열 : application
문자열에 있는 문자 : a, p, l, i, c, t, o, n
문자 개수 : 8
</pre>
	 */
	public void practice12() {//미완성!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		int size = str.length();
		for(int i=0 ; i<size; i++) {
			
		}
	}
	/**
	 * <pre>
	 * 사용자가  입력한  배열의  길이만큼의  String 배열을  선언  및  할당하고 
배열의  인덱스에  넣을  값  역시  사용자가  입력하여  초기화  하세요. 
단, 사용자에게  배열에  값을  더  넣을지  물어보고  몇  개를  더  입력할  건지, 
늘린  곳에  어떤  데이터를  넣을  것인지  받으세요.
사용자가  더  이상  입력하지  않겠다고  하면  배열  전체  값을  출력하세요.
(배열의  얕은  복사, 깊은  복사를  이용하는  문제)
	 * </pre>
	 * <pre>
	 * 배열의    크기를    입력하세요    : 3 
1번째    문자열    : 자바의    정석
2번째    문자열    : 알고리즘
3번째    문자열    : C프로그래밍
더    값을    입력하시겠습니까?(Y/N) : y 
더    입력하고    싶은    개수    : 2
4번째 문자열 : 인간관계 
5번째 문자열 : 자기계발
더    값을    입력하시겠습니까?(Y/N) : y 
더    입력하고    싶은    개수    : 1
6번째    문자열    : 영단어600
더    값을    입력하시겠습니까?(Y/N) : n
[자바의 정석, 알고리즘, C프로그래밍, 인간관계, 자기계발, 영단어600]
	 * </pre>
	 */
	public void practice13() {//미완성!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		System.out.print("배열의 크기를 입력하세요 : ");
		int input = sc.nextInt();
		String[] str = new String[input];
		for(int i=0; i<str.length; i++) {
			System.out.printf("%d번째 문자열 : ", i+1);
			str[i] = sc.nextLine();
		
		while(true) {
		System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
		char yn = sc.next().toLowerCase().charAt(0);
		if(yn == 'n') break;
		System.out.print("더 입력하고 싶은 개수 : ");
		int input2 = sc.nextInt();
		for(int j=0; j<input2; j++) {
			System.out.printf("%d번째 문자열 : ", j+i+1);
			
			String[] arr2 = new String[input2];
			arr2[j] =sc.nextLine(); 
		}
		}
		
		
		}
		System.out.println(str.toString());
		
	}
}
		
		
		
	
			
			
			
			
			
		
	
	
	
		
		
		

