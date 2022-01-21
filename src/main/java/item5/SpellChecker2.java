package item5;

/* 싱글턴을 잘못 사용한 예 */
public class SpellChecker2 {

    private final Lexicon dictionary = new Lexicon(); // Lexicon을 의존

    private SpellChecker2() {

    }
    public static SpellChecker2 INSTANCE = new SpellChecker2();
}

// => 실제로 SpeelCheck클래스는 여러 사전을 사용하는데 모든 쓰임에 대응할 수 없다.