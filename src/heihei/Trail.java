/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heihei;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author lixua
 */
public class Trail extends GameObject {
    private float alpha = 1;
    private float life;
    
    private int width, height;
    
    private Handler handler;
    private Color color;
    
    public Trail(float x, float y, int width, int height, ID id, Handler handler, Color color, float life){
        super(x, y, id);
        this.width = width;
        this.height = height;
        this.handler = handler;
        this.color = color;
        this.life = life;
    }
    
    public void tick(){
        if(alpha > life) {
            alpha -= (life - 0.008f);
        } else {
            handler.removeObject(this);
        }
    }
    
    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        
        g.setColor(color);
        g.fillRect((int)x, (int)y, width, height);
        
        g2d.setComposite(makeTransparent(1));
    }
    
    public Rectangle getBounds(){
        return null;
    }

    private Composite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type, alpha));
    }
}
