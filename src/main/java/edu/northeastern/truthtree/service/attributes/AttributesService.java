package edu.northeastern.truthtree.service.attributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.truthtree.AppConst;


import java.util.ArrayList;
import java.util.List;

import edu.northeastern.truthtree.adapter.attributes.IAttributesAdapter;
import edu.northeastern.truthtree.common.normalizationStrategy.INormalizationStrategy;
import edu.northeastern.truthtree.common.normalizationStrategy.NormalizationStrategyFactory;
import edu.northeastern.truthtree.enums.NormalizationType;

@Component
public class AttributesService implements IAttributesService {

  private IAttributesAdapter adapter;
  private List<INormalizationStrategy> normalizationStrategies;

  @Autowired
  public AttributesService(IAttributesAdapter adapter) {
    this.adapter = adapter;
    this.normalizationStrategies = new ArrayList<>();

  }

  @Override
  public Object getAttributes(List<Integer> locations, List<Integer> collections, List<Integer> properties,
                              List<Integer> attributes, List<Integer> yearRange, List<Integer> yearList,
                              List<NormalizationType> normalizationTypes) {
    List result = null;
    if(locations == null){
      return new ArrayList<>();
    }
    List normalizationParameters = getNormalizationParameters(locations, yearRange, yearList, normalizationTypes);
    initializeNormalizationStrategies(normalizationTypes);
    if (attributes != null) {
      if (yearList != null) {
        result = (ArrayList) adapter.getAttributesWithLocationsYearList(attributes, locations, yearList);
      } else if (yearRange != null) {
        result = (ArrayList) adapter.getAttributesWithLocationsYearRange(attributes, locations, yearRange);
      } else {
        result = (ArrayList) adapter.getAttributesWithLocations(attributes, locations);
      }
    } else {
      attributes = adapter.getAttributeIdWithCollectionProperty(collections, properties);
      result = (ArrayList) adapter.getAttributes(attributes);
    }
    for(INormalizationStrategy strategy: normalizationStrategies){
      result = strategy.normalize(result, normalizationParameters);
    }

    return result;
  }

  /**
   * This method calls database service adapter to fetch normalization parameters - Total Revenue or Population or both.
   * It also determines normalization strategies which will be called in the end of the calling method.
   * @param locations list containing location ids
   * @param yearRange list containing start and end year for the year range
   * @param yearList list containing years for which values need to be fetched
   * @param normalizationTypes type of normalization requested
   * @return list containing values for normalization for given locations and years
   */
  private List getNormalizationParameters(List<Integer> locations,
                                          List<Integer> yearRange, List<Integer> yearList,
                                          List<NormalizationType> normalizationTypes) {
    List result = null;
    List<Integer> attributeList = new ArrayList<>();
    if (normalizationTypes != null && !normalizationTypes.isEmpty()) {
      for (NormalizationType type : normalizationTypes) {
        if (NormalizationType.BY_REVENUE.equals(type)) {
          attributeList.add(AppConst.TOTAL_REVENUE_ID);
        } else if (NormalizationType.PER_CAPITA.equals(type)) {
          attributeList.add(AppConst.POPULATION_ID);
        }
      }
      if (yearList != null) {
        result = (ArrayList) adapter.getAttributesWithLocationsYearList(attributeList, locations, yearList);
      } else if (yearRange != null) {
        result = (ArrayList) adapter.getAttributesWithLocationsYearRange(attributeList, locations, yearRange);
      } else{
        result = (ArrayList)adapter.getAttributesWithLocations(attributeList, locations);
      }

    }
    return result;
  }

  private void initializeNormalizationStrategies(List<NormalizationType> normalizationTypes){
    for(NormalizationType type: normalizationTypes){
      this.normalizationStrategies.add(NormalizationStrategyFactory.getInstance(type));
    }
  }

}

