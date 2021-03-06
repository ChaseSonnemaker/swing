
package org.kickstats.swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Creates a window that animates a rotating shaded 3D shape.
 * 
 * The background color as well as the shape's color, type of 3D shape,
 * number of main faces, sides, width, speed of rotation, and 
 * rotation axis can all be manipulated through menus on the windows. 
 * 
 * @author Chase Sonnemaker with guidance from Leon Tabak's code.
 * @version 10 April 2020
 */
public class Swing3D extends JFrame implements ActionListener {
    
    //Frame constants
    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 800;
    private final String FRAME_TITLE = "3D Shaded Shape";
    
    //Menu name constants
    private final String B_COLOR = "Background Color";
    private final String S_COLOR = "Shape Color";
    private final String S_TYPE = "Shape Type";
    private final String S_SIDES = "Sides";
    private final String R_SPEED = "Rotation Speed";
    private final String S_WIDTH = "Shape Width";
    private final String R_TYPE = "Type of Rotation";
    
    //Menu HashMaps
    private final HashMap<String, Color> backColors = new HashMap<>();
    private final HashMap<String, Color> shapeColors = new HashMap<>();
    private final HashMap<String, Integer> shapeTypes = new HashMap<>();
    private final HashMap<String, Integer> sideNums = new HashMap<>();
    private final HashMap<String, Integer> speeds = new HashMap<>();
    private final HashMap<String, Double> widths = new HashMap<>();
    private final HashMap<String, Integer> types = new HashMap<>();
    private final int items = 9;
    
    //Panel
    private final SwingPanel3D panel;
    
    
    /**
     * Creates a new JMenu object attached to a JMenuBar object with a 
     * specified name and list of items.
     * 
     * @param m The JMenuBar object that this JMenu will be located on.
     * @param name The name of the JMenu.
     * @param s A list of items to be placed in the JMenu.
     */
    public final void createNewMenu(JMenuBar m, String name, List<String> s) {
        JMenu menu = new JMenu(name);
        m.add(menu);
        
        for(String itemName : s) {
            JMenuItem newItem = new JMenuItem(itemName);
            newItem.addActionListener(this);
            newItem.setActionCommand(itemName);
            menu.add(newItem);
        }// for
    }// createMenu
    
    
    /**
     * Creates the window with a SwingPanel3D panel and creates menus through
     * which users can interact with the animation.
     * 
     * Creates HashMaps which are used to create menus. There are menu options 
     * for background color, shape color, shape type, number of main face sides,
     * width of the shape, speed of the rotation, and axis of the 
     * rotation. Also sets the initial values of these menu options.
     */
    public Swing3D() {
        
        //Initial setup
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        Container pane = this.getContentPane();
        this.panel = new SwingPanel3D();
        pane.add(panel);
        
        
        //Color HashMap creation
        this.backColors.put(B_COLOR + ": " + "Red", new Color(255, 51, 51));
        this.backColors.put(B_COLOR + ": " + "Blue", new Color(51, 153, 255));
        this.backColors.put(B_COLOR + ": " + "Green", new Color(0, 204, 0));
        this.backColors.put(B_COLOR + ": " + "Orange", new Color(255, 153, 0));
        this.backColors.put(B_COLOR + ": " + "Gold", new Color(255, 204, 51));
        this.backColors.put(B_COLOR + ": " + "Purple", new Color(102, 0, 153));
        this.backColors.put(B_COLOR + ": " + "Brown", new Color(153, 102, 0));
        this.backColors.put(B_COLOR + ": " + "Gray", new Color(153, 153, 153));
        this.backColors.put(B_COLOR + ": " + "Yellow", new Color(255, 255, 0));
        
        this.shapeColors.put(S_COLOR + ": " + "Red", new Color(255, 51, 51));
        this.shapeColors.put(S_COLOR + ": " + "Blue", new Color(51, 153, 255));
        this.shapeColors.put(S_COLOR + ": " + "Green", new Color(0, 204, 0));
        this.shapeColors.put(S_COLOR + ": " + "Orange", new Color(255, 153, 0));
        this.shapeColors.put(S_COLOR + ": " + "Gold", new Color(255, 204, 51));
        this.shapeColors.put(S_COLOR + ": " + "Purple", new Color(102, 0, 153));
        this.shapeColors.put(S_COLOR + ": " + "Brown", new Color(153, 102, 0));
        this.shapeColors.put(S_COLOR + ": " + "Gray", new Color(153, 153, 153));
        this.shapeColors.put(S_COLOR + ": " + "Yellow", new Color(255, 255, 0));
        
        
        //Rotation type HashMap creation
        this.shapeTypes.put(S_TYPE + ": " + "Prism", 0);
        this.shapeTypes.put(S_TYPE + ": " + "Anti-Prism", 1);
        this.shapeTypes.put(S_TYPE + ": " + "Pyramid", 2);
        
        
        //Rotation type HashMap creation
        this.types.put(R_TYPE + ": " + "x-axis", 0);
        this.types.put(R_TYPE + ": " + "y-axis", 1);
        this.types.put(R_TYPE + ": " + "z-axis", 2);

        
        //widths, sideNums, and speeds HashMap creation
        for(int i = 0; i < items; i++) {
            int sides = 3 + i * 3;
            String sidesName = S_SIDES + ": " + sides;
            
            int speed = i;
            String speedName = R_SPEED + ": " + speed;
            
            double width = 0.1 + i * 0.1;
            String widthFormat = String.format("%.2f", width);
            String widthName = String.format(S_WIDTH + ": " + widthFormat);
            
            this.sideNums.put(sidesName, sides);
            this.speeds.put(speedName, speed);
            this.widths.put(widthName, width);            
        }// for
        
        
        //Set initial shape values
        this.panel.setBackground(new Color(51, 153, 255));
        this.panel.setColor(new Color(255, 51, 51));
        this.panel.setSides(15);
        this.panel.setSpeed(2);
        this.panel.setWidth(0.8);
        this.panel.setRotation(1);
        
        
        //Create menus
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        
        //Background color
        List<String> backColorsList = new ArrayList<>();
        backColorsList.addAll(this.backColors.keySet());
        createNewMenu(menuBar, this.B_COLOR, backColorsList);
        
        //Shape color
        List<String> shapeColorsList = new ArrayList<>();
        shapeColorsList.addAll(this.shapeColors.keySet());
        createNewMenu(menuBar, this.S_COLOR, shapeColorsList);
        
        //Shape type
        List<String> shapeTypesList = new ArrayList<>();
        shapeTypesList.addAll(this.shapeTypes.keySet());
        createNewMenu(menuBar, this.S_TYPE, shapeTypesList);
        
        //Sides
        List<String> sideNumsList = new ArrayList<>();
        sideNumsList.addAll(this.sideNums.keySet());
        createNewMenu(menuBar, this.S_SIDES, sideNumsList);
       
        //Widths
        List<String> widthsList = new ArrayList<>();
        widthsList.addAll(this.widths.keySet());
        createNewMenu(menuBar, this.S_WIDTH, widthsList);
        
        //Speed
        List<String> speedsList = new ArrayList<>();
        speedsList.addAll(this.speeds.keySet());
        createNewMenu(menuBar, this.R_SPEED, speedsList);
        
        //Type
        List<String> typesList = new ArrayList<>();
        typesList.addAll(this.types.keySet());
        createNewMenu(menuBar, this.R_TYPE, typesList);

        
        this.setVisible(true);
    }// Swing3D()
    
    
    /**
     * Listens for menu interaction and uses setters to change corresponding 
     * values in the SwingPanel3D class to produce changes in the animation.
     * 
     * Allows the user to set the parameters of the rotating 3D shape animation.
     * 
     * @param event A click on a menu by a user.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();
        
        if(actionCommand.indexOf(B_COLOR) >= 0) {
            this.panel.setBackground(this.backColors.get(actionCommand));
        }// if
        else if(actionCommand.indexOf(S_COLOR) >= 0) {
            this.panel.setColor(this.shapeColors.get(actionCommand));
        }// else if
        else if(actionCommand.indexOf(S_TYPE) >= 0) {
            this.panel.setShape(this.shapeTypes.get(actionCommand));
        }// else if
        else if(actionCommand.indexOf(S_SIDES) >= 0) {
            this.panel.setSides(this.sideNums.get(actionCommand));
        }// else if
        else if(actionCommand.indexOf(S_WIDTH) >= 0) {
            this.panel.setWidth(this.widths.get(actionCommand));
        }// else if
        else if(actionCommand.indexOf(R_SPEED) >= 0) {
            this.panel.setSpeed(this.speeds.get(actionCommand));
        }// else if
        else if(actionCommand.indexOf(R_TYPE) >= 0) {
            this.panel.setRotation(this.types.get(actionCommand));
        }// else if
    }// actionPerformed(ActionEvent)
    
    /**
     * Creates an instance of this class which creates the window and begins 
     * the animation.
     */
    public static void main(String[] args) {
        Swing3D s3D  = new Swing3D();
    } // main( String [] )
    
    
}// Swing3D
