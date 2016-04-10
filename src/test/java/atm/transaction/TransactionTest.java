package atm.transaction;

import atm.ATM;
import atm.physical.CustomerConsole;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.*;
import simulation.Simulation;
//import simulation.SimKeyboard;can't do;  not public.

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Robert Wilk
 *         Created on 2/15/2016.
 */
public class TransactionTest {

    ATM theatm;
    Simulation thesim;
    //SimKeyboard thekey;
    @Before
    public void setUp() throws Exception
    {//ATM is always required to be available, if transaction is to not throw an exception for it.
        theatm = new ATM(0, null, null, null);
        //which is necessary for the CustomerConsole to get "user" input.
        //which then calls readMenuChoice, which then calls Simulation for input......
        thesim = new Simulation(theatm);
        //to which Simulation has SimKeyboard.........
        //thekey = new SimKeyboard();
        //to which I can't even get the SimKeyBoard in any way, due to not having an accessor and sufficient access to it.
        //So I said, "screw it", let's use Reflection to get private stuff.
        //Method simKeyMethod = SimKeyboard.getDeclaredmethod();
        //to which I can't reflect on a default accessible class because I can't import it......


    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void testMakeWithdrawal() throws Exception
    {//make sure that if the transaction choice is 0, then a withdrawal is returned.
        //theatm.getCustomerConsole().readMenuChoice("Please choose transaction type",new String[]{ "Withdrawal", "Deposit", "Transfer", "Balance Inquiry" });//effectively pretend to get user input.

        //pretend to give user input that selects withdrawal
        //thesim.readInput(thesim.MENU_MODE, 0);
        //assertEquals(new Withdrawal(theatm,null,null,0), Transaction.makeTransaction(theatm,null,null,0));
        //assertTrue(Transaction.makeTransaction(theatm,null,null,0) instanceof Withdrawal);
        //make sure that the result of this transaction is an instance of a withdrawal.
    }

    @Test
    public void testMakeDeposit() throws Exception {

    }

    @Test
    public void testMakeTransfer() throws Exception {

    }

    @Test
    public void testMakeInquiry() throws Exception {

    }

    @Test
    public void testReturnNull() throws Exception
    {//make sure that if no proper input is given for choice, null is returned


        //assertEquals(null, Transaction.makeTransaction(theatm, null, null, 0));
        //assertTrue(Transaction.makeTransaction(theatm, null, null, 0) == null);
    }


    /*@Test
    public void testSerialNumber() throws Exception
    {
        //assertEquals(Transaction.getSerialNumber(), 1);
    }*/
}