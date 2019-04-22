package edu.northeastern.truthtree.adapter;


import static org.junit.Assert.assertEquals;

import edu.northeastern.truthtree.adapter.attributes.AttributesDBAdapter;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class AttributesDBAdapterTest {

  private AttributesDBAdapter attributesDBAdapter;

  @Before
  public void setup() {
    attributesDBAdapter = new AttributesDBAdapter();
  }

  @Test
  @Ignore
  public void testGetAttributeIdWithCollectionProperty() {
    List<Integer> properties = Arrays.asList(73, 45);
    List<Integer> collections = Arrays.asList(74);
    List<Integer> expectedOutput = Arrays.asList(1, 2);
    assertEquals(expectedOutput,
            attributesDBAdapter.getAttributeIdWithCollectionProperty(collections, properties));
  }
}
