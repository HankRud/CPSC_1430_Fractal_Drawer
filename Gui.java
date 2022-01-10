import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
/**@author Harry RUdolph
 * Generates a graphic user interface
**/
public class Gui {
   JButton drawButton;
   JCheckBox setDark;
   JFrame frame;
   JPanel panel;
   JSlider childCount;
   JSlider recursionDepth;
   JSlider childRatio;
   FractalSubject subject;


   /** the class constructor and driver
    *
    * @param subject  fractal subject
    */
   public Gui( FractalSubject subject){
      this.subject= subject;
      this.panel= new JPanel();
      this.frame = new JFrame("Fractal Builder");
      frame.setSize(500,400);

      this.childCount= new JSlider(JSlider.HORIZONTAL,1,13,1);
      JLabel childCountLabel= new JLabel("Number of Children");
      childCountLabel.setHorizontalAlignment(JLabel.CENTER);
      childCount.setMajorTickSpacing(1);
      childCount.createStandardLabels(1,1);
      childCount.setPaintTicks(true);
      childCount.setPaintLabels(true);

      this.recursionDepth= new JSlider(JSlider.HORIZONTAL,2,10,6);
      JLabel recursionLabel= new JLabel("Recursion Depth");
      recursionLabel.setHorizontalAlignment(JLabel.CENTER);
      recursionDepth.setMajorTickSpacing(2);
      recursionDepth.setMinorTickSpacing(1);
      recursionDepth.setPaintTicks(true);
      recursionDepth.setPaintLabels(true);
      recursionDepth.createStandardLabels(2,2);

      this.childRatio= new JSlider(JSlider.HORIZONTAL,20,70,50);
      JLabel childRatioLabel= new JLabel("Ratio");
      childRatioLabel.setHorizontalAlignment(JLabel.CENTER);
      childRatio.createStandardLabels(10,20);
      childRatio.setMajorTickSpacing(10);
      childRatio.setMinorTickSpacing(2);
      childRatio.setPaintTicks(true);
      childRatio.setPaintLabels(true);

      this.drawButton = new JButton("Draw Fractal");
      drawButton.setPreferredSize(new Dimension(50,20));
      drawButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            subject.setData(childCount.getValue(), childRatio.getValue(), recursionDepth.getValue(), Color.green);

            }
      });

      this.setDark = new JCheckBox("Dark Mode");
      setDark.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == 1) {
               subject.setBackgroundColor(Color.BLACK);
            } else {
               subject.setBackgroundColor(Color.WHITE);
            }
         }
      });



      panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
      panel.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));
      panel.add(childCount);
      panel.add(childCountLabel);
      panel.add(recursionDepth);
      panel.add(recursionLabel);
      panel.add(childRatio);
      panel.add(childRatioLabel);
      panel.add(Box.createRigidArea(new Dimension(0, 30)));
      panel.add(drawButton);
      panel.add(Box.createRigidArea(new Dimension(0, 30)));
      panel.add(setDark);

      panel.setVisible(true);
      frame.add(panel);
      frame.setVisible(true);

   }

}
