import atm.ATM;
import simulation.Simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Robert Wilk
 * on 3/24/2016.
 */
public class TestUtil {

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
        new Robot().keyPress(KeyEvent.VK_ENTER);
    }

    /**
     * Gets the text currently displayed in the atm GUI.
     * @param simulation The current simulation.
     * @return An array of labels containing the display text.
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public Label[] getCurrentDisplay(Simulation simulation)
    throws NoSuchFieldException, IllegalAccessException {
        Object simDisplay = getObjectByField(simulation, "display");

        return (Label[]) getObjectByField(simDisplay, "displayLine");
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
            IllegalAccessException, AWTException {
        ATMMain atmMain = new ATMMain();
        Simulation simulation = atmMain.getTheSimulation();
        Thread.sleep(100);
        TestUtil.turnAtmOn(simulation);
        Thread.sleep(100);
        TestUtil.setInitialCash(simulation, 200);
        Label[] display = new TestUtil().getCurrentDisplay(simulation);
        Thread.sleep(100);
        for (Label label : new TestUtil().getCurrentDisplay(simulation))
            System.out.println(label.getText());
    }
}
