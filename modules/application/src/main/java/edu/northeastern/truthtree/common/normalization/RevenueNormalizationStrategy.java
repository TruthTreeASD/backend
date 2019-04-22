package edu.northeastern.truthtree.common.normalization;

import edu.northeastern.truthtree.AppConst;
import java.util.List;

public class RevenueNormalizationStrategy extends AbstractNormalizationStrategy {

  protected void setParameterMap(List normalizationParameters) {
    super.updateParameterMap(normalizationParameters, AppConst.TOTAL_REVENUE_PARAMETER);
  }

  @Override
  protected List apply(List result) {
    return super.updateNormalizationValues(result, AppConst.BY_REVENUE);
  }
}
