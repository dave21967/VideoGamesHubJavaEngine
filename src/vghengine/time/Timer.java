package vghengine.time;

public class Timer extends Thread {
    private int waitTime;

    public Timer() {
        waitTime = 0;
    }

    public void setWaitTime(int t) {
        waitTime = t;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void run() {
        while(waitTime > 0) {
            waitTime--;
            try {
                Thread.sleep(1000);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
