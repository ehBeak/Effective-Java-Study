package item24.nestedstatic;

public class Outer {

    private String name;

    private static String name2;

    // 정적 멤버 클래스
    public static class StaticInner {

        /*public String getName() {//불가능
            return Outer.this.name2;
        }*/

    }

    // private 정적 멤버 클래스: 바깥 클래스가 표현하는 객체의 한 부분(구성요소)을 나타낼 때 씀
    private static class StaticInnerPrivate {

    }


    /** 특징
     * 다른 클래스 안에 선언
     * 바깥 클래스의 private 멤버에도 접근 가능
     * 이하 일반 클래스와 동일
     * 다른 정적 멤버와 똑같은 접근 규칙 가짐
     */


    /** 언제 사용하는지
     * 바깥 클래스와 함께 쓰일 때만 유용한 public 도우미 클래스
     * 개념상 중첩 클래스의 인스턴스가 바깥 인스턴스와 독립적으로 존재할 수 있을때
     * 멤버 클래스에서 바깥 인스턴스에 접근할 일이 없다면 무조건 static을 붙여서 정적 멤버 클래스로 만들자.
     */
    // 왜 사용하는지
}