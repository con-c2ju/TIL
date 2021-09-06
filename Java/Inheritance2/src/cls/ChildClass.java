package cls;

public class ChildClass extends ParentClass {

	public ChildClass() {
		System.out.println("ChildClass ChildClass()");
	}
	
	public void method() {	// Over Ride: 상속받은 메소드를 고쳐서 기입하는 것
		System.out.println("ChildClass method()");
	}
	
	public void method(int i) {	// 이 경우는 Over Load. Over Ride를 사용하려면 사양이 완전히 동일해야함
		System.out.println("ChildClass method()");
	}
	
	public void process() {
		super.method();	// 부모클래스의 method 함수
		this.method();	// 자식클래스의 method 함수. 이 경우 그냥 method라고 적어도 됨.
	}
}
