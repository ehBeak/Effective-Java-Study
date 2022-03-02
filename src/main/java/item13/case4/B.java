package item13.case4;

import java.util.Arrays;
import java.util.EmptyStackException;

// 만약 elements 필드가 final이었다면, case4.A 클래스의 동작 방식은 작동하지 않는다.
// -> Cloneable 아키텍쳐는 '가변 객체를 참조하는 필드는 final로 선언하라'는 일반 용법과 충돌한다.
public class B implements Cloneable{

    private final Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public B() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size]=null;
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
//            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    protected A clone_13_2() {
        try {
            A result = (A) super.clone();
//            result.elements = elements.clone(); // final 객체이기 때문에 값이 변할 수 없다.
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
