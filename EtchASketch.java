import acm.program.GraphicsProgram;
import acm.graphics.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

/**
 * class EtchASketch creates an
 * etch a sketch using a turtle marker
 * and user interaction.
 * 
 * This is a template that includes
 *  - code framework with init method
 *  - code framework for keyboard control
 *  - code framework for 1 button
 *  
 *  Students will modify and in the process practice
 *  - reading class APIs
 *  - using constructors and methods for provided classes
 *
 * API References
 *     KeyEvent 
 *     https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyEvent.html
 *     GTurtle
 *     https://cs.stanford.edu/people/eroberts/jtf/javadoc/student/acm/graphics/GTurtle.html
 *     GraphicsProgram
 *     https://cs.stanford.edu/people/eroberts/jtf/javadoc/student/acm/program/GraphicsProgram.html
 *     All ACM package classes
 *     https://cs.stanford.edu/people/eroberts/jtf/javadoc/student/index.html
 *     
 * Students:
 * <Add comment documenting your program functionality>
 * @author J. Smith
 * @author <student name>
 * @version October 2020
 */
public class EtchASketch extends GraphicsProgram
{
    private static int UP = -1;
    private static int DOWN = 1;
    private static int NOCHANGE = 0;
    private JButton penUp;
    private JTextField  uiCommand;
    private GTurtle turtle;
    private JLabel uiMsg;
    private JButton uiButton;
    
    public void init ()
    {
        penUp = new JButton("Pen Up");
        add(penUp, EAST);
        JLabel cmdMsg = new JLabel("Enter command >");
        add(cmdMsg, NORTH);
        uiCommand = new JTextField(30);
        add(uiCommand, NORTH);
        uiMsg = new JLabel("Program status: ");
        add(uiMsg, SOUTH);
        uiButton = new JButton("ENTER");
        add(uiButton, NORTH);
        turtle = new GTurtle();
        double turtleStartX = getGCanvas().getWidth()/2;
        double turtleStartY = getGCanvas().getHeight()/2;
        add(turtle,turtleStartX ,turtleStartY );
        addActionListeners(this);
        addKeyListeners(this);
    }
    
    public void actionPerformed (ActionEvent aEvent)
    {
       String choice = aEvent.getActionCommand();
       displayUImessage(choice);
        if (choice.equals("Pen Up"))
        {
            displayUImessage("choice");
        }
        else if (choice.equals("ENTER"))
        {
            String commandWord = parseCommand(uiCommand.getText());
            doCommand(commandWord);
        }
  
    }
    
    public void keyPressed (KeyEvent kEvent)
    {
        int keycode = kEvent.getKeyCode();
        if (keycode == KeyEvent.VK_UP)
        {
            turtle.move(NOCHANGE, UP);
        }
    }
    
    private String parseCommand(String command)
    {
        return "";
    }
    
    private void doCommand(String command)
    {
        displayUImessage(command);
    }
    
    private void displayUImessage (String msg)
    {
        uiMsg.setText("Program Status: executing command " + msg);
    }
}
