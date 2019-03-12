package edu.northeastern.truthtree.service.collections;

import edu.northeastern.truthtree.adapter.collections.CollectionsDBAdapter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CollectionsServiceTest {

    private CollectionsService collectionsService = new CollectionsService(new CollectionsDBAdapter());

    @Test
    public void getAllCollections() {
        assertEquals(true, true);
    }
}