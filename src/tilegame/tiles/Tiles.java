/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Dell
 */
public class Tiles {
    
    //Static Stuffe Here
    public static Tiles[] tiles=new Tiles[256];
    public static Tiles grassTile=new GrassTile(0);
    public static Tiles dirtTile=new DirtTile(1);
    public static Tiles stoneTile=new StoneTile(2);
    
    
    //Class
    public static final int TILE_WIDTH=60,TILE_HEIGHT=60;
    protected BufferedImage bufferedImage;
    protected final int id;
    
    public Tiles(BufferedImage bufferedImage,int id)
    {
        this.bufferedImage=bufferedImage;
        this.id=id;
        
        tiles[id]=this;
    }
    
    
    public void update()
    {
        
    }
    public boolean isSolid()
    {
        return false;
    }
    public void render(Graphics g,int x,int y)
    {
        g.drawImage(bufferedImage, x, y,TILE_WIDTH ,TILE_HEIGHT,null);
    }
    public int getid()
    {
        return id;
    }
    
}
