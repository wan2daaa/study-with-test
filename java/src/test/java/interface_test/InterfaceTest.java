package interface_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InterfaceTest {

	@DisplayName("인터페이스에 변수를 선언하면, 상수로 처리된다.")
	@Test
	void interfaceConstant() throws Exception {
		BaseInterface interfaces = new Class();
		assertThat(interfaces.AGE).isEqualTo(27);
//		interfaces.AGE = 12;
	}

	@DisplayName("인터페이스는 default 메소드를 가질 수 있다.")
	@Test
	void interfaceDefault() throws Exception {
		BaseInterface interfaces = new Class();
		assertThat(interfaces.getAge()).isEqualTo(27);
	}
}
