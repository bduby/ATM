/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 12 18:58:26 GMT 2016
 */

package atm.transaction;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import atm.ATM;
import atm.Session;
import atm.transaction.Inquiry;
import atm.transaction.Transaction;
import atm.transaction.Transfer;
import atm.transaction.Withdrawal;
import banking.Card;
import java.net.Inet4Address;
import java.net.InetAddress;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.net.MockInetAddress;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Transaction_ESTest extends Transaction_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getByName((String) null);
      ATM aTM0 = new ATM((-2413), "==", "==", (InetAddress) inet4Address0);
      Session session0 = new Session(aTM0);
      Card card0 = new Card((-2413));
      Transfer transfer0 = new Transfer(aTM0, session0, card0, (-2413));
      transfer0.serialNumber = (-2413);
      // Undeclared exception!
      try { 
        transfer0.performTransaction();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("atm.physical.CustomerConsole", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLocalHost();
      ATM aTM0 = new ATM((-95), "9;p}HX=[%_j", "pfd^2S/g\"p$nx9&Je", (InetAddress) inet4Address0);
      Session session0 = new Session(aTM0);
      Card card0 = new Card((-95));
      Inquiry inquiry0 = new Inquiry(aTM0, session0, card0, (-95));
      assertEquals(1, inquiry0.getSerialNumber());
      
      inquiry0.serialNumber = 0;
      int int0 = inquiry0.getSerialNumber();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLocalHost();
      ATM aTM0 = new ATM((-95), "9;p}HX=[%_j", "pfd^2S/g\"p$nx9&Je", (InetAddress) inet4Address0);
      Session session0 = new Session(aTM0);
      Card card0 = new Card((-95));
      Inquiry inquiry0 = new Inquiry(aTM0, session0, card0, (-95));
      assertEquals(1, inquiry0.getSerialNumber());
      
      inquiry0.serialNumber = (-95);
      int int0 = inquiry0.getSerialNumber();
      assertEquals((-95), int0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.anyLocalAddress();
      ATM aTM0 = new ATM(0, "Your card has been retained\nPlease contact the bank.", "Your card has been retained\nPlease contact the bank.", (InetAddress) inet4Address0);
      Session session0 = new Session(aTM0);
      Card card0 = new Card(0);
      Inquiry inquiry0 = new Inquiry(aTM0, session0, card0, 0);
      inquiry0.completeTransaction();
      assertEquals(1, inquiry0.getSerialNumber());
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLocalHost();
      ATM aTM0 = new ATM(3233, "]/,qS)>5R3/}ooFU\"&", "]/,qS)>5R3/}ooFU\"&", (InetAddress) inet4Address0);
      Session session0 = new Session(aTM0);
      Card card0 = new Card(3233);
      // Undeclared exception!
      try { 
        Transaction.makeTransaction(aTM0, session0, card0, 1);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("atm.physical.CustomerConsole", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.anyLocalAddress();
      ATM aTM0 = new ATM(60, "$HV!%E.Iva]", "z|7F>LU?SM#L", (InetAddress) inet4Address0);
      Session session0 = new Session(aTM0);
      Card card0 = new Card(60);
      Withdrawal withdrawal0 = new Withdrawal(aTM0, session0, card0, 100);
      // Undeclared exception!
      try { 
        withdrawal0.getSpecificsFromCustomer();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("atm.physical.CustomerConsole", e);
      }
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLoopbackAddress();
      ATM aTM0 = new ATM(635, "", " ", (InetAddress) inet4Address0);
      Session session0 = new Session(aTM0);
      Card card0 = new Card(635);
      Transfer transfer0 = new Transfer(aTM0, session0, card0, (-97));
      // Undeclared exception!
      try { 
        transfer0.completeTransaction();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("atm.transaction.Transfer$1", e);
      }
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLoopbackAddress();
      ATM aTM0 = new ATM(2, "n'4}rK*81`1~z.:", "n'4}rK*81`1~z.:", (InetAddress) inet4Address0);
      Session session0 = new Session(aTM0);
      Card card0 = new Card(2);
      Inquiry inquiry0 = new Inquiry(aTM0, session0, card0, 2);
      // Undeclared exception!
      try { 
        inquiry0.performInvalidPINExtension();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("atm.physical.CustomerConsole", e);
      }
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLocalHost();
      ATM aTM0 = new ATM((-95), "9;p}HX=[%_j", "pfd^2S/g\"p$nx9&Je", (InetAddress) inet4Address0);
      Session session0 = new Session(aTM0);
      Card card0 = new Card((-95));
      Inquiry inquiry0 = new Inquiry(aTM0, session0, card0, (-95));
      int int0 = inquiry0.getSerialNumber();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test9()  throws Throwable  {
      Transaction.CardRetained transaction_CardRetained0 = new Transaction.CardRetained();
  }
}