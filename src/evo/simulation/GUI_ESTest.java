/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 12 19:23:43 GMT 2016
 */

package simulation;

import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.GridBagConstraints;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import simulation.GUI;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class GUI_ESTest extends GUI_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      GridBagConstraints gridBagConstraints0 = GUI.makeConstraints(1286, 0, 552, (-2592), 0);
      assertEquals(10, gridBagConstraints0.anchor);
      assertEquals(1286, gridBagConstraints0.gridy);
      assertEquals(0, gridBagConstraints0.gridx);
      assertEquals(1.0, gridBagConstraints0.weighty, 0.01);
      assertEquals(552, gridBagConstraints0.gridwidth);
      assertEquals((-2592), gridBagConstraints0.gridheight);
      assertEquals(1.0, gridBagConstraints0.weightx, 0.01);
      assertEquals(0, gridBagConstraints0.fill);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      GridBagConstraints gridBagConstraints0 = GUI.makeConstraints(0, 0, 0, 1675, 1675);
      assertEquals(1675, gridBagConstraints0.fill);
      assertEquals(1.0, gridBagConstraints0.weightx, 0.01);
      assertEquals(0, gridBagConstraints0.gridx);
      assertEquals(1.0, gridBagConstraints0.weighty, 0.01);
      assertEquals(0, gridBagConstraints0.gridy);
      assertEquals(1675, gridBagConstraints0.gridheight);
      assertEquals(0, gridBagConstraints0.gridwidth);
      assertEquals(10, gridBagConstraints0.anchor);
  }
}
