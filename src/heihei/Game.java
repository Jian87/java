/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heihei;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 *
 * @author lixua
 */
public class Game extends Canvas implements Runnable{
    
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Random r;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;
    public static boolean pause = false;
    public int dif = 0;
    private Shop shop;
    // 0  norma;
    // 1  hard;
    
    public enum STATE {
        Menu,
        Select,
        Help,
        Shop,
        End,
        Game
    }
    
    public STATE gameState = STATE.Menu;
    
    
    public Game() {
        handler = new Handler();
        hud = new HUD();
        shop = new Shop(handler, hud);
        menu = new Menu(this, handler, hud);
        this.addKeyListener(new KeyInput(handler, this));
        this.addMouseListener(menu);
        this.addMouseListener(shop);
        
        
        new Window(WIDTH, HEIGHT, "Game Test", this);
        
        spawner = new Spawn(handler, hud);
        
        r = new Random();
        
        if(gameState == STATE.Game) {
            handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
        } else {
            for(int i = 0; i < 10; i++) {
                handler.addObject(new MenuPatical(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuPatical, handler));
            }
        }
        
       
    }
    
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta > 0) {
                tick();
                delta--;
            }
            if(running) {
                render();
            }
            
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
//                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    
    private void tick(){
        
        if(gameState == STATE.Game) {
            if(!pause) {
                handler.tick();
                hud.tick();
                spawner.tick();
                if(HUD.HEALTH <= 0) {
                    HUD.HEALTH = 100;
                    gameState = STATE.End;
                    handler.objects.clear();
                    for(int i = 0; i < 10; i++) {
                        handler.addObject(new MenuPatical(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuPatical, handler));
                    }


                }
            }
            
        } else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Select) {
            menu.tick();
            handler.tick();
        }
        
        
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        
        
        if(pause) {
            g.drawString("Paused", 100, 100);
        }
        
        if(gameState == STATE.Game) {
            handler.render(g);
            hud.render(g);
        } else if(gameState == STATE.Shop) {
            shop.render(g);
        } else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select) {
            handler.render(g);
            menu.render(g);
        }
        
        
        g.dispose();
        bs.show();
    }
    
    public static float clamp(float val, float min, float max) {
        if(val >= max) {
            return val = max;
        } else if(val <= min) {
            return val = min;
        } else {
            return val;
        }
    }
    
    public static void main(String[] args) {
        new Game();
    }
}
