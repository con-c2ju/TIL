package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MainClass {

	public static void main(String[] args) {
		/*
		 * 	ArrayList : 검색속도가 빠름
		 * 
		 * 	LinkedList : 실시간 추가, 삭제 처리가 빠름
		 * 
		 */
		
		ArrayList<String> alist = new ArrayList<String>();
		
		alist.add("tigers");
		
		String str = new String("lions");
		alist.add(str);
		
		alist.add("giants");
		
		LinkedList<String> list = new LinkedList<>(alist);	// 이게 된다
		
		for (String s : list) {
			System.out.println(s);
		}	// alist의 내용이 출력되는걸 알 수 있음. 둘은 호환이 된다.
		
		list.add("twins");
		
		// LinkedList에만 있는 기능1: 맨 앞에 object 추가하기
		list.addFirst("bears");
		
		for(String s : list) {
			System.out.println(s);
		}	// bears가 맨 앞으로 오고 나머지가 뒤로 밀려남
		
		// LinkedList에만 있는 기능2: 맨 뒤에 object 추가하기 -> ArrayList의 add와 같음
		list.addLast("eagles");
		
		for(String s : list) {
			System.out.println(s);
		}	// eagles가 맨 뒤에 출력
		
		// iterator : 반복자 == pointer(주소)
		// 주소값을 갖고 이동해서 값이 있으면 꺼내주고 다시 이동시켜주고, 다음값이 있는지 확인하면 또 꺼내주는 구문
		Iterator<String> it;
		it = list.iterator();
		
		while(it.hasNext()) {	// 다음 값이 없을때까지 반복
			String value = it.next();
			System.out.println(value);
		}	// Iterator를 사용하여 출력하는 방법도 있다.
		
	}

}
