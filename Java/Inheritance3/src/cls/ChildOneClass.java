package cls;

public class ChildOneClass extends ParentClass {

	public void overRideMethod() {	// 안의 처리는 ChildTwoClass와 다르다고 가정
		System.out.println("ChildOneClass overRideMethod()");
	}
	
	public void OneMethod() {
		System.out.println("ChildOneClass OneMethod()");
	}
	
}
