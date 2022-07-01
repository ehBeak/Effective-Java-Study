package item1_20.item20.wrapper.byinterface;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
// 여러개 기능 추가 가능
public class ForwardingSet<E> implements Set<E> {

    private final Set<E> s;

    public ForwardingSet(Set<E> s) {
        this.s = s;
    }


    @Override
    public int size() {
        return s.size();
    }

    @Override
    public boolean isEmpty() {
        return s.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return s.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return s.iterator();
    }

    @Override
    public Object[] toArray() {
        return s.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return s.toArray(ts);
    }

    @Override
    public boolean add(E e) {
        return s.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return s.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return s.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return s.addAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return s.retainAll(collection);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return s.removeAll(collection);
    }

    @Override
    public void clear() {
        s.clear();
    }

    @Override
    public boolean equals(Object o) {
        return s.equals(o);
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }

    @Override
    public String toString() {
        return s.toString();
    }
}