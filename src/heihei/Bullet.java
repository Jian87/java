/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heihei;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author lixua
 */
public class Bullet extends GameObject {
    
    private Handler handler;
    private Random r = new Random();
    public Bullet(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        velX = r.nextInt(5 - -5) +  (-5);
        velY = 5;
        this.handler = handler;
    }
    
    public void tick() {
        x += velX;
        y += velY;
//        if(x < 0 || x >= Game.WIDTH - 16) {
//            velX = -velX;
//        }
//        if(y < 0 || y >= Game.HEIGHT - 40) {
//            velY = -velY;
//        }

        if(y >= Game.HEIGHT) handler.removeObject(this);
        
//        handler.addObject(new Trail(x, y, 16, 16, ID.Trail, handler, Color.white, 0.1f));
    }

    public void render(Graphics g) {
       g.setColor(Color.white);
       g.fillRect((int)x, (int)y, 16, 16);
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }
}
