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
import tilegame.entities.Player;
import tilegame.input.KeyManager;
import tilegame.tiles.Tiles;
import tilegame.world.World;

/**
 *
 * @author Dell
 */
public class GameState extends state {
    
    private Player player;
    private World world;
    private Handler handler;

    public GameState(Handler handler) {
        super(handler);
         world=new World(handler,"res/Worlds/world2.lvl");
         handler.setWorld(world);
         player=new Player(handler,20,20);
      
       
    }

    @Override
    public void update() {
      player.update();
      world.update();
      
    }

    @Override
    public void render(Graphics g) {
       world.render(g);
        
      // Tiles.tiles[0].render(g, 10, 10);
        player.render(g);
      
    }
    
}
