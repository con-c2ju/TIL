package cls;

public class ParantClass {

	private String name;
	protected int number;	// �ڽ�Ŭ���������� ���� ���
	public int age;	// ��� ���� ����
	
	public void pMethod() {
		System.out.println("ParantClass pMethod()");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/*
	public ParantClass() {
		System.out.println("ParantClass ParantClass()");
	}
	*/
	
	public ParantClass(String name, int number) {
	//	this();	// this�� �ڱ������ε� ��ȣ ���� ����־ �⺻�����ڸ� �����ϰԵ�
		this.name = name;
		this.number = number;
	}

	public ParantClass(String name, int number, int age) {
		super();	
		this.name = name;
		this.number = number;
		this.age = age;
	}
	
	

}
