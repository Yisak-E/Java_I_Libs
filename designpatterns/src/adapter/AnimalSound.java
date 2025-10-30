package adapter;

/**
 * Question: You have a Cat class with meow() method,
 * but your client code expects Animal interface with makeSound()
 * method. Write the adapter.
 */
public class AnimalSound {
    public static void main(String[] args) {
        System.out.println("Animal Sound Class");
        Cat cat = new Cat();
        SoundAdapter adapter = new SoundAdapter(cat);
        adapter.animalSound();
    }
}

class Cat{
    public void sayMeow(){
        System.out.println("Meow ... Meow .. meowwww");
    }
}

interface Animal{
    public void animalSound();
}

class SoundAdapter implements Animal{
    private Cat cat;
    public SoundAdapter(Cat cat) {
        this.cat = cat;
    }
    @Override
    public void animalSound() {
        this.cat.sayMeow();
    }
}

