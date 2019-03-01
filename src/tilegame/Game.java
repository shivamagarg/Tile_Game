/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame;
import tilegame.states.*;

import java.awt.Graphics ;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import tilegame.input.KeyManager;

/**
 *
 * @author Dell
 */
public class Game implements Runnable{
    
    public String name;
    private int width,height;
    private Display display;
    public Thread thread;
    private BufferStrategy bs;
    private Graphics g;
    private Asset asset;
    private boolean running=false;
    //States
    public state State;
    private GameState gameState;
    private settings settingsState;
    
    //Input
    public KeyManager keyManager;
    
    //GameCamera
    private GameCamera gameCamera;
    
    //Handler
    private Handler handler;

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }
    
    public Game(String name,int width,int height){
        
        this.name=name;
        this.width=width;
        this.height=height;
        
        keyManager=new KeyManager();
        
        
    }
    
    public synchronized void start(){
        if(running){
            return;
        }
        running=true;
        thread=new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        if(!running){
            return;
        }
        running=false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  private int x=1;  
    @Override
    public void run() {
        init();
        int fps=60;
        double timeperupdate=1000000000.0/fps;
        double delta=0;
        long now;
        long lastTime=System.nanoTime();
        long timer=0;
        long updates=0;
        while(running){
            now=System.nanoTime();
            delta +=(now-lastTime)/timeperupdate;
            timer +=(now-lastTime);
            lastTime=now;
            
            if(delta>=1){
               
                update();
                
                render();
                updates++;
                delta--;
            }
          if(timer>=1000000000){
              System.out.println("Updates And Frames:"+updates);
              updates=0;
              timer=0;
          }
        }
        
        stop();
    }
    
    public void init(){
        display=new Display(name, width, height);
        display.getJframe().addKeyListener(keyManager);
        
        asset.init();
        gameCamera= new GameCamera(this,0,0); 
        
        handler=new Handler(this);
        
        gameState=new GameState(handler);
        settingsState=new settings(handler);
        
        State=gameState;
        state.setState(State);
         }
    
    public void update(){
        keyManager.update();
      if(state.getState()!=null)
      {
          state.getState().update();
      }
    }
    public void render(){
        
        bs=display.getCanvas().getBufferStrategy();//Create buffers and buffers are used for drawing
        if(bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g=bs.getDrawGraphics();//Graphics it is act like a magical paint brush for drwing in java here drawing on buffers.
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw Here!
        if(state.getState()!=null)
        {
            state.getState().render(g);
        }
        //End Drawing!
        bs.show();
        g.dispose();
        
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
