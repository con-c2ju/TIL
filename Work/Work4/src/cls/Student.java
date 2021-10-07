package cls;

public class Student {
	
	public String name;
	public int ban, no, kor, eng, math, result;
	
	public int getTotal(int num1, int num2, int num3) {
		result = num1 + num2 + num3;
		return result;
	}
	
	public int getAverage() {
		result = result / 3;
		return result;
	}
	
	

}
