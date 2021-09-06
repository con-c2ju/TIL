package cls;

public class MyClass extends AbstractClass {	// 추상클래스를 정의해주지 않으면 에러남

	@Override	// namespace : 지시어, 제시어
	public void abstractMethod() {
		System.out.println("MyClass AbstractMethod()");
	}	// 상속받은 클래스에서 추상메소드를 정의해줘야 사용가능
	
	

}
