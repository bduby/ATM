package simulation;

import atm.ATM;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;

import static org.junit.Assert.assertEquals;

/**
 * @author Robert Wilk
 *         Created on 2/15/2016.
 */
public class SimulationTest {

    ATM theatm;//Luckily, this is somewhat like a built in inversion of control.  Maybe.  It is instantiated outside the constructor.
    int id;
    String place;
    String bankname;
    Simulation thesim;

    @Before
    public void setUp() throws Exception
    {
        id = 42;//the id to insert
        place = "Gordon College";
        bankname = "First National Bank of Podunk";
        theatm = new ATM(id, place, bankname, InetAddress.getLocalHost());
        //copied this instantiation from ATMMain.
        thesim = new Simulation(theatm);//make the actual thing we're testing.
    }

    @After
    public void tearDown() throws Exception {

    }


    //getters
    @Test
    public void testGetInstance() throws Exception {//this getter allows another class to get the Simulation itself
        assert(thesim.getInstance() instanceof Simulation);

    }
}