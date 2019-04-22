package edu.northeastern.truthtree.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.northeastern.truthtree.service.TypeaheadService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by steven on 2019/3/21.
 */
@RestController
@Component
public class TypeaheadController {

  private final TypeaheadService typeaheadService;

  @Autowired
  TypeaheadController(TypeaheadService typeaheadService) {
    this.typeaheadService = typeaheadService;
  }

  @PostMapping("/api/search")
  public ResponseEntity<?> getSearchSuggestions(@RequestBody String body) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      Map<String, String> bodyMap = mapper.readValue(body,
              new TypeReference<HashMap<String, String>>(){});
      String text = Optional.ofNullable(bodyMap.get("text"))
              .orElseThrow(() -> new IllegalArgumentException());
      return ResponseEntity.ok(this.typeaheadService.search(text));
    } catch(IllegalArgumentException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    } catch (IOException e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
