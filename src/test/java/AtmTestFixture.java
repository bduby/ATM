import atm.ATM;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import simulation.Simulation;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;

import static junit.framework.Assert.*;

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
     *
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
     *
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
        turnATMOnAndAddTwenties(5);
        insertCard(1, "42");
        chooseTransactionAndAccountType(TestUtil.Transaction.DEPOSIT, TestUtil.Account.CHECKING);
        TestUtil.enterDepositAmount(simulation, 4000);
        Thread.sleep(TestUtil.MEDIUM_SLEEP);
        TestUtil.insertEnvelope(simulation);
        Thread.sleep(TestUtil.LONG_SLEEP * 3);
        Button button = TestUtil.checkForReceipt(simulation);
        boolean successful = button != null;
        turnATMOff();
        Thread.sleep(TestUtil.MEDIUM_SLEEP);
        checkForSuccessAndPerformAction(button, successful, "DEPOSIT: Deposit into checking was unsuccessful!");
    }

    /**
     * Tests withdrawal $40 from the checking account for the fixture's account.
     * Pass/Fail is determined by the visibility of the "Take receipt" button
     * which only appears if the withdrawal was a success.
     *
     * @throws IllegalAccessException
     * @throws AWTException
     * @throws NoSuchFieldException
     * @throws InterruptedException
     */
    @Test
    public void test$40WithdrawalFromChecking() throws NoSuchFieldException, IllegalAccessException, InterruptedException, AWTException {
        turnATMOnAndAddTwenties(5);
        insertCard(1, "42");
        chooseTransactionAndAccountType(TestUtil.Transaction.WITHDRAWAL, TestUtil.Account.CHECKING);
        TestUtil.chooseWithdrawalType(TestUtil.WithdrawalAmount.FORTY);
        Thread.sleep(TestUtil.LONG_SLEEP * 3);
        Button button = TestUtil.checkForReceipt(simulation);
        boolean successful = button != null;
        turnATMOff();
        Thread.sleep(TestUtil.MEDIUM_SLEEP);
        checkForSuccessAndPerformAction(button, successful, "Withdrawal: withdrawal from checking was unsuccessful!");
    }

    /**
     * Tests withdrawal $200 from the checking account for the fixture's account.
     * Pass/Fail determined by visibility of "Take receipt" button
     * @throws IllegalAccessException
     * @throws AWTException
     * @throws NoSuchFieldException
     * @throws InterruptedException
     */
    @Test
    public void testWithdrawInsufficientFunds()
    throws NoSuchFieldException, IllegalAccessException, InterruptedException, AWTException {
        turnATMOnAndAddTwenties(5);
        insertCard(1, "42");
        TestUtil.chooseTransactionType(TestUtil.Transaction.WITHDRAWAL);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.chooseAccountType(TestUtil.Account.CHECKING);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.chooseWithdrawalType(TestUtil.WithdrawalAmount.TWO_HUNDRED);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        Label[] theDisplay = TestUtil.getCurrentDisplay(simulation);
        boolean passed = theDisplay[0].getText().equals("Insufficient cash available");
        cancelForNextTest();
        turnATMOff();
        if (!passed)
            fail("WITHDRAWAL FAILED: The ATM did not stop a withdrawal that was greater than its cash on hand!");
    }

    /**
     * Tests making a balance inquiry the checking account for the fixture's account.
     * Pass/Fail is determined by the visibility of the "Take receipt" button
     * which only appears if the deposit was a success.
     *
     * @throws IllegalAccessException
     * @throws AWTException
     * @throws NoSuchFieldException
     * @throws InterruptedException
     */
    @Test
    public void testBalanceInquiryChecking()
            throws NoSuchFieldException, IllegalAccessException, AWTException, InterruptedException {
        Label theDisplay[] = TestUtil.getCurrentDisplay(simulation);
        if (theDisplay[0].getText().compareTo("Not currently available") == 0)
            turnATMOnAndAddTwenties(10);
        else
            fail("BALANCE INQUIRY FAILED: ATM was not off, could not turn ATM on.\n");

        theDisplay = TestUtil.getCurrentDisplay(simulation);
        if (theDisplay[0].getText().compareTo("Please insert your card") == 0)
            insertCard(1, "42");
        else
            fail("BALANCE INQUIRY FAILED: ATM was not at Insert Card prompt, could not insert card.\n");

        theDisplay = TestUtil.getCurrentDisplay(simulation);
        if (theDisplay[0].getText().compareTo("Please choose transaction type") == 0) {
            chooseTransactionAndAccountType(TestUtil.Transaction.BALANCE_INQUIRY, TestUtil.Account.CHECKING);
            Thread.sleep(TestUtil.LONG_SLEEP * 3);
        } else
            fail("BALANCE INQUIRY FAILED: Error selecting transaction and account types.\n");


        theDisplay = TestUtil.getCurrentDisplay(simulation);
        if (theDisplay[0].getText().compareTo("Would you like to do another transaction?") == 0) {
            Button take = TestUtil.checkForReceipt(simulation);
            if (take == null) {
                cancelForNextTest();
                fail("BALANCE INQUIRY FAILED: No receipt printed for balance inquiry of checking account.\n");
            }
            for (ActionListener actionListener : take.getActionListeners())
                actionListener.actionPerformed(null);
        } else
            fail("BALANCE INQUIRY FAILED: ATM Did not prompt for another transaction after inquiry.\n");
        turnATMOff();
        Thread.sleep(TestUtil.MEDIUM_SLEEP);

        theDisplay = TestUtil.getCurrentDisplay(simulation);
        if (theDisplay[0].getText().compareTo("Not currently available") != 0)
            fail("BALANCE INQUIRY FAILED: ATM did not shut off properly at the end.\n");

        Thread.sleep(TestUtil.MEDIUM_SLEEP);
    }

    /**
     * Austin Purcell made this.  Like, super late.
     * Performs a transfer from one account to another.
     * Pass/Fail determined by visibility of "Take receipt" button
     * @throws InterruptedException
     * @throws AWTException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void testTransferFromCheckingToSaving()
            throws NoSuchFieldException, IllegalAccessException, AWTException, InterruptedException
    {
        turnATMOnAndAddTwenties(5);//put some money in this bank, yo.
        insertCard(1, "42");//insert the pin, like we do with user input.
        TestUtil.chooseTransactionType(TestUtil.Transaction.TRANSFER);//I will do a transfer today.
        Thread.sleep(TestUtil.SHORT_SLEEP);//sleep for a bit, threads and mutex locks.
        TestUtil.chooseAccountType(TestUtil.Account.CHECKING);//transferring from checking
        Thread.sleep(TestUtil.SHORT_SLEEP);//sleep for a bit, threads and mutex locks.
        TestUtil.chooseAccountType(TestUtil.Account.SAVINGS);//transferring to savings account
        Thread.sleep(TestUtil.SHORT_SLEEP);//sleep for a bit, threads and mutex locks.
        TestUtil.enterDepositAmount(simulation, 40);//deposit is just entering input as though it was a number on the keyboard.
        //so just use this...
        Thread.sleep(TestUtil.LONG_SLEEP*3);//wait a long time, due to animations of the reciept.
        Button takereceiptbutton = TestUtil.checkForReceipt(simulation);//check to see that a button is there
        assertNotNull(takereceiptbutton);//make sure the button isn't null.
        turnATMOff();//gonna turn the thing off when i'm done, just because the other tests probably need this off.
        Thread.sleep(TestUtil.MEDIUM_SLEEP);//sleep for a decent amount.






    }





/*    @Test
    public void testTransferFunds()
            throws InterruptedException, AWTException, NoSuchFieldException, IllegalAccessException
    {
        TestUtil.chooseTransactionType(TestUtil.Transaction.TRANSFER);//we will transfer, so use this transaction.
        Thread.sleep(TestUtil.SHORT_SLEEP);//take a bit of a break.  Probably for animations.
        TestUtil.chooseAccountType(TestUtil.Account.CHECKING);//choose the account type to transfer from.
        Thread.sleep(TestUtil.SHORT_SLEEP);//more animations.
        TestUtil.chooseAccountType(TestUtil.Account.SAVINGS);//choose the account type to transfer to.
        Thread.sleep(TestUtil.SHORT_SLEEP);//more animations
        TestUtil.enterDepositAmount( Simulation.getInstance(), 2000);//Select an amount to transfer to, and press enter.
        //effectively transfer 20 dollars.
        TestUtil.pressEnter();//enter the stuff
        Thread.sleep(TestUtil.LONG_SLEEP*3);//wait for a loooong time to process.
        Button take = TestUtil.checkForReceipt(simulation);
        if (take == null){
            cancelForNextTest();
            fail("TRANSFER FAILED: No receipt printed for Transfer!");
        }
        for (ActionListener actionListener : take.getActionListeners())
            actionListener.actionPerformed(null);
        TestUtil.chooseYesOrNo(TestUtil.Choice.YES);//Thing prompts for another transaction
        Thread.sleep(TestUtil.SHORT_SLEEP);
    }*/

    // Support Methods for Tests...

    /**
     * Support method for getting the simulation to the
     * Select Transaction screen, to prep for the next test
     * before failing.
     *
     * @throws InterruptedException
     * @throws AWTException
     */
    private void cancelForNextTest()
            throws InterruptedException, AWTException {
        TestUtil.cancelTrans(TestUtil.Button.CANCEL);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.chooseYesOrNo(TestUtil.Choice.YES);
        Thread.sleep(TestUtil.SHORT_SLEEP);
    }

    /**
     * Support method for starting ATM and inserting initial money
     *
     * @param initTwenties The number of twenties to initialize the ATM with.
     * @throws InterruptedException
     * @throws AWTException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    private void turnATMOnAndAddTwenties(int initTwenties)
            throws InterruptedException, AWTException, IllegalAccessException, NoSuchFieldException {
        TestUtil.turnAtmOn(simulation);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.setInitialCash(simulation, initTwenties);
        Thread.sleep(TestUtil.SHORT_SLEEP);
    }

    /**
     * Support method for inserting card and entering pin
     *
     * @param cardNumber The given card number.
     * @param pin        The given pin.
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws AWTException
     * @throws InterruptedException
     */
    private void insertCard(int cardNumber, String pin)
            throws NoSuchFieldException, IllegalAccessException, AWTException, InterruptedException {
        TestUtil.insertCard(simulation, cardNumber);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.enterPassword(simulation, pin);
        Thread.sleep(TestUtil.SHORT_SLEEP);
    }

    /**
     * Support method for turning off the atm
     *
     * @throws AWTException
     * @throws InterruptedException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private void turnATMOff()
            throws AWTException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        TestUtil.cancelTrans(TestUtil.Button.CANCEL);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.chooseYesOrNo(TestUtil.Choice.YES);
        Thread.sleep(TestUtil.LONG_SLEEP);
        TestUtil.turnAtmOff(simulation);
    }

    /**
     * Support method for choosing transaction and account types
     *
     * @param transaction The type of transaction you would like to make
     * @param account The account you would like to act on
     * @throws InterruptedException
     * @throws AWTException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private void chooseTransactionAndAccountType(TestUtil.Transaction transaction, TestUtil.Account account)
            throws InterruptedException, AWTException, NoSuchFieldException, IllegalAccessException {
        TestUtil.chooseTransactionType(transaction);
        Thread.sleep(TestUtil.SHORT_SLEEP);
        TestUtil.chooseAccountType(account);
        Thread.sleep(TestUtil.SHORT_SLEEP);
    }

    /**
     * Support method for checking success, and handling failure or taking receipt
     *
     * @param button The button to be acted on if successful
     * @param successful The boolean that determines success
     * @param msg The message to fail with
     */
    private void checkForSuccessAndPerformAction(Button button, boolean successful, String msg) {
        if (!successful)
            fail(msg);
        else
            TestUtil.performActionOnButton(button);
    }
}