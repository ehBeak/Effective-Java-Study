package item9;

import java.lang.ref.Cleaner;

public class SampleResourceCleaner implements AutoCloseable{

    private boolean closed;

    private static final Cleaner cleaner = Cleaner.create();
    private final Cleaner.Cleanable cleanable;

    private final CleanResource cleanResource;

    public SampleResourceCleaner() {
        this.cleanResource = new CleanResource();
        this.cleanable = cleaner.register(this, cleanResource);
    }

    private static class CleanResource implements Runnable {
        @Override
        public void run() {
            System.out.println("Clean");
        }
    }



    @Override
    public void close() throws Exception {
        if (this.closed) {
            throw new IllegalStateException();
        }
        this.closed=true;
        cleanable.clean();
        System.out.println("close");
    }


}
