package item1_20.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

/* 메모리 누수 예시1 */
public class Stack_X {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack_X() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size]; // 메모리 누수 일어남(다 쓴 참조 : 가비지 컬렉터가 회수하지 않음)
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }


}
