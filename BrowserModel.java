// import java.util.List;
import java.util.Stack;


/**
 * 
 * Our browser will “browse” several lines of text in the same file. Figure 21-5
 * shows the classes that we have to write for this project. As usual, this is a
 * team effort: I’ll provide the LineCruiser, BrowserMouseListener,
 * BrowserControlPanel, and BrowserView classes, and you work on the
 * BrowserModel class.
 *
 * @author Leo Shaw
 * @version Jan 22
 * @author Period: 4
 * @author Assignment: JMCh21_3Browsing
 *
 * @author Sources: none
 */

public class BrowserModel
{
    private BrowserView view;

    private Stack<Integer> backStack; 

    private Stack<Integer> forwardStack; 

    private int topLine;


    /**
     * constructor for Browserview.
     *
     * @param view2
     *            a browser view
     */
    public BrowserModel( BrowserView view2 )
    {
        backStack = new Stack<Integer>();
        forwardStack = new Stack<Integer>();

        view = view2;
        view.update( 0 );

    }


    /**
     * method with the name of followlink
     * which passes the integer n. 
     *
     * @param n
     *            goes to n
     */
    public void followLink( int n )
    {
        Integer num = new Integer( topLine ); 
        backStack.push( num );

        topLine = n;
        view.update( topLine );
        forwardStack.removeAllElements();

    }


    /**
     *  backstack is empty return the value.
     * hasBack Boolean.
     *
     * @return boolean stk
     */
    public boolean hasBack()
    {

        return !backStack.empty();
    }


    /**
     *  forward stack is empty return the
     * value. hasforward Boolean.
     *
     * @return boolean stk
     */
    public boolean hasForward()
    {

        return !forwardStack.empty();
    }


    /**
     * defining a stack of num.
     * Restriction to 0
     */
    public void home()
    {
        Integer num = new Integer( topLine );
        backStack.push( num );

        topLine = 0;
        view.update( topLine );
        forwardStack.removeAllElements();

    }


    /**
     * defining the method of back and
     * stack of n.
     */
    public void back()
    {
        Integer n = new Integer( topLine );
        forwardStack.push( n );

        System.out.println( "backA: " + topLine );
        if ( hasBack() ) 
        {

            int num = backStack.pop().intValue();
            topLine = num;
        }
        view.update( topLine );
        System.out.println( "backB: " + topLine );
    }


    /**
     *  defining the method of forward and
     * stack of n.
     */
    public void forward()
    {

        Integer n = new Integer( topLine );
        backStack.push( n );
        if ( hasForward() ) 
        {

            int num = forwardStack.pop().intValue();
            topLine = num;
            view.update( topLine );
        }
    }


    // For test purposes only
    /**
     * get back
     * 
     * @return stack integer
     */
    public Stack<Integer> getBackStk()
    {
        return backStack;
    }


    /**
     * get forward
     * 
     * @return stack integer
     */
    public Stack<Integer> getForwardStk()
    {
        return forwardStack;
    }


    /**
     * get topline
     * 
     * @return just int
     */
    public int getTopLine()
    {
        return topLine;
    }
}
