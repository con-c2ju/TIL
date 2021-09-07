package dto;

public class MyClass {
	private int num;
	private String name;
	private double height;
	
	public MyClass() {
		
	}

	public MyClass(int num, String name, double height) {
		super();
		this.num = num;
		this.name = name;
		this.height = height;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "MyClass [num=" + num + ", name=" + name + ", height=" + height + "]";
	}

}
