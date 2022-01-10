import java.awt.*;
import java.util.ArrayList;

/**
 * @author harryrudolph
 */
public class FractalGenerator implements FractalSubject {
    private ArrayList<FractalObserver> observers;
    private ArrayList<FractalElement> elements;
    private int childCount;
    private double childRatio;
    private int recursionDepth;
    private Color color;
    private Color backgroundColor;
    private boolean wantDark;
    double radius = 100;



    public FractalGenerator(){
        observers= new ArrayList<FractalObserver>();
        elements = new ArrayList<FractalElement>();
        this.color= new Color(217, 255, 100);

    }



    @Override
    /**
     * {@inheritDoc}
     */
    public void attach(FractalObserver observer) {
        observers.add(observer);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void detach(FractalObserver observer) {
        observers.remove(observer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyObservers() {

        for (FractalObserver o: observers) {
            o.update();
            elements.clear();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setData(int childCount, double childRatio, int recursionDepth, Color color) {
        this.childCount= childCount;
        this.childRatio = childRatio/100;
        this.recursionDepth = recursionDepth;
        this.color= color;

        notifyObservers();

    }

    /**
     * {@inheritDoc}
     */
    private void generateData( double radius ,double xCoord, double yCoord) {
        FractalElement circle = new Circle(this.color,radius*2 ,(xCoord-radius), (yCoord));
        if ( radius <= (this.radius* (Math.pow(childRatio,recursionDepth)) )){
            return;
        }else{
            elements.add(circle);

            double tempr = radius;
            radius = radius * (childRatio);
            for(int currChild = 1; currChild <= childCount; currChild++) {
                double theta = (Math.PI / 2) + ((Math.PI * 2 * (currChild - 1)) / childCount);

                xCoord = (2*tempr)*Math.cos(theta)+tempr+ circle.getxCoord();

                yCoord = (2*tempr)*Math.sin(theta)-tempr+radius+ circle.getyCoord();

                double tangentX= circle.getxCoord()+ tempr;
                double tangentY= circle.getyCoord();
               // elements.add(new Line(color, tangentX,tangentY,tangentX+Math.cos(theta)*radius,tangentY+Math.sin(theta)*radius));

                generateData(radius, xCoord, yCoord);
            }

        }
    }



    /**
     * {@inheritDoc}
     */
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * {@inheritDoc}
     */
    public Color getBackgroundColor(){
        return this.backgroundColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<FractalElement> getData() {
        generateData(radius,0,0);
        return this.elements;
    }
}
