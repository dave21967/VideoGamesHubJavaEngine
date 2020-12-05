package vghengine.tilemap;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage sheet;

    public SpriteSheet(String filename) {
        try {
            this.sheet = ImageIO.read(getClass().getResource(filename));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public SpriteSheet(BufferedImage txt) {
        this.sheet = txt;
    }

    public BufferedImage getSubTexture(int x, int y, int w, int h) {
        return this.sheet.getSubimage(x, y, w, h);
    }
}
