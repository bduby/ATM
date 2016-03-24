/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 12 19:11:19 GMT 2016
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
        customerConsole0.readPIN("V");
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
      CustomerConsole customerConsole0 = new CustomerConsole();
      // Undeclared exception!
      try { 
        customerConsole0.readMenuChoice("x?R4&pX8omR", (String[]) null);
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
        customerConsole0.readAmount("SWUCCESS");
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
        customerConsole0.display("Ekh=L]B9n7u");
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