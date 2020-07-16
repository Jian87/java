/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heihei;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author lixua
 */
public class Shop extends MouseAdapter {
    
    private Handler handler;
    private int B1 = 1000;
    private int B2 = 1000;
    private int B3 = 1000;
    private HUD hud;
    
    public Shop(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }
    
    public void render(Graphics g) {
        g.setColor(Color.white);
        
        Font fnt = new Font("arial", 0, 48);
        Font fnt2 = new Font("arial", 0, 12);

        g.setFont(fnt);
        g.drawString("Shop", Game.WIDTH / 2, 50);



        g.setFont(fnt2);
        
        g.drawString("Update Health", 110, 120);
        g.drawString("Cost: " + B1, 110, 140);
        g.drawRect(100, 100, 100, 80);

        
        g.drawString("Update Speed", 260, 120);
        g.drawString("Cost: " + B2, 260, 140);
        g.drawRect(250, 100, 100, 80);

        
        g.drawString("Update Health", 410, 120);
        g.drawString("Cost: " + B3, 410, 140);
        g.drawRect(400, 100, 100, 80);
        
        g.drawString("Score: " + hud.getScore(), Game.WIDTH / 2, 300);
        g.drawString("Click Space Back", Game.WIDTH / 2, 330);
    }
    
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        
        // box1, update health
        if(mx >= 100 && mx <= 200) {
            if(my >= 100 && my <= 180) {
//                System.out.println("Box1");
                if(hud.getScore() >= B1) {
                    hud.setScore(hud.getScore() - B1);
                    B1 += 1000;
                    hud.bounds += 20;
                    hud.HEALTH = (100 + (hud.bounds) / 2);
                }
            }
        }
        
        
        // box2
        if(mx >= 250 && mx <= 350) {
            if(my >= 100 && my <= 180) {
//                System.out.println("Box2");
                if(hud.getScore() >= B2) {
                    hud.setScore(hud.getScore() - B1);
                    B1 += 1000;
                    handler.spd++;
                }
                
            }
        }
        
        // box3
        if(mx >= 400 && mx <= 500) {
            if(my >= 100 && my <= 180) {
                if(hud.getScore() >= B3) {
                    hud.setScore(hud.getScore() - B1);
                    B1 += 1000;
                    hud.HEALTH = 100;
                }
            }
        }
    }
}
