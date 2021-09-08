package single;

public class Singleton {

	private static Singleton si = null;	// 정적변수로 설정. null로 설정했기에 선언됐지만 아직 생성된 건 아님.
	public String sname;
	public int sage;
	
	
	private Singleton() {	// 생성자에 private -> 다른 클래스에 Singleton 클래스 객체를 생성할 수 없다.
		
	}
	
	public static Singleton getInstance() {
		if(si == null) {
			si = new Singleton();
		}
		return si;	// 처음 딱 한번만 새로운 주소값이 생성, 그 뒤엔 몇번을 호출해도 같은 인스턴스가 나올것.
	}
}
