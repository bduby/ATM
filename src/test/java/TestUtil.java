import simulation.Simulation;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by Robert Wilk
 * on 3/24/2016.
 */
public class TestUtil {
    /**
     * Equals 1 second of sleep time
     */
    public static final int SHORT_SLEEP     = 1000;
    /**
     * Equals 2.5 second of sleep time
     */
    public static final int MEDIUM_SLEEP    = 2500;
    /**
     * Equals 5 second of sleep time
     */
    public static final int LONG_SLEEP      = 5000;

    /**
     * Maps transaction menu options to key presses.
     */
    public enum Transaction {
        WITHDRAWAL(KeyEvent.VK_1),
        DEPOSIT(KeyEvent.VK_2),
        TRANSFER(KeyEvent.VK_3),
        BAL_INQUIRY(KeyEvent.VK_4);

        private int keyEvent;

        Transaction(int keyEvent) {
            this.keyEvent = keyEvent;
        }

        public int getKeyEvent() {
            return keyEvent;
        }
    }

    /**
     * Maps account menu options to key presses.
     */
    public enum Account {
        CHECKING(KeyEvent.VK_1),
        SAVINGS(KeyEvent.VK_2),
        MONEY_MARKET(KeyEvent.VK_3);

        private int keyEvent;

        Account(int keyEvent) {
            this.keyEvent = keyEvent;
        }

        public int getKeyEvent() {
            return keyEvent;
        }
    }

    /**
     * Maps withdrawal amount menu options to key presses.
     */
    public enum WithdrawalAmount {
        TWENTY(1, KeyEvent.VK_1),
        FORTY(2, KeyEvent.VK_2),
        SIXTY(3, KeyEvent.VK_3),
        ONE_HUNDRED(5, KeyEvent.VK_4),
        TWO_HUNDRED(10, KeyEvent.VK_5);

        private static final int base = 20;

        private int amount;
        private int keyEvent;

        WithdrawalAmount(int factor, int keyEvent) {
            amount = base * factor;
            this.keyEvent = keyEvent;
        }

        public int getAmount() {
            return amount;
        }

        public int getKeyEvent() {
            return keyEvent;
        }
    }

    /**
     * Maps a yes/no menu option to key presses.
     */
    public enum Choice {
        YES(KeyEvent.VK_1), NO(KeyEvent.VK_2);

        private int keyEvent;

        Choice(int keyEvent) {
            this.keyEvent = keyEvent;
        }

        public int getKeyEvent() {
            return keyEvent;
        }
    }

    /**
     * Starts a new instance of the ATM simulator.
     * @return The ATM simulator instance.
     * @throws UnknownHostException
     */
    public static ATMMain startAtmSimulator() throws UnknownHostException {
        return new ATMMain();
    }

    /**
     * Turns on the atm associated with the simulation by simulating an event
     * on the button that turns the atm on.
     * @param simulation The current simulation.
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void turnAtmOn(Simulation simulation)
            throws NoSuchFieldException, IllegalAccessException {
        Panel opPanel = (Panel) getObjectByField(simulation, "operatorPanel");
        Component[] components = opPanel.getComponents();
        Button button = (Button) ((Panel) components[2]).getComponent(0);
        for (ActionListener actionListener : button.getActionListeners()) {
            actionListener.actionPerformed(null);
        }
    }

    /**
     * Sets the initial cash-on-hand amount for the atm.
     * @param simulation The current simulation.
     * @param cash The number of twenties to begin with.
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws AWTException
     */
    public static void setInitialCash(Simulation simulation, int cash)
            throws NoSuchFieldException, IllegalAccessException, AWTException {
        Object gui = simulation.getGUI();
        Object panel = getObjectByField(gui, "billsPanel");
        TextField billsNumberField = (TextField) getObjectByField(panel, "billsNumberField");
        billsNumberField.setText(String.valueOf(cash));
        pressEnter();
    }

    /**
     * Gets the text currently displayed in the atm GUI.
     * @param simulation The current simulation.
     * @return An array of labels containing the display text.
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static Label[] getCurrentDisplay(Simulation simulation)
    throws NoSuchFieldException, IllegalAccessException {
        Object simDisplay = getObjectByField(simulation, "display");
        return (Label[]) getObjectByField(simDisplay, "displayLine");
    }

    /**
     * Inserts a card with the given card number.
     * @param simulation The current simulation.
     * @param cardNumber The user's card number.
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws InterruptedException
     * @throws AWTException
     */
    public static void insertCard(Simulation simulation, int cardNumber)
            throws NoSuchFieldException, IllegalAccessException, InterruptedException, AWTException {
        Button simReader = (Button) getObjectByField(simulation, "cardReader");
        Arrays.asList(simReader.getActionListeners()).forEach(l -> l.actionPerformed(null));
        Object panel = getObjectByField(simulation.getGUI(), "cardPanel");
        TextField cardNumberField = (TextField) getObjectByField(panel, "cardNumberField");
        Thread.sleep(MEDIUM_SLEEP);
        cardNumberField.setText(String.valueOf(1));
        pressEnter();
    }

    /**
     * Enters the password after a card was inserted.
     * @param simulation The current simulation
     * @param password The password for the inserted card.
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws AWTException
     */
    public static void enterPassword(Simulation simulation, String password)
            throws NoSuchFieldException, IllegalAccessException, AWTException {
        Object keyboard = getObjectByField(simulation, "keyboard");
        ((StringBuffer) getObjectByField(keyboard, "currentInput")).append(password);
        pressEnter();
    }

    /**
     * Chooses a transaction type if prompted by simulating the appropriate key press.
     * @param transaction The transaction type.
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws AWTException
     */
    public static void chooseTransactionType(TestUtil.Transaction transaction)
            throws NoSuchFieldException, IllegalAccessException, AWTException {
        press(transaction.getKeyEvent());
    }

    /**
     * Chooses an account type if prompted by simulating the appropriate key press.
     * @param account The account type.
     * @throws AWTException
     */
    public static void chooseAccountType(TestUtil.Account account) throws AWTException {
        press(account.getKeyEvent());
    }

    /**
     * Chooses a withdrawal amount if prompted by simulating the appropriate key press.
     * @param withdrawalAmount The amount to withdrawal.
     * @throws AWTException
     */
    public static void chooseWithdrawalType(TestUtil.WithdrawalAmount withdrawalAmount) throws AWTException {
        press(withdrawalAmount.getKeyEvent());
    }

    /**
     * Makes a yes/no choice if prompted by simulating the appropriate key press.
     * @param choice The choice made.
     * @throws AWTException
     */
    public static void chooseYesOrNo(Choice choice) throws AWTException {
        press(choice.getKeyEvent());
    }

    /**
     * Gets a declared field from an object using reflection.
     * @param object The object with the field.
     * @param name The declared name of the field.
     * @return The field.
     * @throws NoSuchFieldException
     */
    static Field getDeclaredField(Object object, String name) throws NoSuchFieldException {
        return object.getClass().getDeclaredField(name);
    }

    /**
     * Gets a declared field from an object using reflection and sets it as accessible.
     * @param object The object with the field.
     * @param name The declared name of the field.
     * @return The accessible field.
     * @throws NoSuchFieldException
     */
    static Field getAccessibleDeclaredField(Object object, String name) throws NoSuchFieldException {
        Field field = getDeclaredField(object, name);
        field.setAccessible(true);
        return field;
    }

    /**
     * Gets the Object representation of a declared field using reflection.
     * @param object The object with the field.
     * @param name The declared name of the field.
     * @return The object associated to the field.
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    static Object getObjectByField(Object object, String name) throws NoSuchFieldException, IllegalAccessException {
        Field field = getAccessibleDeclaredField(object, name);
        return field.get(object);
    }

    /**
     * Simulates a press of the enter key.
     * @throws AWTException
     */
    static void pressEnter() throws AWTException {
        press(KeyEvent.VK_ENTER);
    }

    /**
     * Simulates the press a some key.
     * @param keyEvent The integer value of the key event.
     * @throws AWTException
     */
    static void press(int keyEvent) throws AWTException {
        new Robot().keyPress(keyEvent);
    }

    /**
     * A test of the TestUtil functionality.
     * @param args Not used.
     * @throws UnknownHostException
     * @throws InterruptedException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws AWTException
     */
    public static void main(String[] args)
            throws UnknownHostException,
            InterruptedException,
            NoSuchFieldException,
            IllegalAccessException, AWTException, NoSuchMethodException, InvocationTargetException {
        ATMMain atmMain = new ATMMain();
        Simulation simulation = atmMain.getTheSimulation();
        Thread.sleep(SHORT_SLEEP);
        TestUtil.turnAtmOn(simulation);
        Thread.sleep(SHORT_SLEEP);
        TestUtil.setInitialCash(simulation, 200);
        Thread.sleep(SHORT_SLEEP);
        TestUtil.insertCard(simulation, 1);
        Thread.sleep(SHORT_SLEEP);
        TestUtil.enterPassword(simulation, "42");
        for (int i = 0; i < 2; i++) {
            Thread.sleep(SHORT_SLEEP);
            TestUtil.chooseTransactionType(Transaction.WITHDRAWAL);
            Thread.sleep(SHORT_SLEEP);
            TestUtil.chooseAccountType(Account.CHECKING);
            Thread.sleep(SHORT_SLEEP);
            TestUtil.chooseWithdrawalType(WithdrawalAmount.FORTY);
            Thread.sleep(LONG_SLEEP * 4);
            TestUtil.chooseYesOrNo(Choice.YES);
        }
    }
}
