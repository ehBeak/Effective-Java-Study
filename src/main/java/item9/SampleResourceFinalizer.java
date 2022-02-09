package item9;

public class SampleResourceFinalizer implements AutoCloseable {

    private boolean closed;

    @Override
    public void close() throws Exception {
        if (this.closed) {
            throw new IllegalStateException();
        }
        this.closed=true;
        System.out.println("close");
    }

    /* 안전망 */
    @Override
    protected void finalize() throws Throwable {
        if(!this.closed) close();
    }
}
