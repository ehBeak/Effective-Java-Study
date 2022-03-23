package item19;

public class Sub extends Super {

    private final Instance instance;

    Sub() {
        instance = Instance.now();
    }

    @Override
    public void overrideMe() {
        System.out.println("instance = " + instance);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
