package cls;

public abstract class AbstractClass {	// 클래스 앞에도 abstract 선언을 해줘야함. 컴파일러가 알아봐야 해서
	
	private int number;	// 멤버 변수
	
	public void method() {	// 일반 멤버 메소드
		System.out.println("AbstracrClass method()");
	}
	
	public abstract void abstractMethod();	// 클래스 앞에 abstract 선언을 하지 않으면 에러남

}
