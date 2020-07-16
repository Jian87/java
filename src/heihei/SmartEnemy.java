/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package heihei;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author lixua
 */
public class SmartEnemy extends GameObject{
    private Handler handler;
    private GameObject player;
    public SmartEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        for(int i = 0; i < handler.objects.size(); i++) {
            if(handler.objects.get(i).getId() == ID.Player) {
                player = handler.objects.get(i);
                break;
            }
        }
    }
    
    public void tick() {
        x += velX;
        y += velY;
        float diffx = x - player.getX() - 8;
        float diffy = y - player.getY() - 8;
        
        float distance = (float)Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY())*(y - player.getY()));
        
        velX = (float)((-1.0 / distance) * diffx);
        velY = (float)((-1.0 / distance) * diffy);
        
        
        if(x < 0 || x >= Game.WIDTH - 16) {
            velX = -velX;
        }
        if(y < 0 || y >= Game.HEIGHT - 40) {
            velY = -velY;
        }
        
        handler.addObject(new Trail(x, y, 16, 16, ID.Trail, handler, Color.green, 0.1f));
    }

    public void render(Graphics g) {
       g.setColor(Color.green);
       g.fillRect((int)x, (int)y, 16, 16);
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }
}
