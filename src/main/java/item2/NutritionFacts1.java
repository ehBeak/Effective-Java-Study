package item2;

/*
* 점층적 생성자 패턴 - 확장하기 어렵다!
* */
public class NutritionFacts1 {

    // final -> 결국 매개변수가 모두 있는 생성자를 호출함
    private final int servingSize; // 필수
    private final int servings; // 필수
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    // 생성자 a
    public NutritionFacts1(int servingSize, int servings) {
        this(servingSize, servings, 0); // 생성자 b호출
    }

    // 생성자 b
    public NutritionFacts1(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories,0,0,0); // 생성자 호출
    }

    // 모든 매개변수를 가지고 있는 생성자
    public NutritionFacts1(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {

        /* 인스턴스 생성 */
        NutritionFacts1 cocaCola = new NutritionFacts1(240, 8, 100, 0, 35, 27);

        // ==> 매개변수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵다.
    }


}
