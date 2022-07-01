package item44.lambda;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {

        // T타입 인수를 하나 받아서 T 타입 반환
        UnaryOperator<Integer> plus10 = (i) -> i + 10;
        UnaryOperator<Integer> multiply = (i) -> i * 2;

        // T타입 2개 받아서 T타입 반환
        BinaryOperator<Integer> plus = (a, b) -> a + b;

        // T타입 받아서 boolean 반환
        Predicate<String> isHello = (s) -> s.startsWith("Hello");

        // T타입 받아서 R타입 리턴 (인수와 리턴 타입 다름)
        Function<Integer, String> print10 = (s) -> String.valueOf(s);

        // 인수 받지 않고 T타입 제공
        Supplier<Integer> get10 = () -> 10;
        get10.get();

        // T타입 받아서 아무 값도 리턴 안함
        Consumer<Integer> printT = (i) -> System.out.println(i);

        // T, U를 받아서 R 타입 리턴
        BiFunction<Integer, Integer, Integer> biPlus = (a, b) -> a + b + 10;

    }
}
