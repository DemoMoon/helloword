package day0509;

/**
 * 1.简单工厂模式
 * 2.抽象工厂模式
 *
 * @author Administrator
 */
public class Client1 {
    public static void main(String[] args) {
        //1.简单工厂模式
        ComputerEngineer computerEngineer = new ComputerEngineerImp();
        computerEngineer.makeComputer(new CpuFactoryIntel(), new MainboardFactoryIntel());
        computerEngineer.makeComputer(new CpuFactoryAmd(), new MainboardFactoryAmd());
        System.out.println("-------11111111111-------");
        computerEngineer.makeComputer(new CpuFactoryIntel(), new MainboardFactoryAmd());
        computerEngineer.makeComputer(new CpuFactoryAmd(), new MainboardFactoryIntel());

        System.out.println("------22222222222--------");
        //2.抽象工厂模式
        ComputerEngineer2 computerEngineer2 = new ComputerEngineerImp2();
        AbstractFactory intelFactory = new IntelFactory();
        computerEngineer2.makeComputer2(intelFactory);
        AbstractFactory amdFactory = new AmdFactory();
        computerEngineer2.makeComputer2(amdFactory);
    }
}


interface AbstractFactory {
    /**
     * 创建CPU对象
     *
     * @return CPU对象
     */
    Cpu createCpu();

    /**
     * 创建主板对象
     *
     * @return 主板对象
     */
    Mainboard createMainboard();
}

class IntelFactory implements AbstractFactory {

    @Override
    public Cpu createCpu() {
        return new IntelCpu(755);
    }

    @Override
    public Mainboard createMainboard() {
        return new IntelMainboard(755);
    }

}

class AmdFactory implements AbstractFactory {
    @Override
    public Cpu createCpu() {
        return new AmdCpu(938);
    }

    @Override
    public Mainboard createMainboard() {
        return new AmdMainboard(938);
    }

}


/**
 * 工程师
 */
interface ComputerEngineer2 {
    /**
     * 组装电脑
     */
    void makeComputer2(AbstractFactory abstractFactory);
}

class ComputerEngineerImp2 implements ComputerEngineer2 {

    /**
     * 组装电脑
     */
    @Override
    public void makeComputer2(AbstractFactory abstractFactory) {
        Cpu cpu = abstractFactory.createCpu();
        cpu.calculate();
        Mainboard mainboard = abstractFactory.createMainboard();
        mainboard.installCPU();
    }
}

/**
 * 工程师
 */
interface ComputerEngineer {
    /**
     * 组装电脑
     *
     * @param cpuFactory       cpuFactory
     * @param mainboardFactory mainboardFactory
     */
    void makeComputer(CpuFactory cpuFactory, MainboardFactory mainboardFactory);
}

/**
 * 工程师
 */
class ComputerEngineerImp implements ComputerEngineer {
    @Override
    public void makeComputer(CpuFactory cpuFactory, MainboardFactory mainboardFactory) {
        Cpu cpu = cpuFactory.createCpu();
        cpu.calculate();
        Mainboard mainboard = mainboardFactory.createMainboard();
        mainboard.installCPU();
    }
}

interface CpuFactory {
    Cpu createCpu();
}

class CpuFactoryIntel implements CpuFactory {

    @Override
    public Cpu createCpu() {
        return new IntelCpu(755);
    }
}

class CpuFactoryAmd implements CpuFactory {

    @Override
    public Cpu createCpu() {
        return new AmdCpu(938);
    }
}

/**
 * CPU
 */
interface Cpu {
    void calculate();
}

class IntelCpu implements Cpu {
    /**
     * CPU的针脚数
     */
    private int pins = 0;

    public IntelCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("Intel CPU的针脚数：" + pins);

    }
}

class AmdCpu implements Cpu {
    /**
     * CPU的针脚数
     */
    private int pins = 0;

    public AmdCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("AMD CPU的针脚数：" + pins);
    }
}

interface MainboardFactory {
    Mainboard createMainboard();
}

class MainboardFactoryIntel implements MainboardFactory {

    @Override
    public Mainboard createMainboard() {
        return new IntelMainboard(755);
    }
}

class MainboardFactoryAmd implements MainboardFactory {
    @Override
    public Mainboard createMainboard() {
        return new AmdMainboard(938);
    }
}

/**
 * 主板
 */
interface Mainboard {
    void installCPU();
}

class IntelMainboard implements Mainboard {
    /**
     * CPU插槽的孔数
     */
    private int cpuHoles = 0;

    /**
     * 构造方法，传入CPU插槽的孔数
     *
     * @param cpuHoles
     */
    public IntelMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("Intel主板的CPU插槽孔数是：" + cpuHoles);

    }
}

class AmdMainboard implements Mainboard {
    /**
     * CPU插槽的孔数
     */
    private int cpuHoles = 0;

    /**
     * 构造方法，传入CPU插槽的孔数
     *
     * @param cpuHoles
     */
    public AmdMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("AMD主板的CPU插槽孔数是：" + cpuHoles);
    }
}
