package main;

import cls.AbstractClass;
import cls.MyClass;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	Abstract Class : 추상 클래스
		 					 추상 메소드를 하나 이상 포함하고 있는 클래스
		 					 -> 내용은 없고 선언만 되어 있는 메소드
		 	
		 	public void method (int n) { <- prototype (사양)
		 		처리
		 	}
		 	
		 	public abstract void method(int n); 	// 처리가 없음. 이런 기능이 필요하겠다~ 는 선언만 해놓는 것
		 	
		 */
		
		
		AbstractClass acls = new AbstractClass() {	// 생성 불가능. 다른클래스에서 상속받고 오버라이드해야 사용가능
			
			@Override
			public void abstractMethod() {
				System.out.println("AbstracrClass method()");
			}
			
		};
		
		
		MyClass cls = new MyClass();
		cls.method();
		cls.abstractMethod();

	}

}
