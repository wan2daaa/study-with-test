package stream_test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

/**
 * 병렬 처리가 항상 일반 스트림보다 빠르지 않다.
 *
 * ---
 * 1. 요소 수가 적고 요소당 처리 시간이 짧으면 일반 stream이 빠를 수 있다.
 *
 * 병렬 stream 은 fork join 과 쓰레드풀 생성 시간이 있기 때문
 *
 * ---
 * 2. 스트림 소스의 종류 에 따라 달라진다.
 * ArrayList 같은 배열은 인덱스로 요소를 관리해서 포크 단계에서 요소 쉽게 분리 가능
 * 하지만, HashSet, TreeSet, LinkedList 는 요소 분리가 어려워 상대적으로 병렬 처리 속도가 늦다
 *
 * ---
 * 3.코어의 수
 * CPU 코어가 많으면 많을 수록 속도가 증가
 *
 */
class StreamParallel {

	@Test
	void parallel() throws Exception {
		Random random = new Random();

		ArrayList<Integer> scores = new ArrayList<>();
		for (int i = 0; i < 100000000; i++) {
			scores.add(random.nextInt(101));
		}

		double avg = 0.0;
		long startTime = 0;
		long endTime = 0;
		long time = 0;

		Stream<Integer> stream = scores.stream();
		startTime = System.nanoTime();
		avg = stream
				.mapToInt(i -> i.intValue())
				.average()
				.getAsDouble();
		endTime = System.nanoTime();
		time = (endTime - startTime);
		System.out.printf("일반 스트림 처리 시간 : %d ns \n", time);


		Stream<Integer> parallelStream = scores.parallelStream();
		startTime = System.nanoTime();
		avg = parallelStream
				.mapToInt(i -> i.intValue())
				.average()
				.getAsDouble();
		endTime = System.nanoTime();
		time = (endTime - startTime);
		System.out.printf("병렬 스트림 처리 시간 : %d ns", time);

	}
}
