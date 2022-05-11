package item21_40.item26.wildcardtype.unbounded;

import java.util.Set;

public class SetExample {

    // 안좋은 예시 - 로 타입 사용: 안전하지 않다.
    static int numElementsInCommon_bad(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    // 좋은 예시 - 비한정적 와일드 카드 사용: 안전하다.
    static int numElementsInCommon_good(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }
}
