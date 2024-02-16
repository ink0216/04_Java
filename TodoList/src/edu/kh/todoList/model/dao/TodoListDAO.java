package edu.kh.todoList.model.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.kh.todoList.model.dto.Todo;

// DAO (Data Access Object) : 데이터가 저장된 파일/DB/외부 장치에 접근하는 역할만 함 
public interface TodoListDAO {
//public abstract를 명시하지 않아도 public abstract으로 해석됨!!
//인터페이스가 가진 모든 메서드는 모두 추상메서드이기 때문에 적어도 그만 안적어도 그만임!
	
	/** TodoList를 파일로 저장하는 메서드
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	void saveFile() throws FileNotFoundException, IOException ;
	
	
	
	/** 할 일 목록 반환 
	 * @return todoList
	 */
	List<Todo> todoListFullView();

	
	/** 전달 받은 index 번째 todo를 반환
	 * @param index
	 * @return index 번째 todo, 없으면 null
	 */
	Todo todoDetailView(int index);

	
	
	/** 할 일 추가
	 * @param todo
	 * @return 추가된 index 번호 반환
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	int todoAdd(Todo todo) throws FileNotFoundException, IOException;

	
	
	/** 할 일 완료 여부 변경 (O <-> X)
	 * @param index
	 * @return 해당 index 요소의 완료 여부가 변경되면 true
	 * 				 index 요소가 없으면 false
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	boolean todoComplete(int index) throws FileNotFoundException, IOException;

	
	/** 할 일 수정
	 * @param index
	 * @param title
	 * @param detail
	 * @return 성공 true, 실패 시 false
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	boolean todoUpdate(int index, String title, String detail) throws FileNotFoundException, IOException;


	/** 할 일 삭제
	 * @param index
	 * @return 성공 시 삭제된 할 일(Todo) 반환
	 * 				인덱스 범위 초과로 실패 시 null 반환 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	Todo todoDelete(int index) throws FileNotFoundException, IOException;
}
