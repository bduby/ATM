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

    public static void turnAtmOn(Simulation simulation) throws NoSuchFieldException, IllegalAccessException {
        Field panel = simulation.getClass().getDeclaredField("operatorPanel");
        panel.setAccessible(true);
        Panel opPanel = (Panel) panel.get(simulation);
        Component[] components = opPanel.getComponents();
        Button button = (Button) ((Panel) components[2]).getComponent(0);
        for (ActionListener actionListener : button.getActionListeners()) {
            actionListener.actionPerformed(null);
        }
    }

    public static void setInitialCash(Simulation simulation, int cash) throws NoSuchFieldException, IllegalAccessException, AWTException {
        Object gui = simulation.getGUI();
        Field bills = gui.getClass().getDeclaredField("billsPanel");
        bills.setAccessible(true);
        Object panel = bills.get(gui);
        Field field = panel.getClass().getDeclaredField("billsNumberField");
        field.setAccessible(true);
        TextField billsNumberField = (TextField) field.get(panel);
        billsNumberField.setText(String.valueOf(cash));
        new Robot().keyPress(KeyEvent.VK_ENTER);
    }

    public Label[] getCurrentDisplay(Simulation simulation)
    throws NoSuchFieldException, IllegalAccessException {

        Field display = simulation.getClass().getDeclaredField("display");
        display.setAccessible(true);
        Object simDisplay = display.get(simulation);
        Field displayLine = simDisplay.getClass().getDeclaredField("displayLine");
        displayLine.setAccessible(true);
        return (Label[]) displayLine.get(simDisplay);
    }

    public static void main(String[] args)
            throws UnknownHostException,
            InterruptedException,
            NoSuchFieldException,
            IllegalAccessException, AWTException {
        ATMMain atmMain = new ATMMain();
        Thread.sleep(100);
        TestUtil.turnAtmOn(atmMain.getTheSimulation());
        Thread.sleep(100);
        TestUtil.setInitialCash(atmMain.getTheSimulation(), 200);
        Label[] display = new TestUtil().getCurrentDisplay(atmMain.getTheSimulation());
        Thread.sleep(100);
        for (Label label : new TestUtil().getCurrentDisplay(atmMain.getTheSimulation()))
            System.out.println(label.getText());
    }
}
