package mycls;

public class MyClass {	//template
	
	// 변수(멤버)
	public int number;	// public 선언을 하면 다른 클래스에서도 변수가 보임
	public String name;
	public double height;
	
	// 메소드(멤버)
	public void method() {
		System.out.println("MuClass method()");
	}
	
	public void func() {
		System.out.println("MyClass func()");
	}
	// 나중에 메소드 수정할 일이 생겨서도 여기서 메소드만 수정하면 다른 부분은 영향X
	// 절차지향인 경우 하나를 수정하면 다른 부분이 영향받을 수 있음
	
}
