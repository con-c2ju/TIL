package main;

import java.util.Calendar;

public class MainCalss {

	public static void main(String[] args) {
		/*
		 	멤버 메소드 : class에 소속되어 있는 함수.
		 			   instance 메소드 (instance를 경유해서 호출할 수 있기 때문에)
		 */
		
		MyClass cls = new MyClass();
		cls.memberMethod();
		cls.staticMethod(); // 호출은 되는데 경고가 띄워짐. '이렇게 호출하는거 아니다.'
		MyClass.staticMethod(); // static 메소드는 인스턴스를 통해서가 아니라 클래스를 통해 호출
		
		MyClass mycls = MyClass.getInstance();	// static 메소드 하나로 많은 값을 한번에 초기화 할 수 있음
		
		Calendar cal = Calendar.getInstance();	// Calendar에서도 static 메소드로 값을 초기화함
	}
	
	static void method() {
		System.out.println("method()");
	}
	
	
}
