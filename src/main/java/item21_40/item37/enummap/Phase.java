package item21_40.item37.enummap;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Phase {
    SOLID, LIQUID, GAS, PLASMA;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, LIQUID),

        IONIZE(GAS, PLASMA), DEIONIZE(PLASMA, GAS);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        // key:SOLID  value:[SOLID,MELT(SOLID,LIQUID)]
        // 이전 상태와 '이후 상태에서 전이로의 맵'에 대응시키는 맵
        // 이전상태: SOLID  이후 상태: LIQUID  전이: MELT
        private static final Map<Phase, Map<Phase, Transition>> m =
                Stream.of(values())
                .collect(Collectors.groupingBy(t -> t.from, () -> new EnumMap<>(Phase.class), // EnumMap
                        Collectors.toMap(t -> t.to, t -> t, (x, y) -> y, () -> new EnumMap<>(Phase.class))
                ));

        public static Transition from(Phase from, Phase to) {
            return m.get(from).get(to);
        }
    }

}
