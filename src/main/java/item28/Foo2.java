package item28;

import java.util.List;

public class Foo2 {
    public static void main(String[] args) {
        // 제네릭에서 배열을 못만들도록 하는 이유(컴파일에서 방지하는 이유)
//        List<String>[] stringLists = new List<String>[1];// 가능하다고 가정,
//        List<Integer> intList = List.of(42); // 원소가 하나인 List<Integer>생성
//        Object[] objects = stringLists;// List<String> 배열을 Object 배열에 할(배열은 공변!)
//        objects[0] = intList;// 제네릭의 소거로 성공 -> List[]가 되기 때문에 ArrayStoreException 발생하지 않음
//        String s = stringLists[0].get(0);// ClassCatException 발생
        /**
         * 컴파일러는 꺼낸 원소를 자동으로 String으로 형변환 하는데,
         * 이 원소는 Integer이므로 런타임에 ClassCastException이 발생한다
         */

    }
}
