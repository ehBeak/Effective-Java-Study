package item43;

import java.util.HashMap;
import java.util.Map;

public class Foo {
    public static void main(String[] args) {
        Map<Object, Integer> map = new HashMap<>();

        Object key = new Object();

        // 키가 맵 안에 없다면 키와 숫자 1을 매핑하고, 이미 있다면 기존 매핑 값을 증가시킨다.
        // -> 단점: 매개변수인 count와 incr은 큭 하는 일 없이 공간을 꽤 차지한다. 두 인수의 합을 단순히 반환할 뿐
        map.merge(key, 1, (count, incr) -> count + incr);

        // 이를 해결하고자 정적 메서드 sum을 참조하자
        map.merge(key, 1, Integer::sum);

        /**
         * 람다 대신 꼭 메서드 참조를 진행하라는 것은 아님, 단 메서드 참조 쪽이 짧고 명확하다면 메서드 참조를 쓰고,
         * 그렇지 않은 때만 람다를 사용하자.
         *
         * 메소드 참조 유형
         * 1. 정적 메서드 참조
         * 2. 인스턴스 메서드 참조 - 한정적 인스턴스 참조
         * 3. 인스턴스 메서드 참조 - 비한정적 인스턴스 참조
         * 4. 클래스 생성자 참조
         * 5. 배열 생성자 참조
         */

    }
}
