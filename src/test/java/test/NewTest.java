package test;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	  String str = "TestNG is working fine";
	  assertEquals("TestNG is working fine", str);
  }
  @BeforeMethod
  public void beforeMethod() {
  }

}
