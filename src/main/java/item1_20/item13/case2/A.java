package item1_20.item13.case2;

// clone을 재정의한 클래스가 final일때
public final class A implements Cloneable { // => 이거 필요 없음!
    private int number;
    private String name;

    // 상속 못하기 때문에 case1의 경우를 고려할 필요가 없다.
    // 하지만, final클래스의 clone메서드가 super.clone을 호출하지 않는다면, cloneable을 구현할 이유도 없다.
    // Object의 clone 구현의 동작 방식에 기댈 필요가 없기 때문이다.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new A(); // => super.clone() 호출 안하니까!
    }
}
