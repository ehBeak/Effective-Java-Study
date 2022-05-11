package item1_20.item13.case5;

public class HashTable_O_2 {

    private Entry2[] buckets;

    private static class Entry2 {
        final Object key;
        Object value;
        Entry2 next;

        public Entry2(Object key, Object value, Entry2 next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // 이 엔트리가 가리키는 연결 리스트를 재귀적으로 복사
        Entry2 deepCopy() {
            Entry2 result = new Entry2(key, value, next);
            for (Entry2 p = result; p.next != null; p = p.next) {
                p.next = new Entry2(p.next.key, p.next.value, p.next.next);
            }
            return result;
        }
    }

    // 엔트리 자신이 가리키는 연결 리스트를 반복적으로 복사한다.
    @Override
    protected HashTable_O_2 clone() {
        try {
            HashTable_O_2 result = (HashTable_O_2) super.clone();
            result.buckets = new Entry2[buckets.length]; // 버킷 크기 할당

            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    result.buckets[i] = buckets[i].deepCopy();
                }
            }

            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
