/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heihei;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author lixua
 */
public class Player extends GameObject {
    Random r = new Random();
    private Handler handler;
    public Player(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public void tick() {
        x += velX;
        y += velY;
        
        x = Game.clamp(x, 0, Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 64);
        collision();
    }
    
    public void collision(){
        for(int i = 0; i < handler.objects.size(); i++) {
            GameObject t = handler.objects.get(i);
            
            // collision code
            if(t.id == ID.BasicEnemy || t.id == ID.FastEnemy || t.id == ID.Bullet || t.id == ID.EnemyBoss) {
                if(getBounds().intersects(t.getBounds())) {
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    public void render(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g; // can be used to draw bounds
        if(this.id == ID.Player) {
            g.setColor(Color.WHITE);
        } else if(this.id == ID.Player2) {
            g.setColor(Color.blue);
        }
        g.fillRect((int)x, (int)y, 32, 32);
        
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
}
