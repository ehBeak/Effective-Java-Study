package item21_40.item32;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 메서드가 안전한지 확인하는 법
 * varargs 매개변수 배열이 호출자로부터 그 메서드로 순수하게 인수들을 전달하는 일만 한다면 그 메서드는 안전
 */
public class NotSafe {

    // 위험!! - 가변인수로 넘어온 매개변수들을 배열에 담아 반환하는 제네릭 메서드
    // 배열의 타입은 컴파일 타임에 결정되는데, 그 시점에 컴파일러가 충분한 정보를 주지 않음 그래서 잘못 판단할 수 있음
    static <T> T[] toArray(T... args) {
        return args;
    }

    // 위의 함수의 위험성에 대한 예시
    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a, b); // 넘기면 toArray함수가 Object[] 타입의 배열 생성
            case 1: return toArray(a, c);
            case 2: return toArray(b, c);
        }
        throw new AssertionError();
    }

    public static void main(String[] args) {
        // 1. pickTwo 호출 -> 2. toArray 호출
        // 2에서 Object[] 타입 생성 후 반환
        // 1.에서 2에서 받은 Object[] 타입 반환
        // Object[] 타입을 String[]이 받음 -> ClassCastException 발생
        String[] attributes = pickTwo("좋은", "빠른", "저렴한");
    }
}
