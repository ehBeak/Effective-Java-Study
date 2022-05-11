package item1_20.item13.case3;

// 제대로 동작하는 clone메서드를 가진 상위 클래스를 상속해 Cloneable을 구현하고 싶을 때 - 상위 클래스 필드가 불변이나 기본 타입일 때
public class B extends A implements Cloneable { // 2. cloneable 인터페이스 구현

    public B(int number, String name) {
        super(number, name);
    }

    @Override
    protected B clone(){// 클라이언트 쪽에서 형변환 하지 않도록 반환 타입 바꿈
        try {
            // 공변 변환 타이핑: 메서드의 반환 타입은 상위 클래스의 메서드가 반환하는 타입의 하위 타입일 수 있다.
            return (B) super.clone(); // 1. 먼저 super.clone을 호출한다. 모든 필드가 기본 타입이거나 불변객체라면 손볼 것이 없다.
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // 일어날 수 없는 일
        }

    }
}
