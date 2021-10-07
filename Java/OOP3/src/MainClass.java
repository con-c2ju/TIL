
import dto.MemberDto;

public class MainClass {

	public static void main(String[] args) {
		
		// 은닉성
		MemberDto mem = new MemberDto();
		
		// mem.number = 1;	private로 입력되어 외부에서 접근할 수 없다.
		mem.name = "홍길동";
		// mem.height = 180.1;	 protected는 해당 클래스와 관련된 클래스만 접근가능함
		
		mem.setNumber(0);
		mem.getNumber();	// 이것이 캡슐화. 변수들에 접근할 수 업도록 벽을 만들고 여기에 접근할 수 있는 방법을 만들어둔 것
		
		System.out.print(mem);	// heap 영역의 주소 출력
		System.out.print(mem.getThis()); 	// heap 영역의 주소값을 가진 자신을 참조함. 위의 것과 같은 결과
		
		MemberDto obj = new MemberDto();
		
		System.out.print(obj);	// 서로 다른 변수가 저장되는 위치가 다르듯이 서로 다른 개체도 heap 영역의 주소가 다르다.
		
		
	}

}
