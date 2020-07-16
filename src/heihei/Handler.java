/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heihei;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author lixua
 */
public class Handler {
    public int spd = 5;
    LinkedList<GameObject> objects = new LinkedList<GameObject>();
    
    public void tick(){
        for(int i = 0; i < objects.size(); i++) {
            GameObject t = objects.get(i);
            t.tick();
        }
    }
    
    public void render(Graphics g) {
        for(int i = 0; i < objects.size(); i++) {
            GameObject t = objects.get(i);
            t.render(g);
        }
    }
    
    public void addObject(GameObject object) {
        this.objects.add(object);
    }
    
    public void removeObject(GameObject object) {
        this.objects.remove(object);
    }
    
    public void clearEnemys() {
        for(int i = 0; i < objects.size(); i++) {
            GameObject t = objects.get(i);
            if(t.getId() == ID.Player) {
                objects.clear();
                addObject(new Player(t.getX(), t.getY(), ID.Player, this));
            }
        }
    }
    
}
