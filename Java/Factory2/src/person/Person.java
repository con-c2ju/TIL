package person;

import bomb.Bomb;
import types.AbstractItem;
import weapon.Weapon;

public class Person {
	
	public Weapon mWeapon;	// 멤버변수 (선언만 됨. 아직 생성안됨)
	public Bomb mBomb;
	
	public void create(AbstractItem item) {
		
		mWeapon = item.createWeapon();
		mBomb = item.createBomb();
		
	}

}
