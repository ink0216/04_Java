package edu.kh.array.ex;

import java.util.Arrays;

public class ArrayEx2 {
/**
 * 얕은 복사 : 값이 아닌 주소만 복사 (JS에서도 했었음)
 * int[] arr1 = new int[4];
 * int[]arr2 = arr1; 인 경우
 * 서로 다른 두 변수가 같은 배열을 참조하고 있음
 * arr2에 arr1과 같은 주소가 들어가서
 * arr1에서 배열 수정하면
 * arr2가 가서 열어봤을 때에도 바껴있음
 */
public void method1() {
	int[] arr1 = {100, 200, 300, 400}; //arr1에는 참조하고 있는 배열의 주소만 저장돼있음
	int[] arr2 = arr1; //1번에 대입돼있는 주소를 대입
	System.out.println("arr1 :"+Arrays.toString(arr1)); //Array 쓰고 자동완성 해서 위에 임폴트 해오고
	System.out.println("arr2 :"+Arrays.toString(arr2));
	
	//서로 다른 변수(arr1, arr2)를 이용하여 값을 변경
	arr1[0] = 1234;
	arr2[1] = 9876;
	System.out.println("------------------------------------------------------------------------------");
	System.out.println("arr1 :"+Arrays.toString(arr1)); 
	System.out.println("arr2 :"+Arrays.toString(arr2)); //그럼 두 변수 둘다 똑같이 바껴서 나올거임
	//얕은 복사(같은 주소를 참조) 상태이기 때문에
	//arr1, arr2모두 출력 시 같은 결과가 나옴
}


/**
 * 깊은 복사 : 값을 똑같이 복사한 배열/객체를 새로 생성
 * 새로운 배열을 기존의 heap 영역에 있던 배열이랑 같은 수로 새로 만들어서
 * arr1에서 값 바꿔도 arr2가 참조하는 배열에는 영향 없음
 */
public void method2() {
	int[] arr1 = {10,20,30,40,50}; //원본 배열
	
	//arr1의 값을 복사할 배열(깊은 복사) 2개 만듦
	int[]	arr2 = new int[arr1.length]; //칸 수가 똑같은 배열 생성
	int[]	arr3 = new int[arr1.length]; //칸 수가 똑같은 배열 생성
	
	//깊은 복사 방법 1 ) - for문 이용
	for(int i=0 ; i<arr1.length;i++) {
		arr2[i]=arr1[i]; //1번에 있는 인덱스를 같은 위치에 넘겨주기(복사)
	}
	
	//깊은 복사 방법 2) - System.arraycopy() 이용

  // System.arraycopy(원본 배열명, 원본 복사 시작 인덱스,
	// 			복사 배열명, 복사 배열에서 가져온 값 삽입 시작 인덱스, 몇 개 복사할 지 복사 길이)
	//매개변수가 다섯개 !!!!!
	System.arraycopy(arr1, 0, arr3, 0, arr1.length); //0번부터 복사해서 0번부터 넣을건데 끝까지 복사할거야
	System.out.println("arr1 :" +Arrays.toString(arr1));  //원본
	System.out.println("arr2 :" +Arrays.toString(arr2));	//for문 사용
	System.out.println("arr3 :" +Arrays.toString(arr3));	//arraycopy사용
	
	//모든 배열의 0번 인덱스 값을 바꿔보기
	arr1[0] = 999;
	arr2[0] = 888;
	arr3[0] = 777;
	System.out.println("------------------------------------------------------------------------------");
	System.out.println("arr1 :" +Arrays.toString(arr1));  //원본
	System.out.println("arr2 :" +Arrays.toString(arr2));	//for문 사용
	System.out.println("arr3 :" +Arrays.toString(arr3));	//arraycopy사용
}
/**
 * 2차원 배열 : 1차원 배열 참조 변수의 묶음(주소 저장해놓은 것을 묶어놓은것)
 * 기존의 배열 = 1차원 배열
 * 변수 : 값을 저장하는 공간
 * 1차원 배열 : 변수의 묶음
 * 2차원 배열 : 1차원 배열 참조변수의 묶음
 * 각각 다른 배열을 참조하는 변수 두개에 각각 배열의 주소가 들어있는데 그 주소 두개를 또 묶어서 배열로 만든 것 
 */
public void method3() {
	//2차원 배열 선언
	int[][] arr=new int[2][3]; 
	//==3칸짜리 1차원 배열을 참조하는 참조형 변수 2개를 묶어서 참조하는 배열 생성해서 그 주소를 arr에 대입
	
	//2차원 배열 초기화하기
	arr[0][0] =10; 
	arr[0][1] =20;
	arr[0][2] =30;
	
	arr[1][0] =40;
	arr[1][1] =50;
	arr[1][2] =60;//arr아파트의 1층의 2호
	
	//2차원 배열 내 모든 요소 순차 접근
	
	//arr[row].length ==row번째 행이 참조하고하고 있는 1차원 배열의 length ==3 
	//								==row 번째 행의 열의 개수
	
	//행 제어 for문
	for(int row=0 ;row<arr.length; row++) {
		//2바퀴 돌림
		//arr.length = 1차원 배열 참조변수의 개수 = 2
		
		//열 제어 for문
		for(int col=0 ; col<arr[row].length; col++) {
			System.out.print(arr[row][col]+" "); //요소 출력
		}
		System.out.println();//줄바꿈
	}
}




}
