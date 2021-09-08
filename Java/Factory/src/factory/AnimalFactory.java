package factory;

import animal.Animal;
import animal.Cat;
import animal.Cow;
import animal.Dog;

public class AnimalFactory {

	public static Animal create(String animalName) {
		
		if(animalName.equals("야옹이")) {
			return new Cat();
		}
		else if(animalName.equals("멍멍이")) {
			return new Dog();
		}
		else if(animalName.equals("황소")) {
			return new Cow();
		}
		else {
			return null;
		}
		
	}
	
}
