import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * the conroller of all the class viewShape and model DrawingBoard 
 * 
 *
 * @author Bisrat Asefaw
 * @version 10/19/2018
 */
public class Controller extends JPanel{
    private DrawingBoard model;     //model to make changes in the view
    private ViewShape viewPane;// view shape
    private InterfaceView viewText; //view text
    //*****************//listeners for diferent actions//********
    private MouseListener  mouseListener;
    private ButtonListener buttonListener;
    private KeyListener keyListener;
    private MouseMotionListener listener;
    //****************//////instance variables of controller board/////++
    private int dx, dy,x1,y,x;// valuse used to track the previos points of
                              // pointer and used to draw shapes 
    private boolean dragged;
    
    /**
     * constructor for conttroler to 
     */
    public Controller( DrawingBoard w ) {
        x=0;

        model = w;
        setLayout( new BorderLayout( ) );

        //*****create pane with ball display and place it in the center**\\
        viewPane = new ViewShape( model );//something to look
        viewText=new View(model);
        add( viewPane, BorderLayout.CENTER );
        

        //**********register the view with the model*****\\\\
        model.addView( viewPane );
        model.addView(viewText);//****Todo***
        keyListener=new KeyControl(model);//Todo****

        //*****set up listener for mouse clicks on the view*******\\
        viewPane.addKeyListener( keyListener );//Todo****
        ////+++++++++++++++++++++++++++++++++++//////////////

        listener=new SMouseListener(model);
        mouseListener = new SMouseListener( model );
        viewPane.addMouseListener( mouseListener );
        viewPane.addMouseMotionListener(listener);

        ////========/////////////
        //viewText.addMouseListener( mouseListener );
        //viewText.addMouseMotionListener(listener);
        ////===========///////////
        //******** create panel with cre buttons and add it at the bottom
        JButton triangle = new JButton( "Triangle" );
        JButton circle = new JButton( "Circle" );
        JButton tShape = new JButton( "T-shape" );
        //**remove button to remove the selected shape *****
        JButton remove = new JButton( "Remove" );
        //****color selector button to change the color red,yellow and green
        JButton red = new JButton( "red" );
        JButton green = new JButton( "green" );
        JButton yellow = new JButton( "yellow" );

        JPanel buttons = new JPanel( );
        buttons.add( triangle );
        buttons.add( circle );
        buttons.add( tShape );
        buttons.add( remove );
        buttons.add( red );
        buttons.add( green );
        buttons.add( yellow );

        triangle.setBackground( Color.yellow );
        circle.setBackground( Color.green );
        tShape.setBackground( Color.red );
        //assign color to the buttons with respect to thier content color
        red.setBackground( Color.red );        
        red.setOpaque(true);

        green.setBackground( Color.GREEN );
        green.setOpaque(true);

        yellow.setBackground( Color.YELLOW);
        yellow.setOpaque(true);

        buttons.setBackground( Color.lightGray );
        this.add( buttons, BorderLayout.SOUTH );

        //*********set up listener for the buttons*****\
        //keyListener = new (model);
        buttonListener = new ButtonListener( model );

        triangle.addActionListener( buttonListener );
        circle.addActionListener( buttonListener );
        tShape.addActionListener( buttonListener );
        remove.addActionListener( buttonListener );
        red.addActionListener( buttonListener );
        yellow.addActionListener( buttonListener );
        green.addActionListener( buttonListener );
    }

    /**
     * class that uses the mouse Process mouse click by adding 
     * a new Shapes to the simulation at the location of the click with
     * default color and shape and after creating the shape the user 
     * can change the color of the shape and can remove the
     * selected shape by using color button and remove
     * button
     * 
     */

    class SMouseListener implements MouseListener, MouseMotionListener {
        // instance variables
        private DrawingBoard model; // the DrawingBoard we are controlling

        /**
         * Constructor for objects of class SMouseListener
         * 
         * @param model the model object containing the state of the system
         */
        public SMouseListener( DrawingBoard model ) {
            super( );
            this.model = model;

        }

        /**
         * Process mouse click by adding a new Shapes to the simulation 
         * at the location of the click with default color and shape and after 
         * creating the shape the user can change the color of the shape and 
         * can remove the selected shape by using color button and remove
         * button
         * 
         * @param e the mouse click event
         */
        public void mouseClicked( MouseEvent e ) {}

        /**
         * dummy methods for other mouse event implimentation
         */
        public void mouseEntered ( MouseEvent e ) { }
        public void mouseExited  ( MouseEvent e ) { }
        public void mouseMoved   (MouseEvent e  ) { }
        public void mouseReleased( MouseEvent e ) { }
        
        /**
         * method that holds the preesed position of the mouse
         * 
         * @param e the mouse event for current press operation
         */
        public void mousePressed ( MouseEvent e ) { 
            dx=e.getX();
            dy=e.getY();
            if(x==2){
                //Shape s=new Circle(e.getX(),e.getY(),50);
                model.addShape(new Circle(e.getX(),e.getY(),50));                
                x=0;
            }else if(x==1){
                //Shape c=new Delta(e.getX(),e.getY(),100);
                model.addShape(new Delta(e.getX(),e.getY(),100));
                x=0;

            }else if(x==3){
                //Shape t= new Tee(e.getX(),e.getY(),100);
                model.addShape(new Tee(e.getX(),e.getY(),100));               
                x=0;
            }else{
                model.setSelected(e.getX(),e.getY());
            }

        }
        
        

        /**
         * method that use the mouse dragg event to move the selected shape
         * in the window
         * 
         * @param e the mouse dragging event
         */

        public void mouseDragged(MouseEvent e){

            x1=e.getX();
            y=e.getY();
            if(model.myShape()!=null){
                if(model.myShape().isOn(e.getX(),e.getY()) == true){                     
                    model.move(x1-dx,y-dy);
                    //viewPane.notifyViewer( );
                    dx=x1;
                    dy=y;
                }

            }
        }
    }

    /**
     * cass that shows the simulation of event handling using key buttons
     * 
     */
    class ButtonListener implements ActionListener {
        // instance variables DrawingBoard shapes 
        private DrawingBoard model; 

        /**
         * Constructor for objects of class shpae button action listener
         * 
         * @param model the model object of the simulation
         */
        public ButtonListener( DrawingBoard model ) {
            this.model = model;
        }

        /**
         * Process button clicks by turning the shapes to 
         * drifferent shapes like, triangle, circle and tee
         * 
         * @param e the event created by the button click
         */
        public void actionPerformed( ActionEvent e ) {
            if ( e.getActionCommand( ).equals( "Triangle" ) ) {
                x=1;
            } else if ( e.getActionCommand( ).equals( "Circle" ) ) {
                x=2;
            } else if ( e.getActionCommand( ).equals( "T-shape" ) ) {
                x=3;
            }
            if(e.getActionCommand( ).equals( "Remove" ) ){
                model.removeShape();
                //viewPane.notifyViewer( );
            }
            if(e.getActionCommand( ).equals( "red" ) ){                
                model.setColor(Color.RED);
                //viewPane.notifyViewer( );
            }else if(e.getActionCommand( ).equals( "yellow" ) ){
                model.setColor(Color.YELLOW);
                //viewPane.notifyViewer( );
            }else if(e.getActionCommand( ).equals( "green" ) ){
                model.setColor(Color.GREEN);
                //viewPane.notifyViewer( );
            }

        }
    }

    /**
     * class that uses the key listener class and make the use of the up , right , left and down keys
     * to move the selected shape
     */
    class KeyControl implements KeyListener{

        private DrawingBoard model;
        /**
         * Constructor for objects of class SimMouseListener
         * 
         * @param model the model object containing the state of the our model
         *               shapes
         */
        public KeyControl(DrawingBoard model){
            this.model = model;
        }

        /**
         * method used to remove the selected shape if the 
         * F key button is pressed 
         * 
         * @param e the key event that related to pressing of the selected key
         */
        public void keyPressed(KeyEvent e){

            if(e.getKeyChar()==KeyEvent.VK_D){
                model.removeShape();
                //viewPane.notifyViewer( );
            }
            if(e.getKeyChar()==KeyEvent.VK_UP){
                model.move(10,10);
                //viewPane.notifyViewer( );

            }

        }
        
        
        //dummy methods keyListener implimentation 
        public void keyReleased(KeyEvent e){}

        public void keyTyped(KeyEvent e){}

    }
}
