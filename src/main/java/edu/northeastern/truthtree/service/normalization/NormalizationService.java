package edu.northeastern.truthtree.service.normalization;

import org.springframework.stereotype.Component;

import edu.northeastern.truthtree.enums.NormalizationType;
@Component
public class NormalizationService implements INormalizationService{

  @Override
  public NormalizationType[] getNormalizationTypes() {
    return NormalizationType.values();
  }
}
