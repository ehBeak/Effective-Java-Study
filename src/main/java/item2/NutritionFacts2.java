package item2;

/*
* 자바빈즈 패턴 - 일관성이 깨지고, 불변으로 만들 수 없다.
* */
public class NutritionFacts2 {

    // 1. 매개변수들은 (기본값이 있다면) 기본값으로 초기화
    private int servingSize = -1;// 필수
    private int servings = -1; // 필수
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    // 2. 기본 생성자
    public NutritionFacts2() {
    }

    // 3. setter 메서드
    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {

        /* 인스턴스 생성 */
        NutritionFacts2 cocaCola = new NutritionFacts2();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);

        // ==> 객체 하나를 만드려면 여러개의 메서드를 호출해야함
        // ==> 객체가 완전히 생성되기 전까지는 일관성이 무너지 상태
        // ==> 클래스를 불변으로 만들 수 없음
    }
}
