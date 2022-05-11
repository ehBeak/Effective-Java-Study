package item1_20.item4;

//1. 특정 메서드들을 모아 놓은 클래스 ex. java.lang.Math, java.util.Arrays
//2. 특정 인터페이스를 구현하는 객체를 생성하는 정적 메서드 모아놓은 클래스 ex. Java.util.Collections
//3. final 클래스와 관련한 메서드들 모아놓은 클래스

/*
public class Player implements Comparable<Player> {
    // Fields, Getters, Setters 생략

    @Override
    public int compareTo(Player o) {
        return o.getScore() - getScore();
    }
}
*/

public class UtilityClass {
    // 인스턴스화 방지 -

    // private 생성자 명시
    private UtilityClass() {
        throw new AssertionError(); // 외부에서 사용불가, 상속 불가
    }

}
