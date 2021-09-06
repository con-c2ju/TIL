package cls;

public class ChildTwoClass extends ParentClass {

	public void overRideMethod() {	// 안의 처리는 ChildOneClass와 다르다고 가정
		System.out.println("ChildTwoClass overRideMethod()");
	}
	
	public void TwoFunc() {
		System.out.println("ChildTwoClass TwoFunc()");
	}
	
}
