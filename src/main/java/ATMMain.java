/* * ATM Example system - file ATMMain.java * * copyright (c) 2001 - Russell C. Bjork * */ import java.awt.*;import java.awt.event.*;import java.net.InetAddress;import java.net.UnknownHostException;import atm.ATM;import simulation.Simulation;/** Main program class for the application version of the ATM simulation. *  Create an instance of the ATM, put it in a frame, and then let the GUI *  do the work. */ public class ATMMain{    private ATM theATM;    private Frame mainFrame;    private Simulation theSimulation;    public ATMMain() throws UnknownHostException {        theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",                InetAddress.getLocalHost() /* We're not really talking to a bank! */);        theSimulation = new Simulation(theATM);        mainFrame = new Frame("ATM Simulation");        mainFrame.add(theSimulation.getGUI());        MenuBar menuBar = new MenuBar();        Menu fileMenu = new Menu("File");        MenuItem quitItem = new MenuItem("Quit", new MenuShortcut('Q'));        quitItem.addActionListener(new ActionListener() {            public void actionPerformed(ActionEvent e)            {                System.exit(0);            }        });        fileMenu.add(quitItem);        menuBar.add(fileMenu);        mainFrame.setMenuBar(menuBar);        mainFrame.addWindowListener(new WindowAdapter() {            public void windowClosing(WindowEvent e)            {                System.exit(0);            }        });        new Thread(theATM).start();        mainFrame.setResizable(false);        mainFrame.pack();        mainFrame.setVisible(true);    }    public ATM getTheATM() {        return theATM;    }    public void setTheATM(ATM theATM) {        this.theATM = theATM;    }    public Frame getMainFrame() {        return mainFrame;    }    public void setMainFrame(Frame mainFrame) {        this.mainFrame = mainFrame;    }    public Simulation getTheSimulation() {        return theSimulation;    }    public void setTheSimulation(Simulation theSimulation) {        this.theSimulation = theSimulation;    }    public static void main(String[] args) throws UnknownHostException {        new ATMMain();    }}    