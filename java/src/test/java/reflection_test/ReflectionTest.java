package reflection_test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 자바는 클래스와 인터페이스의 메타 정보를 Class 객체로 관리
 * 메타 정보란, 패키지 정보, 멤버(생성자, 필드, 메소드) 정보를 의미
 *
 * 이런 메타정보를 프로그램에서 읽고 수정하는 행위를 리플렉션이라고 함
 */
public class ReflectionTest {

	@Test
	void stringReflection() throws Exception {
		Class<String> stringClass1 = String.class;
		Class<?> stringClass2 = Class.forName("java.lang.String");

		String str = "String";
		Class<? extends String> stringClass3 = str.getClass();

		assertThat(stringClass1).isEqualTo(stringClass2);
		assertThat(stringClass2).isEqualTo(stringClass3);
		assertThat(stringClass1).isEqualTo(stringClass3);

		// 패키지와 타입 정보
		assertThat(stringClass1.getPackage().getName()).isEqualTo("java.lang");
		assertThat(stringClass1.getSimpleName()).isEqualTo("String");
		assertThat(stringClass1.getName()).isEqualTo("java.lang.String");

		// 멤버 정보
		assertThat(stringClass1.getDeclaredConstructors()).isNotEmpty();
		assertThat(stringClass1.getDeclaredMethods()).isNotEmpty();
		assertThat(stringClass1.getDeclaredFields()).isNotEmpty();
	}
}
