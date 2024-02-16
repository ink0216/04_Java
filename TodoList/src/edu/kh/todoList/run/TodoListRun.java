package edu.kh.todoList.run;

import edu.kh.todoList.view.TodoListView;
//MVC 구조 : 대규모 프로젝트에 적절, 초반세팅 힘듬
//이게 시작!
public class TodoListRun {
public static void main(String[] args) {
	//현재 프로젝트의 흐름
	/*처음에 run이 실행되면 
	 * View 하나만 호출
	 * View 객체 생성해서 
	 * View 객체 생성시 Sevice를 만들고
	 * Service가 DAO를 만들고
	 * DAO가 파일을 입출력함
	 * Run <->View <-> Service <-> DAO <->File
	 * */
	System.out.println("----- 프로그램 실행 -----");
	TodoListView view = new TodoListView(); //TodoListView 객체 생성
	view.startView(); //호출

}
}
