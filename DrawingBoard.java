import java.util.*;
import java.awt.*;

/**
 * class that keep track of the shapes and also the selected shape
 * the selected shape will be always on the top of the array. there are
 * some methods that i add to the disign given for testing.
 *
 * @author Bisrat Asefaw
 * @version 10/09/2018
 */
public class DrawingBoard{

    private ArrayList<Shape> myList= new ArrayList<Shape>();

    private ArrayList<InterfaceView> listeners=new ArrayList<>();

    private InterfaceView viewPane;
    /**
     * method that adds a selected shape to the drawing board 
     * 
     * @param s the selected shape to be added to the jframe
     */
    public void addShape(Shape s){
        myList.add(s);
        flaseSape();
        myList.get(myList.size()-1).setSelected(true);
        retriveShape();        
    }

    /**
     * method that registers all listners and keeps them ready to get
     * notified for every action changed in the model this method is
     * causing me to much triuble which is not doing what it sapposed to do
     */
    private void notifyAllListeners() {
        Iterator<InterfaceView> it = listeners.iterator();
        while ( it.hasNext() ) {
            InterfaceView c = it.next();
            c.notifyViewer();
        }
    }

    /**
     * method that addes all interested viewers to the model
     * 
     * @param v the listener that is added or registered with this model
     */
    public void addView( InterfaceView v ) {
        listeners.add( v );
    }

    /**
     * method that sets all the shapes to selected false 
     */

    public void flaseSape(){

        for(int i=0;i<myList.size();i++){
            myList.get(i).setSelected(false);
        }
        
    }

    /** able to pass in an x,y coordinate, and the topmost shape that
     * contains this x,y coordinate becomes the selected shape. 
     * 
     * @param x  the x-coordinate of the point  
     * @param y  the y-coordinate of the point 
     * 
     */
    public void setSelected(int x,int y){
        if(myList.size()>=1){
            int idx=0;

            int count=0;
            int n=myList.size();
            for(int i=n-1;i>=0;i--){
                if(myList.get(i).isOn(x,y)==true&& count==0){                    
                    idx=i;
                    count++;

                }
            }
            flaseSape();
            if(count>0){
                myList.get(idx).setSelected(true);
                myList.add(myList.get(idx));
                myList.remove(idx);
            }
        }
        notifyAllListeners();
    }

    /** A client should be able to query the DrawingBoard to retrieve
     * a reference to the selected shape.
     * 
     * @return the selected shape 
     * @return null no shape is selected
     */
    public void retriveShape(){
        int n=myList.size();
        if(n>=1){
            int idx=0;
            for(int i=0;i<n;i++){
                if(myList.get(i).isSelected()==true){
                    idx=i;
                }
            }
            myList.add(myList.get(idx));
            flaseSape();
            myList.get(myList.size()-1).setSelected(true);
            myList.remove(idx);
        }
        notifyAllListeners();
    }

    /** 
     * the method used to remove the selected shape from the DrawingBoard and
     * set the next shape from the shapes to select but if there is no
     * shape selected this method do nothing 
     * 
     */
    public void removeShape(){
        int x=0;
        if(myList.size()>0){
            if(myList.get(myList.size()-1).isSelected()==true&&myList.size()>0){
                myList.remove(myList.get(myList.size()-1));
                if(myList.size()>0)
                    myList.get(myList.size()-1).setSelected(true);
            }

        }        
        notifyAllListeners();
    }

    /**
     * adds color to the selected shape from the list of shapes 
     * 
     * @param c the color to paint the selected shape
     */
    public void setColor(Color c){
        for(int i=0;i<myList.size();i++){
            if(myList.get(i).isSelected()==true){
                myList.get(i).setColor(c); 

            }            
        }
        notifyAllListeners();                               
    }

    /**if the client wants to move the selected shape from the drawing
     * board 
     * 
     * @param changeInX the change in x value of the selected shape
     * @param changeInY the change in y value of the selected shape
     * 
     */
    public void move(int changeInX,int changeInY){
        int idx=0;
        int count=0;
        for(int i=myList.size()-1;i>=0;i--){
            if(myList.get(i).isSelected()==true){
                count++;
                idx=i;
            }
        }

        if(count>0){
            myList.get(idx).shiftUpperLeftBy(changeInX,changeInY);
        }
        notifyAllListeners();
    }

    /**
     * method that copies the entire array list of shapes to new array list
     * 
     * @param c the new array list to hold the copy
     * 
     * @return c the new array list 
     */
    public ArrayList copyList(ArrayList<Shape> c){
        c.addAll(myList);
        return c;
    }

    /**method that returmyList.size() the list with a shapes added for testimyList.size()g amyList.size()d lookimyList.size()g
     * the behavoir of the objects imyList.size() the Arraylist
     * 
     * @returmyList.size() myList the list of shapes that is crated for testimyList.size()g 
     */
    public ArrayList getMyList(){
        return myList;
    }

    /**
     * method that returnes the selected shape far draging perpose
     * 
     * @return selectedShape the selected shape
     * @return null if there is no selected shape
     */
    public Shape myShape(){
        if(myList.size()>0){
            if(myList.get(myList.size()-1).isSelected()){
                return myList.get(myList.size()-1); //selected shape
            }
        }
        return null;
    }

    public int numberOfShapes(){
        return myList.size();
    }
}
