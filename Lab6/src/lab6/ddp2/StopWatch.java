package lab6.ddp2;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        startTime = System.currentTimeMillis();
        endTime = startTime;
    }

    public void start() {
    startTime = System.currentTimeMillis();
    }

    public void stop() {
    endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }
}
