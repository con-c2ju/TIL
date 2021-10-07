package main;

public class MyClass {
	
	static int stNumber;
	int memVar;

	public void memberMethod() {
		System.out.println("MyClass memberMethod()");
	}
	
	public static void staticMethod() {
		System.out.println("MyClass staticMethod()");
		// 멤버 메소드와의 차이: this와 super 사용 불가능
	//	memVar = 1;	오류 발생. 실제 멤버변수는 앞에 this.가 붙었다고 보면 됨 
	}
	
	public static MyClass getInstance() {
		MyClass m = new MyClass();
		m.memVar = 1;
		// static method의 주 사용처: 초기화할 값이 많은 경우
		
		return m;
	}

}
