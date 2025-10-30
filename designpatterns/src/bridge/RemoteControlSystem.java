package bridge;

/**
 * 🧠 When to Use Bridge:
 * Avoid permanent binding between abstraction and implementation
 * Both abstractions and implementations should be extensible
 * Changes in implementation shouldn't affect clients
 * Hide implementation details from client
 * Remember: "Bridge separates what from how"
 */
public class RemoteControlSystem {
    public static void main(String[] args) {
        SonyTV tv1 = new SonyTV();
        SamsungTV tv2 = new SamsungTV();

        BasicRemote remote = new BasicRemote(tv1);
        remote.turnOn();
        remote.setChannel(3);

    }
}

interface TV{
    void on();
    void off();
    void setChannel(int channel);
}

class SonyTV implements TV{
    @Override
    public void on() {
        System.out.println("Sony TV on");
    }
    @Override
    public void off() {
        System.out.println("Sony TV off");
    }
    @Override
    public void setChannel(int channel) {
        System.out.println("Sony TV setChannel: "+channel);
    }
}

class SamsungTV implements TV{
    @Override
    public void on() {
        System.out.println("Samsung TV on");
    }
    @Override
    public void off() {
        System.out.println("Samsung TV off");
    }
    @Override
    public void setChannel(int channel) {
        System.out.println("Samsung TV setChannel: "+channel);
    }
}

abstract class RemoteControl{
    protected TV tv;
    public RemoteControl(TV tv){
        this.tv = tv;
    }
    abstract void turnOn();
    abstract void turnOff();
    abstract void setChannel(int channel);
}


class BasicRemote extends RemoteControl{
    public BasicRemote(TV tv){
        super(tv);
    }
    public void turnOn(){
        tv.on();
    }
    public void turnOff(){
        tv.off();
    }
    public void setChannel(int channel){
        tv.setChannel(channel);
    }
}

