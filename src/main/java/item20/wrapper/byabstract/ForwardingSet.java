package item20.wrapper.byabstract;

import java.util.AbstractSet;
import java.util.Iterator;

// 기능을 하나만 추가
public class ForwardingSet<E> extends AbstractSet<E> {

    private final AbstractSet<E> s;

    public ForwardingSet(AbstractSet<E> s) {
        this.s = s;
    }

    @Override
    public Iterator<E> iterator() {
        return s.iterator();
    }

    @Override
    public int size() {
        return s.size();
    }
}
