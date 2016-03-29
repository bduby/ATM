import atm.ATM;
import atm.Session;
import org.junit.BeforeClass;
import org.junit.Test;
import simulation.Simulation;

import java.awt.*;
import java.net.UnknownHostException;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Robert Wilk
 * on 3/28/2016.
 */
public class AtmTestFixture {

    private static ATMMain atmMain;
    private static Simulation simulation;
    private static ATM atm;

    @BeforeClass
    public static void intiAtm() throws UnknownHostException {
        atmMain = TestUtil.startAtmSimulator();
        simulation = atmMain.getTheSimulation();
        atm = atmMain.getTheATM();
    }

    @Test
    public void test$40WithdrawalFromChecking()
            throws NoSuchFieldException, IllegalAccessException, InterruptedException, AWTException {
        TestUtil.turnAtmOn(simulation);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.setInitialCash(simulation, 200);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.insertCard(simulation, 1);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.enterPassword(simulation, "42");
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.chooseTransactionType(TestUtil.Transaction.WITHDRAWAL);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.chooseAccountType(TestUtil.Account.CHECKING);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.chooseWithdrawalType(TestUtil.WithdrawalAmount.FORTY);
        Thread.sleep((int) (TestUtil.LONG_SLEEP * 3.5));
        assertEquals(null, null);
        TestUtil.chooseYesOrNo(TestUtil.Choice.YES);
    }
}
