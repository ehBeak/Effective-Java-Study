package item1;

import java.util.EnumSet;

public class Foo {

    public static void main(String[] args) {
        /* 정적 팩터리 메서드 장점
        *  1. 인스턴스를 새로 생성하지 않는다.
        *  2. 이름을 정의할 수 있다.
        *  3. 반환타입의 하위 타입을 반환할 수 있다.
        *  4. 매개변수에 따라 다른 클래스의 객체를 반환 가능하다.
        *  5. 작성 시점에 반환할 객체의 클래스가 존재하지 않아도 된다. */

        /* 정적 팩터리 메서드 단점
         *  1. 정적 책터리 만으로는 하위 클래스를 만들 수 없다.
         *  2. 정적 팩터리 메서드는 프래그래머가 찾기 어렵다. */
    }
}
