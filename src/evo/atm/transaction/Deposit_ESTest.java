/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 12 19:32:46 GMT 2016
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
public class
Deposit_ESTest extends Deposit_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Deposit deposit0 = new Deposit((ATM) null, (Session) null, (Card) null, 332);
      // Undeclared exception!
      try { 
        deposit0.getSpecificsFromCustomer();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("atm.transaction.Deposit", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Deposit deposit0 = new Deposit((ATM) null, (Session) null, (Card) null, (-25));
      // Undeclared exception!
      try { 
        deposit0.completeTransaction();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("atm.transaction.Deposit", e);
      }
  }
}
