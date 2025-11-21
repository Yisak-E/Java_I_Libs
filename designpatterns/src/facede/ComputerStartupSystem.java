package facede;

public class ComputerStartupSystem {
    public static void main(String[] args) {
        System.out.println("\nComputer Startup System\n");
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();
        OperatingSystem os = new OperatingSystem();

        ComputerFacade cf = new ComputerFacade(cpu,memory,hardDrive,os);
        cf.startComputer();
        System.out.println("\nI just send message on Telegram \n");
        cf.shutdownComputer();
    }
}


class CPU{
    public void start(){
        System.out.println("CPU Starting...");
    }
    public void execute(){
        System.out.println("CPU Executing...");
    }
}

class Memory{
    public void load(){
        System.out.println("Memory Loading...");
    }
}

class HardDrive{
    public void read(){
        System.out.println("Hard Drive reading...");
    }
}

class OperatingSystem{
    public void boot(){
        System.out.println("⚙️ OS booting...");
    }
}

class ComputerFacade{
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;
    private OperatingSystem operatingSystem;

    public ComputerFacade(CPU cpu, Memory memory, HardDrive hardDrive,  OperatingSystem operatingSystem){
        this.cpu = cpu;
        this.memory = memory;
        this.hardDrive = hardDrive;
        this.operatingSystem = operatingSystem;
    }

    public void startComputer(){
        System.out.println("Computer Starting...");
        cpu.start();
        memory.load();
        hardDrive.read();
        operatingSystem.boot();
    }

    public void shutdownComputer(){
        System.out.println("Computer Shutdown processing...");
        cpu.execute();
        memory.load();
        hardDrive.read();
        operatingSystem.boot();
    }
}