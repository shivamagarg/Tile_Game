/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame;

import java.awt.image.BufferedImage;


/**
 *
 * @author Dell
 */
public class Asset {
    
    public static BufferedImage player,tree,grass,dirt,rocks;
    public static final int width=28,height=29;
    public static void init(){
        spritesheet sheet=new spritesheet(ImageLoader.loadImage("/textures/sheet.png"));
        player=sheet.crop(130, 3, width, height);
        tree=sheet.crop(0,0, width, height);
        grass=sheet.crop(65, 0, width, height);
        dirt=sheet.crop(33, 0, width, height);
        rocks=sheet.crop(97,0, width, height);
    }
}
