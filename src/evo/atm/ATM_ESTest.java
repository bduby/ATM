/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 12 19:03:32 GMT 2016
 */

package atm;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import atm.ATM;
import java.net.Inet4Address;
import java.net.InetAddress;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.net.MockInetAddress;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class ATM_ESTest extends ATM_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      ATM aTM0 = new ATM((-524), " TO  ", "%6]", (InetAddress) null);
      assertEquals(-524, aTM0.getID());
      assertEquals(" TO  ", aTM0.getPlace());
      assertEquals("%6]", aTM0.getBankName());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLocalHost();
      ATM aTM0 = new ATM(2708, "EfR*%ZVJjA~(Y^ra", "EfR*%ZVJjA~(Y^ra", (InetAddress) inet4Address0);
      aTM0.getPlace();
      assertEquals(2708, aTM0.getID());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLoopbackAddress();
      ATM aTM0 = new ATM((-1), "", "", (InetAddress) inet4Address0);
      aTM0.getPlace();
      assertEquals(-1, aTM0.getID());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLocalHost();
      ATM aTM0 = new ATM(2708, "EfR*%ZVJjA~(Y^ra", "EfR*%ZVJjA~(Y^ra", (InetAddress) inet4Address0);
      int int0 = aTM0.getID();
      assertEquals(2708, int0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLocalHost();
      ATM aTM0 = new ATM((-1), (String) null, (String) null, (InetAddress) inet4Address0);
      int int0 = aTM0.getID();
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.anyLocalAddress();
      ATM aTM0 = new ATM(2340, "JRNNS# ", "JRNNS# ", (InetAddress) inet4Address0);
      aTM0.getBankName();
      assertEquals(2340, aTM0.getID());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.anyLocalAddress();
      ATM aTM0 = new ATM((-336), "", "", (InetAddress) inet4Address0);
      aTM0.getBankName();
      assertEquals(-336, aTM0.getID());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLoopbackAddress();
      ATM aTM0 = new ATM((-828), (String) null, (String) null, (InetAddress) inet4Address0);
      // Undeclared exception!
      try { 
        aTM0.run();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("atm.physical.CustomerConsole", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLoopbackAddress();
      ATM aTM0 = new ATM((-828), (String) null, (String) null, (InetAddress) inet4Address0);
      aTM0.getPlace();
      assertEquals(-828, aTM0.getID());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLocalHost();
      ATM aTM0 = new ATM(2708, "EfR*%ZVJjA~(Y^ra", "EfR*%ZVJjA~(Y^ra", (InetAddress) inet4Address0);
      aTM0.getEnvelopeAcceptor();
      assertEquals(2708, aTM0.getID());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLoopbackAddress();
      ATM aTM0 = new ATM((-828), (String) null, (String) null, (InetAddress) inet4Address0);
      aTM0.cardInserted();
      assertEquals(-828, aTM0.getID());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLocalHost();
      ATM aTM0 = new ATM(2708, "EfR*%ZVJjA~(Y^ra", "EfR*%ZVJjA~(Y^ra", (InetAddress) inet4Address0);
      aTM0.getCardReader();
      assertEquals(2708, aTM0.getID());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      ATM aTM0 = new ATM(0, " TO  ", " TO  ", (InetAddress) null);
      aTM0.getNetworkToBank();
      assertEquals(0, aTM0.getID());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.anyLocalAddress();
      ATM aTM0 = new ATM(2340, "JRNNS# ", "JRNNS# ", (InetAddress) inet4Address0);
      aTM0.getLog();
      assertEquals(2340, aTM0.getID());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLoopbackAddress();
      ATM aTM0 = new ATM((-828), (String) null, (String) null, (InetAddress) inet4Address0);
      aTM0.switchOn();
      assertEquals(-828, aTM0.getID());
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.anyLocalAddress();
      ATM aTM0 = new ATM(2340, "JRNNS# ", "JRNNS# ", (InetAddress) inet4Address0);
      aTM0.getCashDispenser();
      assertEquals(2340, aTM0.getID());
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.anyLocalAddress();
      ATM aTM0 = new ATM(2340, "JRNNS# ", "JRNNS# ", (InetAddress) inet4Address0);
      aTM0.getOperatorPanel();
      assertEquals(2340, aTM0.getID());
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLoopbackAddress();
      ATM aTM0 = new ATM((-828), (String) null, (String) null, (InetAddress) inet4Address0);
      aTM0.switchOff();
      assertEquals(-828, aTM0.getID());
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.getLocalHost();
      ATM aTM0 = new ATM((-8863), (String) null, (String) null, (InetAddress) inet4Address0);
      aTM0.getBankName();
      assertEquals(-8863, aTM0.getID());
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      ATM aTM0 = new ATM(0, " TO  ", " TO  ", (InetAddress) null);
      int int0 = aTM0.getID();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.anyLocalAddress();
      ATM aTM0 = new ATM(2340, "JRNNS# ", "JRNNS# ", (InetAddress) inet4Address0);
      aTM0.getCustomerConsole();
      assertEquals(2340, aTM0.getID());
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Inet4Address inet4Address0 = (Inet4Address)MockInetAddress.anyLocalAddress();
      ATM aTM0 = new ATM(2340, "JRNNS# ", "JRNNS# ", (InetAddress) inet4Address0);
      aTM0.getReceiptPrinter();
      assertEquals(2340, aTM0.getID());
  }
}
