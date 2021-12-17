package vghengine.clock;

import java.util.concurrent.TimeUnit;

public class Clock extends Thread {
    private int elapsed;
    private boolean stop;

    public Clock() {
        setElapsed(0);
        setStop(false);
    }

    @Override
    public void run() {
        while(!this.stop) {
            this.elapsed++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getElapsedAsSeconds() {
        return elapsed;
    }
    
    public double getMilliseconds() {
        return elapsed*1000;
    }

    public void setElapsed(int elapsed) {
        this.elapsed = elapsed;
    }

    public boolean isStop() {
        return stop;
    }

    public void stopClock() {
        setStop(true);
    }

    public void restart() {
        setElapsed(0);
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
