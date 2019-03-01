/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.entities;

import java.awt.Color;
import java.awt.Graphics;
import tilegame.Asset;
import tilegame.Game;
import tilegame.Handler;

/**
 *
 * @author Dell
 */
public class Player extends creature{
    public Player(Handler handler,float x,float y) {
    super(handler,x,y,creature.DEFAULT_CREATURE_WIDTH,creature.DEFAULT_CREATURE_HEIGHT);
    bounds.x=16;
    bounds.y=32;
    bounds.width=32;
    bounds.height=32;
    }

    @Override
    public void update() {
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }
    
    public void getInput()
    {
        xMove=0;
        yMove=0;
        
        if(handler.getKeyManager().up)
        {
            yMove=-speed;
        }
        if(handler.getKeyManager().down)
        {
            yMove=speed;
        }
        if(handler.getKeyManager().left)
        {
            xMove=-speed;
        }
        if(handler.getKeyManager().right)
        {
            xMove=speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.player,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),
                width,height,null);
        g.setColor(Color.red);
        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),bounds.width ,bounds.height);
        //Collision Detection Remaining
    }
    
    
    
}
