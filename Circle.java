import java.awt.*;
/**
 * class that creats circle by passing the user input to the supper class 
 * with yellow defoult color and a toString that over 
 * rides the super class toString method
 *
 * @author Bisrat Asefaw
 * @version 10/09/2018
 */
public class Circle extends AbstractShape{
    private Color color;
    private int radius;
    /** 
     * Construct a circle object given the center and the raius of the 
     *    circle and a difault cololor for circle 
     *    
     * @param centerX  the x-coordinate center circle 
     * @param centerY  the y-coordinate center circle
     * @param radius  the radius circle 
     */
    public Circle(int centerX,int centerY,int radius){
        super(centerX,centerY,radius*2);        
        this.color=Color.YELLOW;
        this.radius=radius;
    }

    /** checkes for the point x,y if it lies on the shape circle
     * 
     * @param x  the x-coordinate of the point  
     * @param y  the y-coordinate of the point 
     * 
     * @return true  if the point is on the shape
     * @return false if the point doesn't lie on shape
     */

    public boolean isOn(int x,int y){

        if( getHeight()/2>=Math.sqrt(Math.pow((getLeftUpperBoundX()+getHeight()/2)-x,2)+Math.pow((getLeftUpperBoundY()+getHeight()/2)-y,2))){
            return true;
        }
        else{
            return false;
        }
    } 
    /**
     * method that draws a Circle depending on the user input of the center x,y
     * that also draws the boarder when this shape is selected otherwise only the 
     * filled Circle shape 
     * 
     * @param g the graphics content for creating any crystalic shapes 
     */

    public void drawThing( Graphics g ) {
        g.setColor( color );
        g.drawOval(getLeftUpperBoundX(),getLeftUpperBoundY(),getHeight(),getHeight());
        g.fillOval( getLeftUpperBoundX(), getLeftUpperBoundY(), getHeight(), getHeight() );
        if(isSelected()){
            g.setColor(Color.BLACK);
            g.drawOval(getLeftUpperBoundX(),getLeftUpperBoundY(),getHeight(),getHeight());
        }
    }

    /**method that used to return the color of the object up on call
     * 
     * @return color  of the shape
     */
    public Color getColor(){
        return color;
    }

    /**
     * method that sets the color of the shape based on the user input
     * 
     * @param color the input color to change the color of the shape
     */
    public void setColor(Color color){
        this.color=color;
    }
    
    /**
     * method that returns the string representation of the color this shape
     * 
     * @return Red for red color
     * @return Green for Green color
     * @return Yellow for Yellow color
     */

    public String color(){

        if(color.equals(Color.RED)){
            return "Red";
        }
        else if(color.equals(Color.GREEN)){
            return "Green";
        }
        return "Yellow";

    }

    /**
     * this method gives the string representation of the given circle object
     *   overrides the super toString and adds some unique behavior of a 
     *   circle by calling the toSting of super class
     * 
     * @return string representation of the object Cirle
     */
    @Override
    public String toString(){
        return  "Circle \nColor " + color()
        + "\nCenter ("+getLeftUpperBoundX()+getHeight()/2+
        " , "+getLeftUpperBoundY()+getHeight()/2+")\nRadius ="+getHeight()/2;
    }
}
