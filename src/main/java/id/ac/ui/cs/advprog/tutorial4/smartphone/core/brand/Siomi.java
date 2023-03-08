package id.ac.ui.cs.advprog.tutorial4.smartphone.core.brand;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory.SmartPhoneFactory;

public class Siomi extends SmartPhone{
    private SmartPhoneFactory smartPhoneFactory;

    public Siomi(SmartPhoneFactory smartPhoneFactory){
        this.smartPhoneFactory = smartPhoneFactory;
        setName("Siomi");
    }

    // TODO: Complete this method
    public void create(){

        System.out.println("Creating smartphone " + getName());
        setRAM(smartPhoneFactory.addRAM());
        setProcessor(smartPhoneFactory.addProcessor());
        setScreen(smartPhoneFactory.addScreen());
    }

    // TODO: Complete this method
    public void calculatePrice(){
        System.out.println("Calculating price for " + getName());
        setPrice(getProcessor().getPrice() * 1.5 + getRAM().getPrice() * 2 + getScreen().getPrice());

    }
}