package main;

import cls.HeClass;
import cls.MyClass;
import cls.YouClass;
import single.Singleton;

public class MainClass {

	public static void main(String[] args) {
		/*
		 * 	  [UML]
		 * 	클래스 명				MyClass					YouClass
		 * 	----------			-----------------		-----------------
		 * 	멤버 변수				-name:String			-name:String
		 * 	-: private			-age:int				-year:int
		 * 	+: public			-----------------		-----------------
		 * 	----------			method(char, int)		method(char, int)
		 * 	멤버 메소드				=> UML을 사용해 클래스의 내용을 간단하게 확인할 수 있음
		 * 						* 만약 MyClass의 name을 YouClass로 넘겨받고 싶다면?
		 * 							- MyClass에서는 getName()을 설정, YouClass에는 setName(String)을 설정
		 * 							- setName(String)에서 getName()을 매개변수로 받음
		 * 							===> 엄청 복잡하다. 이걸 해결하기 위해 나온 게 싱글턴(Singleton)
		 * 	[Singleton Pattern]
		 * 		: instance 1개만 만들어놓고 데이터를 접근하기 위한 패턴
		 * 		  class 간의 대화가 목적
		 * 		  어떤 클래스에서도 접근이 가능
		 * 
		 * 		Singleton 내부에 인스턴스를 만들어 놓고, 여기에 데이터를 저장하고 받아오는 식.
		 * 		getter와 setter를 만들지 않고 값을 주고받을 수 있다.
		 * 		클래스 끼리 대화할 때 끼고가는 중간지대 느낌. -> 모든 클래스가 접근 가능해야한다.
		 * 		싱글턴은 반드시 하나만 존재해야함!! 싱글턴의 인스턴스 하나를 통해 각 클래스가 자료를 주고받는 것. (싱글턴이 여러개면 값이 겹친다)
		 * 			ex. 만약 DAO에 자료를 입출력하는 메소드가 여러개라면 문제가 발생할 것.
		 */
		
		MyClass mycls = new MyClass("홍길동");
		YouClass youcls = new YouClass();
		
		mycls.method();
		youcls.func();
		System.out.println(youcls.toString());	// Singleton을 통해 외부에 노출되지 않고 클래스가 데이터를 주고받음
		
		/*
		String name = mycls.getName();
		
		youcls.setName(name);	// 바로 mycls.getName() 넣어도 됨
		
		System.out.println(youcls.toString());
		
		// 이 방법의 문제점1: 노출이 많다. 두 클래스가 대화하는게 너무 많이 노출되고 있음
		// 이 방법의 문제점2: 클래스의 개수가 많아지면 점점 더 복잡해질 것
		 */
		
		/*
		Singleton si = Singleton.getInstance();
		System.out.println(si);	// heap 영역이 아닌 static 영역의 주소임
		System.out.println(Singleton.getInstance());	// 이젠 새로운 주소값이 생성되지 않음. Singleton의 si가 null이 아니므로
		*/
		HeClass hecls = new HeClass(); 
		youcls.setSage(13);
		hecls.getSage();
		System.out.println(hecls.toString());
		
		
	}

}
