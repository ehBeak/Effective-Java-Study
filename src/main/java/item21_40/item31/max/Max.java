package item21_40.item31.max;

import java.util.List;
import java.util.Objects;

public class Max {

    // 컬렉션에서 최댓값을 반환한다. - 재귀적 타입 한정 사용, 한정적 와일드 카드
    // ? extends E: ScheduledFuture<?>를 상속받은(확장한) 것
    // ScheduleFuture<V> 는 Comparable<E>를 상속받았기 때문에, 즉 상위 타입이기 때문에 오류 없음
    public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("컬렉션이 비어 있습니다.");
        }

        E result = null;
        for (E e : list) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }

        return result;
    }

    // 컬렉션에서 최댓값을 반환한다. - 재귀적 타입 한정 사용, 한정적 와일드 카드 사용안함
    //E: ScheduledFuture<?> -> Comparable<ScheduleFuture<?>>를 구현해야함
    public static <E extends Comparable<E>> E max_x(List<E> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("컬렉션이 비어 있습니다.");
        }

        E result = null;
        for (E e : list) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }

        return result;
    }
}
