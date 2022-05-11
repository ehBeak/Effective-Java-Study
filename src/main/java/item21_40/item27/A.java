package item21_40.item27;

import java.util.Arrays;

public class A<T> {

    transient Object[] elementData;
    private int size;
    private static final int MAX_ARRAY_SIZE = 2147483639;

    public <T> T[] toArray(T[] a) {
        if (a.length < this.size) {
            // 생성한 배열과 매개변수로 받은 배열의 타입이 모두 T[]로 같으므로
            // 올바를 형변환이다.
            @SuppressWarnings("unchecked") T[] result = (T[]) Arrays.copyOf(this.elementData, this.size, a.getClass());
            return result;
        } else {
            System.arraycopy(this.elementData, 0, a, 0, this.size);
            if (a.length > this.size) {
                a[this.size] = null;
            }

            return a;
        }
    }
}

/**
 * @SupressWarning을 선언 전체에 다는 것보다 지역변수를 선언하고 그 변수에 달아주자.
 * 안전한 이유에 대한 주석 필수
 */