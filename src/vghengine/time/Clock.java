package vghengine.time;

public class Clock extends Thread {
    private int elapsed;
    private boolean stop;

    public Clock() {
        setElapsed(0);
        stop = false;
    }

    public void restart() {
        elapsed = 0;
    }

    @Override
    public void run() {
        while(!stop) {
            try {
                Thread.sleep(1000);
                elapsed++;
                System.out.println(elapsed);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getElapsed() {
        return elapsed;
    }

    public int getMilliseconds() {
        return elapsed / 1000;
    }

    public void setElapsed(int elapsed) {
        this.elapsed = elapsed;
    }
}
