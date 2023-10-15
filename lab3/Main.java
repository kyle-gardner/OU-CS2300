public class Main {
	public static void main(String[] args) {
		Animal myAnimal = new Animal();
		myAnimal.isMammal();
		myAnimal.mate();
		System.out.println("");

		Fish myFish = new Fish();
		myFish.isMammal();
		myFish.mate();
		System.out.println("");

		Zebra myZebra = new Zebra();
		myZebra.isMammal();
		myZebra.run();	
	}
}

// a lot of the types arent in the instructions so im assuming we're
// to just pick whatever we want. sorry if not.
class Animal {
	public int age;
	public String gender;

	public void isMammal() {
		System.out.println("perhaps...");	
	}
	public void mate() {
		System.out.println("mating...");	
	}
}

class Fish extends Animal {
	private int sizeInFeet;	

	private boolean canEat() {
		return true;
	}	

}

class Zebra extends Animal {
	public boolean is_wild;

	public void run() {
		System.out.println("zebra is running");
	}
}