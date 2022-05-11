package item21_40.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favorites {

    // 키가 와일드카드 타입
    private Map<Class<?>, Object> favorites = new HashMap<>();
//    private Map<K, V> f = new HashMap<>();


    // Class 객체를 매개변수화한 키 역할로 사용, 이 방식이 동작하는 이유는 class의 클래스가 제네릭이기 때문
    public <T> void putFavorite(Class<T> type, T instance) {
//        favorites.put(Objects.requireNonNull(type), instance);
        favorites.put(Objects.requireNonNull(type), type.cast(instance)); //동적 형변환
    }

    public <T> T getFavorite(Class<T> type) {
        // Object인 객체 타입을 T로 바꿔 변환하자
        return type.cast(favorites.get(type));
    }

    public static void main(String[] args) {
        Favorites f = new Favorites();

        f.putFavorite(String.class, "JAVA");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);
        Integer favoriteInteger = f.getFavorite(Integer.class);
        Class favoriteClass = f.getFavorite(Class.class);

        System.out.println("favoriteString = " + favoriteString);
        System.out.println("favoriteInteger = " + favoriteInteger);
        System.out.println("favoriteClass = " + favoriteClass);
    }
}
