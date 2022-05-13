package item21_40.item36.bitfield;

//비트 열거 상수 - 구닥다리 기법!
public class Text {

    // 비트 필드: 여러 상수를 하나의 집합으로 모을 수 있다.
    public static final int STYLE_BOLD = 1 << 0;
    public static final int STYLE_ITALIC = 1 << 1;
    public static final int STYLE_UNDERLINE = 1 << 2;
    public static final int STYLE_STRIKETHROUGH = 1 << 3;

    // 매개변수 styles는 0개 이상의 STYLE_ 상수를 비트별 OR한 값이다.
    public void applyStyles(int styles) {

    }

    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(STYLE_BOLD | STYLE_ITALIC);
    }

    /**
     * 장점
     * 1. 비트별 연산을 사용해 합집합과 교집합과 같은 집합 연산을 효율적으로 수행할 수 있음
     */

    /**
     * 단점
     * 1. 정수 열거 상수의 단점을 그대로 지닌다.
     * 2. 비트값이 그대로 출력되면 단순한 정수 열거 상수를 출력할 때보다 해석하기 훨씬 어렵다.
     * 3. 비트 필드 하나에 녹아있는 모든 원소를 순회하기도 까다롭다.
     * 4. 최대 몇 비트가 필요한지 API작성시 미리 예측하여 적절한 타입을 선택해야한다.
     */

    /**
     * 대안책
     * => java.util 패키지의 EnumSet 클래스를 사용하자.
     */
}
