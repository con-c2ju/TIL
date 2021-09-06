package main;

import cls.ChildClass;
import cls.ParantClass;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	inheritance : 상속
		 	
		 	부모 클래스 -> 자식 클래스
		 	variable(변수)
		 	class(함수)
		 	
		 */
		
		ParantClass pc = new ParantClass("홍길동", 1001);
		
		pc.pMethod();
		
		ChildClass cc = new ChildClass();
		
		cc.pMethod();	// 부모클래스의 함수에 접근할 수 있음
	//	cc.number = 123;	protected 변수라 자식클래스가 아닌 곳에서는 사용불가
		cc.age = 24;	// public 변수는 자식클래스가 아닌 곳에서도 사용가능
		
		ChildClass cc1 = new ChildClass("김철수", 1002, "서울시", 25);
	
	}

}
