import java.awt.*;

/**
 * an abstract class that creats differernt shape Delta,Tee and Circle
 *  the constructor of this class gets the inputs from the subclass and creat
 *  the left Upper box point and height. have methods shiftUpperLeftBy,
 *  moveUpperLeftTo,set and get Color of the object shape.there are
 *  some methods that i add to the disign given for testing.
 *
 * @author Bisrat Asefaw
 * @version 10/09/2018
 */
public abstract class AbstractShape implements Shape{

    private int bondingBoxX;
    private int bondingBoxY; 
    private boolean select;
    private int height;

    /** Construct a circle,delta and tee object
     * 
     * @param x  the x-coordinate center circle 
     * @param y  the y-coordinate center circle
     * @param height  the radius circle 
     * 
     */
    public AbstractShape(int x,int y,int height){
        this.bondingBoxX=x-height/2;
        this.bondingBoxY=y-height/2;
        this.height=height;
    }

    /**
     * abstract method used to force the subclasses to impliment the is on 
     *    method to check if the given point is on the shape
     *    
     * @param x the x value of the point 
     * @param y the y value of the point
     */
    public  abstract boolean isOn(int x, int y);

    /**
     * method that tells if the specific shape is selected or not 
     *         up on call
     *         
     * @return select if shape is selected or not
     */
    public boolean isSelected(){
        return select;
    }
    public Color setColor(){
        return Color.RED;
    }
    /**
     * sets the shape to be selected 
     * 
     * @param b set selected shape to true and false to disselect
     */

    public void setSelected(boolean b){
        this.select=b;        
    }

    /**
     * method that shifts the upper left box by deltaX and deltaY valuse
     * 
     * @param deltaX the change in x value of the bonding box
     * @param deltaY the change in y value of the bonding box
     */

    public void shiftUpperLeftBy(int deltaX, int deltaY){
        this.bondingBoxX=this.bondingBoxX+deltaX;
        this.bondingBoxY=this.bondingBoxY+deltaY;
    }

    /**
     * moves the upper bonding box x and y value to a specific input values
     *       up on the method call
     *       
     *  @param newX  the x-coordinate to move the shape bonding box
     *  @param newY  the y-coordinate to move the shape bonding box
     */
    public void moveUpperLeftTo(int newX, int newY){
        this.bondingBoxX=newX;
        this.bondingBoxY=newY;
    }

    /**
     * returns the bonding box y co-ordinate used to check/test if the moveUpperLeftTo
     *         shiftUpperLeftBy methods and the constructor are working as
     *         prefered
     * 
     * @return bondingBoxY the y-component of the left upper corner 
     */
    public int getLeftUpperBoundY(){
        return this.bondingBoxY;
    }
    
    public int getHeight(){
        return this.height;
    }

    /**
     * returns the bonding box y co-ordinate used to check/test if the moveUpperLeftTo
     *         shiftUpperLeftBy methods and the constructor are working as
     *         prefered
     * 
     * @return bondingBoxY the x-component of the left upper corner 
     */
    public int getLeftUpperBoundX(){
        return this.bondingBoxX;
    }

    /**
     * the string representation of the shape object which is a more
     *   general form which is common for all the subclasses of shapes
     *   delta , circle and Tee
     * 
     * @return info the String representation of the object 
     */
    public String toString(){
        String info="";
        info+="\nThe left edge x =("+ bondingBoxX+","+bondingBoxY+")";
        info+="\nThe height ="+ height;
        return info;
    }

}
