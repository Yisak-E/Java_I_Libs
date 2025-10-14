package proto;

public class Singleton {
    private static Singleton instanc;

    protected Singleton() {}

    public static Singleton getInstance() {
        if (instanc == null) {
            instanc = new Singleton();
        }
        return instanc;
    }
}


class testSingleton {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
