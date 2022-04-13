package item24.inner.calculator;

import java.util.AbstractMap;

public class Calculator {

    public static Operation operation; // 정적 멤버 클래스?

    public static enum Operation2 {
        PLUS("+") {
            public double apply(double x, double y) { return x+y; }
        },

        MINUS("-") {
            public double apply(double x, double y) { return x-y; }
        },

        TIMES("*") {
            public double apply(double x, double y) { return x*y; }
        },

        DIVIDE("/") {
            public double apply(double x, double y) { return x/y; }
        };

        private final String symbol;

        Operation2(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return "Operation{" +
                    "symbol='" + symbol + '\'' +
                    '}';

        }
    }
}
