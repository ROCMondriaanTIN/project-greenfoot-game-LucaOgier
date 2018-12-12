import greenfoot.*;
public class LevelSelect extends World
{
 
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public LevelSelect()
    {    
        super(600, 400, 1); 
        Greenfoot.start();
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("1")) Greenfoot.setWorld(new Level1());
        if (Greenfoot.isKeyDown("2")) Greenfoot.setWorld(new Level2());
    }
}