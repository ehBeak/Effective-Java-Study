package item1_20.item13.case1;

public class B extends A {

    private String type;

    public B(int number, String name, String type) {
        super(number, name);
        this.type = type;
    }


    /*
    * clone메서드가 super.clone이 아닌, 생성자를 호출해 얻은 인스턴스를 반환해도 컴파일러는 불평하지 않는다.
    * 하지만 이 클래스의 하위 클래스에서 super.clone을 호출한다면 잘못된 클래스의 객체가 만들어져, 결국 하위 클래스의 clone메서드가 제대로 동작하지 못한다. */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // A의 값이 반환된다.
    }


    /*@Override
    protected B clone() throws CloneNotSupportedException {
        return (B) super.clone(); // A의 값이 반환된다.
    }*/
}
