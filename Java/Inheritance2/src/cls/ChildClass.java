package cls;

public class ChildClass extends ParentClass {

	public ChildClass() {
		System.out.println("ChildClass ChildClass()");
	}
	
	public void method() {	// Over Ride: ��ӹ��� �޼ҵ带 ���ļ� �����ϴ� ��
		System.out.println("ChildClass method()");
	}
	
	public void method(int i) {	// �� ���� Over Load. Over Ride�� ����Ϸ��� ����� ������ �����ؾ���
		System.out.println("ChildClass method()");
	}
	
	public void process() {
		super.method();	// �θ�Ŭ������ method �Լ�
		this.method();	// �ڽ�Ŭ������ method �Լ�. �� ��� �׳� method��� ��� ��.
	}
}
