package static_test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StaticTest {

	@Test
	void staticInitTest() throws Exception {
		assertThat(Static.name).isEqualTo("박재완");
	}

	private static class Static {

		static String firstName = "재완";
		static String lastName = "박";
		static String name;

		static {
			name = lastName + firstName;
		}

	}
}
