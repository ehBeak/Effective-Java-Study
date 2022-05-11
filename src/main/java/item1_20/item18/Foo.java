package item1_20.item18;

import java.util.HashSet;
import java.util.List;

public class Foo {

    public static void main(String[] args) {
        /* 상속보다는 컴포지션을 사용하라
        *  1. 다른 패키지의 구체 클래스를 상속하는 일은 위험하다
        *  2. 메서드 호출과 달리 상속은 캡슐화를 깨뜨린다. */

        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("a", "b", "c"));

        int addCount = s.getAddCount();
        System.out.println("addCount = " + addCount);

        InstrumentedSet<String> set = new InstrumentedSet<>(new HashSet<>());
        set.addAll(List.of("a", "b", "c"));
        int addCount1 = set.getAddCount();
        System.out.println("addCount1 = " + addCount1);


    }

    public void callBack(InstrumentedSet<String> instrumentedSet) {
        
    }
}
