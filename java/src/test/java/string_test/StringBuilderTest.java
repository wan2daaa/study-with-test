package string_test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * String 은 내부 문자열을 수정할 수없고, 새로운 String 객체를 생성하는 형식
 * 잦은 문자열 변경 작업을 해야할 때 StringBuilder 사용하는게 효과적
 *
 * StringBuilder 는 내부 버퍼에 문자열을 저장해두고 그안에서 추가, 수정, 삭제 작업을 함
 */
public class StringBuilderTest {

	@Test
	void stringBuilderBasic() throws Exception {
		String data = new StringBuilder("DEF")
				.append("GHI")
				.insert(0, "ABC")
				.delete(3, 4)
				.toString();

		Assertions.assertThat(data).isEqualTo("ABCEFGHI");
	}
}
