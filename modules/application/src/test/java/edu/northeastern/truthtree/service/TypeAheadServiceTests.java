package edu.northeastern.truthtree.service;

import edu.northeastern.truthtree.adapter.TypeaheadAdapter;
import edu.northeastern.truthtree.dto.LocationDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TypeAheadServiceTests {

    @Mock
    private TypeaheadAdapter typeaheadAdapter;

    private TypeaheadService typeaheadService;

    @Before
    public void setup() {
        typeaheadService = new TypeaheadService(typeaheadAdapter);
    }

    @Test
    public void testSearch() {
        String searchTerm = "mass";
        try {
            List<LocationDTO> actual = typeaheadAdapter.search(searchTerm);
            assertThat(actual, is(typeaheadService.search(searchTerm)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testSearchWithNullBody() throws Exception {
        List<LocationDTO> actual = typeaheadAdapter.search(null);
        assertThat(actual, is(typeaheadService.search(null)));
    }

}
