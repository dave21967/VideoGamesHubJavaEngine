package vghengine.clock;

public class Timer extends Thread {
    private int waitTime;
    private int timeLeft;
    private boolean timeOut;

    public Timer(int wt) {
        setWaitTime(wt);
        setTimeLeft(wt);
        setTimeOut(false);
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int wt) {
        if(wt >= 0) {
            this.waitTime = wt;
        }
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int tl) {
        if(tl >= 0) {
            this.timeLeft = tl;
        }
    }

    public boolean isTimeOut() {
        return timeOut;
    }

    public void setTimeOut(boolean timeOut) {
        this.timeOut = timeOut;
    }

    @Override
    public void run() {
        while(!timeOut) {
            setTimeLeft(getTimeLeft() - 1);
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException ie) {

            }
        }
    }

    public void restart() {
        setTimeLeft(getWaitTime());
    }
}
