   import greenfoot.*;
 
public class TitleScreen extends ImagesTest
{
 
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setImage("menu.png");
        Greenfoot.start();
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("enter")) Greenfoot.setWorld(new LevelSelect());
    }
}