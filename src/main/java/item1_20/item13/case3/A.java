package item1_20.item13.case3;

public class A {

    private int number; // 기본 타입
    private String name; // 불변 객체

    public A(int number, String name) {
        this.number = number;
        this.name = name;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
