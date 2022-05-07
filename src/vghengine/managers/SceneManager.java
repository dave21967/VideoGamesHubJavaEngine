package vghengine.managers;

import vghengine.gui.Scene;

import java.util.HashMap;

public class SceneManager {
    private HashMap<String, Scene> scenes;

    public SceneManager() {
        scenes = new HashMap<String, Scene>();
    }

    public void addScene(String sceneName, Scene scene) {
        scenes.put(sceneName, scene);
    }

    public Scene getScene(String name) {
        return scenes.get(name);
    }
}
