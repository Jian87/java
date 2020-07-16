
package heihei;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author lixua
 */
public class FastEnemy extends GameObject{
    private Handler handler;
    public FastEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        velX = 2;
        velY = 8;
        this.handler = handler;
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
        
        handler.addObject(new Trail(x, y, 16, 16, ID.Trail, handler, Color.cyan, 0.1f));
    }

    public void render(Graphics g) {
       g.setColor(Color.cyan);
       g.fillRect((int)x, (int)y, 16, 16);
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }
}
