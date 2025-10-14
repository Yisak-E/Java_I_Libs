package proto.foodOrder;

public class FoodOrder {
    public static void main(String[] args) {
        // Create prototype menu items
        FoodItem pizza = new FoodItem("Pizza", 12.99, "Large cheese pizza");
        FoodItem burger = new FoodItem("Burger", 8.99, "Beef burger with fries");
        FoodItem salad = new FoodItem("Salad", 6.99, "Fresh garden salad");

        // Clone for different orders
        FoodItem order1Pizza = pizza.clone();
        order1Pizza.setSpecialInstructions("Extra cheese, no olives");

        FoodItem order2Pizza = pizza.clone();
        order2Pizza.setSpecialInstructions("Pepperoni, well done");

        FoodItem order1Burger = burger.clone();
        order1Burger.setSpecialInstructions("No onions, add bacon");

        System.out.println("Order 1 Pizza: " + order1Pizza.getName() + " - " + order1Pizza.getSpecialInstructions());
        System.out.println("Order 2 Pizza: " + order2Pizza.getName() + " - " + order2Pizza.getSpecialInstructions());
        System.out.println("Order 1 Burger: " + order1Burger.getName() + " - " + order1Burger.getSpecialInstructions());
    }
}

class FoodItem implements Cloneable {
    private String name;
    private Double price;
    private String description;
    private String specialInstructions;
    public FoodItem(String name, Double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.specialInstructions = "None";
    }


    public FoodItem (FoodItem item) {
        this.name = item.name;
        this.price = item.price;
        this.description = item.description;
        this.specialInstructions = item.specialInstructions;
    }

    public FoodItem clone(){
        return new FoodItem(this);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSpecialInstructions() {
        return specialInstructions;
    }
    public void setSpecialInstructions(String specialDescription) {
        this.specialInstructions = specialDescription;
    }

    @Override
    public  String toString() {
        return "Special Instruction: " + this.specialInstructions;
    }
}
