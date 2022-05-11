package item1_20.item1;

public interface Type {

    // 그렇기 때문에 이름이 Type인 인터페이스를 반환하는 정적 메서드가 필요하면, "Types"라는 (인스턴스화 불가인)동반 클래스를 만들어 그 안에 정의하는 것이 관례였다.
    /*class Types {
        private static final Types instance = new Types();
//        private static final Type instance = new Types();

        private Types() {}

        public static Types getInstance() {
            return instance;
        }
    }*/
}
