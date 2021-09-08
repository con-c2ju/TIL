package cls;

import single.Singleton;

public class YouClass {
	
	private String name;
	private int age;

	@Override
	public String toString() {
		return "YouClass [name=" + name + "]";
	}
	
	/*
	public void setName(String name) {
		this.name = name;
	}
	*/
	
	public void func() {
		Singleton si = Singleton.getInstance();
		name = si.sname;
	}
	
	public void setSage(int age) {
		Singleton si = Singleton.getInstance();
		this.age = age;
		si.sage = this.age;
	}
}
