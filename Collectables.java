import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Collectables here.
 * 
 * @author ShuyuhS 
 * @version 1
 */
public class Collectables extends Actor
{
    public boolean ifCollected;
    public boolean isOpened;
    
    public Collectables(){
        super();
        ifCollected = false;
        isOpened = false;
        setImage ("star.png");
    }
}