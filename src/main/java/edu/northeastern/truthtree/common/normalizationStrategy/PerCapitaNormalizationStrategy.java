package edu.northeastern.truthtree.common.normalizationStrategy;

import java.util.List;

import edu.northeastern.truthtree.AppConst;

public class PerCapitaNormalizationStrategy extends AbstractNormalizationStrategy {


  @Override
  protected void setParameterMap(List normalizationParameters) {
    super.updateParameterMap(normalizationParameters, AppConst.POPULATION_PARAMETER);
  }

  @Override
  protected List apply(List result) {
    return super.updateNormalizationValues(result, AppConst.PER_CAPITA);
  }
}
