package main;

import cls.ChildClass;
import cls.ParentClass;

public class MainClass {

	public static void main(String[] args) {
		
		ChildClass cc = new ChildClass();
		cc.method();
		cc.process();
		
		ParentClass pc = new ChildClass();
		pc.method();
	//	pc.process();	호출 불가능!
		
		ChildClass c = (ChildClass)pc;
		c.process();	// 호출가능

	}

}
