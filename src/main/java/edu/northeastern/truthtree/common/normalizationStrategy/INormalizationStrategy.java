package edu.northeastern.truthtree.common.normalizationStrategy;

import java.util.List;

import edu.northeastern.truthtree.enums.NormalizationType;

public interface INormalizationStrategy {
  public List normalize(List result, List normalizationParameters);
}
