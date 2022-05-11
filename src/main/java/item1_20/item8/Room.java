package item1_20.item8;

import java.lang.ref.Cleaner;

/* cleaner을 안전망으로 활용하는 AutoCloseable 클래스*/
public class Room implements AutoCloseable {

    private static final Cleaner cleaner = Cleaner.create(); // cleaner 생성

    // 청소가 필요한 자원, 절대 Room을 참조해서는 안 된다!
    // ==> cleaner가 방을 청소할 때 수거할 자원들을 담고 있음
    private static class State implements Runnable {
        int numJunkPiles; // 방(Room)안의 쓰레기 수(수거할 방안의 쓰레기 수)

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        //close메소드나 cleaner가 호출된다.
        @Override
        public void run() {
            System.out.println("방 청소");
            numJunkPiles = 0;
        }
    }

    private final State state; // 방의 상태, cleanable 과 공유한다.
    private final Cleaner.Cleanable cleanable;// cleanable 객체, 수거 대상이 되면 방을 청소한다.

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }


    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}

// 더 현실적으로 만들려면 이 필드는 네이티브 피어를 가리키는 포인터를 담은 final long변수여야 한다.