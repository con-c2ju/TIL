package main;

import java.util.ArrayList;
import java.util.List;

import dto.MyClass;

public class DtoClass {

	public static void main(String[] args) {
		List<MyClass> mlist = new ArrayList<MyClass>();
		// List는 인터페이스, ArrayList와 LinkedList는 클래스다.
		// List에서 선언해놓은 것을 ArrayList와 LinkedList에서 정의해서 사용하는것
		
		// List는 CRUD가 필수
		// 추가
		MyClass mycls = new MyClass(1, "성춘향", 165.1);
		mlist.add(mycls);
		
		mlist.add(new MyClass(2, "이몽룡", 172));
		
		mycls = new MyClass(3, "향단이", 168.5);	// mycls는 변수로만 활용한 셈
		mlist.add(mycls);
		
		mlist.add(2, new MyClass(4, "월매", 266.8));
		
		for(int i = 0 ; i < mlist.size() ; i++) {
			MyClass my = mlist.get(i);
			System.out.println(my.toString());
		}
				
		// 삭제
		mlist.remove(2);
		
		for(MyClass my : mlist) {
			System.out.println(my);
		}
		
		// 검색
		String name = "이몽룡";
		int _index = -1;
		for(int i = 0 ; i < mlist.size() ; i++) {
			MyClass my = mlist.get(i);
			if(name.equals(my.getName())) {
				_index = i;
				break;
			}
		}
		
		System.out.println(mlist.get(_index).toString());
		
		// 수정
		MyClass newObj = new MyClass();
		newObj.setNum(22);
		newObj.setName("LMR");
		newObj.setHeight(175.9);
		
		mlist.set(1, newObj);
		
		for (MyClass my : mlist) {
			System.out.println(my.toString());
		}
	}

}
