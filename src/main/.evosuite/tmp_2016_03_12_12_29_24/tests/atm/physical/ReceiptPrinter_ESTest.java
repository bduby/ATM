/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 12 20:39:06 GMT 2016
 */

package atm.physical;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import atm.physical.ReceiptPrinter;
import banking.Receipt;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class ReceiptPrinter_ESTest extends ReceiptPrinter_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ReceiptPrinter receiptPrinter0 = new ReceiptPrinter();
      receiptPrinter0.printReceipt((Receipt) null);
  }
}
