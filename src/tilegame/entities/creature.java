/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.entities;

import java.awt.Graphics;
import tilegame.Game;
import tilegame.Handler;

/**
 *
 * @author Dell
 */
public abstract class creature extends entity {
    
    public static final int DEFAULT_HEALTH=10;
    public static final float DEFAULT_SPEED=3.0f;
    public static final int DEFAULT_CREATURE_WIDTH=60,
                            DEFAULT_CREATURE_HEIGHT=60;
    protected int health;
    protected float speed;
    protected float xMove,yMove;
    

    @Override
    public abstract void render(Graphics g);

    @Override
    public abstract void update();
    public creature(Handler handler,float x,float y,int width,int height) {
        super(handler,x,y,width,height);
        health=DEFAULT_HEALTH;
        speed=DEFAULT_SPEED;
        xMove=0;
        yMove=0;
    }
    
    public void move()
    {
        x+=xMove;
        y+=yMove;
    }
    
    
    
    
    
    
    
    
    
 //Getters And Setters
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    
    
    
    
}
