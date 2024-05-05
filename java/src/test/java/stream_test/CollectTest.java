package stream_test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectTest {

	@Test
	void collect() throws Exception {

		ArrayList<Person> people = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			people.add(new Person(i, "name" + i));
		}

		List<Person> collectList = people.stream()
				.filter(s -> s.age >= 5)
//				.collect(Collectors.toList()); //.toList() 로 대체 가능
				.toList(); //JAVA 16

		assertThat(collectList).hasSize(5);

		Map<String, Integer> collectMap = people.stream()
				.collect(
						Collectors.toMap(
								p -> p.name, //key
								p -> p.age   //value
						)
				);

		assertThat(collectMap).hasSize(10);
	}

	@Test
	void grouping() throws Exception {
		ArrayList<Person> people = new ArrayList<>();

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 5; i++) {
				people.add(new Person( j , "name" + i));
			}
		}

		Map<Integer, List<Person>> collectedMap = people.stream()
				.collect(
						Collectors.groupingBy(s -> s.age)
				);

		for (Integer i : collectedMap.keySet()) {
			System.out.println(i + " : " + collectedMap.get(i));
		}

	}

	static class Person {
		int age;
		String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person{" +
					"age=" + age +
					", name='" + name + '\'' +
					'}';
		}
	}
}
