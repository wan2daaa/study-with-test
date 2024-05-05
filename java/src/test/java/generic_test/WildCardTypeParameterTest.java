package generic_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

class CuteCat extends Cat {}


class WildCardTypeParameterTest {


	private static class Main {

		public static void addDog(List<? super Dog> list) {
			list.add(new Dog());
			System.out.println("Dog added");
		}

		public static void printAnimals(List<? extends Animal> list) {
			for (Animal animal : list) {
				System.out.println(animal.getClass().getSimpleName());
			}
		}
	}

	@Test
	void wildcardType() throws Exception {
		List<Animal> animalList = new ArrayList<>();
		Main.addDog(animalList); // List<Animal>에 Dog 추가
//		Main.addDog(new Cat());
//		Main.addDog(new CuteCat());

		List<Dog> dogList = new ArrayList<>();
		dogList.add(new Dog());
		List<Cat> catList = new ArrayList<>();
		catList.add(new Cat());
		catList.add(new CuteCat());
//		catList.add(new Dog());

		Main.printAnimals(dogList);
		Main.printAnimals(catList);

	}
}
