package item21_40.item24.anonymous;

public class Anonymous {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 쓰이는 시점에 만들어짐
 * 비정적인 문맥에서 상ㅇ됭 때만 바깥 클래스으 인스턴스를 참조할 수 있다.
 * 상수표현을 위해 초기화된 final 기본 타입과 문자열 필드만 가질 수 있다.
 */
