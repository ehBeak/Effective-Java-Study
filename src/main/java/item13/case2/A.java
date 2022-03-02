package item13.case2;

// clone을 재정의한 클래스가 final일때
public final class A {
    private int number;
    private String name;

    // 상속 못하기 때문에 case1의 경우를 고려할 필요가 없다.
    // 하지만, final클래스의 clone메서드가 super.clone을 호출하지 않는다면, cloneable을 구현할 이유도 없다.
    // Object의 clone 구현의 동작 방식에 기댈 필요가 없기 때문이다.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
