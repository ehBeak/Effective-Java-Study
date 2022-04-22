package item29.e;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 *  elements 필드의 타입을 E[]에서 Object[]로 바꾸는 것 -> 비검사 형변환 수행 할당문에 @SuppressWarning
 */
public class Stack2<E> {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack2() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    } // 오류 발생

   public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        @SuppressWarnings("unchecked") E result = (E) elements[--size];

        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    //? 다 쓴 참조를 해제하는 가장 좋은 방법은 그 참조를 담은 변수를 유효범위 밖으로 밀어내는 것이다.
}
