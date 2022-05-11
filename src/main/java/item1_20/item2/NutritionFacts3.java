package item1_20.item2;

/*
* 빌더 패턴 - 점층적 생성자 패턴과 자바빈즈 패턴의 장점만 취했다.
* */
public class NutritionFacts3 {

    private final int servingSize; // 필수
    private final int servings; // 필수
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // 필수 매개변수 - final
        private final int servingSize;
        private final int servings;
        // 선택 매개변수 - 기본값으로 초기화
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        // 1. 필수 매개변수 만으로 Builder 생성자를 호출
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        // 2. 빌더 객체가 제공하는 일종의 세터 메서드들로 선택 매개변수 설정
        public Builder calories(int val) {
            calories = val;
            return this; // 연쇄적으로 호출 가능 ==> 플루언트 API, 메서드 연쇄
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        // 3. Builder 클래스 내에서 NutritionFacts3를 생성하는 함수
        public NutritionFacts3 build() {
            return new NutritionFacts3(this); // 생성자 호출
        }
    }

    // 4. private 생성자 (외부 호출 불가)
    private NutritionFacts3(Builder builder) {

        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;

    }

    public static void main(String[] args) {

        NutritionFacts3 nutritionFacts3
                = new NutritionFacts3.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
    }
}
