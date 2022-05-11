package item21_40.item29.generic;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * 배열보다는 리스트를 우선해라
 * -> 자바가 리스트를 기본 타입으로 제공하지 않으므로 결국은 기본 타입인 배열을 사용해 구현해야한다.
 * -> Stack<>은 어떤 참조 타입으로든 Stack을 만들 수 있으나 기본 타입은 사용 불가가 */
public class Stack<E> {

    private List<E> elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new ArrayList<E>(DEFAULT_INITIAL_CAPACITY);
    }

    public void push(E e) {
        ensureCapacity();
        elements.add(e);
    }
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        elements.remove(size);
        return elements.get(--size);
    }

    private void ensureCapacity() {
        if (elements.size() == size) {

//            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
