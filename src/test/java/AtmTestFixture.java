import atm.ATM;
import atm.physical.CustomerConsole;
import atm.transaction.Withdrawal;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import simulation.Simulation;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by Robert Wilk
 * on 3/28/2016.
 */
public class AtmTestFixture {
    /**
     * The launcher for the ATM simulator.
     */
    private static ATMMain atmMain;
    /**
     * The simulation associated with the ATM simulator.
     */
    private static Simulation simulation;
    /**
     * The ATM associated with the ATM simulator.
     */
    private static ATM atm;

    /**
     * Sets up the test fixture with an instance of the ATMMain class
     * and its associated simulation and atm instances.
     * @throws UnknownHostException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws InterruptedException
     * @throws AWTException
     */
    @BeforeClass
    public static void intiAtm()
            throws UnknownHostException, NoSuchFieldException, IllegalAccessException, InterruptedException, AWTException {
        atmMain = TestUtil.startAtmSimulator();
        simulation = atmMain.getTheSimulation();
        atm = atmMain.getTheATM();
        TestUtil.turnAtmOn(simulation);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.setInitialCash(simulation, 200);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.insertCard(simulation, 1);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.enterPassword(simulation, "42");
        Thread.sleep(TestUtil.SHORT_SLEEP);
    }

    /**
     * Closes the atm main frame after all tests in the fixture have completed.
     */
    @AfterClass
    public static void tearDownAtm() {
        Frame frame = atmMain.getMainFrame();
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    /**
     * Tests depositing $40 into the checking account for the fixture's account.
     * Pass/Fail is determined by the visibility of the "Take receipt" button
     * which only appears if the deposit was a success.
     * @throws IllegalAccessException
     * @throws AWTException
     * @throws NoSuchFieldException
     * @throws InterruptedException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    @Test
    public void testDepositing$40IntoChecking()
            throws IllegalAccessException, AWTException, NoSuchFieldException, InterruptedException,
            NoSuchMethodException, InvocationTargetException {
        TestUtil.chooseTransactionType(TestUtil.Transaction.DEPOSIT);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.chooseAccountType(TestUtil.Account.CHECKING);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.enterDepositAmount(simulation, 4000);
        Thread.sleep(TestUtil.MEDIUM_SLEEP);
        TestUtil.insertEnvelope(simulation);
        Thread.sleep(TestUtil.LONG_SLEEP * 3);
        Button take = TestUtil.checkForReceipt(simulation);
        if (take == null)
            fail("DEPOSIT FAILED: No receipt printed for deposit\n");
        for (ActionListener actionListener : take.getActionListeners())
            actionListener.actionPerformed(null);
        TestUtil.chooseYesOrNo(TestUtil.Choice.YES);
        Thread.sleep(TestUtil.SHORT_SLEEP);
    }

    // TODO: Brian this needs javadocs!
    @Test
    public void test$40WithdrawalFromChecking() throws NoSuchFieldException, IllegalAccessException, InterruptedException, AWTException {
        TestUtil.chooseTransactionType(TestUtil.Transaction.WITHDRAWAL);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.chooseAccountType(TestUtil.Account.CHECKING);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.chooseWithdrawalType(TestUtil.WithdrawalAmount.FORTY);
        Thread.sleep((int) (TestUtil.LONG_SLEEP * 3.5));
        Button take = TestUtil.checkForReceipt(simulation);
        if (take == null)
            fail("WITHDRAWAL FAILED: No receipt printed for withdrawal\n");
        for (ActionListener actionListener : take.getActionListeners())
            actionListener.actionPerformed(null);
        TestUtil.chooseYesOrNo(TestUtil.Choice.YES);
        Thread.sleep(TestUtil.SHORT_SLEEP);
<<<<<<< HEAD
=======
    }

    /**
     * Tests making a balance inquiry the checking account for the fixture's account.
     * Pass/Fail is determined by the visibility of the "Take receipt" button
     * which only appears if the deposit was a success.
     * @throws IllegalAccessException
     * @throws AWTException
     * @throws NoSuchFieldException
     * @throws InterruptedException
     */
    @Test
    public void testBalanceInquiryChecking()
            throws NoSuchFieldException, IllegalAccessException, AWTException, InterruptedException {
        TestUtil.chooseTransactionType(TestUtil.Transaction.BALANCE_INQUIRY);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.chooseAccountType(TestUtil.Account.CHECKING);
        Thread.sleep((int) (TestUtil.LONG_SLEEP * 3.5));
        Button take = TestUtil.checkForReceipt(simulation);
        if (take == null)
            fail("WITHDRAWAL FAILED: No receipt printed for withdrawal\n");
        for (ActionListener actionListener : take.getActionListeners())
            actionListener.actionPerformed(null);
        TestUtil.chooseYesOrNo(TestUtil.Choice.YES);
        Thread.sleep(TestUtil.SHORT_SLEEP);
>>>>>>> a846b0c9333926fe30f7bf556b08b486b7e2cf88
    }
}
