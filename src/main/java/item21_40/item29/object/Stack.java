package item21_40.item29.object;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 클라이언트는 스택에서 꺼낸 객체를 형변환 해야하는데, 이때 런타임 오류가 날 위험이 있다.
 */
public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
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
