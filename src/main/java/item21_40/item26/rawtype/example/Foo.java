package item21_40.item26.rawtype.example;

public class Foo {
    public static void main(String[] args) {
        Coin coin = new Coin();
        CollectionRaw collectionRaw = new CollectionRaw();
        collectionRaw.add(coin); // Stamp가 아닌 Coin을 add
        collectionRaw.useIterator(); // 컴파일 단계에서 오류가 나지 않지만, 런타임에서 ClassCastException을 던진다.
    }
}
