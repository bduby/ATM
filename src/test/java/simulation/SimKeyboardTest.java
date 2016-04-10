package simulation;

import atm.ATM;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * @author Robert Wilk
 *         Created on 2/15/2016.
 */
public class SimKeyboardTest {

    SimKeyboard thekey;
    Simulation thesim;
    ATM theatm;
    @Before
    public void setUp() throws Exception
    {
        theatm = new ATM(0, null, null, null);
        thesim = new Simulation(theatm);
        //Way too much coupling...
        thekey = new SimKeyboard(new SimDisplay(), null);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testReadInput() throws Exception {

        assertEquals("a", thekey.readInput(0, thesim.AMOUNT_MODE));

    }




}