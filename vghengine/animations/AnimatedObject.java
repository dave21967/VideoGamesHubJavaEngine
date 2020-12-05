package vghengine.animations;

public abstract class AnimatedObject {
    private int delay;
    private int frame;

    public AnimatedObject() {
        setDelay(10);
        frame = 0;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void play() {
        frame++;
        if(frame%delay == 0) {
            this.update();
        }
    }

    public abstract void update();
}
