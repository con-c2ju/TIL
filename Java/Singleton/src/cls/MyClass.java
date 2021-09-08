package cls;

import single.Singleton;

public class MyClass {
	
	private String name;

	public MyClass(String name) {
		this.name = name;
	}
	
	/*
	public String getName() {
		return name;
	}
	*/
	
	public void method() {
		Singleton si = Singleton.getInstance();
		si.sname = name;
	}

}
