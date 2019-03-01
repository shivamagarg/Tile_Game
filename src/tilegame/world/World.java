/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.world;

import java.awt.Graphics;
import tilegame.Game;
import tilegame.Handler;
import tilegame.tiles.Tiles;
import tilegame.utils.Utils;

/**
 *
 * @author Dell
 */
public class World {
    
    private int width,height;
    private int[][] blocks;
    private int spawnX,spawnY;
    private Handler game;
    public World(Handler handler,String path)
    {
        this.game=handler;
        loadWorld(path);
    }
    public void update()
    {
        
    }
    public void render(Graphics g)
    {
        int xStart=(int)Math.max(0, game.getGameCamera().getxOffset() / Tiles.TILE_WIDTH);
        int xEnd=(int)Math.min(width, (game.getGameCamera().getxOffset() +game.getWidth()) / Tiles.TILE_WIDTH + 1);
        int yStart=(int)Math.max(0, game.getGameCamera().getyOffset() / Tiles.TILE_HEIGHT);
        int yEnd=(int)Math.min(height, (game.getGameCamera().getyOffset() +game.getHeight()) / Tiles.TILE_HEIGHT + 1);
        for(int y=yStart;y<yEnd;y++)
        {
            for(int x=xStart;x<xEnd;x++)
            {
                getTile(x,y).render(g,(int) (x*Tiles.TILE_WIDTH-game.getGameCamera().getxOffset()),
                        (int)(y*Tiles.TILE_HEIGHT - game.getGameCamera().getyOffset()));
            }
        }
    }
    public Tiles getTile(int x,int y)
    {
        if(x<0||y<0||x>=width||y>=height)
        {
            return Tiles.grassTile;
        }
        
        Tiles t=Tiles.tiles[blocks[x][y]];
        if(t==null)
        {
            return Tiles.dirtTile;
        }
        else
        {
            return t;
        }
    }
    public void loadWorld(String path)
    {
       String file=Utils.loadfileasString(path);
       String []tokens=file.split("\\s");//DEnoting space bar spaces!!
       width=Utils.parseInt(tokens[0]);
       height=Utils.parseInt(tokens[1]);
       spawnX=Utils.parseInt(tokens[2]);
       spawnY=Utils.parseInt(tokens[3]);
       
       blocks=new int[width][height];
       
       for(int y=0;y<height;y++)
       {
           for(int x=0;x<width;x++)
           {
               blocks[x][y]=Utils.parseInt(tokens[(x+y*width)+4]);
           }
       }
       
    }
    
}
