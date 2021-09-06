package cls;

public class ChildClass extends ParantClass {
	
	private String address;
	
	public ChildClass() {	// �ڽ�Ŭ���� ������ ȣ��� �θ�Ŭ���� �����ں��� ȣ���
		super("������", 16);	// this: �ڱ�����, super: �θ�����
		System.out.print("ChildClass ChildClass()");
	}
	
	public ChildClass(String name, int number, String address, int age) {
		super(name, number, age);	// �ڽ�Ŭ������ ���� �θ�Ŭ������ ������ ���� �� ���� �ִ�.
		this.address = address;	// super�� this�� �Բ� �� �� �ִµ�, �ݵ�� super�� ���� ���� �־�� �Ѵ�.
	}

	public void func() {
		System.out.println("ChildClass func()");
		
	//	name = "������"; �θ�Ŭ������ private �������� ���� �Ұ�
		setName("������");	// �θ�Ŭ������ �Լ��� ���������� ���� ����
		number = 34;	// protected ������ �ڽ�Ŭ�������� ���� ����
		age = 24;	// public ������ Ŭ���� ������� ���� ����
		
		super.number = 12;
		super.pMethod();	// �̷������ε� ��밡��
	}

}
