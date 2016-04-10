package atm.transaction;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Robert Wilk
 *         Created on 2/15/2016.
 */
public class WithdrawalTest extends TestCase{

    @Before
    public void setUp() throws Exception
    {
        Withdrawal withdrawtest = new Withdrawal(null, null, null, 0);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetSpecificsFromCustomer() throws Exception {

    }

    @Test
    public void testCompleteTransaction() throws Exception {

    }
}