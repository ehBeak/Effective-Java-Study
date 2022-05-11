package item1_20.item5;

import java.util.Objects;

/* 빌더에 적용한 의존 객체 주입 */
public class SpellChecker3 {

    // 필수 매개변수
    private final Lexicon dictionary;
    private final int page;
    // 선택 매개변수
    private int count;

    // Builder 클래스
    public static class Builder {
        // 필수 매개변수
        private final Lexicon dictionary;
        private final int page;
        // 선택 매개변수 - 기본 값으로 초기화
        private int count = 0;

        public Builder(Lexicon dictionary, int page) { // 의존 객체 주입
            this.dictionary = Objects.requireNonNull(dictionary);
            this.page = Objects.requireNonNull(page);
        }

        public Builder count(int count) {
            this.count = count;
            return this;
        }

        public SpellChecker3 build() {
            return new SpellChecker3(this);
        }

    }

    private SpellChecker3(Builder builder) {
        this.dictionary = builder.dictionary;
        this.page = builder.page;
    }

    public static void main(String[] args) {

        SpellChecker3 spellChecker3 =
                new Builder(new Lexicon(), 3)
                .count(1)
                .build();
    }

}
