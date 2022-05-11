package item21_40.item32;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 제네릭 varargs 매개변수를 안전하게 사용하는 메서드
 * 조건1) varargs 매개변수 배열에 아무것도 저장하지 않는다.
 * 조건2) 그 배열(혹은 복제본)을 신뢰할 수 없는 코드에 노출하지 않는다.
 * 이 두가지 조건을 모두 만족해야한다.
 */
public class Safe {

    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {// List<? etends String>[]
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    /**
     * @safeVarargs 사용 규칙
     * 1. 재정의 할 수 없는 메서드에만 달아야 한다.(정적 메서드, final 인스턴스 메서드, 자바9 이후로는 private 인스턴스 메서드에도 허용된다.)
     *
     */

    // pickTwo 함수 안전하게 사용 예시 List.of를 사용하자 - List.of는 @SafeVarargs하다.
    static <T> List<T> pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0: return List.of(a, b); // 넘기면 toArray함수가 Object[] 타입의 배열 생성
            case 1: return List.of(a, c);
            case 2: return List.of(b, c);
        }
        throw new AssertionError();
    }
}
