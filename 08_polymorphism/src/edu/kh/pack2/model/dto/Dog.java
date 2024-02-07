package edu.kh.pack2.model.dto;

public class Dog extends Animal{
//extends Animal 쓰면 오류나는 이유
	// The type Dog must implement the inherited abstract method Animal.sleep()
	//오버라이딩 하라는 뜻
	
	//추상 클래스를 상속받은 경우!!
	//	->부모 클래스에 작성된 추상메서드를 반드시!!!모두!!! 오버라이딩 해야 오류나지 않는다
	//			==오버라이딩 강제화
	//먹는것과 자는것 모두 오버라이딩(재정의)해야 함
	
	//필드(강아지라면 있어야 하는 것)
	private boolean harness; //가슴줄 있는지 없는지
	
	
	//기본생성자
	public Dog()	{
		super(); //아무것도 안쓰면 이거 추가해줌
	}
	//매개변수 생성자
	public Dog(String type, boolean harness) {
		super(type);
		this.harness = harness;
	}
	
	//getter/setter
	

	public boolean isHarness() {
		return harness; //boolean이어서 getHarness가 아닌 isHarness로 이름지어짐
	}
	public void setHarness(boolean harness) {
		this.harness = harness;
	}
	
	@Override
	public void eat()	{
		System.out.println("강아지는 엎드려서 입만 이용해서 밥을 먹는다.");
	}
	
	
	@Override
	public void sleep()	{
		System.out.println("강아지는 몸을 웅크리고 잔다.");
	}
	
	@Override
	public String toString()	{
		return super.toString()+" / 가슴줄 유무 :"+harness;
	}
	
}
