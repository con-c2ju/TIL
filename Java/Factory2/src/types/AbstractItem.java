package types;

import bomb.Bomb;
import weapon.Weapon;

public interface AbstractItem {
	
	public Weapon createWeapon();
	public Bomb createBomb();

}
