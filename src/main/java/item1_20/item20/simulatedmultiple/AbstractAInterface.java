package item1_20.item20.simulatedmultiple;

abstract public class AbstractAInterface implements AInterface{

    public String product;

    @Override
    public void start() {
        System.out.println("AbstractAInterface.start");
    }

    @Override
    public void process() {
        System.out.println("AbstractAInterface.process");
    }

    @Override
    public void stop() {
        System.out.println("AbstractAInterface.stop");
    }

}
