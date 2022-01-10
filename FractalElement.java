import java.awt.*;

/** @author  harryrudolph
 * 
 */
public interface FractalElement {

    /**returns the x coordinate
     * 
     * @return xcoordinates 
     */
    public double getxCoord();

    /** returns the y coordinates
     * 
     * @return y coordinate
     */
    public double getyCoord();

    /**
     * shifts the y coordiantes
     *
     * @param yCoord y cooridnate
     * @param height panel height
     * @return shifted y coord
     */
    private int shiftY(double yCoord, double height) {
        yCoord= (height/2)-yCoord;
        return (int) Math.round(yCoord);
    }


    /**
     * shifts the x coordiantes
     *
     * @param xCoord x cooridnate
     * @param height panel height
     * @return shifted x coord
     */
    private int shiftX(double xCoord, double height) {
        xCoord= xCoord+(height/2);
        return (int) Math.round(xCoord);
    }


    /** draws the element
     * 
     * @param graphic  the graphic to draw on
     * @param height    the height of the panel
     * @param width     the width of the panel
     */
    public void draw(Graphics graphic,double height,double width);

    public double getLength();


}
