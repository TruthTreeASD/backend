package edu.northeastern.truthtree.assembler;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.dto.PageDTO;
import springfox.documentation.spring.web.json.Json;


@Component
@SuppressWarnings("unchecked")
public class LocationAssembler {
  private ObjectMapper mapper;

  @Autowired
  public LocationAssembler(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  public List<LocationDTO> jsonArrayToLocationList(JSONArray array) {
    return (List) array
            .stream()
            .map(location -> {
              Map locationMap = (Map) location;
              return new LocationDTO
                      .Builder()
                      .withId(locationMap.get("id").toString())
                      .withTypeCode(((Number)locationMap.get("type_code")).intValue())
                      .withName(locationMap.get("name").toString())
                      .withLatitude((Double) locationMap.get("latitude"))
                      .withLongitude((Double) locationMap.get("longitude"))
                      .build();
            })
            .collect(Collectors.toList());
  }

  public PageDTO<LocationDTO> locationListToPage(List<LocationDTO> locations) {
    return new PageDTO.Builder()
            .withCurrentPage(1)
            .withTotalItemCount(locations.size())
            .withTotalPageCount(1)
            .withItems(locations)
            .build();
  }

  public PageDTO<LocationDTO> mapToLocationPage(Map<String, Object> dataMap,
                                                 Map<Long, Object> basicInfoMap) {
    List<Map<String, Object>> populationMaps = (List) dataMap.get("data");
    return new PageDTO
            .Builder()
            .withCurrentPage((int) dataMap.get("currentPage"))
            .withTotalPageCount((int) dataMap.get("totalPage"))
            .withTotalItemCount((int) dataMap.get("total"))
            .withItems(populationMaps
                    .stream()
                    .map(populationMap -> this.mapToLocationDTO(populationMap, basicInfoMap))
                    .collect(Collectors.toList()))
            .build();
  }

  private LocationDTO mapToLocationDTO(Map<String, Object> populationMap,
                                       Map<Long, Object> basicInfoMap) {
    long locationId =  ((Number) populationMap.get("location_id")).longValue();
    long population = ((Number) populationMap.get("value")).longValue();
    Map<String, Object> locationMap = (Map) basicInfoMap.get(locationId);
    return new LocationDTO
            .Builder()
            .withId(locationMap.get("id").toString())
            .withName((String) locationMap.get("name"))
            .withTypeCode(((Number) locationMap.get("type_code")).intValue())
            .withPopulation(population)
            .build();
  }
}

