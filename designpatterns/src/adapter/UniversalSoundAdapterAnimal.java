package adapter;

public class UniversalSoundAdapterAnimal {
    public static void main(String[] args) {
        System.out.println("=== Animal Sound Demo ===");

        // Original cat with adapter
        Cat2 cat = new Cat2("Ketie");
        SoundMakerToAnimalAdapter  catAdapter = new SoundMakerToAnimalAdapter (cat);

        // What if we have a Dog with different method?
        Dog dog = new Dog("Bobie");
        SoundMakerToAnimalAdapter  dogAdapter = new SoundMakerToAnimalAdapter (dog);

        // Client code works with ANY animal through adapter!
        makeAnimalSound(catAdapter);
        makeAnimalSound(dogAdapter);
    }

    // Client method only knows about Animal interface
    public static void makeAnimalSound(Animal animal) {
        animal.animalSound();
    }
}

interface SoundMaker{
    void makeSound();
}
class Cat2 implements SoundMaker{
    public Cat2(String name) {
        System.out.println("This is " + name);
    }
    public void sayMeow(){
        System.out.println("Meow");
    }

    @Override
    public void makeSound() {
        sayMeow();
    }
}

class Dog implements SoundMaker{
    public Dog(String name) {
        System.out.println("This is " + name);
    }
    public void bark() {  // Different method name!
        System.out.println("Woof! Woof!");
    }
    @Override
    public void makeSound() {
        bark();
    }
}


class SoundMakerToAnimalAdapter  implements Animal{
    private SoundMaker soundMaker;
    public SoundMakerToAnimalAdapter (SoundMaker soundMaker) {
        this.soundMaker = soundMaker;
    }
    @Override
    public void animalSound() {
        soundMaker.makeSound();
    }
}
