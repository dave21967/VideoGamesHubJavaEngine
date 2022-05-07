package vghengine.components;

import java.util.ArrayList;

public class Component {
    private ArrayList<Component> components;

    public Component() {
        components = new ArrayList<Component>();
    }

    public void addComponent(Component c) {
        components.add(c);
    }

    public Component getComponent(int index) {
        return components.get(index);
    }
}