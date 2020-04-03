package org.kickstats.geo1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.QuadCurve2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SwingPanel extends JPanel implements ActionListener {

    private double ctr1x1 = -0.5;
    private double ctr1y1 = 0.5;
    private double ctr1x2 = 0.5;
    private double ctr1y2 = -0.5;
    private double x1 = 1;
    private double x2 = -1;
    private double y1 = 0.0;
    private double y2 = 0.0;
    private double factorChange = 0.3;
    
    private Color color = Color.red;

    public SwingPanel() {
        Timer timer = new Timer(50, this);
        timer.start();
    } // SwingPanel()

    public Color getColor() {
        return this.color;
    } // getColor()

    public void setColor(Color c) {
        this.color = c;
    } // setColor( Color )

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        int w = this.getWidth();
        int h = this.getHeight();

        AffineTransform transform = new AffineTransform();
        AffineTransform scaling = new AffineTransform();
        scaling.setToScale(w / 2, h / 2);
        AffineTransform translation = new AffineTransform();
        translation.setToTranslation(1.0, 1.0);

        transform.concatenate(scaling);
        transform.concatenate(translation);

        // Replace this block of code that creates
        // an ellipse with your own code that draws
        // something else
        // Make sure that all geometry fits in a square
        // whose corners are (-1, -1) and (+1, +1)
        ctr1y1 = ctr1y1 + factorChange;
        ctr1y2 = ctr1y2 - factorChange;
        CubicCurve2D.Double curve = new CubicCurve2D.Double(x1, y1, ctr1x1,
        ctr1y1, ctr1x2, ctr1y2, x2, y2);

        Shape shape = transform.createTransformedShape(curve);
        g2D.setColor(this.getColor());
        g2D.draw(shape);
    } // paintComponent( Graphics )

    @Override
    public void actionPerformed(ActionEvent event) {
        // You might also like to try what happens
        // in each step of the animation
        // Move? In which direction? How much?
        // Make bigger? Or make smaller?
        // Rotate? (There's an AffineTransform for that, too.)
        // Change color?

        if (this.ctr1y1 > 2) {
            this.factorChange = -this.factorChange;
        } // if
        else if (this.ctr1y1 < -2) {
            this.factorChange = -this.factorChange;
        } // else if

        this.repaint();
    } // actionPerformed( ActionEvent )

} // SwingPanel
