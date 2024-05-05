package wane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * resource 란 데이터를 제공하는 객체를 말한다.
 * 리소스를 사용하기 위해 연다음, 닫아야 한다.
 *
 * finally 에 close() 메소드로 정리해도 되지만,
 *
 * try-with-resources 를 이용해서 예외 발생 여부와 상관없이 리소스를 자동으로 닫아줌!
 *
 * try-with-resources 를 사용하려면 Autoclosable 을 impl 받아 close() 메서드 작성 필요
 * 참고로 FileInputStream은 AutoClosable 을 구현하고 있다.
 */
public class ResourceHandling {


	class FileHandling implements AutoCloseable {
		public void handleFile() throws IOException {
			FileInputStream fis = null;

			try {
				fis = new FileInputStream("file.txt");
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			} finally {
				fis.close();

			}
		}

		public void handleFileWithResources() {
			try (FileInputStream fis = new FileInputStream("file.txt")) {
		} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public void close() throws Exception {

		}
	}

}