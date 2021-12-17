package vghengine.entities;

import java.util.ArrayList;
import java.util.List;

public class GameObject {
    private List<GameObject> objects;

    public GameObject() {
        objects = new ArrayList<GameObject>();
    }

    public void addObject(GameObject obj) {
        objects.add(obj);
    }

    public void removeObject(int index) {
        objects.remove(index);
    }

    public void removeObject(GameObject go) {
        objects.remove(go);
    }

    public GameObject getObject(int index) {
        return objects.get(index);
    }
}
