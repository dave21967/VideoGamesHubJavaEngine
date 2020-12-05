package vghengine.tilemap;
import vghengine.entities.Tile;
import vghengine.managers.FileManager;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * @apiNote The txt file that composes the map, should be formatted like this
 * 2 2 //mapHeight and mapWidth;
 * 0 0
 * 0 0
 */

public class TileMap {
    private ArrayList<Tile> tilemap;
    private ArrayList<Tile> walls;
    private int mapWidth;
    private int mapHeight;

    public TileMap() {
        setMapWidth(10);
        setMapHeight(10);
        tilemap = new ArrayList<Tile>();
        walls = new ArrayList<Tile>();
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public void setMapHeight(int mapHeight) {
        this.mapHeight = mapHeight;
    }

    public String[][] getMapFromFile(String filename) {
        try {
            FileManager fm = new FileManager(filename, "r");
            String mapSize = fm.readLine();
            setMapHeight(Integer.parseInt(mapSize.split(" ")[0]));
            setMapWidth(Integer.parseInt(mapSize.split(" ")[1]));

            String[][] level = new String[this.mapHeight][this.mapWidth];

            for(int i=0;i<mapHeight;i++) {
                String line = fm.readLine();
                level[i] = line.split(" ");
            }
            fm.closeFile();
            return level;

        } catch(FileNotFoundException fnfe) {
            System.out.println("File non trovato");
            return null;
        } catch(IOException ioe) {
            return null;
        }
    }

    public void addTile(Tile t) {
        tilemap.add(t);
    }

    public void addWall(Tile t) {
        tilemap.add(t);
        walls.add(t);
    }

    public Tile getTile(int index) {
        return tilemap.get(index);
    }

    public Tile getWall(int index) {
        return walls.get(index);
    }
    
    public ArrayList<Tile> getWalls() {
        return walls;
    }
    
    public int getTilemapSize() {
        return tilemap.size();
    }

    public int getWallsSize() {
        return this.walls.size();
    }

    public void removeTile(int index) {
        tilemap.remove(index);
    }

    public void draw(Graphics g) {
        for(int i=0;i<tilemap.size();i++) {
            g.drawImage(tilemap.get(i).getTexture(), (int)tilemap.get(i).getX(), (int)tilemap.get(i).getY(), null);
        }
    }
}
