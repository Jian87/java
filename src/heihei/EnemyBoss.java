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
public class EnemyBoss extends GameObject{
    
    private Handler handler;
    private int timer = 0;
    private int timer2 = 50;
    private Random r = new Random();
    public EnemyBoss(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        velX = 0;
        velY = 2;
        this.handler = handler;
    }
    
    public void tick() {
        x += velX;
        y += velY;
        
        if(timer <= 0) {
            velY = 0;
        } else {
            timer--;
        }
        
        if(timer <= 0) {
            timer2--;
        }
        
        if(timer2 <= 0) {
            if(velX == 0) {
                velX = 2;
            }
            
            int spawn = r.nextInt(10);
            if(spawn == 0) {
                handler.addObject(new Bullet((int)x+24, (int)y+24, ID.Bullet, handler));
            }
        }
        
        if(x < 0 || x >= Game.WIDTH - 64) {
            velX = -velX;
        }
        if(y < 0 || y >= Game.HEIGHT - 40) {
            velY = -velY;
        }
        
//        handler.addObject(new Trail(x, y, 64, 64, ID.Trail, handler, Color.red, 0.1f));
    }

    public void render(Graphics g) {
       g.setColor(Color.red);
       g.fillRect((int)x, (int)y, 64, 64);
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 64, 64);
    }
}

