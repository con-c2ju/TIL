package cls;

public class ParantClass {

	private String name;
	protected int number;	// 자식클래스에서만 접근 허용
	public int age;	// 모두 접근 가능
	
	public void pMethod() {
		System.out.println("ParantClass pMethod()");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/*
	public ParantClass() {
		System.out.println("ParantClass ParantClass()");
	}
	*/
	
	public ParantClass(String name, int number) {
	//	this();	// this로 자기참조인데 괄호 안이 비어있어서 기본생성자를 참조하게됨
		this.name = name;
		this.number = number;
	}

	public ParantClass(String name, int number, int age) {
		super();	
		this.name = name;
		this.number = number;
		this.age = age;
	}
	
	

}
