package edu.northeastern.truthtree.controller.normalization;

import org.springframework.http.ResponseEntity;

/**
 * Returns type of normalization supported by Truthtree application. It can be - Gross, Per-capita,
 * by total revenue.
 */
public interface INormalization {
  public ResponseEntity<Object> getNormalizationTypes();
}
