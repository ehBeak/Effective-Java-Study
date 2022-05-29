package item42.functionobject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

public class FunctionObject {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();

        // 예시: 정렬을 위한 비교함수로 익명 클래스를 사용 -> 코드가 너무 길다. 자바는 함수형 프로그래밍에 적합하지 않다.
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return Integer.compare(s.length(), t1.length());
            }
        });

        // 위의 코드를 람다 방식으로 바꾼 모습
        Collections.sort(words,
                (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        // 람다 자리에 비교자 생성 메서드 사용한 모습
        Collections.sort(words, comparingInt(String::length));

        // List 인터페이스에 추가된 sort 메서드 이용
        words.sort(comparingInt(String::length));

    }
}
