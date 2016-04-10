package atm;

import atm.physical.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Robert Wilk, Austin Purcell
 *         Created on 2/15/2016.
 */
public class ATMTest {

    ATM theatm;
    int id;
    String place;
    String bankname;
    @Before
    public void setUp() throws Exception {
        id = 42;//the id to insert
        place = "Gordon College";
        bankname = "First National Bank of Podunk";
        theatm = new ATM(id, place, bankname, InetAddress.getLocalHost());
        //copied this instantiation from ATMMain.
    }

    @After
    public void tearDown() throws Exception {

    }


    //Ensure getters return expected values (ex. id = id still when getting it.
    //These getters are very specific:  What I put in should be spat right back out, since I didn't modify any of them.
    @Test
    public void testGetID()
    {
        assertTrue(theatm.getID() == id);//make sure the ids match for what was given, and for the accessor of id.
    }

    @Test
    public void testGetPlace()
    {
        assertEquals(place, theatm.getPlace());
    }

    @Test
    public void testGetBankName()
    {
        assertEquals(bankname, theatm.getBankName());
    }


    //these are more vague getter tests:  I'm only going to test that the instance matches what should be outputted.
    @Test
    public void testGetCardReader()
    {
        assert(theatm.getCardReader() instanceof CardReader);
    }

    @Test
    public void testGetCashDispenser()
    {
        assert(theatm.getCashDispenser() instanceof CashDispenser);
    }

    @Test
    public void testGetCustomerConsole()
    {
        assert(theatm.getCustomerConsole() instanceof CustomerConsole);
    }

    @Test
    public void testGetEnvelopeAcceptor()
    {
        assert(theatm.getEnvelopeAcceptor() instanceof EnvelopeAcceptor);
    }

    @Test
    public void testGetLog()
    {
        assert(theatm.getLog() instanceof Log);
    }

    @Test
    public void testGetNetworkToBank()
    {
        assert(theatm.getNetworkToBank() instanceof NetworkToBank);
    }

    @Test
    public void testGetOperatorPanel()
    {
        assert(theatm.getOperatorPanel() instanceof OperatorPanel);
    }

    @Test
    public void testGetRecieptPrinter()
    {
        assert(theatm.getReceiptPrinter() instanceof ReceiptPrinter);
    }


}