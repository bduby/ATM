import atm.ATM;
import simulation.Simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Robert on 3/24/2016.
 */
public class TestUtil {

    public static ATMMain startAtmSimulator() throws UnknownHostException {
        return new ATMMain();
    }

    public static void turnAtmOn(Simulation simulation)
            throws NoSuchFieldException, IllegalAccessException {
        Panel opPanel = (Panel) getObjectByField(simulation, "operatorPanel");
        Component[] components = opPanel.getComponents();
        Button button = (Button) ((Panel) components[2]).getComponent(0);
        for (ActionListener actionListener : button.getActionListeners()) {
            actionListener.actionPerformed(null);
        }
    }

    public static void setInitialCash(Simulation simulation, int cash)
            throws NoSuchFieldException, IllegalAccessException, AWTException {
        Object gui = simulation.getGUI();
        Object panel = getObjectByField(gui, "billsPanel");
        TextField billsNumberField = (TextField) getObjectByField(panel, "billsNumberField");
        billsNumberField.setText(String.valueOf(cash));
        new Robot().keyPress(KeyEvent.VK_ENTER);
    }

    public Label[] getCurrentDisplay(Simulation simulation)
    throws NoSuchFieldException, IllegalAccessException {
        Object simDisplay = getObjectByField(simulation, "display");

        return (Label[]) getObjectByField(simDisplay, "displayLine");
    }

    static Field getDeclaredField(Object object, String name) throws NoSuchFieldException {
        return object.getClass().getDeclaredField(name);
    }

    static Field getAccessibleDeclaredField(Object object, String name) throws NoSuchFieldException {
        Field field = getDeclaredField(object, name);
        field.setAccessible(true);
        return field;
    }

    static Object getObjectByField(Object object, String name) throws NoSuchFieldException, IllegalAccessException {
        Field field = getAccessibleDeclaredField(object, name);
        return field.get(object);
    }

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
