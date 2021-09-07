package main;

import java.util.ArrayList;
import java.util.Iterator;

public class MainClass {

	public static void main(String[] args) {
		/*
		 * 	Collection(수집)
		 * 
		 * 	List:	목록
		 * 			- ArrayList
		 * 				배열처럼 사용할 수 있는 목록
		 * 				선형구조				O-O-O-O-O-O
		 * 				검색속도가 빠르다			- 관리부문에서 중요
		 * 
		 * 			- LinkedList
		 * 				추가/삭제 속도가 빠르다	- 게임에서 중요
		 * 
		 * 	Map:
		 * 			- HashMap
		 * 			- TreeMap
		 */
		
		ArrayList<Integer> list = new ArrayList<>();
		
		//CRUD
			// 추가
		Integer iobj = new Integer(111);
		
		list.add(iobj);
		list.add(222);
		list.add(new Integer(333));
		
		int len = list.size();
		System.out.println("len: " + len);
		
		//list 내용 확인하기 (for, foreach)
		for(int i = 0 ; i < list.size() ; i++) {
			Integer in = list.get(i);	// 배열 list[1] == 리스트 list.get(1)
			System.out.println(in);
		}
		
		for(Integer in : list) {
			System.out.println(in);
		}
		
			// '원하는 곳에' 추가
		Integer inum = 200;
		list.add(1, inum);	// 1번지에 새로운 데이터를 넣음. 원래 있던 데이터는 삭제되는 게 아니라 뒤로 밀려남 <- 배열과의 차이
		
		for(Integer in : list) {
			System.out.println(in);
		}
		
			// 검색 - 방법1
		int index = list.indexOf( 222 );	// 해당 값의 인덱스 번호를 받음
		System.out.println("index: " + index);
		
			// 검색 - 방법2
		for(int i = 0 ; i < list.size() ; i++) {
			Integer in = list.get(i);
			if(in == 200) {
				System.out.println("index: " + i);
			}
		}
			
			// 수정 (추가랑 다름!)
		Integer newdata = new Integer(300);
		list.set(3, newdata);
		
		for(Integer in : list) {
			System.out.println(in);
		}
		
			// 삭제
		list.remove(1);
		
		for(Integer in : list) {
			System.out.println(in);
		}
		
		
		// ArrayList<String>
		// 추가(끝, 중간), 삭제, 검색, 수정
		ArrayList<String> strlist = new ArrayList<>();
		strlist.add("사과");
		strlist.add("오렌지");
		strlist.add("자몽");
		
			// 추가 - 끝
		String str = "바나나";
		strlist.add(str);
		
			// 추가 - 중간
		String str1 = "포도";
		strlist.add(1, str1);
		
			// 삭제
		strlist.remove(3);
		
			// 검색
		int search = strlist.indexOf("오렌지");
		System.out.println(search);
			
			// 수정
		strlist.set(0, "홍도");
		
		for(String in : strlist) {
			System.out.println(in);
		}
		
	}

}
