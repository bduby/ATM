/**
 * Created by Ron on 3/29/2016.
 *
 * Re-Added to undo a commit.
 */


/*
 * ATM Example system - file ATM.java
 *
 * copyright (c) 2001 - Russell C. Bjork
 *
 */

package atm;
        import java.net.InetAddress;
        import atm.physical.*;
        import banking.Card;
        import banking.Money;

/** Representation for the ATM itself.  An object of this class "owns"
 *  the objects representing the component parts of the ATM, and the
 *  communications network, and is responsible for creating customer
 *  sessions which then use it to gain access to the component parts.
 *  This is an active class - when an instance of the class is created,
 *  a thread is executed that actually runs the system.
 */

public class ATM implements Runnable
{
    /** Constructor
     *
     *  @param id the unique ID for this ATM
     *  @param place the physical location of this ATM
     *  @param bankName the name of the bank owning this ATM
     *  @param bankAddress the Internet address of the bank
     */
    public ATM(int id, String place, String bankName, InetAddress bankAddress)
    {
        this.id = id;
        this.place = place;
        this.bankName = bankName;
        this.bankAddress = bankAddress;

        // Create objects corresponding to component parts

        log = new Log();
        cardReader = new CardReader(this);
        cashDispenser = new CashDispenser(log);
        customerConsole = new CustomerConsole();
        envelopeAcceptor = new EnvelopeAcceptor(log);
        networkToBank = new NetworkToBank(log, bankAddress);
        operatorPanel = new OperatorPanel(this);
        receiptPrinter = new ReceiptPrinter();

        // Set up initial conditions when ATM first created

        state = OFF_STATE;
        switchOn = false;
        cardInserted = false;
    }

    // Methods corresponding to major responsibilities of the ATM

    /** The main program/applet will create a Thread that executes
     *  this code.
     */
    public void run()
    {
        Session currentSession = null;

        while (true)
        {
            switch(state)
            {
                case OFF_STATE:

                    customerConsole.display("Not currently available");

                    synchronized(this)
                    {
                        try
                        {
                            wait();
                        }
                        catch(InterruptedException e)
                        { }
                    }

                    if (switchOn)
                    {
                        performStartup();
                        state = IDLE_STATE;
                    }

                    break;

                case IDLE_STATE:

                    customerConsole.display("Please insert your card");
                    cardInserted = false;

                    synchronized(this)
                    {
                        try
                        {
                            wait();
                        }
                        catch(InterruptedException e)
                        { }
                    }

                    if (cardInserted)
                    {
                        currentSession = new Session(this);
                        state = SERVING_CUSTOMER_STATE;
                    }
                    else if (! switchOn)
                    {
                        performShutdown();
                        state = OFF_STATE;
                    }

                    break;

                case SERVING_CUSTOMER_STATE:

                    // The following will not return until the session has
                    // completed

                    currentSession.performSession();

                    state = IDLE_STATE;

                    break;

            }
        }
    }

    /** Inform the ATM that the switch on the operator console has been moved
     *  to the "on" position.
     */
    public synchronized void switchOn()
    {
        switchOn = true;
        notify();
    }

    /** Inform the ATM that the switch on the operator console has been moved
     *  to the "off" position.
     */
    public synchronized void switchOff()
    {
        switchOn = false;
        notify();
    }

    /** Inform the ATM that a card has been inserted into the card reader.
     */
    public synchronized void cardInserted()
    {
        cardInserted = true;
        notify();
    }

    // The following methods allow objects of other classes to access component
    // parts of the ATM

    /** Accessor for id
     *
     *  @return unique id of this ATM
     */
    public int getID()
    {
        return id;
    }

    /** Accessor for place
     *
     *  @return physical location of this ATM
     */
    public String getPlace()
    {
        return place;
    }

    /** Accessor for bank name
     *
     *  @return name of bank owning this ATM
     */
    public String getBankName()
    {
        return bankName;
    }

    /** Accessor for card reader
     *
     *  @return card reader component of this ATM
     */
    public CardReader getCardReader()
    {
        return cardReader;
    }

    /** Accessor for cash dispenser
     *
     *  @return cash dispenser component of this ATM
     */
    public CashDispenser getCashDispenser()
    {
        return cashDispenser;
    }

    /** Accessor for customer console
     *
     *  @return customer console component of this ATM
     */
    public CustomerConsole getCustomerConsole()
    {
        return customerConsole;
    }

    /** Accessor for envelope acceptor
     *
     *  @return envelope acceptor component of this ATM
     */
    public EnvelopeAcceptor getEnvelopeAcceptor()
    {
        return envelopeAcceptor;
    }

    /** Accessor for log
     *
     *  @return log component of this ATM
     */
    public Log getLog()
    {
        return log;
    }

    /** Accessor for network to bank
     *
     *  @return network connection to bank of this ATM
     */
    public NetworkToBank getNetworkToBank()
    {
        return networkToBank;
    }

    /** Accessor for operator panel
     *
     *  @return operator panel component of this ATM
     */
    public OperatorPanel getOperatorPanel()
    {
        return operatorPanel;
    }

    /** Accessor for receipt printer
     *
     *  @return receipt printer component of this ATM
     */
    public ReceiptPrinter getReceiptPrinter()
    {
        return receiptPrinter;
    }

    // Private methods

    /** Perform the System Startup use case when switch is turned on
     */
    private void performStartup()
    {
        Money initialCash = operatorPanel.getInitialCash();
        cashDispenser.setInitialCash(initialCash);
        networkToBank.openConnection();
    }

    /** Perform the System Shutdown use case when switch is turned off
     */
    private void performShutdown()
    {
        networkToBank.closeConnection();
    }


    // Instance variables recording information about the ATM


    /** Unique ID for this ATM
     */
    private int id;

    /** Physical location of this ATM
     */
    private String place;

    /** Name of the bank owning this ATM
     */
    private String bankName;

    /** Internet address of the bank
     */
    private InetAddress bankAddress;


    // Instance variables referring to the omponent parts of the ATM

    /** The ATM's card reader
     */
    private CardReader cardReader;

    /** The ATM's cash dispenser
     */
    private CashDispenser cashDispenser;

    /** The ATM's customer console
     */
    private CustomerConsole customerConsole;

    /** The ATM's envelope acceptor
     */
    private EnvelopeAcceptor envelopeAcceptor;

    /** The ATM's log
     */
    private Log log;

    /** The ATM's network connection to the bank
     */
    private NetworkToBank networkToBank;

    /** The ATM's operator panel
     */
    private OperatorPanel operatorPanel;

    /** The ATM's receipt printer
     */
    private ReceiptPrinter receiptPrinter;


    // State information


    /** The current state of the ATM - one of the possible values listed below
     */
    private int state;

    /** Becomes true when the operator panel informs the ATM that the switch has
     *  been turned on - becomes false when the operator panel informs the ATM
     *  that the switch has been turned off.
     */
    private boolean switchOn;

    /** Becomes true when the card reader informs the ATM that a card has been
     *  inserted - the ATM will make this false when it has tried to read the
     *  card
     */
    private boolean cardInserted;


    // Possible values for state


    /** The ATM is off.  The switch must be turned on before it can operate
     */
    private static final int OFF_STATE = 0;

    /** The ATM is on, but idle.  It can service a customer, or it can be shut down
     */
    private static final int IDLE_STATE = 1;

    /** The ATM is servicing a customer.
     */
    private static final int SERVING_CUSTOMER_STATE = 2;
}