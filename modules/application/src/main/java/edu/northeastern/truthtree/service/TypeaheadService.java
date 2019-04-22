package edu.northeastern.truthtree.service;

import edu.northeastern.truthtree.adapter.TypeaheadAdapter;
import edu.northeastern.truthtree.dto.LocationDTO;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by steven on 2019/3/21.
 */
@Component
public class TypeaheadService {

  private TypeaheadAdapter typeaheadAdapter;

  @Autowired
  public TypeaheadService(TypeaheadAdapter typeaheadAdapter) {
    this.typeaheadAdapter = typeaheadAdapter;
  }

  public List<LocationDTO> search(String text) throws IOException {
    return this.typeaheadAdapter.search(text);
  }
}
