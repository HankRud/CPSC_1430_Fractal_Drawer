import java.awt.*;


public class Line implements FractalElement{

    private Color color;
    private double startX;
    private double startY;
    private double endX;
    private double endY;

    public Line(Color color, double startX, double startY,double endX, double endY ){
        this.color = color;
        this.startX= startX;
        this.startY= startY;
        this.endX=endX;
        this.endY= endY;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public double getxCoord() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getyCoord() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(Graphics graphic,double width, double height) {
        graphic.setColor(color);
        graphic.drawLine(shiftX(startX, width), shiftY(startY, height), shiftX(endX, width), shiftY(endY, height));
    }

    /**
     * {@inheritDoc}
     */
    private int shiftX(double xCoord,double width){
        xCoord= xCoord+ (width/2);
        return (int)Math.round(xCoord);
    }

    /**
     * {@inheritDoc}
     */
    private int shiftY(double yCoord,double height){
        yCoord= height/2 - yCoord;
        return (int)Math.round(yCoord);
    }

    @Override
    public double getLength() {
        return 0;
    }
}
