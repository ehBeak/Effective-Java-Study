package item20.simulatedmultiple;

import java.util.AbstractMap;

// 시뮬레이트한 다중 상속 : 다중 상속의 많은 장점을 제공하는 동시에 단점은 피하게 된다.
public class AClass implements AInterface{// , BInterface.., CInterface

    private InnerAbstractAInterface inner = new InnerAbstractAInterface();

    @Override
    public void start() {
        inner.start();
    }

    @Override
    public void process() {
        inner.process();
    }

    @Override
    public void stop() {
        inner.stop();
    }

    @Override
    public void choose() {
        inner.choose();
    }

    private class InnerAbstractAInterface extends AbstractAInterface{

        @Override
        public void choose() {
            System.out.println("product = " + product);
        }
    }

}
