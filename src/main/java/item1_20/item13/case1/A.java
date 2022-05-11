package item1_20.item13.case1;

public class A {

    private int number;
    private String name;

    public A(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new A(this.number, this.name);
    }
}
