package adapter;

public class EcommerceStore {
    public static void main(String[] args) {
        OlderPayment oldPay =  new OlderPayment();
        PaymentAdapter paymentAdapter = new PaymentAdapter(oldPay);
        System.out.print("The total price is ");
        paymentAdapter.pay(345);

    }
}

interface ModernPayment{
    void pay(double price);
}


class OlderPayment{
    public void pay(String currency, double price){
        System.out.println(currency +": " + price);
    }
}

class PaymentAdapter implements ModernPayment{
    private OlderPayment older;
    public PaymentAdapter(OlderPayment older){
        this.older = older;
    }
    @Override
    public void pay(double price) {
        older.pay("USD",price);

    }
}