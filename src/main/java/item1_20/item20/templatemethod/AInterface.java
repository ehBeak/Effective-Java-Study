package item1_20.item20.templatemethod;

public interface AInterface {

    boolean equals();

    int getSize(); // 기반 메서드

    // default 함수
    default boolean isEmpty() {
        return getSize() == 0; // 기반 메서드를 통해 디폴트 메서드를 구현
    }


}
