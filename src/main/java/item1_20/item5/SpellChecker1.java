package item1_20.item5;

/* 정적 유틸리티를 잘못 사용한 예 */
public class SpellChecker1 {

    private static final Lexicon dictionary = new Lexicon(); // Lexicon을 의존

    private SpellChecker1() {

    }
}

// => 실제로 SpeelCheck클래스는 여러 사전을 사용하는데 모든 쓰임에 대응할 수 없다.