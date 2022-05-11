package item21_40.item36.enumset;

import java.util.EnumSet;
import java.util.Set;

// EnumSet - 비트 필드를 대체하는 현대적 기법
public class Text {

    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    // 매개변수가 EnumSet<Style>이 아닌, Set<Style>인 이유는 인터페이스로 받는 것이 좋은 습관이기 때문이다.
    public void applyStyles(Set<Style> styles) {

    }

    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }

    /**
     * 장점
     * 1. Set 인터페이스를 완전히 구현하고 타입 안전
     * 2. 다른 Set 구현체와도 함께 사용할 수 있다.
     * 3. EnumSet의 내부는 비트 벡터로 구현되어있어, 원소가 64개 이하라면 비트필드에 비견되는 성능을 보여줌
     * 4. 비트를 직접 다룰 때 흔히 겪는 오류들에서 해방된다.
     */
}
