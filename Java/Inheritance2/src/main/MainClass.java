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
	//	pc.process();	ȣ�� �Ұ���!
		
		ChildClass c = (ChildClass)pc;
		c.process();	// ȣ�Ⱑ��

	}

}
