/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.states;

import java.awt.Graphics;
import tilegame.Asset;
import tilegame.Game;
import tilegame.Handler;

/**
 *
 * @author Dell
 */
public class settings extends state {

    public static int x=1;
    public settings(Handler handler)
    {
        super(handler);
    }
    @Override
    public void update() {
        x+=1;
    }

    @Override
    public void render(Graphics g) {
       g.drawImage(Asset.player, x, 0, null);
    }
    
}
