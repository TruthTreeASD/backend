package edu.northeastern.truthtree.common.normalization;

import java.util.List;

/**
 * Represents interface for NormalizationStrategy followed in the application.
 */
public interface INormalizationStrategy {
  public List normalize(List result, List normalizationParameters);
}
