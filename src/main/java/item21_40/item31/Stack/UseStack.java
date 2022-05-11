package item21_40.item31.Stack;

import java.util.Collection;
import java.util.Iterator;

public class UseStack {
    public static void main(String[] args) {
        // 1. pushAll
        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return null;
            }
        };
        /**
         * 매개변수화 타입이 불공변이기 때문에 오류 발생 => 한정적 와일드 카드 사용하자!
         */
//        numberStack.pushAll(integers);


        // 2. popAll
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
        /**
         * 불공변이기 때문에 오류 발생 -> 와일드 카드 타입으로 해결!
         */
//        numberStack1.popAll(objects);

    }
}
