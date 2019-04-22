package edu.northeastern.truthtree.service.advancedsearch;

import static org.junit.Assert.assertEquals;

import edu.northeastern.truthtree.adapter.advancedsearch.SimilarLocationsDBAdapter;
import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.enums.NormalizationType;
import edu.northeastern.truthtree.service.advancedsearch.SimilarLocationsService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SimilarLocationsServiceTests {

    @Mock
    private SimilarLocationsDBAdapter similarLocationsAdapter;

    private SimilarLocationsService similarLocationsService;

    @Before
    public void setup() {
        similarLocationsService = new SimilarLocationsService(similarLocationsAdapter);
    }

    @Test
    public void testGetSupportedAttributes() {
        List<CommonAttributeDTO> actualResponse = similarLocationsAdapter.getSupportedAttributes();
        assertEquals(actualResponse, similarLocationsService.getSupportedAttributes());
    }

    @Test
    public void testGetSimilarLocationsWithSingleAttribute() {
        List<Integer> attributes = new ArrayList<>();
        attributes.add(132);
        List<Integer> yearRange = new ArrayList<>();
        yearRange.add(2014);
        yearRange.add(2016);
        List<LocationDTO> actualResponse = similarLocationsAdapter
                .getSimilarLocations(220000000, 0, attributes,
                        NormalizationType.PER_CAPITA, yearRange, null);
        try {
            assertEquals(actualResponse, similarLocationsService.getSimilarLocations(220000000, 0,
                    attributes, NormalizationType.PER_CAPITA, yearRange, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetSimilarLocationsWithMultipleAttributes() {
        List<Integer> attributes = new ArrayList<>();
        attributes.add(1);
        attributes.add(132);
        List<Integer> yearRange = new ArrayList<>();
        yearRange.add(2014);
        List<LocationDTO> actualResponse = similarLocationsAdapter
                .getSimilarLocations(220000000, 0, attributes,
                        NormalizationType.BY_REVENUE, yearRange, null);
        try {
            assertEquals(actualResponse, similarLocationsService.getSimilarLocations(220000000, 0,
                    attributes, NormalizationType.BY_REVENUE, yearRange, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(expected = Exception.class)
    public void testGetSimilarLocationsWithNullYear() throws Exception {
        List<Integer> attributes = new ArrayList<>();
        attributes.add(1);
        List<Integer> yearRange = new ArrayList<>();
        List<LocationDTO> actualResponse = similarLocationsAdapter
                .getSimilarLocations(220000000, 0, attributes,
                        NormalizationType.BY_REVENUE, yearRange, null);
        assertEquals(actualResponse, similarLocationsService.getSimilarLocations(220000000, 0,
                attributes, NormalizationType.BY_REVENUE, yearRange, null));
    }

    @Test(expected = Exception.class)
    public void testGetSimilarLocationsWithSingleAttributSingleYear() throws Exception {
        List<Integer> attributes = new ArrayList<>();
        attributes.add(1);
        List<Integer> yearRange = new ArrayList<>();
        yearRange.add(2014);
        List<LocationDTO> actualResponse = similarLocationsAdapter
                .getSimilarLocations(220000000, 0, attributes,
                        NormalizationType.BY_REVENUE, yearRange, null);
        assertEquals(actualResponse, similarLocationsService.getSimilarLocations(220000000, 0,
                attributes, NormalizationType.BY_REVENUE, yearRange, null));
    }
}
