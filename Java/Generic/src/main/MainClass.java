package main;

public class MainClass {

	public static void main(String[] args) {
		
		double d;
		// 
		
		MyClass cls = new MyClass();
		// cls == local 변수 == object == 객체
		// 		stack		heap
		// stack 영역에 올라간 cls는 heap 영역의 new MyClass()의 주소값을 받아옴 (주소값은 4byte)
		
		// delete cls; 이걸 가비지 콜렉터가 자동으로 해줌. 안해주면 메모리 공간 부족해진다
		// 가급적이면 main에서는 동적할당을 하지 않는 게 좋다. 메인클래스가 끝날 때 까지 메모리가 유지되니까...
		System.out.println(cls);
		
		MyClass clscopy = cls;	// 값을 넣는 게 아니라 주소값을 집어넣음. 생성된 건 아님! 이렇게 주소값을 주고받을 수 있는 게 객체.
		System.out.println(clscopy);	// 같은 주소값 나옴. 그냥 cls와 같은 객체가 된거
		
		int num, num1;
		num = 1;
		num1 = num;	// 이건 그냥 값을 받은거임. 객체와의 차이
		
		Object obj = cls;
		System.out.println(obj);
		
	//	Object yobj = new YouClass();
	//	Object mobj = new MyClass();	// Object는 최상위클래스라 모든 클래스가 자식클래스임
		// but 인터페이스처럼 선언을 할 수는 없기때문에 저장용도로밖에 사용못함
		
		Object arrObj[] = new Object[2];
		Object arrObj1, arrObj2;	// 위랑 아래랑 같은 상태임. 그냥 변수만 두개 생성한거고 아직 객체가 아니다.
		
		arrObj[0] = new MyClass(234, "성춘향");
		arrObj[1] = new YouClass();	// Object 클래스는 여러 클래스를 하나로 묶을 수 있다.
		
		if (arrObj[0] instanceof MyClass) {
			MyClass mycls = (MyClass)arrObj[0];
			mycls.method();
		}
		
		
		Box<Integer> box = new Box<Integer>( 10 );	// 이렇게 함으로써 T가 적힌 부분은 모두 Integer 자료형이 됨
		System.out.println(box.getTemp() + 23);	// 할당한 값인 10 + 23 == 33이 출력
		
		Box<String> strbox = new Box<>("Hello");
		System.out.println(strbox.getTemp() + 23);	// Hello23이 출력
		
		BoxMap<Integer, String> bmap = new BoxMap<>(1001, "홍길동");	// 원래는 뒷부분에도 자료형 정의해줘야 하지만 생략가능
		System.out.println(bmap.getKey());
		System.out.println(bmap.getValue());
		
	}

}

class Box<T>{	// 이게 Generic
	
	T temp;

	public Box (T temp) {
	this.temp = temp;	// Generic 안에서 연산하는 건 불가능.
	}

	public T getTemp() {
		return temp;
	}

	public void setTemp(T temp) {
		this.temp = temp;
	}
}

class BoxMap<K,V>{	// Generic은 여러개 사용할 수 있다.
	
	K key;
	V value;
	
	public BoxMap(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
}	


class MyClass extends Object {	// 모든 클래스는 기본적으로 최상위클래스인 Ogject를 상속받음
	private int number;
	private String name;
	
	public MyClass() {
		
	}
	
	public void method() {
		System.out.println("number: " + number);
		System.out.println("name: " + name);
	}

	public MyClass(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}
}

class YouClass {
	
}
