package main;

import person.Person;
import types.Atype;

public class MainClass {

	public static void main(String[] args) {
		
		Person char1 = new Person();
		char1.create(new Atype());	// 이 타입을 바꾸면 weapon과 bomb의 종류도 달라진다.
		// 게임에서 직업별 사용가능 무기 등을 설정할 때 이용할 수 있을 것.
		
		char1.mWeapon.drawWeapon();
		char1.mBomb.drawBomb();
		
		// person만 리스트에 넣으며 각 캐릭터에 맞게 캐릭터를 계속 생성할 수 있음!

	}

}
