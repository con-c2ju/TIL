package main;

import cls.ChildClass;
import cls.ParantClass;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	inheritance : ���
		 	
		 	�θ� Ŭ���� -> �ڽ� Ŭ����
		 	variable(����)
		 	class(�Լ�)
		 	
		 */
		
		ParantClass pc = new ParantClass("ȫ�浿", 1001);
		
		pc.pMethod();
		
		ChildClass cc = new ChildClass();
		
		cc.pMethod();	// �θ�Ŭ������ �Լ��� ������ �� ����
	//	cc.number = 123;	protected ������ �ڽ�Ŭ������ �ƴ� �������� ���Ұ�
		cc.age = 24;	// public ������ �ڽ�Ŭ������ �ƴ� �������� ��밡��
		
		ChildClass cc1 = new ChildClass("��ö��", 1002, "�����", 25);
	
	}

}
