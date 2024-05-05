package stream_test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class StreamRangeTest {

	@Test
	void range() throws Exception {
		AtomicInteger sum = new AtomicInteger();

		IntStream.range(0, 10) // 0 <= x < 10
				.forEach(sum::addAndGet);

		Assertions.assertThat(sum.get()).isEqualTo(45);
	}

	@Test
	void rangeClosed() throws Exception {
		AtomicInteger sum = new AtomicInteger();

		IntStream.rangeClosed(0, 10) // 0 <= x <= 10
				.forEach(sum::addAndGet);

		Assertions.assertThat(sum.get()).isEqualTo(55);
	}
}
