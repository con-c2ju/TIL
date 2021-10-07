package dto;

public class MemberDto {
	
	private int number;
	public String name;
	protected double hright;
	
	// 멤버변수의 90%는 private. 엄밀히 말하면 OOP 은닉성 규칙 위반임 (에러는 아니지만)
	// 멤버함수(메소드)는 90%가 public. 외부에서 부를 수 있어야 하니까
	
	// getter => 외부에서 private 변수에 접근할 수있도록 하는 함수(메소드). (외부에서)값을 취득
	public int getNumber() {
		return number;
	}
	
	// setter => (외부에서)값을 변경. getter만 있으면 값을 읽는것만 가능
	public void setNumber(int num) {
		number = num;	// 외부에서 매개변수를 타고와서 private 변수인 name에 넣어줌
	}
	
	// this : 자기 참조 == heap의 주소
	public MemberDto getThis() {
		return this;	// this는 예약어. 변수명으로 쓸 수 없음
	}
	public void func(int number) {
		this.number = number;	// this 사용함으로써 같은 이름의 멤버변수와 매개변수를 구분할 수 있음
	}
}
