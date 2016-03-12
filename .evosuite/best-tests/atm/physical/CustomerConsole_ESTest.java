/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 12 17:55:38 GMT 2016
 */

package atm.physical;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import atm.physical.CustomerConsole;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class CustomerConsole_ESTest extends CustomerConsole_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      CustomerConsole customerConsole0 = new CustomerConsole();
      // Undeclared exception!
      try { 
        customerConsole0.readPIN("");
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
      String[] stringArray0 = new String[6];
      CustomerConsole customerConsole0 = new CustomerConsole();
      // Undeclared exception!
      try { 
        customerConsole0.readMenuChoice("Cancelld by ac*stCer", stringArray0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("atm.physical.CustomerConsole", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      CustomerConsole customerConsole0 = new CustomerConsole();
      // Undeclared exception!
      try { 
        customerConsole0.readAmount(")!3?ZX`$");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("atm.physical.CustomerConsole", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      CustomerConsole customerConsole0 = new CustomerConsole();
      // Undeclared exception!
      try { 
        customerConsole0.display("");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("atm.physical.CustomerConsole", e);
      }
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      CustomerConsole.Cancelled customerConsole_Cancelled0 = new CustomerConsole.Cancelled();
  }
}
