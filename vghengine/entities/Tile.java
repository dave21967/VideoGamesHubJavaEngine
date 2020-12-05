/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.entities;

import vghengine.math.Vector2;

import java.awt.image.BufferedImage;

/**
 *
 * @author david
 */
public class Tile extends Sprite {
    
    public Tile(Vector2 pos, Vector2 dimension, String img) {
        super(pos, img);
    }

    public Tile(Vector2 pos, BufferedImage txt) {
        super(pos, txt);
    }
}
