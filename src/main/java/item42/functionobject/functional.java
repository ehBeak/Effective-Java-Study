package item42.functionobject;

/**
 * 함수 객체
 *  -> 자바에서 함수 타입을 표현할 때 추상 메서드를 하나만 담은 인터페이스를 사용함
 *
 * 사용
 *  1. 특정 함수나 동작을 나타내는 데 사용(예시-FunctionObject)
 *
 *  단점
 *   - 자바는 함수형 프로그래밍에 적합하지 않다.
 *
 *  해결
 *   -> 함수형 인터페이스들의 인스턴스를 람다식을 사용해 만든다.
 */
public interface functional {
    void print();
}
