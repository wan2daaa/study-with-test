package char_test;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CharTest {

	@Test
	void charChange() throws Exception {

		char c1 = 'A';
		char c2 = 65; //유니코드

		char c3 = '가';
		char c4 = 44032; //유니코드

//		char emptyChar = ''; //빈문자 불가
		char gapChar = ' ';


		assertThat(c1).isEqualTo(c2);
		assertThat(c2).isEqualTo('A');

		assertThat(c3).isEqualTo(c4);
		assertThat(c4).isEqualTo('가');

		assertThat(gapChar).isEqualTo((char) 32);
	}
}
