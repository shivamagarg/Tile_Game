/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import tilegame.Game;
import tilegame.Handler;

/**
 *
 * @author Dell
 */
public abstract class entity {
     
    protected Handler handler;
     protected float x,y;
     protected int width,height;
     protected Rectangle bounds;
     
     public entity(Handler handler,float x,float y,int width,int height)
     {
         this.x=x;
         this.y=y;
         this.width=width;
         this.height=height;
         this.handler=handler;
         bounds=new Rectangle(0, 0, width, height);
     }
     public abstract void update();
     public abstract void render(Graphics g);
     

//Getters And Setters
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}
