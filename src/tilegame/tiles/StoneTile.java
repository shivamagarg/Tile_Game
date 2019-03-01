/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.tiles;

import java.awt.image.BufferedImage;
import tilegame.Asset;

/**
 *
 * @author Dell
 */
public class StoneTile extends Tiles {

    public StoneTile(int id) {
        super(Asset.rocks, id);
    }
    @Override
    public boolean isSolid()
    {
        return true;
    }
    
}
