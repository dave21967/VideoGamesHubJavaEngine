package vghengine.animations;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Animation {
    private String name;
    private List<BufferedImage> frames;
    private BufferedImage texture;
    private int frame;
    private int index;
    private int delay;

    public Animation(String n, int d) {
        setName(n);
        index = 0;
        frame = 0;
        delay = d;
        frames = new ArrayList<BufferedImage>();
    }

    public void addFrame(String file) {
        try {
            frames.add(ImageIO.read(getClass().getResource(file)));
        }
        catch(IOException ioe) {

        }
    }

    public void addFrame(BufferedImage bi) {
        frames.add(bi);
    }

    public void play() {
        frame++;
        if(frame%delay == 0) {
            if(index == frames.size()-1) {
                index = 0;
            }
            else {
                index++;
            }
        }
        setTexture(frames.get(index));
    }

    public void setTexture(BufferedImage i) {
        texture = i;
    }

    public BufferedImage getTexture() {
        return this.texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
