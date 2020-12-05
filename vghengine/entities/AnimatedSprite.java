package vghengine.entities;

import vghengine.animations.Animation;
import vghengine.math.Vector2;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AnimatedSprite extends Sprite {
    private List<Animation> animations;

    public AnimatedSprite(Vector2 pos, String img) {
        super(pos, img);
        animations = new ArrayList<Animation>();
    }

    public Animation getAnimationByName(String name) {
        Animation anim = null;
        for(int i=0;i<animations.size();i++) {
            if(animations.get(i).getName().equals(name)) {
                anim = animations.get(i);
                break;
            }
            else {
                anim = null;
                break;
            }
        }
        return anim;
    }

    public void addAnimation(Animation a) {
        animations.add(a);
    }

    public AnimatedSprite(Vector2 pos, BufferedImage txt) {
        super(pos, txt);
    }

    public void playAnimation(String name) {
        if(isVisible()) {
            getAnimationByName(name).play();
            setTexture(getAnimationByName(name).getTexture());
        }
    }
}
