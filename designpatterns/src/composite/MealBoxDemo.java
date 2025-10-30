package composite;

import java.util.ArrayList;
import java.util.List;

public class MealBoxDemo {
    public static void main(String[] args) {
        MealBox mb = new MealBox();
        mb.add(new Burger());
        mb.add(new Fries());

        mb.serve();
        System.out.println(mb.getPrice());
    }
}

interface MealComponent{
    void serve();
    double getPrice();
}

class Burger implements MealComponent{
    @Override
    public void serve() {
        System.out.println("Burger");
    }
    public double getPrice() {
        return 43.9;
    }
}

class Fries  implements MealComponent{
    @Override
    public void serve() {
        System.out.println("Fries");
    }
    public double getPrice() {
        return 12.0;
    }
}

class MealBox implements MealComponent{
    private List<MealComponent>  components = new ArrayList<MealComponent>();


    public void add(MealComponent component){
        components.add(component);
    }
    @Override
    public void serve() {
        System.out.println("Meal box");
        for (MealComponent component : components) {
            component.serve();
        }
    }

    @Override
    public double getPrice() {
        double sum = 0;
        for (MealComponent component : components) {
            sum += component.getPrice();
        }
        return sum;
    }
}
