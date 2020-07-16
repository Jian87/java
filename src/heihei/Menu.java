/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heihei;

import static heihei.Game.HEIGHT;
import heihei.Game.STATE;
import static heihei.Game.WIDTH;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 *
 * @author lixua
 */
public class Menu extends MouseAdapter{
    private Game game;
    private Handler handler;
    private Random r = new Random();
    private HUD hud;
    
    public Menu(Game game, Handler handler, HUD hud) {
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        
        if(game.gameState == STATE.Menu) {
            // play
            if(mouseOver(mx, my, 210, 150, 200, 64)) {
                game.gameState = STATE.Select;
                return;
            }

            if(mouseOver(mx, my, 210, 250, 200,64)) {
                game.gameState = STATE.Help;
            }
            // quit
            if(mouseOver(mx, my, 210, 350, 200, 64)) {
                System.exit(1);
            }
        } else if(game.gameState == STATE.Select) {
            // normal
            if(mouseOver(mx, my, 210, 150, 200, 64)) {
                game.gameState = STATE.Game;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemys();
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                
                game.dif = 0;
            }
            // hard
            if(mouseOver(mx, my, 210, 250, 200,64)) {
                game.gameState = STATE.Game;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemys();
                handler.addObject(new EnemyBoss((Game.WIDTH / 2)-48, 0, ID.EnemyBoss, handler));
                
                game.dif = 1;
                
            }
            // back
            if(mouseOver(mx, my, 210, 350, 200, 64)) {
                if(mouseOver(mx, my, 210, 350, 200, 64)) {
                    game.gameState = STATE.Menu;
                    return;
                }
            }
        }
        
        // back button
        if(game.gameState == STATE.Help) {
            if(mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = STATE.Menu;
                return;
            }
        }
        
        
        // try again button
        if(game.gameState == STATE.End) {
            if(mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = STATE.Menu;
                hud.setLevel(1);
                hud.setScore(0);
//                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
//                handler.clearEnemys();
//                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            }
        }
    }
    
    public void mouseReleased(MouseEvent e) {
        
    }
    
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if(mx > x && mx < x + width) {
            if(my > y && my < y + height) {
                return true;
            }
        }
        return false;
    }
    
    public void tick() {
        
    }
    
    public void render(Graphics g) {
        
        if(game.gameState == STATE.Menu) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 240, 70);



            g.setFont(fnt2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 280, 190);

            g.drawRect(210, 250, 200, 64);
            g.drawString("Help", 280, 290);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 280, 390);
        } else if(game.gameState == STATE.Help) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);
            
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 240, 70);
            
            g.setFont(fnt3);
            g.drawString("Use WASD keys to move player and escape from enemys", 50, 200);
            
            g.setFont(fnt2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Back", 280, 390);
        }else if(game.gameState == STATE.End) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);
            
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Game Over", 180, 70);
            
            g.setFont(fnt3);
            g.drawString("You Lost with a score of: " + hud.getScore(), 175, 200);
            
            g.setFont(fnt2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Try Again", 245, 390);
        } else if(game.gameState == STATE.Select) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Select Level", 240, 70);



            g.setFont(fnt2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Normal", 280, 190);

            g.drawRect(210, 250, 200, 64);
            g.drawString("Hard", 280, 290);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Back", 280, 390);
        }
        
    }
    
    
}
