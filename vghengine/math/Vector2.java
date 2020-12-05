/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.math;

/**
 *
 * @author david
 */
public class Vector2 {
    public double x;
    public double y;
    
    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Vector2(Vector2 v) {
        this.x = v.x;
        this.y = v.y;
    }
    
    public boolean equals(Vector2 vector) {
        if(this.x == vector.x && this.y == vector.y) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public String toString() {
        return "x: "+String.valueOf(this.x)+" y: "+String.valueOf(this.y);
    }
}
