package item42.operation;

import java.util.function.DoubleBinaryOperator;

public enum OperationLambda {

    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator operator;

    OperationLambda(String symbol, DoubleBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public double apply(double x, double y) {
        return operator.applyAsDouble(x, y);
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static void main(String[] args) {
        OperationLambda op = OperationLambda.PLUS;
        op.apply(1, 2);
    }
}

/**
 * 위와 같이 람다식으로 바꿀 수 있음
 * 이름 보면 상수별 클래스 몸체를 사용할 이유가 없다고 느껴질지 모르지만, 꼭 그렇지는 않다.
 * 람다는 이름이 없고 문서화도 못하기 때문이다.
 * 따라서 코드 자체로 동작이 명확히 설명되지 않거나 코드 줄 수가 많아지면 람다를 쓰지 말아야한다.
 */
