package item13.case4;

import java.util.Arrays;
import java.util.EmptyStackException;

// 클래스에서 가변 객체를 참조하는 경우 clone메서드 정의하는 법
public class A implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public A() {
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
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    // 잘못된 방식
//    @Override
    protected A clone_X() {
        try {
            return (A) super.clone(); // 참조 값만 복사가 되는 문제 발생!!
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // 재귀적 호출 방식
//    @Override
    protected A clone_13_2() {
        try {
            A result = (A) super.clone();
            result.elements = elements.clone(); // 가변 객체만 따로 clone하기(깊은 복사)
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


}
