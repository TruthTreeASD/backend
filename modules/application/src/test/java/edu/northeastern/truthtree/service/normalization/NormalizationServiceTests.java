package edu.northeastern.truthtree.service.normalization;

import edu.northeastern.truthtree.enums.NormalizationType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class NormalizationServiceTests {

    private NormalizationService normalizationService;

    @Before
    public void setup() {
        normalizationService = new NormalizationService();
    }

    @Test
    public void testGetNormalizationTypes() {
        List<Map<String, String>> actual = new ArrayList<>();
        for(NormalizationType type : NormalizationType.values()) {
            Map<String, String> map = new LinkedHashMap<>();
            map.put("name", type.name());
            map.put("displayValue", type.getValue());
            actual.add(map);
        }
        List<Map<String, String>> expected = (List) normalizationService.getNormalizationTypes();
        assertThat(actual, is(expected));

    }
}
