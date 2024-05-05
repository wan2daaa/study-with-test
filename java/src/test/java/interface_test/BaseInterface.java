package interface_test;

// 인터페이스는 다중 상속 가능
public interface BaseInterface extends ParentInterface1, ParentInterface2 {

	// public static final int AGE = 27; 과 동일!
	int AGE = 27;

	// default 메소드를 인터페이스에 정의할 수있고, 이걸 override 도 가능
	default int getAge() {
		return AGE;
	}
}
