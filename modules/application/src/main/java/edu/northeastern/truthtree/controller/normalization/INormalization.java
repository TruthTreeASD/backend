package edu.northeastern.truthtree.controller.normalization;

import org.springframework.http.ResponseEntity;

/**
 * Returns type of normalization supported by Truthtree application. It can be - Gross, Per-capita,
 * by total revenue. For more details, see {@link edu.northeastern.truthtree.enums.NormalizationType}
 */
public interface INormalization {
  ResponseEntity<Object> getNormalizationTypes();
}
