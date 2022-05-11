package item21_40.item31.max;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ScheduledFuture;

public class UseMax {
    public static void main(String[] args) {

        List<ScheduledFuture<?>> scheduledFutures = new List<ScheduledFuture<?>>() {
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
            public Iterator<ScheduledFuture<?>> iterator() {
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
            public boolean add(ScheduledFuture<?> scheduledFuture) {
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
            public boolean addAll(Collection<? extends ScheduledFuture<?>> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, Collection<? extends ScheduledFuture<?>> collection) {
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

            @Override
            public ScheduledFuture<?> get(int i) {
                return null;
            }

            @Override
            public ScheduledFuture<?> set(int i, ScheduledFuture<?> scheduledFuture) {
                return null;
            }

            @Override
            public void add(int i, ScheduledFuture<?> scheduledFuture) {

            }

            @Override
            public ScheduledFuture<?> remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<ScheduledFuture<?>> listIterator() {
                return null;
            }

            @Override
            public ListIterator<ScheduledFuture<?>> listIterator(int i) {
                return null;
            }

            @Override
            public List<ScheduledFuture<?>> subList(int i, int i1) {
                return null;
            }
        };

//        Max.max_x(scheduledFutures);  //컴파일 오류 E:ScheduledFuture<?>
        Max.max(scheduledFutures); // 컴파일 오류 없음
    }
}
