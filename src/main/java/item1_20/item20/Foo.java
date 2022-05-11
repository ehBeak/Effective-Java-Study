package item1_20.item20;

import java.util.*;

public class Foo {

    /* 추상 클래스보다는 인터페이스를 우선하라
    *
    *  다중 구현 매커니즘
    *  1. 인터페이스
    *  2. 추상 클래스
    *  -> 차이점: 추상 클래스가 정의한 타입을 구현하는 클래스는 반드시 추상클래스의 하위 클래스가 되어야 한다.
    *
    *
    *  인터페이스는 믹스인 정의에 안성맞춤이다.
    *  믹스인: 대상 타입의 주된 기능에 선택적 기능을 혼합 하는 클래스 (추상 클래스는 믹스인을 정의 할 수 없다.)
    *  -> 인터페이스는 계층구조가 없는 타입 프레임 워크를 만들 수 있다.
    *
    *  래퍼 클래스 관용구와 함께 사용한 인터페이스는 기능을 향상 시키는 안전하고 강력한 수단이 된다.
    *
    *  인터페이스에서 디폴트 메서드를 제공할 때는 상속하려는 사람을 위한 설명을 @implSpec 자바독 태그를 붙여 문서화 해야한다.
    *
    *  인터페이스는 인스턴스 필드를 가질 수 없고 public이 아닌 정적 멤버도 가질 수 없다.
    *
    *  인터페이스와 추상 골격 구현 클래스를 함께 제공하는 식으로 인터페이스와 추상 클래스의 장점을 모두 취하는 방법
    *  인터페이스: 타입 정의와 디폴트 메서드 몇 개도 함께 제공
    *  골격 구현 클래스: 나머지 메서드까지 구현
    *  -> 템플릿 메서드 패턴
    *
    *  골격 구현 작성
    *  1. 인터페이스를 잘 살펴 다른 메서드의 구현에 사용되는 기반 메서드 선정 -> 추상 메서드
    *  2. 기반 메서드들을 사용해 직접 구현할 수 있는 메서들를 모두 디폴트 메서드로 제공
    *  3. 단, equals + hashcode 는 디폴트 메서드로 제공하지 말자
    *  4. 남은 메서드는 이 인터페이스를 구현하는 골격 구현 클래스를 하나 만들어 남은 메서드들을 작성해 넣는다. */

    // 골격 구현을 사용해 완성한 구체 클래스
    static List<Integer> intArrayList(int[] a) {
        Objects.requireNonNull(a);

        return new AbstractList<Integer>() {
            @Override
            public Integer get(int i) {
                return a[i];
            }

            @Override
            public int size() {
                return a.length;
            }

            @Override
            public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val;
                return oldVal;
            }
        };
    }
}
