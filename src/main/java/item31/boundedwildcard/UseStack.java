package item31.boundedwildcard;

import java.util.Collection;
import java.util.Iterator;

public class UseStack {
    public static void main(String[] args) {
        // 1.
        Stack<Number> numberStack = new Stack<>();

        Iterable<Integer> integers = new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return null;
            }
        };

        /**
         * 한정적 와일드 카드를 사용해서 하위타입도 받을 수 있도록 함
         * -> 컴파일 단계에서 문제가 없으니 타입 안전하다.
         */
        numberStack.pushAll(integers);


        // 2.
        Stack<Number> numberStack1 = new Stack<>();
        Collection<Object> objects = new Collection<Object>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Object> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        numberStack1.popAll(objects);

    }
}
