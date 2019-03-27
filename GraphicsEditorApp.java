import java.awt.*;
import javax.swing.*;
/**
 * demonstration program for creating the main method for 
 * creating the jFrame and setting its default dimention and 
 * for creating a controler objact and register with the model
 *
 * @author Bisrat Asefaw    
 * @version 10/21/2018
 */
public class GraphicsEditorApp{

    public static void main(String[] args){

        JFrame frame = new JFrame( "Shapes Demo" );
        JPanel jp=new JPanel();
        frame.setPreferredSize(new Dimension (700,700));
        DrawingBoard myBoard=new DrawingBoard();
        Controller c=new Controller(myBoard);
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        frame.getContentPane( ).add( c );
        frame.add(jp,BorderLayout.SOUTH);
        frame.pack( );        
        frame.setVisible( true );

    }

}
