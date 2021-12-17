package vghengine.managers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class TextureLoader {
    public TextureLoader() {

    }

    public BufferedImage loadFromFile(String filename) {
        try {
            BufferedImage bi  = ImageIO.read(getClass().getResource(filename));
            return bi;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
