/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heihei;

import java.util.Random;

/**
 *
 * @author lixua
 */
public class Spawn {
    
    private int scoreKeep = 0;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }
    
    public void tick(){
        scoreKeep++;
        if(scoreKeep >= 200) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
//            int l = hud.getLevel();
            
//            switch (l) {
//                case 2:
//                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
//                    break;
//                case 3:
//                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
//                    break;
//                case 4:
//                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
//                    break;
//                case 5:
//                    handler.clearEnemys();
//                    handler.addObject(new EnemyBoss((Game.WIDTH / 2)-48, 0, ID.BasicEnemy, handler));
//                    break;
//                default:
//                    break;
//            }
        }
    }
}
