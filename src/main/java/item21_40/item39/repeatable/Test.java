package item21_40.item39.repeatable;

import java.lang.annotation.*;

/**
 * 명시한 예외를 던져야만 성공하는 테스트 메서드용 에너테이션
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(TestContainer.class)
public @interface Test {
    Class<? extends Throwable> value();
}
