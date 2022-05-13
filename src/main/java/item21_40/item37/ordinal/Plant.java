package item21_40.item37.ordinal;

import java.util.*;
import java.util.stream.Collectors;

public class Plant {

    enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }

    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        // 정원에 심은 식물들을 배열 하나로 관리
        // 이들을 생애주기 별로 묶기

        // 생애주기별로 총 3개의 집합을 만들고
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[LifeCycle.values().length];
        for (int i=0; i<plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }

        Plant[] garden = new Plant[4];
        garden[1] = new Plant("p1", LifeCycle.ANNUAL);
        garden[2] =(new Plant("p2", LifeCycle.BIENNIAL));
        garden[3] =(new Plant("p3", LifeCycle.PERENNIAL));
        garden[4] =(new Plant("p4", LifeCycle.ANNUAL));

        // 정원을 한 바퀴 돌며 각 식물을 해당 집합에 넣는다.
        for (Plant p: garden) {
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }

        /////////////////////////////////////////////////////////////////////////
        //결과 출력 - for문
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }

        ////////////////////////////////////////////////////////////
        //결과 출력 - stream: EnumMap이 아닌 고유한 맵 구현체를 사용했기 때문에 EnumMap을 써서 얻는 공간과 성능 이점이 사라진다.
        System.out.println(Arrays.stream(garden)
                .collect(Collectors.groupingBy(p -> p.lifeCycle)));

        /**
         * ordinal 을 사용할때 문제점
         * 1. 배열은 제네릭과 호환되지 않아 비검사 형변환을 수행해야 하고 깔끔히 컴파일이 되지 않는다.
         * 2. 배열은 각 인덱스의 의미를 모르니 출력 결과에 직접 레이블을 달아야 한다.
         * 3. 정확한 정숫값을 사용한다는 것을 직접 보증해야한다.(타입 안전하지 않기 때문)
         */

        /**
         * 대안: EnumMap을 사용하자.
         */
    }



}
