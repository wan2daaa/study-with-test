package instanceof_test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InstanceofTest {

	@Test
	void instanceOf() throws Exception {
		Main main = new Main();

		Parent child = new Child();

		Parent parent = new Parent();

		assertThat(main.instanceofChild(child)).isTrue();
		assertThat(main.instanceofChild(parent)).isFalse();
	}
}



class Main {

	public boolean instanceofChild(Parent parent) {
		/*
			if (parent instanceof Child) {
			return ((Child) parent).childMethod();
			}
		 */

//		System.out.println("parent.child = " + parent.childMethod());
		
		// parent 객체가 Child 타입이라면 -> true , 아니면 false (Parent 객체 일때)
		if (parent instanceof Child child) { // JAVA 12 부터 가능

			System.out.println("child.childMethod() = " + child.childMethod());

			return true;
		}

		return false;
	}
}


class Parent {
	public String getClassName() {
		return "Parent";
	}

	public String parentMethod() {
		return "Parent Method";
	}
}

class Child extends Parent {

	@Override
	public String getClassName() {
		return "Child";
	}

	public String childMethod() {
		return "Child Method";
	}
}
