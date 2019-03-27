import java.awt.*;
/**
 * class that creats Tee shape with defoult color of green and has a method 
 * to check if the given point is on the shape and a toString that over 
 * rides the super class toString method
 *
 * @author Bisrat Asefaw
 * @version 10/09/2018
 */
public class Tee extends AbstractShape{
    private Color color;
    /** Construct a circle object 
     * 
     * @param leftX  the x-coordinate of the left upper corner of the tee
     * @param leftY  the y-coordinate of the left upper corner of the tee
     * @param height  the height of the tee 
     * @throws IllegalArgumentException if ehight is not multiple of 10
     */
    public Tee(int leftX, int leftY,int height){
        super(leftX+height/2,leftY+height/2,height);
        if(height%10!=0){
            throw new IllegalArgumentException("hight must be multiples of 10");
        }
        this.color=Color.GREEN;
    }

    /** checkes for the point x,y if it lies on the shape tee
     * 
     * @param x  the x-coordinate of the point  
     * @param y  the y-coordinate of the point 
     * 
     * @return true if the point is on the shape
     * @return false if the point doesn't lie on shape
     */
    public boolean isOn(int x,int y){
        int thickness=getHeight()/5;
        if(x>getLeftUpperBoundX()+getHeight() || y>getLeftUpperBoundY()+getHeight()||y<getLeftUpperBoundY()||x<getLeftUpperBoundX()){
            return false;
        }

        else if(x>=(getHeight()-thickness)/2+ getLeftUpperBoundX() && x<=((getHeight()-thickness)/2+ getLeftUpperBoundX())+thickness){
            return true;
        }
        else if(y<=getLeftUpperBoundY()+thickness){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * method that draws a Tee depending on the user input of the left x,y
     * that also draws the boarder when this shape is selected otherwise only the 
     * filled Tee shape 
     * 
     * @param g the graphics content for creating any crystalic shapes 
     */

    public void drawThing( Graphics g ){
        int[] x={getLeftUpperBoundX(),getLeftUpperBoundX()+getHeight(),
                getLeftUpperBoundX()+getHeight(),
                getLeftUpperBoundX()+3*getHeight()/5,
                getLeftUpperBoundX()+3*getHeight()/5,
                getLeftUpperBoundX()+2*getHeight()/5,
                getLeftUpperBoundX()+2*getHeight()/5,getLeftUpperBoundX()};
        int[] y={getLeftUpperBoundY(),getLeftUpperBoundY(),
                getLeftUpperBoundY()+getHeight()/5,
                getLeftUpperBoundY()+getHeight()/5,
                getLeftUpperBoundY()+getHeight(),
                getLeftUpperBoundY()+getHeight(),
                getLeftUpperBoundY()+getHeight()/5,
                getLeftUpperBoundY()+getHeight()/5};

        g.setColor( color );
        g.fillPolygon(x, y, 8);

        if(isSelected()){
            g.setColor(Color.BLACK);
            g.drawPolygon(x, y, 8);            
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

    /** this method gives the string representation of the given Tee object
     *   overrides the super toString and adds some unique behavior of a 
     *   Tee by calling the toSting of super class
     * 
     * @return string representation of the Tee shape object
     */
    @Override
    public String toString(){
        return  "Tee \nColor is " + color()+ super.toString();
    }
}
