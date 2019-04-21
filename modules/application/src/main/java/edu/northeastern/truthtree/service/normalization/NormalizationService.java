package edu.northeastern.truthtree.service.normalization;

import edu.northeastern.truthtree.enums.NormalizationType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class NormalizationService implements INormalizationService {

  /**
   * Returns supported normalization types in name-display value format.
   *
   * @return Object containing list of normalization types.
   */
  @Override
  public Object getNormalizationTypes() {
    List<Map<String, String>> normalizationTypes = new ArrayList<>();
    for (NormalizationType type : NormalizationType.values()) {
      Map<String, String> map = new LinkedHashMap<>();
      map.put("name", type.name());
      map.put("displayValue", type.getValue());
      normalizationTypes.add(map);
    }
    return normalizationTypes;
  }
}
