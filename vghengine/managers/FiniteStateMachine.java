/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.managers;

import java.util.ArrayList;
import vghengine.entities.GameObject;

/**
 *
 * @author david
 */
public class FiniteStateMachine extends GameObject {
    private ArrayList<String> states;
    private String currentState;
    
    public FiniteStateMachine() {
        states = new ArrayList<>();
        currentState = "";
    }
    
    public void addState(String state) {
        states.add(state);
    }
    
    public String getState(String s) {
        String state = null;
        for(int i=0;i<states.size();i++) {
            if(states.get(i).equals(s)) {
                state = states.get(i);
                break;
            }
        }
        return state;
    }
    
    public void travel(String s) {
        setCurrentState(s);
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
}
