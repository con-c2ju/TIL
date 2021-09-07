package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MainClass {
	public static void main(String[] args) {
		/*
		 * 	HashMap : 사전
		 * 				apple -> 사과
		 * 				 key : value (like Generic의 BoxMap)
		 * 			(2진)트리구조 : 짜는데는 선형구조가 편함
		 * 						 but 기록한 자료를 찾는것은 어려움 (선형의 처음에서 시작하거나 끝에서 시작해야하므로)
		 * 						 2진트리 구조는 시작하고 절반씩 잘라서 자료를 찾기 때문에 탐색에 훨씬 유리
		 * 	TreeMap : HashMap + Sorting(key를 기준으로)
		 * 			  HashMap에 비해 속도는 떨어지지만 Sorting이 있어 검색이 빠름
		 * 
		 * 	※둘다 key 값이 중복되면 안됨! (value는 중복돼도 됨)
		 */
		
	//	HashMap<Integer, String> hMap = new HashMap<>();
		Map<Integer, String> hMap = new HashMap<>();	// 둘다 Map이라는 Interface로 연결되어 있어 List처럼 서로 호환됨.
		
		// 추가 <- 선형구조가 아닌 트리구조라서 원하는 위치에 추가하는 기능이 없음. HashMap이 트리구조에 알아서 배치함
		hMap.put(1, "하나");	
		hMap.put(new Integer(2), new String("둘"));	// Integer나 String 모두 wrapper class라 정석은 동적할당임
		hMap.put(3, "셋");
		
		// 값을 산출 : key 값을 넣으면 -> value가 산출
		String value = hMap.get( 2 );	// .get을 쓰는건 List와 같지만, 안에 넣는 건 index가 아니라 key값이다.
		System.out.println(value);	// 트리 안에서 key값을 찾고 그에 해당하는 value를 출력함. key만 알면 value를 바로 찾을 수 있음
				
		// 삭제
		String del = hMap.remove( 2 );	// remove에 커서를 올리면 String이라고 뜨는데, 우리가 value를 String으로 설정했기 때문.
		System.out.println(del);	// 삭제되면서 value값을 출력하고 사라진다.
		
		// 검색
		// key값이 있다/없다 -> 검색하려면 먼저 해야함
		boolean b = hMap.containsKey( 3 );
		if(b) {
			String val = hMap.get(3);
			System.out.println(val);
		}
		
		// 수정
		hMap.replace(3, "쓰리");
		System.out.println(hMap.get(3));
		
		// 추가
		hMap.put(3, "삼");	// 위에꺼랑 다름 수정한 게 아니라 새로 추가한거임
		System.out.println(hMap.get(3));	// 출력하면 삼으로 나옴. 이미 존재하는 key값으로 추가하면 그 key값의 value가 수정돼버림
		
		hMap.put(4, "사");
		hMap.put(5, "오");
		
		// map에 들어있는 모든 값을 출력 -> Iterator 사용!
		Iterator<Integer> it = hMap.keySet().iterator();
		
		while(it.hasNext()) {
			
			Integer key = it.next();
			System.out.print("key: " + key + " ");
			
			String v = hMap.get(key);
			System.out.println("value: " + v);
		}	// 순차적으로 출력하는 것 같지만 실제로 순서대로 출력하는 건 아님!(트리구조는 순서가 아니다)
		
		
		// 좋아하는 과일 5개
		// apple : 사과
		
		Map<String, String> map = new HashMap<>();
		
		map.put("apple", "사과");
		map.put("orange", "오렌지");
		map.put("watermelon", "수박");
		map.put("grape", "포도");
		map.put("mango", "망고");
		
		// 출력
		Iterator<String> iter = map.keySet().iterator();
		
		while(iter.hasNext()) {
			String k = iter.next();
			System.out.print("영어: " + k + " / ");
			
			String v = map.get(k);
			System.out.println("한글: " + v);
		}	// 출력하다보면 순서가 중구난방이란걸 알 수 있음. Sorting이 안된다! -> TreeMap 이용
		
		
		// TreeMap -> HashMap처럼 동적할당 받는 건 자주 안함. 좀 무거운 편이라...
		TreeMap<String, String> tMap = new TreeMap<>( map );
		
		// 오름차순
	//	Iterator<String> itkey = tMap.keySet().iterator();	// TreeMap의 keyset은 HashMap과 약간 다름
		
		// 내림차순
		Iterator<String> itkey = tMap.descendingKeySet().iterator();
		
		while(itkey.hasNext()) {
			String k = itkey.next();
			String v = tMap.get(k);
			
			System.out.println("영어: " + k + " / 한글: " + v);
		}
		
	}

}
