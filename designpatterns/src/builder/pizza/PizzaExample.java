package builder.pizza;


public class PizzaExample  {
    public static void main(String[] args) {
        PizzaDirector chef = new PizzaDirector();

        PizzaBuilder margherita = new MargheritaPizzaBuilder();
        chef.constractPizza(margherita);
        Pizza mar = margherita.getPizza();
        mar.description();

        PizzaBuilder customPizza = new CustomPizzaBuilder();
        customPizza.buildCrust();
        customPizza.buildCheese();
        customPizza.buildToppings();
        customPizza.buildSauce();
        Pizza custom = customPizza.getPizza();
        custom.description();


    }
}

class Pizza {
    private String crust;
    private String sauce;
    private String cheese;
    private String toppings;

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public void description(){
        System.out.println("Pizza with: "+ crust + " crust, " + sauce + " sauce, " + cheese + " cheese, " + toppings + " toppings");
    }
}

interface PizzaBuilder{
    void buildCrust();
    void buildSauce();
    void buildCheese();
    void buildToppings();

    Pizza getPizza();
}

class MargheritaPizzaBuilder implements PizzaBuilder{
    private Pizza pizza;
    public MargheritaPizzaBuilder(){
        pizza = new Pizza();
    }

    @Override
    public void buildCrust() {
        pizza.setCrust("Margherita");
    }

    @Override
    public void buildSauce() {
       pizza.setSauce("Tomato sauce");
    }

    @Override
    public void buildCheese() {
        pizza.setCheese("Mozzarella");
    }

    @Override
    public void buildToppings() {
        pizza.setToppings("Fresh Basil");
    }

   public Pizza getPizza(){
        return pizza;
   }
}

class CustomPizzaBuilder implements PizzaBuilder{
    private Pizza pizza;

    public CustomPizzaBuilder() {
        this.pizza = new Pizza();
    }

    public void buildCrust() {
        pizza.setCrust("Stuffed");
    }

    public void buildSauce() {
        pizza.setSauce("BBQ");
    }

    public void buildCheese() {
        pizza.setCheese("Extra Cheese");
    }

    public void buildToppings() {
        pizza.setToppings("Chicken, Mushrooms, Peppers");
    }

    public Pizza getPizza() {
        return pizza;
    }
}

class PizzaDirector{
    public void constractPizza(PizzaBuilder builder){
        builder.buildCrust();
        builder.buildSauce();
        builder.buildCheese();
        builder.buildToppings();
    }
}
