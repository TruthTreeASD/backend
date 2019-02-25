package edu.northeastern.truthtree;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@SpringBootTest
public class AttributeApiTests {

  @DataProvider(name = "params")
  public static Object[][] credentials() {
    return new Object[][] {
        { "locationIds=320000000&attributeIds=4&yearList=2000", "Test@123" },
        { "testuser_1", "Test@123" }};
  }

  @Test(dataProvider = "params")
  public void testResponse() {
    System.out.println("hahaha");
  }
}

