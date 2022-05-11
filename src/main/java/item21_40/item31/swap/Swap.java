package item21_40.item31.swap;

import java.util.ArrayList;
import java.util.List;

public class Swap {

    // 비한정적 타입 매개변수 사용
    public static <E> void swap1(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }


    // 비한정적 와일드 카드 사용
    public static void swap2(List<?> list, int i, int j) {
//        list.set(i, list.set(j, list.get(i))); // 컴파일 오류: List<?>에는 null값만 들어감

        // -> private 도우미 메서드 따로 작성
        swapHelper(list, i, j);
    }

    // 와일드카드 타입을 실제 타입으로 바꿔주는 private 도우미 메서드
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    /**
     * 메서드 선언에 타입 매개변수가 한 번만 나오면 와일드 카드로 대체해라
     * 비한정적 타입 매개변수 E -> 비한정적 와일드 카드 ?
     * 한정적 타입 매개변수 String -> 한정적 와일드 카드 ? extends String
     */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("list = " + list);
//        swap1(list, 1, 2);
        swap2(list, 1, 2);

        System.out.println("list = " + list);

    }
}
