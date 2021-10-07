package cls;

public class MyClass {

	private int number;
	private String name;
	private double height;
	
	public MyClass() {	// 생성자
		System.out.println("MyClass MyClass()");
		number = 10;
		name = "빈칸";
		height = 100.0;
	}
	
	public MyClass(char c) {
		System.out.println("MyClass MyClass(char c)");
	}
	
	public MyClass(int number, String name, double height) {
		System.out.println("MyClass MyClass(int number, String name, double height)");
		this.number = number;
		this.name = name;
		this.height = height;
	}
	
	public MyClass(int i) {
		
		// 생성자에서 다른 생성자를 호출할 경우 반드시 제일 위체 적어야함.
		this();	// 기본 생성자 (매개변수가 없는 생성자)를 호출함. 생성자 안에서 생성자 호출하기 가능
	//	this('A'); 불가능! this 다음에 또 this를 쓰는 건 불가능
		this.number = i;
		System.out.println("MyClass MyClass(int i)");
		
	}
	
}
