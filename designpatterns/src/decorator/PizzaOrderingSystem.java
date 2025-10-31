package decorator;

public class PizzaOrderingSystem {
    public static void main(String[] args) {
        Pizza myPizza = new OliveDecorator(new CheeseDecorator(new BasicPizza()));
        System.out.println("Pizza ordering");
        System.out.println(myPizza.getDescription());
        System.out.println(myPizza.getPrice());
    }
}

interface Pizza{
    String getDescription();
    double getPrice();
}

class BasicPizza implements Pizza{
    @Override
    public String getDescription() {
        return "Basic Pizza";
    }
    @Override
    public double getPrice() {
        return 1.5;
    }
}

class CheeseDecorator implements Pizza{
    private Pizza pizza;
    public CheeseDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public String getDescription() {
        return "Cheese, "+ pizza.getDescription();
    }
    @Override
    public double getPrice() {
        return pizza.getPrice() + 1.5;
    }
}

class PepperDecorator implements Pizza{
    private Pizza pizza;
    public PepperDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public String getDescription() {
        return "Pepper, "+ pizza.getDescription();
    }
    @Override
    public double getPrice() {
        return pizza.getPrice() + 2.0;
    }
}

class MushroomDecorator implements Pizza{
    private Pizza pizza;
    public MushroomDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return "Mushroom, "+ pizza.getDescription();
    }
    @Override
    public double getPrice() {
        return pizza.getPrice() + 1.25;
    }
}

class OliveDecorator implements Pizza{
    private Pizza pizza;
    public OliveDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public String getDescription() {
        return "Olive, "+ pizza.getDescription();
    }
    @Override
    public double getPrice() {
        return pizza.getPrice() + 0.75;
    }
}
