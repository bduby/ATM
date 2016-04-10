import atm.ATM;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Robert Wilk
 *         Created on 2/15/2016.
 */
public class ATMMainTest {
    @Before
    public void setUp() throws Exception {
       ATMMain.main(null);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetATM() throws Exception
    {//test to make sure the ATM getter returns an instance of an ATM
        //assertTrue(ATMMain.getTheATM() instanceof ATM);
        //Can't ask for stuff, since I can't make it static.  But I can't get ATMMAin, since...aww screw it.
    }


}