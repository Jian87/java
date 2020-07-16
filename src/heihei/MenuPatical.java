/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heihei;

/**
 *
 * @author lixua
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author lixua
 */
public class MenuPatical extends GameObject{
    
    private Handler handler;
    private Random r = new Random();
    private Color color;
    public MenuPatical(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        velX = (r.nextInt(5 - -5) + -5);
        velY = (r.nextInt(5 - -5) + -5);
        if(velX == 0) {
            velX = 3;
        }
        
        if(velY == 0) {
            velY = 3;
        }
        this.handler = handler;
        this.color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }
    
    public void tick() {
        x += velX;
        y += velY;
        if(x < 0 || x >= Game.WIDTH - 16) {
            velX = -velX;
        }
        if(y < 0 || y >= Game.HEIGHT - 40) {
            velY = -velY;
        }
        
        handler.addObject(new Trail(x, y, 16, 16, ID.Trail, handler, color, 0.03f));
    }

    public void render(Graphics g) {
       g.setColor(color);
       g.fillRect((int)x, (int)y, 16, 16);
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }
}
