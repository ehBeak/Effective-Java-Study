package item2;

/*
 * 빌더 패턴은 계층적으로 설계된 클래스와 함께 쓰기에 좋다.
 * */

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// 추상 클래스는 추상 빌더를,
// 구체 클래스는 구체 빌더를 갖게 한다.
public abstract class Pizza {

    public enum Topping {
        HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
    }
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> { // 재귀적 타입 한정

        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // 하위 클래스에서는 형변환 하지 않고도 메서드 연쇄를 지원 == 시뮬레이트한 셀프 타입
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }



}
