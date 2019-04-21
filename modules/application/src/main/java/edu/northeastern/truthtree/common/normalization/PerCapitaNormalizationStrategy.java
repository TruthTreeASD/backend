package edu.northeastern.truthtree.common.normalization;

import edu.northeastern.truthtree.AppConst;
import java.util.List;

/**
 * This strategy divides attribute values with the population of the location for the given year.
 */
public class PerCapitaNormalizationStrategy extends AbstractNormalizationStrategy {

  /**
   * Initializes parameters map with the normalization parameters meant for per-capita normalization
   * strategy.
   *
   * @param normalizationParameters represents a list containing values required for normalization.
   */
  @Override
  protected void setParameterMap(List normalizationParameters) {
    super.updateParameterMap(normalizationParameters, AppConst.POPULATION_PARAMETER);
  }

  /**
   * Applies normalization with on the result and given type.
   *
   * @param result represents a list containing values to be normalized.
   */
  @Override
  protected List apply(List result) {
    return super.updateNormalizationValues(result, AppConst.PER_CAPITA);
  }
}
