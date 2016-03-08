package atm.transaction;

import atm.ATM;
import atm.Session;
import atm.transaction.Deposit;
import banking.Card;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import simulation.Simulation;

import java.awt.*;

/**
 * @author Robert Wilk
 *         Created on 2/15/2016.
 */
public class DepositTest {

    private ATM atm;
    private Session session;
    private Card card;
    private int pin;
    private Deposit deposit;
    private Simulation sim;
    private Frame frame;

    @Before
    public void setUp() throws Exception {
        atm = new ATM(
          527, "CSUS", "Big Bank", null /* InetAddress.getByAddress("localhost", new byte[] { 127, 0, 0, 1})*/
        );
        session = new Session(atm);
        session.setPIN(1234);
        card = new Card(1234567890);
        pin = 1234;
        sim = new Simulation(atm);
        Frame frame = new Frame();
        frame.add(sim.getGUI());
        frame.pack();
        frame.setVisible(true);
        // new Thread(atm).start();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetSpecificsFromCustomer() throws Exception {
        // sim.getInitialCash();
        //session.performSession();
        /*deposit = new Deposit(atm, session, card, pin);
        Message message = deposit.getSpecificsFromCustomer();
        System.out.println(message);*/
    }

    /*@Test
    public void testCompleteTransaction() throws Exception {

    }

    @Test
    public void testGetSpecificsFromCustomer1() throws Exception {

    }

    @Test
    public void testCompleteTransaction1() throws Exception {

    }*/
}