package string_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTokenizerTest {

	@DisplayName("split 은 구분자 빼고 데이터를 가져온다 ")
	@Test
	void splitMethod() throws Exception {
		String data = "박재완&정경주,wan2daaa-jkj01230";
		String[] splitDatas = data.split("&|,|-");

		assertThat(splitDatas).hasSize(4)
				.contains("박재완", "정경주", "wan2daaa","jkj01230");
	}

	@DisplayName("StringTokenizer 도 split 메소드와 비슷한 역할을 한다.")
	@Test
	void stringTokenizer() {
		String data = "박재완/정경주/wan2daaa/jkj01230";
		StringTokenizer st = new StringTokenizer(data, "/");

		assertThat(st.countTokens()).isEqualTo(4);
		assertThat(st.hasMoreTokens()).isTrue();
		assertThat(st.nextToken()).isEqualTo("박재완");
		assertThat(st.nextToken()).isEqualTo("정경주");
		assertThat(st.nextToken()).isEqualTo("wan2daaa");
		assertThat(st.nextToken()).isEqualTo("jkj01230");

		assertThatThrownBy(st::nextToken).isInstanceOf(NoSuchElementException.class);
		assertThat(st.hasMoreTokens()).isFalse();
	}
}
