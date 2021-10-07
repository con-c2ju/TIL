package main;

import mycls.MyClass;

public class MyClass_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Class 할당, 객체생성
		MyClass cls = new MyClass();
		// cls: object, instance
		// stack, heap, static, sys
		
		int i;	// local variable
		// cls와 달리 완전히 자유로움. 이 안에서 자유롭게 값을 받는 변수
		
		{
			int j;	// local variable
		}
		// local variable은 stack 공간에 올라가서 자신이 위치한 블록이 끝날때 사라진다
		// 객체인 cls 역시 local varisble과 같음
		// 그러나 new MyClass()는 heap 영역에 올라감. cls는 heap 영역의 주소값을 받아온 것
		// 클래스에서 호출된 부분 역시 실제 위치는 heap에 있음
		// 클래스 변수에서 heap 영역에 올라가는 대상을 주체(instance)라고 한다.
		
		cls.number = 1001;
		cls.name = "홍길동";
		cls.height = 175.1;
		
		cls.method();
		cls.func();
		
	}

}
