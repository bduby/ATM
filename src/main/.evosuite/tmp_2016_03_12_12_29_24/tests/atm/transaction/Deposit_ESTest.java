/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 12 20:42:54 GMT 2016
 */

package atm.transaction;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import atm.ATM;
import atm.Session;
import atm.transaction.Deposit;
import banking.Card;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Deposit_ESTest extends Deposit_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Deposit deposit0 = new Deposit((ATM) null, (Session) null, (Card) null, (-1086));
      deposit0.completeTransaction();
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Deposit deposit0 = new Deposit((ATM) null, (Session) null, (Card) null, 138);
      deposit0.getSpecificsFromCustomer();
  }
}
