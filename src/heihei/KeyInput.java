/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heihei;

import heihei.Game.STATE;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author lixua
 */
public class KeyInput extends KeyAdapter {
 
    private Handler handler;
    private boolean[]keyDown = new boolean[4];
    private Game game;
    public KeyInput(Handler handler, Game game) {
        this.handler = handler;
        this.game = game;
        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
    }   
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.objects.size(); i++) {
            GameObject t = handler.objects.get(i);
            if(t.getId() == ID.Player) {
                if(key == KeyEvent.VK_W) {
                    t.setVelY(-handler.spd);
                    keyDown[0] = true;
                } 
                else if(key == KeyEvent.VK_S) {
                    t.setVelY(handler.spd);
                    keyDown[1] = true;
                }
                
                else if(key == KeyEvent.VK_D) {
                    t.setVelX(handler.spd);
                    keyDown[2] = true;
                }
                
                else if(key == KeyEvent.VK_A) {
                    t.setVelX(-handler.spd);
                    keyDown[3] = true;
                }
            }
        }
        
        if(key == KeyEvent.VK_P) {
            if(game.gameState == STATE.Game) {
                if(game.pause) {
                    game.pause = false;
                } else {
                    game.pause = true;
                }
            }
            
        }
        
        if(key == KeyEvent.VK_ESCAPE) System.exit(1);
        
        if(key == KeyEvent.VK_SPACE) {
            if(game.gameState == STATE.Game) {
                game.gameState = STATE.Shop;
            } else if(game.gameState == STATE.Shop) {
                game.gameState = STATE.Game;
            }
        }
    }
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for(int i = 0; i < handler.objects.size(); i++) {
            GameObject t = handler.objects.get(i);
            if(t.getId() == ID.Player) {
                if(key == KeyEvent.VK_W) {
                    t.setVelY(0);
                    keyDown[0] = false;
                } 
                else if(key == KeyEvent.VK_S) {
                    t.setVelY(0);
                    keyDown[1] = false;
                }
                else if(key == KeyEvent.VK_D) {
                    t.setVelX(0);
                    keyDown[2] = false;
                }
                else if(key == KeyEvent.VK_A) {
                    t.setVelX(0);
                    keyDown[3] = false;
                }
                
                if(!keyDown[0] && !keyDown[1]) {
                    t.setVelY(0);
                }
                if(!keyDown[2] && !keyDown[3]) {
                    t.setVelX(0);
                }
            }
            
            
        }
    }
}
