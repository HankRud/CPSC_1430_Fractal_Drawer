import java.awt.*;
import java.util.ArrayList;

/**@author Harry Rudolph
 *
 */
public interface FractalSubject {

    /** attaches observer
     *
     * @param observer  the display
     */
    public void attach(FractalObserver observer);

    /** removes observers
     *
     * @param observer the display
     */
    public void detach(FractalObserver observer);

    /** updates the observers about changes
     *
     */
    public void notifyObservers();

    /** sets the class data
     *
     * @param childCount   the child count
     * @param childRatio    ratio of parents and children
     * @param recursionDepth    recursion depth
     * @param color       the colopr
     */
    public void setData(int childCount, double childRatio, int recursionDepth, Color color);

    /** the background color
     *
     * @param color the background color
     */
    public void setBackgroundColor(Color color);

    /** gets background color
     *
     * @return  the background color
     */
    public Color getBackgroundColor();

    /** populates the array list
     *
     * @return  the array list of elements
     */
    public ArrayList<FractalElement> getData();


}
