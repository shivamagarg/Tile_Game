/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Dell
 */
public class Display {
    
    private JFrame jframe;

    public JFrame getJframe() {
        return jframe;
    }
    private Canvas canvas;

    public Canvas getCanvas() {
        return canvas;
    }
    private int width,height;
    private String name;
    
    public Display(String name,int width,int height){
        
        this.name=name;
        this.width=width;
        this.height=height;
        
        createFrame();
        
    }
    
    public final void createFrame(){
        jframe=new JFrame(name);
        jframe.setSize(width,height);
        jframe.setVisible(true);
        jframe.setResizable(true);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setFocusable(false);
              
        jframe.add(canvas);
        jframe.pack();
        
    }
    
}
