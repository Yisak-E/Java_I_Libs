package composite;

import java.util.ArrayList;
import java.util.List;

public class MenuDemo {
    public static void main(String[] args) {
        Menu menu1 = new MenuItem("Pasta", 34.89);
        Menu menu2 = new MenuItem("Pizza", 44.89);

        ComboMenu combo1 = new ComboMenu();
        combo1.add(menu2);
        combo1.add(menu1);
        combo1.display();
    }
}

interface Menu{
    String getName();
    double getPrice();
    void display();

}

class MenuItem implements Menu{
    private String name;
    private double price;
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public void display() {
        System.out.println(getName() + ": " + getPrice());
    }
}

class ComboMenu implements Menu{
    private List<Menu> menuList;
    public ComboMenu(List<Menu> menuItems) {
        this.menuList = menuItems;
    }
    public ComboMenu() {
        menuList = new ArrayList<>();
    }

    public void add(Menu menu){
        menuList.add(menu);
    }
    @Override
    public String getName() {
       return "this is main menu list";
    }
    @Override
    public double getPrice() {
       double total = 0;
        for (Menu menu : menuList) {
            total += menu.getPrice();
        }
        return total;
    }
    @Override
    public void display() {
        for (Menu menuItem : menuList) {
            menuItem.display();
        }
    }
}
