package edu.kh.variable.ex;

public class VariableEx3 {
public static void main(String[] args) {
	//강제 형변환 : 값의 범위가 큰 자료형을 값의 범위가 작은 자료형으로 변환
	//데이터가 손실될 수 있음

	/*강제 형변환
	 * 1. 값의 범위가 큰 자료형 ->작은 자료형으로 강제적 변환
	 * 		->데이터 손실 고려 필요
	 * 2. 의도적으로 자료형을 다른 자료형으로 변환
	 * 
	 * [작성법]
	 * (자료형) 변수명||값; (|| : 또는)
	 * 		->지정된 자료형으로 변경됨
	 */
	
	//강제 형변환 확인 1
	//	->자료형 변환 + 데이터 손실
	int num1 = 290;
	byte result1 = (byte) num1; //byte로 강제 형변환해서 byte 변수에 저장 가능
	System.out.println("num1 :" +num1);
	System.out.println("result1 :" +result1); //256이 날아감 
	
	//강제 형변환 확인 2
	//	->실수를 정수로 변환해서 소수점 없애기(데이터 손실 활용)
	double num2 = 123.123456789;
	int result2 =  (int)num2;
	System.out.println("num2 :" +num2);
	System.out.println("result2 :" +result2);
	
	/*난수 + 강제 형변환*/
	//	난수 : Math.random();
	//					-> 0.0 <= x < 1.0
	
	// 1~10 사이 난수
	//	int random = Math.random()*10 +1; //1이상 11미만 정수
	int random = (int)(Math.random()*10 +1); //JS에서는 앞에 Math.floor했었음
	//자바스크립트 올림 / 내림 / 반올림 (Math.ceil / Math.floor / Math.round)
	//난수에서 발생하는 소수부분을 강제 형변환으로 제거(떼버림)(이건 그냥 소수점 떼버리는 것임)
	System.out.println("random :" +random);
	
	//강제 형변환 확인 3
	//	->의도적으로 강제 형변환
	System.out.println(123); //기본값 : int
	System.out.println((double)123); // 범위가 작은 int(123)에서 큰 double(123.0)로 나옴
	
	//강제 형변환 확인 4
	// + 값 처리 원칙(같은 자료형 연산 -> 같은 자료형 결과 도출)
	int num3 = 5;
	int num4 = 2;
	
	System.out.println(num3 / num4); //5/2하면 2.5나올 것 같은데 2 나옴
	//int끼리 나눴으니 결과가 int로 나오므로 2.5(double)가 아닌 2(int)로 나옴
	//결과 도출 시에는 값 처리 원칙이 우선됨
	// 2.5나오게 하고 싶으면?
	//	System.out.println((double)(num3 / num4)); //2.5가 나오는 게 아닌, 2가 2.0으로 바뀜
	//2.5나오게 하고 싶으면?
	System.out.println((double)num3 / (double)num4); //연산 재료를 다 double로 해주면 결과도 double로 나옴
	// (double) 5 / (double) 2
	//	== 5.0 / 2.0
	//	== (double) 2.5
	//-------------------------------------------------------------------------------------------------------
	//강제 형변환 + 자동 형변환 + 값 처리 원칙
	//근데 앞쪽이나 뒤쪽의 아무거나 하나 double빼도 됨
	System.out.println((double)num3 / num4);  
	// (int) 5 / (int) 2 
	
	// 강제 형변환 
	//(double) 5.0 / (int) 2 //강제로 둘 중 하나를 double로 바꿔주기
	
	
	// 자동 형변환 
	//값의 범위가 서로 다른 애들의 연산 시 
	//범위 작은 애의 범위가 자동으로 
	//범위 큰 애의 범위로 변환됨
	//(double) 5.0 / (double)2.0
	// 값 처리 원칙 
	//(double) 5.0 / (double) 2.0 == (double) 2.5
	
	
	//강제 형변환 확인 5
	//	문자(char)<->유니코드(int) 서로 바꾸기
	// '' : char  자료형 
	System.out.println("A의 번호 :" +'A');
	System.out.println("A의 번호 :" +(int)'A');
	//84번의 문자는 뭘까? T
	System.out.println("84의 문자 :" +(char)84);
	
	//------------------------------------------------------------------------------
	// 오버플로우 : +범위에서 범위 넘어가는 것
	// 언더플로우 : -범위에서 범위 넘어가는 것
	// 오른쪽에서 벗어나면 왼쪽으로 간다?
	// 오버 플로우 : 연산으로 인해 자료형 값의 범위를 초과하는 경우 발생
	byte temp1 = 127; // byte는 처음에 선언할 때 int 형식으로 써도 허용됨
	byte temp2 = (byte)(temp1 +1); //int 결과를 강제 형변환 시킴
	byte temp3 = (byte)(temp1 +2); //int 결과를 강제 형변환 시킴
	System.out.println("temp1 :" +temp1); //127
	System.out.println("temp2 :" +temp2); //-128 한 칸 넘어가서 왼쪽으로 넘어감
	System.out.println("temp3 :" +temp3); //-127 두 칸 넘어가서 왼쪽으로 두 번 넘어감
	// VariableEx4 클래스 이름 첫글자는 대문자, 카멜표기법 적용! 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
