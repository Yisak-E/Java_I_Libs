package proto;

public class Factory {
    public static void main(String[] args) {
        Creator[] creators = new Creator[3];
        creators[0] = new Creator1();
        creators[1] = new Creator2();
        creators[2] = new Creator3();

        for (Creator creator : creators) {
            Product product = creator.createProduct();
            System.out.println(product);
        }
    }

}
interface Product{

}
interface Creator{
     Product createProduct();
}

class Product1 implements Product{
    @Override
    public String toString(){
        return "Product1";
    }
}
class Product2 implements Product{
    @Override
    public String toString(){
        return "Product2";
    }
}
class Product3 implements Product{
    @Override
    public String toString(){
        return "Product3";
    }
}

class Creator1 implements Creator{
    @Override
    public Product createProduct() {
        return new Product1();
    }


}
class Creator2 implements Creator{
    @Override
    public Product createProduct() {
        return new Product2();
    }


}
class Creator3 implements Creator{
    @Override
    public Product createProduct() {
        return new Product3();
    }



}
