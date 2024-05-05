package stream_vs_for;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

class StreamForTimeTest {

	@Test
	void intStream_vs_for() throws Exception {
		int MAX = Integer.MAX_VALUE;

		AtomicLong sum = new AtomicLong();
		long start = System.currentTimeMillis();
		for (int i = 0; i < MAX; i++) {
			sum.addAndGet(i);
		}
		long end = System.currentTimeMillis();

		System.out.println("[for] Time = " + (end - start));

		long forTime = end - start;

		sum.set(0);
		start = System.currentTimeMillis();
		IntStream.range(0, MAX).forEach(sum::addAndGet);
		end = System.currentTimeMillis();

		System.out.println("[stream] Time = " + (end - start));

		long streamTime = end - start;

		if (forTime > streamTime) {
			System.out.println("stream이 for 보다 더 빠르다.");
		} else {
			System.out.println("for이 stream 보다 더 빠르다.");
		}
	}

	@Test
	void stream_vs_parallel_for() throws Exception {
		int[] array = new int[210000000];
		Arrays.fill(array, 6666); // 배열의 요소를 모두 1로 채움

		// Stream을 이용한 방식
		long startTimeStream = System.nanoTime();
		int sumStream = Arrays.stream(array)
				.sum();
		long endTimeStream = System.nanoTime();
		long durationStream = (endTimeStream - startTimeStream);

		// Parallel Stream을 이용한 방식
		long startTimeParallelStream = System.nanoTime();
		int sumParallelStream = Arrays.stream(array)
				.parallel()
				.sum();
		long endTimeParallelStream = System.nanoTime();
		long durationParallelStream = (endTimeParallelStream - startTimeParallelStream);

		// for문을 이용한 방식
		long startTimeForLoop = System.nanoTime();
		int sumForLoop = 0;
		for (int i = 0; i < array.length; i++) {
			sumForLoop += array[i];
		}
		long endTimeForLoop = System.nanoTime();
		long durationForLoop = (endTimeForLoop - startTimeForLoop);

		// 결과 출력
		System.out.println("Stream을 이용한 방식의 실행 시간: " + durationStream /1000.0 + " ms");
		System.out.println("Parallel Stream을 이용한 방식의 실행 시간: " + durationParallelStream /1000.0 + " ms");
		System.out.println("for문을 이용한 방식의 실행 시간: " + durationForLoop / 1000.0 + " ms");
	}
}
