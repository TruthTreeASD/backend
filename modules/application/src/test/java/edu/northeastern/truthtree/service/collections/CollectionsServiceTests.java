package edu.northeastern.truthtree.service.collections;

import edu.northeastern.truthtree.adapter.collections.CollectionsDBAdapter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CollectionsServiceTests {

    @Mock
    private CollectionsDBAdapter collectionsDBAdapter;

    private CollectionsService collectionsService;

    @Before
    public void setup() {
        collectionsService = new CollectionsService(collectionsDBAdapter);
    }

    @Test
    public void testGetAllCollections() {
        Object actualResponse = collectionsDBAdapter.getCollections();
        Object expectedResponse = collectionsService.getCollections(null);
        assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void testGetCollectionsByLocationId() {
        Integer locationId = 182056011;
        Object actualResponse = collectionsDBAdapter.getCollectionsByLocationId(locationId);
        assertEquals(actualResponse, collectionsService.getCollections(locationId));
    }
}
