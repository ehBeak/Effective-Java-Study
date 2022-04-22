package item29.e;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * - 제네릭 배열 생성을 금지하는 제약을 우회: Object 배열 생성 -> generic으로 형변환 -> @SuppressWarnings
 */
public class Stack1<E> {

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack1() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    } // 오류 발생

   public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        elements[size] = null; // 다 쓴 참조 해제
        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    //? 다 쓴 참조를 해제하는 가장 좋은 방법은 그 참조를 담은 변수를 유효범위 밖으로 밀어내는 것이다.
}
