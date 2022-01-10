import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Display extends JFrame implements FractalObserver  {
    private FractalSubject subject;
    private JPanel panel;

    /** the class constructor
     *
     * @param subject  the fractal subject
     */
    public Display (FractalSubject subject){

        this.setSize(800, 800);
        this.subject = subject;

        subject.attach(this);
        this.panel= new DrawPanel();
        panel.setSize(800,800);
        getContentPane().add(panel);


    }

    @Override
    /** updates the display
     *
     */
    public void update() {
        panel.setBackground(subject.getBackgroundColor());
        panel.repaint();

        setVisible(true);

    }

    /** interior panel class
     *
     */
    private class DrawPanel extends JPanel {
        public DrawPanel(){

        }
        @Override
        /** override of paint component that draws fractal elements
         *
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (FractalElement e: subject.getData()) {
                e.draw(g,this.getHeight(),this.getWidth());
            }
        }

    }
}
