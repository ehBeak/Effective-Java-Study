package item21_40.item37.enummap;

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
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }

        Plant[] garden = new Plant[4];
        garden[1] = new Plant("p1", Plant.LifeCycle.ANNUAL);
        garden[2] =(new Plant("p2", LifeCycle.BIENNIAL));
        garden[3] =(new Plant("p3", LifeCycle.PERENNIAL));
        garden[4] =(new Plant("p4", Plant.LifeCycle.ANNUAL));


        // 정원을 한 바퀴 돌며 각 식물을 해당 집합에 넣는다.
        for (Plant p: garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }

        //결과 출력
        System.out.println(plantsByLifeCycle);

        //결과 출력 - stream
        System.out.println(Arrays.stream(garden)
                .collect(Collectors.groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(LifeCycle.class), Collectors.toSet())));

        /**
         * EnumMap의 장점
         * 1. ordinal과 비교했을때 성능이 비등함(EnumMap도 배열을 사용하기 때문에)
         * 2. 직접 레이블 달 필요 없음
         * 3. 배열 인덱스를 계산하는 과정에서 오류가 날 가능성 없음
         */
    }



}
