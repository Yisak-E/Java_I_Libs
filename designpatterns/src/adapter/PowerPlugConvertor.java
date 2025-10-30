package adapter;

/**
 * When to use Adapter design pattern
 * Legacy code integration - making old classes work with new systems
 * Third-party libraries - adapting external APIs to your interface
 * Interface mismatch - when what you have doesn't match what you need
 * Remember: "Adapter translates between incompatible interfaces"
 */
public class PowerPlugConvertor {
    public static void main(String[] args) {
        EuropeanPlug myPlug = new EuropeanPlug();
        USSocket adopter = new PlugAdapter(myPlug);
        adopter.plugIn();
    }
}

interface USSocket{
    void plugIn();
}

class EuropeanPlug{
    public void connect(){
        System.out.println("European plug connected");
    }
}

class PlugAdapter implements USSocket{
    private EuropeanPlug europeanPlug;

    public PlugAdapter(EuropeanPlug europeanPlug){
        this.europeanPlug = europeanPlug;
    }
    @Override
    public void plugIn(){
        europeanPlug.connect();
    }
}

