/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 12 19:30:39 GMT 2016
 */

package simulation;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import simulation.ATMPanel;
import simulation.GUI;
import simulation.SimCardReader;
import simulation.SimCashDispenser;
import simulation.SimDisplay;
import simulation.SimEnvelopeAcceptor;
import simulation.SimKeyboard;
import simulation.SimOperatorPanel;
import simulation.SimReceiptPrinter;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class ATMPanel_ESTest extends ATMPanel_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ATMPanel aTMPanel0 = null;
      try {
        aTMPanel0 = new ATMPanel((GUI) null, (SimOperatorPanel) null, (SimCardReader) null, (SimDisplay) null, (SimKeyboard) null, (SimCashDispenser) null, (SimEnvelopeAcceptor) null, (SimReceiptPrinter) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }
}