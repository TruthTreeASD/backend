package edu.northeastern.truthtree.common.normalizationStrategy;

import edu.northeastern.truthtree.enums.NormalizationType;

/**
 * Factory class responsible to return instance of {@link INormalizationStrategy} implementation.
 */
public class NormalizationStrategyFactory {


  /**
   * Private constructor of this class.
   */
  private NormalizationStrategyFactory() {

  }

  /**
   * Returns the implementation of {@link INormalizationStrategy} for the provided type. The type
   * should match the string value provided in {@link edu.northeastern.truthtree.enums.NormalizationType}
   * for the respective Strategy type.
   *
   * @param type in String representing normalization strategy.
   * @return strategy belonging to INormalizationStrategy implementations.
   */
  public static INormalizationStrategy getInstance(NormalizationType type) {
    INormalizationStrategy strategy = null;
    if (type.equals(NormalizationType.BY_REVENUE)) {
      strategy = new RevenueNormalizationStrategy();
    } else if (type.equals(NormalizationType.PER_CAPITA)) {
      strategy = new PerCapitaNormalizationStrategy();
    }
    return strategy;
  }
}
