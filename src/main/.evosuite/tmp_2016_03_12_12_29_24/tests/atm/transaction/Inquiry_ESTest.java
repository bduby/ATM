/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 12 20:40:18 GMT 2016
 */

package atm.transaction;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import atm.ATM;
import atm.Session;
import atm.transaction.Inquiry;
import banking.Card;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Inquiry_ESTest extends Inquiry_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Inquiry inquiry0 = new Inquiry((ATM) null, (Session) null, (Card) null, 23);
      inquiry0.getSpecificsFromCustomer();
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Inquiry inquiry0 = new Inquiry((ATM) null, (Session) null, (Card) null, (-2039));
      inquiry0.completeTransaction();
  }
}
