package edu.northeastern.truthtree.service.normalization;

import edu.northeastern.truthtree.controller.normalization.Normalization;
import edu.northeastern.truthtree.enums.NormalizationType;

public interface INormalizationService {
  public NormalizationType[] getNormalizationTypes();
}
