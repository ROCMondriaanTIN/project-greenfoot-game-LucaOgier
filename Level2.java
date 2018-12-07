import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class Level2 extends World{

    private CollisionEngine ce;

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public Level2() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("bg_night.png");

        int[][] map = {
{-1,-1,-1,-1,-1,-1,-1,184,184,184,-1,-1,184,184,-1,-1,-1,-1,-1,-1,-1,-1,185,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{187,-1,-1,-1,-1,187,-1,184,184,184,187,-1,184,184,-1,-1,187,-1,-1,-1,-1,-1,-1,-1,-1,-1,187,-1,-1,-1,-1,-1,-1,186,-1,-1,-1,-1,-1,-1,-1,187,-1,-1,-1,-1,-1,-1,-1,-1,186,-1,-1,231,232,-1},
{-1,-1,-1,204,208,189,-1,184,184,184,-1,-1,184,184,187,-1,-1,-1,-1,186,-1,-1,-1,-1,-1,-1,-1,-1,186,-1,-1,-1,-1,-1,-1,-1,-1,-1,185,-1,-1,-1,-1,-1,-1,-1,-1,-1,187,-1,-1,-1,-1,32,30,36},
{-1,187,-1,17,17,17,-1,230,230,230,-1,-1,184,184,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,187,-1,-1,-1,-1,-1,-1,-1,-1,186,-1,-1,-1,-1,-1,-1,-1,-1,19,19,19},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,187,-1,230,230,-1,-1,185,-1,-1,-1,187,-1,-1,-1,-1,186,-1,-1,-1,-1,-1,187,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,186,-1,-1,-1,-1,19,19,19},
{-1,-1,-1,-1,187,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,190,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,186,187,-1,-1,-1,-1,187,187,-1,-1,-1,-1,-1,-1,-1,19,19,19},
{187,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,19,19,19},
{-1,-1,-1,-1,-1,-1,-1,-1,187,-1,-1,-1,-1,-1,-1,241,165,165,242,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,-1,-1,-1,190,-1,-1,-1,187,-1,-1,-1,-1,-1,-1,-1,-1,186,-1,-1,-1,-1,187,-1,19,19,19},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,160,150,150,161,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,241,165,165,165,242,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,186,-1,-1,-1,-1,-1,-1,96,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,220,241,150,150,150,150,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,160,150,150,150,161,165,-1,-1,-1,-1,185,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96,-1,-1},
{220,219,128,219,-1,-1,-1,-1,-1,-1,-1,-1,221,241,160,150,150,150,150,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,150,150,150,150,150,150,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,190,189,189,96,-1,194},
{165,165,165,165,242,-1,-1,-1,219,219,190,221,241,150,150,150,150,150,150,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,241,165,150,150,150,150,150,150,-1,-1,-1,-1,190,-1,-1,-1,-1,-1,16,16,16,17,17,17,19,19,19},
{150,150,150,150,161,187,187,187,153,165,165,165,160,150,150,150,150,150,150,-1,-1,-1,-1,-1,190,190,-1,-1,-1,160,150,150,150,150,150,150,150,-1,-1,241,165,165,165,242,-1,16,16,185,-1,-1,-1,-1,-1,241,165,165},
{150,150,150,150,150,186,186,186,-1,150,150,150,150,150,150,150,150,150,150,186,186,186,241,165,165,165,165,242,-1,150,150,150,150,150,150,150,150,186,186,160,150,150,150,161,186,186,186,186,186,186,186,186,186,160,150,150},
{150,150,150,150,150,185,185,185,-1,150,150,150,150,150,150,150,150,150,150,185,185,185,160,150,150,150,150,161,185,150,150,150,150,150,150,150,150,185,185,150,150,150,150,150,185,185,185,185,185,185,185,185,185,150,150,150},
};
        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 60, 60, map);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero hero = new Hero(te);
        
        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);

        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 0, 0);
        addObject(hero, 300, 200);
        addObject(new Enemy(), 1170, 410);
        
        // Force act zodat de camera op de juist plek staat.
        camera.act();
        hero.act();

        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
        ce = new CollisionEngine(te, camera);
        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(hero);
        
        Greenfoot.playSound ("Anarchonist.mp3");
         
    }

    @Override
    public void act() {
        ce.update();
    }
}
