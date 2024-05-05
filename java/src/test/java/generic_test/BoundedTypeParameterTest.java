package generic_test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoundedTypeParameterTest {


	@Test
	void test() throws Exception {

		NumberTestClass numberTestClass = new NumberTestClass();

		assertThat(numberTestClass.compare(1, 2)).isFalse();
		assertThat(numberTestClass.compare(1, 1)).isTrue();
	}

	private static class NumberTestClass {

		public <T extends Number> boolean compare(T t1, T t2) {
			double v1 = t1.doubleValue();
			double v2 = t2.doubleValue();
			return v1 == v2;
		}
	}
}
