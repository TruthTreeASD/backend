package edu.northeastern.truthtree.service.attributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import edu.northeastern.truthtree.AppConst;
import edu.northeastern.truthtree.adapter.attributes.IAttributesAdapter;
import edu.northeastern.truthtree.common.normalization.INormalizationStrategy;
import edu.northeastern.truthtree.common.normalization.NormalizationStrategyFactory;
import edu.northeastern.truthtree.enums.NormalizationType;

@Component
public class AttributesService implements IAttributesService {

  private IAttributesAdapter adapter;

  @Autowired
  public AttributesService(IAttributesAdapter adapter) {
    this.adapter = adapter;
  }

  /**
   * This method supports querying attribute values (normalized or gross) with different location
   * ids, attribute ids, years as request parameters. If normalization type is mentioned, It will
   * initialize normalization parameters (population or total revenue as attribute) by querying
   * required values from the database, and then calls corresponding normalization strategy class
   * (see {@link INormalizationStrategy}) to apply normalization logic.
   *
   * @param locations          location id list
   * @param collections        collection id list
   * @param properties         property id list
   * @param attributes         attribute id list
   * @param yearRange          year range
   * @param yearList           year list
   * @param normalizationTypes containing types of normalization requested as list
   * @return result containing attribute values.
   */
  @Override
  public Object getAttributes(List<Integer> locations, List<Integer> collections, List<Integer> properties,
                              List<Integer> attributes, List<Integer> yearRange, List<Integer> yearList,
                              List<NormalizationType> normalizationTypes) {
    List result = null;
    if (attributes != null) {
      result = findAttributesValues(locations, attributes, yearRange, yearList);
    } else {
      attributes = adapter.getAttributeIdWithCollectionProperty(collections, properties);
      result = (ArrayList) adapter.getAttributes(attributes);
    }
    if (normalizationTypes != null) {
      List normalizationParameters = getNormalizationParameters(locations, yearRange, yearList, normalizationTypes);
      for (NormalizationType type : normalizationTypes) {
        INormalizationStrategy strategy = NormalizationStrategyFactory.getInstance(type);
        result = strategy.normalize(result, normalizationParameters);
      }
    }
    return result;
  }

  /**
   * This method calls database service adapter to fetch normalization parameters - Total Revenue or
   * Population or both.
   *
   * @param locations          list containing location ids
   * @param yearRange          list containing start and end year for the year range
   * @param yearList           list containing years for which values need to be fetched
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
      result = findAttributesValues(locations, attributeList, yearRange, yearList);
    }
    return result;
  }

  /**
   * Calls adapter to find attribute values for given locations, attributes, yearRange or yearList
   * combination.
   *
   * @param locations     containing list of location ids
   * @param attributeList containing list of attribute ids
   * @param yearRange     containing start and end year
   * @param yearList      containing list of years for which attributes need to be fetched
   * @return result list containing attribute values
   */
  private List findAttributesValues(List<Integer> locations, List<Integer> attributeList,
                                    List<Integer> yearRange, List<Integer> yearList) {
    List result = null;
    if (yearList != null) {
      result = (ArrayList) adapter.getAttributesWithLocationsYearList(attributeList, locations, yearList);
    } else if (yearRange != null) {
      result = (ArrayList) adapter.getAttributesWithLocationsYearRange(attributeList, locations, yearRange);
    } else {
      result = (ArrayList) adapter.getAttributesWithLocations(attributeList, locations);
    }
    return result;
  }

}

