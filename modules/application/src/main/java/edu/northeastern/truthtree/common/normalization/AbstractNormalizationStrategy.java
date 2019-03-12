package edu.northeastern.truthtree.common.normalization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.northeastern.truthtree.AppConst;

/**
 * Represents abstract class for handling Normalization implementation common between different
 * types of normalization.
 */
public abstract class AbstractNormalizationStrategy implements INormalizationStrategy {

  /**
   * Stores Location Id as key and normalization parameters in the map for the given year.
   */
  protected Map<Long, Map<Long, Double>> parameterMap;

  AbstractNormalizationStrategy() {
    this.parameterMap = new HashMap<>();
  }

  /**
   * This method accepts result containing attribute values and normalization parameters which
   * contains population or total revenue value for the respective locations. It first arranges
   * normalization parameters in the parameterMap and then apply normalization for each attributes
   * in the result list.
   */
  @Override
  public List normalize(List result, List normalizationParameters) {
    this.setParameterMap(normalizationParameters);
    return this.apply(result);
  }

  /**
   * Sets values in the parameterMap for the given normalization type and therefore has been
   * abstracted at this level.
   *
   * @param normalizationParameters represents a list containing values required for normalizing
   *                                actual values.
   */
  protected abstract void setParameterMap(List normalizationParameters);

  /**
   * When the parameterMap is ready, it applies normalization in the result depending upon its type
   * and therefore has been abstracted at this level.
   *
   * @param result represents a list containing values to be normalized.
   * @return List containing final normalized values.
   */
  protected abstract List apply(List result);

  /**
   * This helper method iterates over normalizationParameters to update parameterMap for the given
   * type.
   *
   * @param normalizationParameters represents a list containing values required for normalizing
   *                                actual values.
   * @param type                    Type of normalization in String
   */
  protected void updateParameterMap(List normalizationParameters, String type) {
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

  /**
   * This helper method updates the result list after computing normalized values using
   * parameterMap. Depending upon which type is requested, it calculates and adds the final value,
   * rounded off upto 3 decimal places in the result list. If there is no value present in the
   * parameters map, for e.g, if any particular location doesn't have population value for
   * normalization, percapita value would be returned as 0.
   *
   * @param result list containing values to be normalized
   * @param type   String representing type of normalization
   * @return list containing normalized values.
   */
  protected List updateNormalizationValues(List result, String type) {
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
          Double val = 0.0;
          if (this.parameterMap.get(locationId) != null && this.parameterMap.get(locationId).get(year) != null) {
            val = value / this.parameterMap.get(locationId).get(year);
          }
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
