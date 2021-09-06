package cls;

public class ChildClass extends ParantClass {
	
	private String address;
	
	public ChildClass() {	// 자식클래스 생성자 호출시 부모클래스 생성자부터 호출됨
		super("성춘향", 16);	// this: 자기참조, super: 부모참조
		System.out.print("ChildClass ChildClass()");
	}
	
	public ChildClass(String name, int number, String address, int age) {
		super(name, number, age);	// 자식클래스를 통해 부모클래스로 내용을 전달 할 수도 있다.
		this.address = address;	// super와 this를 함께 쓸 수 있는데, 반드시 super가 가장 위에 있어야 한다.
	}

	public void func() {
		System.out.println("ChildClass func()");
		
	//	name = "일지매"; 부모클래스의 private 변수에는 접근 불가
		setName("일지매");	// 부모클래스의 함수는 정상적으로 접근 가능
		number = 34;	// protected 변수는 자식클래스에서 접근 가능
		age = 24;	// public 변수는 클래스 상관없이 접근 가능
		
		super.number = 12;
		super.pMethod();	// 이런식으로도 사용가능
	}

}
