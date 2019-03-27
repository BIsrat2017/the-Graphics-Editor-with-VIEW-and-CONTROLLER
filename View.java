import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 * class that displays the current behavior of the 
 * model in text format 
 * 
 * * @author Bisrat Asefaw
 * @version 10/09/2018
 */

public class View extends JPanel implements InterfaceView{
    private DrawingBoard model;

    /**
     * constructor of the view class
     * 
     * 
     * @param model the model class of the shapes
     */
    public  View(DrawingBoard model) {
        this.model=model;
    }

    /**
     * method that prints the system out the current behavior of the 
     *  model to window user 
     */
    public void notifyViewer( ) {
        System.out.println('\u000c');
        System.out.println("The number of shapes in the board "+ model.numberOfShapes());
        System.out.println("The selected shape is = " +model.myShape());  

    }

}   