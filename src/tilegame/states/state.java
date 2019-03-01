/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.states;

import java.awt.Graphics;
import tilegame.Game;
import tilegame.Handler;

/**
 *
 * @author Dell
 */

public abstract class state {
    
    private static state currentState=null; 
    public static state getState() {
        return currentState;
    }

    public static void setState(state currentState) {
        state.currentState = currentState;
    }
  
    private Handler handler;
    public state(Handler handler)
    {
        this.handler=handler;
    }
    
    //Class
    
    public abstract void update();
    public abstract void render(Graphics g);
    
}
