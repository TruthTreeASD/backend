package edu.northeastern.truthtree.common.normalizationStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.northeastern.truthtree.AppConst;


public abstract class AbstractNormalizationStrategy implements INormalizationStrategy{

  protected Map<Long, Map<Long, Double>> parameterMap;
  AbstractNormalizationStrategy(){
    this.parameterMap = new HashMap<>();
  }
  @Override
  public List normalize(List result, List normalizationParameters) {
    this.setParameterMap(normalizationParameters);
    return this.apply(result);
  }

  protected abstract void setParameterMap(List normalizationParameters);
  protected abstract List apply(List result);

  protected void updateParameterMap(List normalizationParameters, String type){
    for (Object normalizationData : normalizationParameters) {
      LinkedHashMap map = (LinkedHashMap) normalizationData;
      List attributesList = (ArrayList) map.get(AppConst.ATTRIBUTES);
      for (Object attrList : attributesList) {
        LinkedHashMap attrMap = (LinkedHashMap) attrList;
        List dataList = (ArrayList) attrMap.get(AppConst.DATA);
        Long locationId = (Long) map.get(AppConst.LOCATION_ID);
        Map<Long, Double> valueMap = null;
        for (Object data : dataList) {
          LinkedHashMap dataMap = (LinkedHashMap) data;
          Double value = (Double) dataMap.get(AppConst.VALUE);
          Long year = (Long) dataMap.get(AppConst.YEAR);
          if (type.equals((String) attrMap.get(AppConst.NAME))) {
            valueMap = this.parameterMap.getOrDefault(locationId, new HashMap<>());
            valueMap.put(year, value);
            this.parameterMap.put(locationId, valueMap);
          }
        }
      }
    }
  }

  protected List updateNormalizationValues(List result, String type){
    for (int i = 0; i < result.size(); i++) {
      LinkedHashMap map = (LinkedHashMap) result.get(i);
      List attributesList = (ArrayList) map.get(AppConst.ATTRIBUTES);
      for (int j = 0; j < attributesList.size(); j++) {
        LinkedHashMap attrMap = (LinkedHashMap) attributesList.get(j);
        List dataList = (ArrayList) attrMap.get(AppConst.DATA);
        Long locationId = (Long) map.get(AppConst.LOCATION_ID);
        for (int k = 0; k < dataList.size(); k++) {
          LinkedHashMap dataMap = (LinkedHashMap) dataList.get(k);
          Long year = (Long) dataMap.get(AppConst.YEAR);
          Double value = (Double) dataMap.get(AppConst.VALUE);
          Double val = value / this.parameterMap.get(locationId).get(year);
          val = (double) Math.round(val * 1000) / 1000;
          dataMap.put(type, val);
          dataList.set(k, dataMap);
        }
        attributesList.set(j, attrMap);
      }
      result.set(i, map);
    }
    return result;
  }
}
