
import greenfoot.*;
 import java.util.List;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private boolean isGrounded;
    private boolean isFacingLeft;
    public boolean isDead;
    private int frame = 1;
    private GreenfootImage run1 = new GreenfootImage("p1_walk01L.png");
    private GreenfootImage run2 = new GreenfootImage("p1_walk02L.png");
    private GreenfootImage run3 = new GreenfootImage("p1_walk03L.png");
    private GreenfootImage run4 = new GreenfootImage("p1_walk04L.png");
    private GreenfootImage run5 = new GreenfootImage("p1_walk05L.png");
    private GreenfootImage run6 = new GreenfootImage("p1_walk06L.png");
    private GreenfootImage run7 = new GreenfootImage("p1_walk07L.png");
    private GreenfootImage run8 = new GreenfootImage("p1_walk08L.png");
    private GreenfootImage run9 = new GreenfootImage("p1_walk09L.png");
    private GreenfootImage run10 = new GreenfootImage("p1_walk10L.png");
    private GreenfootImage run11 = new GreenfootImage("p1_walk11L.png");
    private GreenfootImage run12 = new GreenfootImage("p1_walk01.png");
    private GreenfootImage run13 = new GreenfootImage("p1_walk02.png");
    private GreenfootImage run14 = new GreenfootImage("p1_walk03.png");
    private GreenfootImage run15 = new GreenfootImage("p1_walk04.png");
    private GreenfootImage run16 = new GreenfootImage("p1_walk05.png");
    private GreenfootImage run17 = new GreenfootImage("p1_walk06.png");
    private GreenfootImage run18 = new GreenfootImage("p1_walk07.png");
    private GreenfootImage run19 = new GreenfootImage("p1_walk08.png");
    private GreenfootImage run20 = new GreenfootImage("p1_walk09.png");
    private GreenfootImage run21 = new GreenfootImage("p1_walk10.png");
    private GreenfootImage run22 = new GreenfootImage("p1_walk11.png");
    TileEngine tileEngine;
    CollisionEngine collisionEngine;
    public Hero(TileEngine tileEngine) {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        isGrounded = true;
        isFacingLeft = false;
        isDead = false;
        setImage("p1.png");
        this.tileEngine = tileEngine;
        this.collisionEngine = collisionEngine;
    }
    @Override
    public void act() {
        handleInput();
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        for (Actor actor : getIntersectingObjects(Tile.class)) {
            Tile tile = (Tile) actor;
            if (tile.getImage().toString().contains("lock_blue")) {
               Greenfoot.setWorld(new Level2());
                        break;}}
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                Greenfoot.playSound ("Dead2.wav");
                isDead = true;
                break;
            }
            List <Tile> tiles = collisionEngine.getCollidingTiles(this, true);
        for(Tile tile : getIntersectingObjects(Tile.class)) {
                if (tile.type == TileType.COINSILVER) {
                    tileEngine.removeTile(tile);
                    Greenfoot.playSound ("Item4.wav");
                    return;
        }
    }
}
}
public void handleInput() {
     if (Greenfoot.isKeyDown("space") && (isTouching(Tile.class) && (velocityY <= 0.00001))){
            velocityY = -12;
            setImage ("p1_jump.png");
            isGrounded = false;
            Greenfoot.playSound ("Jump4.wav");
       }
     if (Greenfoot.isKeyDown("left")) {
            velocityX = -4.6723;
            animatieLeft();
            isFacingLeft = true;
        } else if (Greenfoot.isKeyDown("right")) {
            velocityX = 4.6723;
            isFacingLeft = false;
            animatieRight();             
        }
    }
    public int getWidth() {
        return getImage().getWidth();
    }
    public int getHeight() {
        return getImage().getHeight();
    }
    public void animatieRight() {
        if(frame == 1){
            setImage(run12);}
        else if (frame == 2){
            setImage(run13);}
        else if (frame == 3){
            setImage(run14);}
        else if (frame == 4){
            setImage(run15);}
        else if (frame == 5){
            setImage(run16);}
        else if (frame == 6){
            setImage(run17);}
        else if (frame == 7){
            setImage(run18);}
        else if (frame == 8){
            setImage(run19);}
        else if (frame == 9){
            setImage(run20);}
        else if (frame == 10){
            setImage (run21);
            frame = 0;
            return;
        }
        frame ++;
       }
       
    public void animatieLeft() {
        if(frame == 1){
            setImage(run1);}
        else if (frame == 2){
            setImage(run2);}
        else if (frame == 3){
            setImage(run3);}
        else if (frame == 4){
            setImage(run4);}
        else if (frame == 5){
            setImage(run5);}
        else if (frame == 6){
            setImage(run6);}
        else if (frame == 7){
            setImage(run7);}
        else if (frame == 8){
            setImage(run8);}
        else if (frame == 9){
            setImage(run9);}
        else if (frame == 10){
            setImage (run10);
            frame = 0;
            return;}
        frame ++;
       }
}
