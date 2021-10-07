package main;

public class MainClass {

	public static void main(String[] args) {
		
		// 절차지향의 예시: TV 프로그래밍
		int ch;			// 채널
		boolean onoff;	// 전원 온오프
		String place;	// 장소
		String maker;
		
		ch = 11;
		onoff = true;
		place = "room1";
		maker = "LG";
		
		// 만약 TV가 하나가 아니라 여러개라면 어떻게 해야할까? 절차지향이면 매우 번거로워짐
		int ch1;		// 채널
		boolean onoff1;	// 전원 온오프
		String place1;	// 장소
		String maker1;
		
		ch1 = 11;
		onoff1 = true;
		place1 = "room2";
		maker = "SamSung";
		
		// ---→ 하나의 묶음으로 만들자. 따로따로 있는 변수들을 하나의 묶음으로 취급하는 것
		Television room1tv = new Television();	// 클래스의 변수 생성. + 동적할당 필수!
		room1tv.ch = 9;
		room1tv.onoff = true;
		room1tv.place = "방1";
		room1tv.maker = "LG";
		
		Television room2tv = new Television();
		room2tv.ch = 5;
		room2tv.onoff = false;
		room2tv.place = "방2";
		room2tv.maker = "SamSung";
		
		// 배열 vs 클래스
		int arrCh[] = new int[3];			// 채널
		boolean arOnoff[] = new boolean[3];	// 전원 온오프
		String arrPlace[] = new String[3];	// 장소
		
		Television arrTv[] = new Television[3];
		//같은 내용을 더 간단하게 입력할 수 있음
	
	}

}
