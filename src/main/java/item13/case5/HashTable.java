package item13.case5;

// clone메서드를 재귀적으로 호출는 것이 불충분한 경우
public class HashTable implements Cloneable {

    private Entry[] buckets;

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        public Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    protected HashTable clone() throws CloneNotSupportedException {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = buckets.clone(); // 복재본은 자신만의 버킷 배열을 갖지만, 이 배열은 원본과 같은 연결 리스트를 참조한다.
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


}
