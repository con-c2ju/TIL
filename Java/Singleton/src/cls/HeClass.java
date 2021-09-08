package cls;

import single.Singleton;

public class HeClass {
	
	private int age;
	
	public void getSage() {
		Singleton si = Singleton.getInstance();
		this.age = si.sage;
	}

	@Override
	public String toString() {
		return "HeClass [age=" + age + "]";
	}

}
