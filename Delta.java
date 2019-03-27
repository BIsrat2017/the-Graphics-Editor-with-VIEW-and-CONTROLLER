import java.awt.*;
/**
 * class that creats delta shape with defoult color of red and has a method 
 * to check if the given point is on the shape and a toString that over 
 * rides the super class toString method
 *
 * @author Bisrat Asefaw
 * @version 10/09/2018
 */
public class Delta extends AbstractShape{

    private Color color;
    /** Construct a Delta shape object 
     * 
     * @param apexX  the x-coordinate of the apex 
     * @param apexY  the y-coordinate of the apex
     * @param height  the height of the Delta 
     * @throws IllegalArgumentException if height is not an even
     *                  
     */
    public Delta(int apexX,int apexY,int height){
        super(apexX,apexY+height/2,height);
        if(height%2!=0){
            throw new IllegalArgumentException("hight must be even number");
        }
        this.color=Color.RED;
    }

    /** checkes for the point x,y if it lies on the shape circle
     * 
     * @param x  the x-coordinate of the point  
     * @param y  the y-coordinate of the point 
     * 
     * @return true if the point is on the shape
     * @return false if the point doesn't lie on shape
     */
    public boolean isOn(int x,int y){
        int x1=(getLeftUpperBoundY()+2*(getLeftUpperBoundX()+getHeight()/2)-y)/2;
        int x2=(y-getLeftUpperBoundY()+2*(getLeftUpperBoundX()+getHeight()/2))/2;
        if(y>(getLeftUpperBoundY()+getHeight())||y<getLeftUpperBoundY()){
            return false;
        }

        if(x>x1 && x<x2){
            return true;
        }
        return false;        
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
     * method that draws a Delta depending on the user input of the apex x,y
     * that also draws the boarder when this shape is selected otherwise only the 
     * filled Delta shape 
     * 
     * @param g the graphics content for creating any crystalic shapes 
     */
    public void drawThing( Graphics g ) {
        int[] x={getLeftUpperBoundX()+getHeight()/2,getLeftUpperBoundX(),getLeftUpperBoundX()+getHeight()};
        int[] y={getLeftUpperBoundY(),getLeftUpperBoundY()+getHeight(),getLeftUpperBoundY()+getHeight()};
        g.setColor( color );
        g.fillPolygon(x, y,3);
        if(isSelected()){
            g.setColor(Color.BLACK);
            g.drawPolygon(x,y,3);
        }
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
     * this method gives the string representation of the delta object
     *   overrides the super toString and adds some unique behavior of a 
     *   delta by calling the toSting of super class
     * 
     * @return string representation of Delta
     */
    @Override
    public String toString(){
        return "Delta \nColor  " + color()+
        "\nApex point at ("+getLeftUpperBoundX()+getHeight()/2+", "+
        getLeftUpperBoundY()+") \nHeght ="+ getHeight();
    }

}
