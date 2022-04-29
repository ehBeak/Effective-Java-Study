package item31.boundedwildcard;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class Stack<E> {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

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

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    // 일련의 원소를 스택에 넣는 메서드
    public void pushAll(Iterable<? extends E> src) {// src 매개변수는 Stack에 사용할 E 인스턴스를 생산함)
        for (E e : src) {
            push(e);
        }
    }

    // Stack 안의 모든 원소를 주어진 컬렉션으로 옮겨 담는다.(
    public void popAll(Collection<? super E> dst) {// dst 매개변수는 Stack으로부터 E 인스턴스를 소비함
        while (!isEmpty()) {
            dst.add(pop());
        }
    }
}
