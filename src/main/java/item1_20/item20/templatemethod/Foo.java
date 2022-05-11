package item1_20.item20.templatemethod;

public class Foo {

//    기반 메서드는 꼭 구현해야한다.
    public static void main(String[] args) {

        AbstractAInterface ai1 =
                new AbstractAInterface() {
                    @Override
                    public int getSize() {
                        return 0;
                    }

                    @Override
                    public boolean isEmpty() {
                        return super.isEmpty();
                    }
                };

        AbstractAInterface ai2 =
                new AbstractAInterface() {
                    @Override
                    public int getSize() {
                        return 0;
                    }
                };

        /*
        AbstractAInterface ai3 =
                new AbstractAInterface() {
                    @Override
                    public boolean isEmpty() {
                        return super.isEmpty();
                    }
                };
        */
    }
}
