package main;

import cls.MyClass;

public class MainClass {

	public static void main(String[] args) {
		
		int array[] = { 1, 2, 3, 4 };	// 같은 자료형의 묶음
		
		/*
		 다른 자료형의 묶음 : 일단... 클래스라고 했었음
		 
		 C언어에서는 structure == 구조체
		 struct MYSTRUCT {
		 	int number;
		 	String name;
		 	double height;
		 };
		 
		 MYSTRUCT st = { 1, "문자열", 123.45 };
		 
		 MyClass cls = new MyClass();
		 MyClass mycls = { 2, "문자열", 123.45 };		불가능! C언의 구조체 에서는 되지만 클래스에서는 이렇게 할 수 없다
		 
		*/
		
		MyClass cls = new MyClass();	// 생성자를 호출하는 것은 MyClass() 부분
		MyClass cls1 = new MyClass('A');
		MyClass cls2 = new MyClass(1, "문자열", 123.45);
		
	//	cls2.MyClass();		불가능! 생성자는 생성할 때 딱 한번 호출됨
		
		MyClass cls3 = new MyClass(1);
		
	}

}

/*
class MyClass {
	int number;
 	String name;
 	double height;
}
*/