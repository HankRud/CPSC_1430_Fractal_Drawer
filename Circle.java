import java.awt.*;

public class Circle implements FractalElement{

    public Color color;
    public double diameter;
    public double xCoord;
    public double yCoord;


    /** class constructor
     *
     * @param color  the color
     * @param diameter  diameter
     * @param xCoord  xCoord
     * @param yCoord  yCoord
     */
    public Circle(Color color,double diameter,double xCoord,double yCoord){
        this.diameter = diameter;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.color= color;
    }



    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(Graphics graphics , double height,double width) {

        graphics.setColor(color);
        graphics.drawOval(shiftX(xCoord, width),shiftY(yCoord,height),(int)diameter,(int)diameter);
    }

    @Override
    public double getLength() {
        return diameter/2;
    }

    /**
     * {@inheritDoc}
     */
    private int shiftX(double xCoord,double width){
        xCoord= xCoord+(width/2);
        return (int) Math.round(xCoord);
    }

    /**
     * {@inheritDoc}
     */
    private int shiftY(double yCoord,double height){
        yCoord= (height/2)-yCoord;
        return (int) Math.round(yCoord);
    }

    /**
     * {@inheritDoc}
     */
    public double getxCoord() {
        return xCoord;
    }

    /**
     * {@inheritDoc}
     */
    public double getyCoord() {
        return yCoord;
    }
}
