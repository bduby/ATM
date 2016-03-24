/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 12 19:26:20 GMT 2016
 */

package simulation;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import atm.ATM;
import java.awt.HeadlessException;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import simulation.Simulation;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Simulation_ESTest extends Simulation_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Simulation simulation0 = Simulation.getInstance();
      assertNull(simulation0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Simulation simulation0 = null;
      try {
        simulation0 = new Simulation((ATM) null);
        fail("Expecting exception: HeadlessException");
      
      } catch(HeadlessException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("java.awt.GraphicsEnvironment", e);
      }
  }
}