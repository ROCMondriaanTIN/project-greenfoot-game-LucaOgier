
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class ImagesTest extends World {
    protected TileType type = TileType.DEFAULT;
    protected int mapIcon = -1;
    protected int mapID = -1;
    private int colom = -1;
    protected int row = -1;

    /**
     * Constructor of the tile. Creates a tile based on image, width and height
     *
     * @param image Path to the image file
     * @param width Width of the tile
     * @param heigth Height of the tile
     */
    public ImagesTest(String image, double width, double heigth) {
        
        setImage(image);
        getImage().scale(width, heigth);
        _id = id;
        id++;
    }

    /**
     * Constructor for the use of a type
     *
     * @param image Path to the image file
     * @param width Width of the tile
     * @param heigth Height of the tile
     * @param type The type of the tile
     */
    public ImagesTest(String image, int width, int heigth, TileType type) {
        this(image, width, heigth);
        this.type = type;
    }

    @Override
    public String toString() {
        return "id: " + _id + "\n"
                + "X: " + getX() + "\n"
                + "Y: " + getY() + "\n"
                + "Type: " + getType();
    }
}