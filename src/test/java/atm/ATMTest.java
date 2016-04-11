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
    public void testGetID() throws Exception
    {
        assertTrue(theatm.getID() == id);//make sure the ids match for what was given, and for the accessor of id.
    }

    @Test
    public void testGetPlace() throws Exception
    {
        assertEquals(place, theatm.getPlace());
    }

    @Test
    public void testGetBankName() throws Exception
    {
        assertEquals(bankname, theatm.getBankName());
    }


    //these are more vague getter tests:  I'm only going to test that the instance matches what should be outputted.
    @Test
    public void testGetCardReader() throws Exception
    {
        assert(theatm.getCardReader() instanceof CardReader);
    }

    @Test
    public void testGetCashDispenser() throws Exception
    {
        assert(theatm.getCashDispenser() instanceof CashDispenser);
    }

    @Test
    public void testGetCustomerConsole() throws Exception
    {
        assert(theatm.getCustomerConsole() instanceof CustomerConsole);
    }

    @Test
    public void testGetEnvelopeAcceptor() throws Exception
    {
        assert(theatm.getEnvelopeAcceptor() instanceof EnvelopeAcceptor);
    }

    @Test
    public void testGetLog() throws Exception
    {
        assert(theatm.getLog() instanceof Log);
    }

    @Test
    public void testGetNetworkToBank() throws Exception
    {
        assert(theatm.getNetworkToBank() instanceof NetworkToBank);
    }

    @Test
    public void testGetOperatorPanel() throws Exception
    {
        assert(theatm.getOperatorPanel() instanceof OperatorPanel);
    }

    @Test
    public void testGetRecieptPrinter() throws Exception
    {
        assert(theatm.getReceiptPrinter() instanceof ReceiptPrinter);
    }


}