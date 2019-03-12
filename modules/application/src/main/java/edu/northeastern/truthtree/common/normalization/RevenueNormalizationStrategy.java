package edu.northeastern.truthtree.common.normalization;

import java.util.List;

import edu.northeastern.truthtree.AppConst;

public class RevenueNormalizationStrategy extends AbstractNormalizationStrategy {

  protected void setParameterMap(List normalizationParameters) {
    super.updateParameterMap(normalizationParameters, AppConst.TOTAL_REVENUE_PARAMETER);
  }

  @Override
  protected List apply(List result) {
    return super.updateNormalizationValues(result, AppConst.BY_REVENUE);
  }
}
