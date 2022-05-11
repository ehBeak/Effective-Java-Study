package item1_20.item18;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {

    private int addCount;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {

        /*boolean modified = false;
        Iterator<? extends E> iterator = c.iterator();

        while(iterator.hasNext()) {
            E e = iterator.next();
            if (this.add(e)) {// 순회하면서 add 호출
                modified = true;
            }
        }
        return modified; //==> 구현 자체가 어렵고, private 필드를 상위 클래스에서 사용한다면 문제*/


        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
