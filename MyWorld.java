import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class MyWorld extends World {

    private CollisionEngine ce;

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public MyWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("bg.png");

        int[][] map = {
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,186,-1,-1,-1,-1,185,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,186,-1,-1,-1,-1,-1,-1,-1,-1,186,-1,-1,-1,-1,187,-1,-1,-1,-1,-1,186,-1,-1,-1,-1,187,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,185,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,185,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,189,208,-1,-1,-1,-1,-1,187,-1,-1,-1,-1,-1,186,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,187,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,17,17,17,-1,-1,-1,17,17,17,17,-1,187,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,187,-1,-1,-1,-1,-1,-1,186,-1,-1,-1,-1,-1,-1,-1},
{-1,185,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,187,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96,96,96},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,190,-1,-1,-1,-1,-1,-1,-1,-1,185,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96,-1,-1,-1},
{-1,-1,-1,-1,186,-1,-1,-1,-1,-1,17,17,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,186,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,17,17,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96,189,-1,189},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,190,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,85,86,218,-1,-1,-1,-1,-1,-1,75,82,82,82,82},
{-1,-1,-1,-1,-1,-1,190,-1,-1,-1,-1,-1,218,87,85,-1,-1,-1,-1,-1,-1,-1,190,-1,190,-1,190,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,190,75,82,82,82,77,-1,-1,-1,190,75,76,65,65,65,65},
{85,84,87,218,128,218,-1,-1,-1,-1,67,82,82,82,82,69,-1,-1,-1,-1,-1,218,-1,86,218,85,218,218,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,190,75,76,65,65,65,78,69,-1,-1,67,76,65,65,65,65,65},
{82,82,82,82,82,82,82,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,82,82,82,82,82,82,82,82,82,-1,-1,-1,-1,-1,84,87,218,218,-1,75,76,65,65,65,65,65,-1,-1,-1,-1,65,65,65,65,65,65},
{65,65,65,65,65,65,65,95,95,95,95,95,95,95,95,95,95,95,95,95,65,65,65,65,65,65,65,65,65,-1,-1,-1,-1,82,82,82,82,82,82,76,65,65,65,65,65,65,95,95,95,95,65,65,65,65,65,65},
{65,65,65,65,65,65,65,93,93,93,93,93,93,93,93,93,93,93,93,93,65,65,65,65,65,65,65,65,65,95,95,95,95,65,65,65,65,65,65,65,65,65,65,65,65,65,93,93,93,93,65,65,65,65,65,65},
        };

        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 60, 60, map);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero hero = new Hero();

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
        Greenfoot.playSound ("LevelCastle1.wav");
    }

    @Override
    public void act() {
        ce.update();
    }
}
