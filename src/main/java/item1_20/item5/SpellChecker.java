package item1_20.item5;

import java.util.Objects;

/* 의존 객체 주입은 유연성과 테스트 용이성을 높여준다. */
public class SpellChecker {

    // private static final Lexicon dictionary; // 클래스가 생성되기 이전에 초기화.
    private final Lexicon dictionary;
    private final A a;

    public SpellChecker(Lexicon dictionary, A a) {
        this.dictionary = Objects.requireNonNull(dictionary);
        this.a = a;
    }

    public static void main(String[] args) {
        // SpellChecker(new Lexicon());
        SpellChecker spellChecker = new SpellChecker(new Lexicon(), new AA());
    }
}

//==> dictionary라는 딱 하나의 자원을 사용하지만, 자원이 몇 개든 의존관계가 어떻든 상관없이 잘 작동
