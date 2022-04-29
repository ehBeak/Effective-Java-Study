package item30;

import java.util.*;

public class Foo1 {

    /**
     * 타입이 안전하지 않다.
     */
    public static Set union1(Set s1, Set s2) {
        Set result = new HashSet(s1); // unchecked
        result.addAll(s2); // unchecked
        return result;
    }

    /**
     * 제네릭 메서드
     */
    public static <E> Set<E> union2(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    /**
     * 제네릭 메서드를 활용하는 간단한 프로그램
     */
    public static void main(String[] args) {
        Set<String> guys = Set.of("톰", "딕", "해리");
        Set<String> stooges = Set.of("래리", "모에", "컬리");
        Set<String> aflCio = union2(guys, stooges);
        System.out.println("aflCio = " + aflCio);


    }

//    interface Comparable<T> {
//        int compareTo(T o);
//    }
//
//    public static <E> E max(Collection<E> e) {
//        Comparable<E> comparable;
//        comparable.compareTo(e.);
//        return e;
//    }


    Collection<Integer> c = new ArrayList<>();
    /**
     * 한정적 와일드 카드 타입을 사용하여 더 유연하게 개선할 수 있다.
     */
    public static <E extends A> Set<E> union3(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
}
