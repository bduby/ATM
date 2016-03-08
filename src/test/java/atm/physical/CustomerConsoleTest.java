package atm.physical;

import atm.physical.CustomerConsole;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Robert Wilk
 *         Created on 2/15/2016.
 */
public class CustomerConsoleTest {

    CustomerConsole customerConsole;

    @Before
    public void setUp() throws Exception {
        customerConsole = new CustomerConsole();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testDisplayPromptNotNull() throws Exception {
        customerConsole.display(null);
    }

    @Test
    public void testReadPIN() throws Exception {

    }

    @Test
    public void testReadMenuChoice() throws Exception {

    }

    @Test
    public void testReadAmount() throws Exception {

    }
}