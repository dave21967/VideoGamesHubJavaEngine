package vghengine.managers;

import com.sun.scenario.Settings;

import javax.sound.sampled.*;
import java.io.IOException;

/**
 * @author david
 * @version 1.0
 * @apiNote It takes only wav files
 */

public class SoundManager {
    private Clip clip;

    public SoundManager(String filename) {
        try {
            clip = AudioSystem.getClip();
            AudioInputStream is = AudioSystem.getAudioInputStream(getClass().getResource(filename));
            clip.open(is);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        clip.start();
    }

    public void stop() {
        clip.stop();
    }

    public boolean isRunning() {
        return clip.isRunning();
    }
}
