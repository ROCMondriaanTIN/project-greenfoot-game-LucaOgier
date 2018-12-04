
import greenfoot.*;

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
    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        isGrounded = true;
        isFacingLeft = false;
        setImage("p1.png");
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

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                Greenfoot.playSound ("Dead2.wav");
                break;
            }
        } 
    }

    public void handleInput() {
        if (Greenfoot.isKeyDown("space") && (isTouching(Tile.class) && (velocityY <= 0))){
            velocityY = -15;
            setImage ("p1_jump.png");
            isGrounded = false;
            Greenfoot.playSound ("Jump.wav");
            
            if (isFacingLeft = true){
                setImage("p1_jump_L.png");
            }
            else {
                setImage ("p1_jump.png");
    }
}
        if (Greenfoot.isKeyDown("left")) {
            velocityX = -4.6723;
            setImage ("p1_walk01L.png");
            
            isFacingLeft = true;
        } else if (Greenfoot.isKeyDown("right")) {
            velocityX = 4.6723;
            isFacingLeft = false;
            if (isGrounded = false)
                setImage ("p1_jump.png");
            else
                setImage ("p1_walk01.png");                   
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
