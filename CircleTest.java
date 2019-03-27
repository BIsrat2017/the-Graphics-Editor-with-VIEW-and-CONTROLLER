
import java.awt.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;  

/**
 * The test class CircleTest.
 *
  * @author  Bisrat Asefaw
 * @version 10/11/2018
 */
public class CircleTest
{
    /**
     * Default constructor for test class CircleTest
     */
    public CircleTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void TestForIsON(){
        AbstractShape shape= new Circle(5,6,10);
        assertEquals(true,shape.isOn(7,8));
    }
    
    @Test
    public void TestForIsONTrue(){
        AbstractShape shape= new Circle(3,4,10);
        assertEquals(true,shape.isOn(5,6));
    }
    
    @Test
    public void TestForIsONFalse(){
        AbstractShape shape= new Circle(3,2,6);
        assertEquals(false,shape.isOn(9,8));
    }
    
    @Test
    public void TestForGetSetColor(){
        AbstractShape shape= new Circle(3,2,6);
        shape.setColor(Color.RED);
        assertEquals(Color.RED,shape.getColor());
    }
    @Test
    public void TestForBoundingShift(){
        AbstractShape shape= new Circle(10,20,6);
        shape.shiftUpperLeftBy(5,5);
        assertEquals(9,shape.getLeftUpperBoundX());
        assertEquals(19,shape.getLeftUpperBoundY());
    }
    
    @Test
    public void TestForBoundingMove(){
        AbstractShape shape= new Circle(10,20,6);
        shape.moveUpperLeftTo(15,30);
        assertEquals(15,shape.getLeftUpperBoundX());
        assertEquals(30,shape.getLeftUpperBoundY());
    }
}
